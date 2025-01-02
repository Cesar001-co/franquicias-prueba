package com.franquiciasBackend.franquicias.controller;

import com.franquiciasBackend.franquicias.DTO.FranquiciaDTO;
import com.franquiciasBackend.franquicias.DTO.SucursalDTO;
import com.franquiciasBackend.franquicias.entitys.Franquicia;
import com.franquiciasBackend.franquicias.entitys.Sucursal;
import com.franquiciasBackend.franquicias.services.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/franquicias")
public class FranquiciaController {

    @Autowired
    private FranquiciaService franquicaService;

    @PostMapping()
    public ResponseEntity<Franquicia> agregarFranquicia(@RequestBody FranquiciaDTO franquiciaDTO) {
        Franquicia nuevaFranquicia = franquicaService.crearFranquicia(franquiciaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFranquicia);
    }

    @PostMapping("/{id}/sucursales")
    public ResponseEntity<Sucursal> agregarSucursal(@PathVariable Long id, @RequestBody SucursalDTO sucursalDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(franquicaService.agregarSucursal(id, sucursalDTO));
    }
}
