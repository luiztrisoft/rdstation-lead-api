package com.trisoft.rdstationleadapi.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Facade {

    @Autowired
    public ServiceFacade service;
}
