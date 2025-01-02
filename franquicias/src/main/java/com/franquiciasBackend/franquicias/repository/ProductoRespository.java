package com.franquiciasBackend.franquicias.repository;

import com.franquiciasBackend.franquicias.entitys.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRespository extends JpaRepository<Producto, Long> {

    // Busqueda personalizada: Obtener producto que más stock tiene por sucursal para una franquicia
    @Query("SELECT p " +
            "FROM Producto p " +
            "WHERE p.stock = ( " +
            "    SELECT MAX(p2.stock) " +
            "    FROM Producto p2 " +
            "    WHERE p2.sucursal.id = p.sucursal.id " +
            ") AND p.sucursal.franquicia.id = :franquiciaId")
    List<Producto> findMaxStockProductsByFranquiciaId(@Param("franquiciaId") Long franquiciaId);

}
