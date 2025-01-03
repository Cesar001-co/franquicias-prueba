package com.franquiciasBackend.franquicias.controller;

import com.franquiciasBackend.franquicias.DTO.NombreDTO;
import com.franquiciasBackend.franquicias.entitys.Producto;
import com.franquiciasBackend.franquicias.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Plus: Actualizar nombre producto
    @PutMapping("/{id}/nombre")
    public ResponseEntity<Producto> actualizarNombreProducto(@PathVariable Long id, @RequestBody NombreDTO nombreDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(productoService.actualizarNombreProducto(id, nombreDTO.getNuevoNombre()));
    }
}
