package com.boredpeople.api_cofilovers.controllers;

import com.boredpeople.api_cofilovers.models.dto.LoginRequest;
import com.boredpeople.api_cofilovers.models.dto.LoginResponse;
import com.boredpeople.api_cofilovers.services.DataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class CentralController {
    @Autowired
    private DataServices dataServices;

    @GetMapping("/login")
    public ResponseEntity<?> loginCliente(@RequestBody LoginRequest request) {
        try {
            LoginResponse response = dataServices.validarLogin(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
