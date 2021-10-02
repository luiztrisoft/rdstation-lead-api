package com.trisoft.rdstationleadapi.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trisoft.rdstationleadapi.exception.TrisoftException;
import com.trisoft.rdstationleadapi.service.RDStationService;
import com.trisoft.rdstationleadapi.service.dto.ConversaoDto;
import com.trisoft.rdstationleadapi.service.dto.RDAccessTokenBodyDto;
import com.trisoft.rdstationleadapi.service.dto.RDOauthTokenDto;
import com.trisoft.rdstationleadapi.web.rest.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class RDStationServiceImpl implements RDStationService {
    @Value("${rdStation.client_id}")
    private String clientId;

    @Value("${rdStation.client_secret}")
    private String clientSecret;

    @Value("${rdStation.refresh_token}")
    private String refreshToken;

    @Value("${rdStation.url.access_token}")
    private String accessTokenUrl;

    @Value("${rdStation.url.criar_lead}")
    private String criarLeadUrl;

    @Value("${rdStation.api_key}")
    private String apiKey;

    @Autowired
    private RestUtil restUtil;

    @Override
    public ResponseEntity<String> criarLead(ConversaoDto conversaoDto) throws JsonProcessingException, TrisoftException {
        String token = autenticarComRefreshToken();
        String json = obterJsonLead(conversaoDto);
        return restUtil.postLeadRDStation(criarLeadUrl, json, token);
    }

    @Override
    public ResponseEntity<String> criarLeadByApiKey(ConversaoDto conversaoDto) throws JsonProcessingException, TrisoftException {
        String json = obterJsonLead(conversaoDto);
        return restUtil.postLeadRDStation(apiKey, json, null);
    }

    private String autenticarComRefreshToken() throws JsonProcessingException, TrisoftException {
        RDAccessTokenBodyDto tokenBody = new RDAccessTokenBodyDto(clientId, clientSecret, refreshToken);
        ResponseEntity<String> post = restUtil.post(accessTokenUrl, tokenBody, null);
        Gson g = new Gson();
        RDOauthTokenDto oauth = g.fromJson(post.getBody(), RDOauthTokenDto.class);
        return oauth.getAccess_token();
    }

    private String obterJsonLead(ConversaoDto conversaoDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(conversaoDto);
        json = json.replace("eventType", "event_type")
                .replace("eventFamily", "event_family")
                .replace("conversionIdentifier", "conversion_identifier")
                .replace("name", "name")
                .replace("email", "email")
                .replace("personalPhone", "personal_phone")
                .replace("cfZohoSegmento", "cf_zoho_segmento")
                .replace("cfZohoPerfilMudanca", "cf_zoho_perfil_mudanca")
                .replace("cfZohoProduto", "cf_zoho_produto")
                .replace("cfCnpj", "cf_cnpj")
                .replace("trafficValue", "traffic_value")
                .replace("trafficSource", "traffic_source")
                .replace("trafficMedium", "traffic_medium")
                .replace("cfUtmSource", "cf_utm_source")
                .replace("cfUtmMedium", "cf_utm_medium")
                .replace("cfUtmCampaign", "cf_utm_campaign");
        return json;
    }
}
