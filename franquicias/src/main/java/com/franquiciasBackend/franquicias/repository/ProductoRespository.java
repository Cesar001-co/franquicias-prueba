package com.franquiciasBackend.franquicias.repository;

import com.franquiciasBackend.franquicias.entitys.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRespository extends JpaRepository<Producto, Long> {

}
