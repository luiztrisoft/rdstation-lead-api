package com.trisoft.rdstationleadapi.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trisoft.rdstationleadapi.exception.TrisoftException;
import com.trisoft.rdstationleadapi.service.dto.ConversaoDto;
import com.trisoft.rdstationleadapi.service.facade.Facade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rd-station")
@Slf4j
public class RDStationResource {

    @Autowired
    private Facade facade;

    @PostMapping("/oauth")
    public ResponseEntity<String> criarLeadOauth(@RequestBody ConversaoDto conversaoDto) throws TrisoftException, JsonProcessingException {
        log.debug("REST request to create a new lead at rd station");
        ResponseEntity<String> post = facade.service.rdStation.criarLeadOauth(conversaoDto);
        return ResponseEntity.ok().body(post.getBody());
    }

    @PostMapping("/api-key")
    public ResponseEntity<String> criarLeadApiKey(@RequestBody ConversaoDto conversaoDto) throws TrisoftException, JsonProcessingException {
        log.debug("REST request to create a new lead at rd station using API KEY");
        ResponseEntity<String> post = facade.service.rdStation.criarLeadApiKey(conversaoDto);
        return ResponseEntity.ok().body(post.getBody());
    }
}
