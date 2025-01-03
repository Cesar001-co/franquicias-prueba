package com.franquiciasBackend.franquicias.controller;

import com.franquiciasBackend.franquicias.DTO.ProductoDTO;
import com.franquiciasBackend.franquicias.DTO.StockDTO;
import com.franquiciasBackend.franquicias.DTO.SucursalDTO;
import com.franquiciasBackend.franquicias.entitys.Producto;
import com.franquiciasBackend.franquicias.entitys.Sucursal;
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
    private ProductoService productoService;

    // 4. Agregar un nuevo producto a una sucursal
    @PostMapping("/{id}/productos")
    public ResponseEntity<Producto> agregarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(sucursalService.agregarProducto(id, productoDTO));
    }

    // 5. Eliminar un producto de una sucursal
    @DeleteMapping("/{id}/productos/{idProducto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id, @PathVariable Long idProducto) {
        productoService.eliminarProducto(id, idProducto);
        return ResponseEntity.noContent().build();
    }

    // 6. Modificar el stock de un producto
    @PutMapping("/productos/{id}/stock")
    public ResponseEntity<Producto> modificarStockProducto(@PathVariable Long id, @RequestBody StockDTO stockDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(productoService.modificarStockProducto(id, stockDTO));
    }

    // Plus: Actualizar el nombre de una sucursal
    @PutMapping("/{id}/nombre")
    public ResponseEntity<Sucursal> actualizarNombreSucursal(@PathVariable Long id, @RequestBody SucursalDTO sucursalDTO) {
        return ResponseEntity.ok(sucursalService.actualizarNombreSucursal(id, sucursalDTO.getNombre()));
    }
}
