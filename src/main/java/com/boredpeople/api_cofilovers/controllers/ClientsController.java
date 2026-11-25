package com.boredpeople.api_cofilovers.controllers;

import com.boredpeople.api_cofilovers.models.dto.LoginClienteRequest;
import com.boredpeople.api_cofilovers.models.dto.LoginClienteResponse;
import com.boredpeople.api_cofilovers.models.dto.RegistroClienteRequest;
import com.boredpeople.api_cofilovers.services.DataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClientsController {

    @Autowired
    private DataServices dataServices;

    //Inicio de sesion
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginClienteRequest request) {
        try {
            LoginClienteResponse response = dataServices.loginClientes(request.getCorreo(), request.getPassword());
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", e.getMessage()));
        }
    }

    //Crear usuario nuevo
    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody RegistroClienteRequest request) {
        try {
            LoginClienteResponse response = dataServices.registrar(
                    request.getNombre(), request.getCorreo(), request.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
