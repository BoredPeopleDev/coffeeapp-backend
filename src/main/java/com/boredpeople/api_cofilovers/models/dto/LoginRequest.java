package com.boredpeople.api_cofilovers.models.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String correo;
    private String password;
}
