package com.boredpeople.api_cofilovers.repositories;

import com.boredpeople.api_cofilovers.models.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Empleados, Integer> {
    @Query (value = "SELECT GETEMPLEADOS()", nativeQuery = true)
    String getEmpleados();
}
