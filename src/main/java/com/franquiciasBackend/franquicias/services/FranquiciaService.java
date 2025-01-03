package com.franquiciasBackend.franquicias.services;

import com.franquiciasBackend.franquicias.DTO.FranquiciaDTO;
import com.franquiciasBackend.franquicias.DTO.ProductoDTO;
import com.franquiciasBackend.franquicias.DTO.SucursalDTO;
import com.franquiciasBackend.franquicias.entitys.Franquicia;
import com.franquiciasBackend.franquicias.entitys.Producto;
import com.franquiciasBackend.franquicias.entitys.Sucursal;
import com.franquiciasBackend.franquicias.repository.FranquiciaRepository;
import com.franquiciasBackend.franquicias.repository.SucursalRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepo;

    @Autowired
    private SucursalRespository sucursalRepo;

    // 1. Agregar una nueva franquicia
    public Franquicia crearFranquicia(FranquiciaDTO franquiciaDTO){
        Franquicia franquicia = new Franquicia();
        franquicia.setNombre(franquiciaDTO.getNombre());
        franquicia.setSucursales(new ArrayList<>());
        return franquiciaRepo.save(franquicia);
    }

    // 2. Agregar una nueva sucursal a una franquicia
    public Sucursal agregarSucursal(Long franquiciaId, SucursalDTO sucursalDTO) {
        // verificar si franquicia existe
        Franquicia franquicia = franquiciaRepo.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(sucursalDTO.getNombre());
        sucursal.setFranquicia(franquicia);
        sucursal.setProductos(new ArrayList<>());
        return sucursalRepo.save(sucursal);
    }

    // Plus: Actualizar en nombre de la franquicia
    public Franquicia actualizarNombreFranquicia(Long franquiciaId, String nuevoNombre) {
        // verificar si franquicia existe
        Franquicia franquicia = franquiciaRepo.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        franquicia.setNombre(nuevoNombre);
        return franquiciaRepo.save(franquicia);
    }
}
