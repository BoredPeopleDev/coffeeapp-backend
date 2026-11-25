package com.boredpeople.api_cofilovers.models.dto;

import lombok.Data;

@Data
public class LoginClienteRequest {
    private String correo;
    private String password;
}
