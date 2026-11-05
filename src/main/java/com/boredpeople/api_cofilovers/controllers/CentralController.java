package com.boredpeople.api_cofilovers.controllers;

import com.boredpeople.api_cofilovers.services.DataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
public class CentralController {
    @Autowired
    private DataServices dataServices;

    @GetMapping(produces = "application/json")
    public ResponseEntity<String> getEmpleados() {
        String json = dataServices.getEmpleados();
        return ResponseEntity.ok(json);
    }
}
