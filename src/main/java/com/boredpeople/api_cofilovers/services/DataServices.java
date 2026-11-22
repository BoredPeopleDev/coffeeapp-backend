package com.boredpeople.api_cofilovers.services;

import com.boredpeople.api_cofilovers.models.Administradores;
import com.boredpeople.api_cofilovers.models.Clientes;
import com.boredpeople.api_cofilovers.models.dto.LoginRequest;
import com.boredpeople.api_cofilovers.models.dto.LoginResponse;
import com.boredpeople.api_cofilovers.models.dto.SuperSuRequest;
import com.boredpeople.api_cofilovers.models.dto.SuperSuResponse;
import com.boredpeople.api_cofilovers.repositories.ClientesRepository;
import com.boredpeople.api_cofilovers.repositories.DataRepository;
import com.boredpeople.api_cofilovers.repositories.SuperSuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataServices {
    @Autowired
    public ClientesRepository clientesRepository;
    public SuperSuRepository superSuRepository;


    public LoginResponse validarLogin(LoginRequest request) {
        Optional<Clientes> clienteOpt = clientesRepository.findByCorreo(request.getCorreo());

        if (clienteOpt.isEmpty() || clienteOpt.get().getActivo().equals("F")) {
            throw new RuntimeException("Credenciales incorrectas o usuario inactivo");
        }
        Clientes cliente = clienteOpt.get();
        if (!cliente.getPasswordHash().equals(request.getPassword())) {
            throw new RuntimeException("Credenciales incorrectas");
        }
        return new LoginResponse("Bienvenido " + cliente.getNombre(), "token");
    }

    public SuperSuResponse validarUsuario(SuperSuRequest request) {
        Optional<Administradores> admOpt = superSuRepository.findByCorreo(request.getCorreo());
        if (admOpt.isEmpty()) {
            throw new RuntimeException("Credenciales incorrectas o usuario inactivo");
        }
        Administradores administradores = admOpt.get();
        if (!administradores.getPasswordHash().equals(request.getPassword())) {
            throw new RuntimeException("Credenciales incorrectas");
        }
        return new SuperSuResponse();
    }
}
