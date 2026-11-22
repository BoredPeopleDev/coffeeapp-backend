package com.boredpeople.api_cofilovers.repositories;

import com.boredpeople.api_cofilovers.models.Administradores;
import com.boredpeople.api_cofilovers.models.dto.SuperSuResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperSuRepository extends CrudRepository<SuperSuResponse, Integer> {
    Optional<Administradores> findByCorreo(String correo);
}
