package com.franquiciasBackend.franquicias.controller;

import com.franquiciasBackend.franquicias.DTO.FranquiciaDTO;
import com.franquiciasBackend.franquicias.DTO.ProductoConSucursalDTO;
import com.franquiciasBackend.franquicias.DTO.SucursalDTO;
import com.franquiciasBackend.franquicias.entitys.Franquicia;
import com.franquiciasBackend.franquicias.entitys.Producto;
import com.franquiciasBackend.franquicias.entitys.Sucursal;
import com.franquiciasBackend.franquicias.services.FranquiciaService;
import com.franquiciasBackend.franquicias.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/franquicias")
public class FranquiciaController {

    @Autowired
    private FranquiciaService franquiciaService;

    @Autowired
    private ProductoService productoService;

    @PostMapping()
    public ResponseEntity<Franquicia> agregarFranquicia(@RequestBody FranquiciaDTO franquiciaDTO) {
        Franquicia nuevaFranquicia = franquiciaService.crearFranquicia(franquiciaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFranquicia);
    }

    @PostMapping("/{id}/sucursales")
    public ResponseEntity<Sucursal> agregarSucursal(@PathVariable Long id, @RequestBody SucursalDTO sucursalDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(franquiciaService.agregarSucursal(id, sucursalDTO));
    }

    @GetMapping("/{franquiciaId}/max-stock")
    public ResponseEntity<List<ProductoConSucursalDTO>> obtenerProductosConMasStockPorFranquicia(@PathVariable Long franquiciaId) {
        List<ProductoConSucursalDTO> productos = productoService.obtenerProductosConMasStockPorFranquicia(franquiciaId);
        return ResponseEntity.status(HttpStatus.OK).body(productos);
    }

    @PutMapping("/{id}/nombre")
    public ResponseEntity<Franquicia> actualizarNombreFranquicia(@PathVariable Long id, @RequestBody FranquiciaDTO franquiciaDTO) {
        return ResponseEntity.ok(franquiciaService.actualizarNombreFranquicia(id, franquiciaDTO.getNombre()));
    }
}
