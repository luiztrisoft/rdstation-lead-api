package com.trisoft.rdstationleadapi.web.rest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.trisoft.rdstationleadapi.exception.TrisoftException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class RestUtil {

    private ObjectMapper objectMapper;
    private final String AUTHORIZATION = "Authorization";
    private Logger log = LoggerFactory.getLogger(RestUtil.class);

    public RestUtil() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModules(new JavaTimeModule())
                .setDateFormat(new StdDateFormat())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public ResponseEntity<String> postJsonString(String url, String jsonBody, String accessToken) throws JsonProcessingException, TrisoftException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        if (accessToken != null) {
            headers.set(AUTHORIZATION, getBearer(accessToken));
        }

        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);
        RestTemplate restTemplate = getRestTemplate();
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        try {
            return restTemplate.postForEntity(url, entity, String.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new TrisoftException(e.getMessage());
        }
    }

    private RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return !response.getStatusCode().is2xxSuccessful();
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                //Empty method
            }
        });
        return restTemplate;
    }

    private String getBearer(String accessToken) {
        return "Bearer ".concat(accessToken);
    }
}
