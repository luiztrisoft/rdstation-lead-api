package com.trisoft.rdstationleadapi.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversaoDto {
    private String eventType;
    private String eventFamily;
    private PayloadDto payload;

    public ConversaoDto(){

    }
}