package com.boredpeople.api_cofilovers.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cli_id")
    private UUID id;

    @Column(name = "cli_nombre")
    private String nombre;

    @Column(name = "cli_correo", unique = true)
    private String correo;

    @Column(name = "cli_password_hash")
    private String passwordHash;

    @Column(name = "cli_activo")
    private String activo;
}
