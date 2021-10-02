package com.trisoft.rdstationleadapi.service.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PayloadDto {
    private String conversionIdentifier;
    private String name;
    private String email;
    private String personalPhone;
    private String cfZohoSegmento;
    private String cfZohoPerfilMudanca;
    private String cfZohoProduto;
    private String cfCnpj;
    private String trafficSource;
    private String trafficMedium;
    private String cfUtmSource;
    private String cfUtmMedium;
    private String cfUtmCampaign;

    public PayloadDto(){

    }
}