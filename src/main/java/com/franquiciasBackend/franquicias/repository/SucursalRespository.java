package com.franquiciasBackend.franquicias.repository;

import com.franquiciasBackend.franquicias.entitys.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRespository extends JpaRepository<Sucursal, Long> {
}
