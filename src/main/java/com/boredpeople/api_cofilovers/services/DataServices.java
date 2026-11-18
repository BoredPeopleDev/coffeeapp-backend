package com.boredpeople.api_cofilovers.services;

import com.boredpeople.api_cofilovers.models.Clientes;
import com.boredpeople.api_cofilovers.models.dto.LoginRequest;
import com.boredpeople.api_cofilovers.models.dto.LoginResponse;
import com.boredpeople.api_cofilovers.repositories.ClientesRepository;
import com.boredpeople.api_cofilovers.repositories.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataServices {
    @Autowired
    public ClientesRepository clientesRepository;

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
}
