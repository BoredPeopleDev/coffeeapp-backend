package com.boredpeople.api_cofilovers.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginClienteResponse {
    private String mensaje;
    private String nombre;
    private String correo;
}