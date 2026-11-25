package com.boredpeople.api_cofilovers.repositories;

import com.boredpeople.api_cofilovers.models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, UUID> {
    //Validar inicio de sesion
    Optional<Clientes> findByCliCorreoAndCliEliminadoEnIsNullAndCliActivo(
            String cliCorreo, String cliActivo);

    //Validar correo
    boolean existsByCliCorreo(String cliCorreo);
}
