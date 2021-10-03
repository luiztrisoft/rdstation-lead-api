package com.trisoft.rdstationleadapi.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RDAccessTokenBodyDto {
    private String clienteId;
    private String clienteSecret;
    private String refreshToken;

    public RDAccessTokenBodyDto(){}

    public RDAccessTokenBodyDto(String clienteId, String clienteSecret, String refreshToken) {
        this.clienteId = clienteId;
        this.clienteSecret = clienteSecret;
        this.refreshToken = refreshToken;
    }
}