package com.boredpeople.api_cofilovers.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "clientes", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clientes {

    @Id
    @GeneratedValue
    @Column(name = "cli_id", updatable = false, nullable = false)
    private UUID cliId;

    @Column(name = "cli_nombre", nullable = false, length = 255)
    private String cliNombre;

    @Column(name = "cli_correo", nullable = false, unique = true, length = 255)
    private String cliCorreo;

    @Column(name = "cli_codigo_qr", nullable = false, unique = true)
    private UUID cliCodigoQr;

    @Column(name = "cli_puntos_acumulados", nullable = false)
    private Integer cliPuntosAcumulados;

    @Column(name = "cli_creado_en", nullable = false, updatable = false)
    private OffsetDateTime cliCreadoEn;

    @Column(name = "cli_actualizado_en")
    private OffsetDateTime cliActualizadoEn;

    @Column(name = "cli_eliminado_en")
    private OffsetDateTime cliEliminadoEn;

    @Column(name = "cli_activo", length = 255)
    private String cliActivo;

    @Column(name = "cli_password_hash", length = 255)
    private String cliPasswordHash;

    @PrePersist
    public void prePersist() {
        if (this.cliCreadoEn == null) this.cliCreadoEn = OffsetDateTime.now();
        if (this.cliPuntosAcumulados == null) this.cliPuntosAcumulados = 0;
        if (this.cliActivo == null) this.cliActivo = "T";
        if (this.cliCodigoQr == null) this.cliCodigoQr = UUID.randomUUID();
    }

    @PreUpdate
    public void preUpdate() {
        this.cliActualizadoEn = OffsetDateTime.now();
    }
}