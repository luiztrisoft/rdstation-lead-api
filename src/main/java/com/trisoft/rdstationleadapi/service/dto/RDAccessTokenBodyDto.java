package com.trisoft.rdstationleadapi.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RDAccessTokenBodyDto {
    private String client_id;
    private String client_secret;
    private String refresh_token;

    public RDAccessTokenBodyDto(){}

    public RDAccessTokenBodyDto(String clienteId, String clienteSecret, String refreshToken) {
        this.client_id = clienteId;
        this.client_secret = clienteSecret;
        this.refresh_token = refreshToken;
    }
}