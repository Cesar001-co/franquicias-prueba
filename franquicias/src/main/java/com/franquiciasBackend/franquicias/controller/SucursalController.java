package com.franquiciasBackend.franquicias.controller;

import com.franquiciasBackend.franquicias.DTO.ProductoDTO;
import com.franquiciasBackend.franquicias.entitys.Producto;
import com.franquiciasBackend.franquicias.services.ProductoService;
import com.franquiciasBackend.franquicias.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private ProductoService productpService;

    @PostMapping("/{id}/productos")
    public ResponseEntity<Producto> agregarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(sucursalService.agregarProducto(id, productoDTO));
    }

    @DeleteMapping("/{id}/productos/{idProducto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id, @PathVariable Long idProducto) {
        productpService.eliminarProducto(id, idProducto);
        return ResponseEntity.noContent().build();
    }
}
