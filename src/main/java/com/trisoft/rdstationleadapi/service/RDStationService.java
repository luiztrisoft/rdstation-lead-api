package com.trisoft.rdstationleadapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trisoft.rdstationleadapi.exception.TrisoftException;
import com.trisoft.rdstationleadapi.service.dto.ConversaoDto;
import org.springframework.http.ResponseEntity;

public interface RDStationService {

    ResponseEntity<String> criarLeadOauth(ConversaoDto conversaoDto) throws JsonProcessingException, TrisoftException;

    ResponseEntity<String> criarLeadApiKey(ConversaoDto conversaoDto) throws JsonProcessingException, TrisoftException;
}

