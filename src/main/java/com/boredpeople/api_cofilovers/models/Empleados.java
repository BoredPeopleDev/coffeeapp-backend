package com.boredpeople.api_cofilovers.models;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empl_id")
    private int empl_id;
}
