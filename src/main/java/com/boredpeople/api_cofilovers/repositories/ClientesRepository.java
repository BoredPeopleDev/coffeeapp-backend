package com.boredpeople.api_cofilovers.repositories;

import com.boredpeople.api_cofilovers.models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, UUID> {
    Optional<Clientes> findByCorreo(String correo);
}
