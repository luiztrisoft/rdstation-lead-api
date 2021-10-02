package com.trisoft.rdstationleadapi.service.facade;

import com.trisoft.rdstationleadapi.service.RDStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFacade {

    @Autowired
    public RDStationService rdStation;

}
