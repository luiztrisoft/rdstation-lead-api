package com.trisoft.rdstationleadapi.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RDOauthTokenDto {
    private String access_token;

    public RDOauthTokenDto(String accessToken){
        this.access_token = accessToken;
    }

}