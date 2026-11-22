package com.boredpeople.api_cofilovers.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "administradores")
public class Administradores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "adm_id")
    private UUID id;

    @Column(name = "adm_nombre")
    private String nombre;

    @Column(name = "adm_correo", unique = true)
    private String correo;

    @Column(name = "adm_password_hash")
    private String passwordHash;
}
