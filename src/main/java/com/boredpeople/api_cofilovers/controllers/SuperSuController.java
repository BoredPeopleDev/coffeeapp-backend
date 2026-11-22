package com.boredpeople.api_cofilovers.controllers;

import com.boredpeople.api_cofilovers.models.Administradores;
import com.boredpeople.api_cofilovers.models.dto.LoginRequest;
import com.boredpeople.api_cofilovers.models.dto.LoginResponse;
import com.boredpeople.api_cofilovers.models.dto.SuperSuRequest;
import com.boredpeople.api_cofilovers.models.dto.SuperSuResponse;
import com.boredpeople.api_cofilovers.repositories.SuperSuRepository;
import com.boredpeople.api_cofilovers.services.DataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adm")
public class SuperSuController {
    @Autowired
    private DataServices dataServices;
    @GetMapping("/login")
    public ResponseEntity<?> loginCliente(@RequestBody SuperSuRequest request) {
        try {
            SuperSuResponse response = dataServices.validarUsuario(request);
            return org.springframework.http.ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return org.springframework.http.ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
