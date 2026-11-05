package com.boredpeople.api_cofilovers.services;

import com.boredpeople.api_cofilovers.repositories.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataServices {
    @Autowired
    public DataRepository dataRepository;
    public String getEmpleados(){
        return dataRepository.getEmpleados();
    }
}
