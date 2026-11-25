package com.boredpeople.api_cofilovers.models.dto;

import lombok.Data;

@Data
public class RegistroClienteRequest {
    private String nombre;
    private String correo;
    private String password;
}
