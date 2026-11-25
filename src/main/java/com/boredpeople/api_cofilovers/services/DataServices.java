package com.boredpeople.api_cofilovers.services;


import com.boredpeople.api_cofilovers.models.Clientes;
import com.boredpeople.api_cofilovers.models.dto.LoginClienteResponse;
import com.boredpeople.api_cofilovers.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataServices {
    @Autowired
    public ClientesRepository clientesRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public LoginClienteResponse loginClientes(String correo, String password) {
        Clientes clientes = clientesRepository.findByCliCorreoAndCliEliminadoEnIsNullAndCliActivo(correo, "T").orElseThrow(() -> new IllegalArgumentException("Correo no registrado o cuenta inactiva"));

        if (clientes.getCliPasswordHash() == null || !passwordEncoder.matches(password, clientes.getCliPasswordHash())) {
            throw new IllegalArgumentException("Contraseña incorrecta");
        }

        return new LoginClienteResponse("Bienvenido, " + clientes.getCliNombre(), clientes.getCliNombre(), clientes.getCliCorreo());
    }

    //Registrar clientes
    public LoginClienteResponse registrar(String nombre, String correo, String password) {
        // 1. Validar que el correo no exista ya
        boolean existe = clientesRepository.existsByCliCorreo(correo);
        if (existe) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }

        // 2. Crear el cliente con la contraseña HASHEADA (nunca en texto plano)
        Clientes clientes = Clientes.builder().cliNombre(nombre).cliCorreo(correo).cliPasswordHash(passwordEncoder.encode(password)).cliPuntosAcumulados(0).cliActivo("T").build();

        // 3. Guardar (PrePersist rellena id, qr, creadoEn)
        Clientes guardado = clientesRepository.save(clientes);

        return new LoginClienteResponse("Cliente registrado correctamente", guardado.getCliNombre(), guardado.getCliCorreo());
    }

}
