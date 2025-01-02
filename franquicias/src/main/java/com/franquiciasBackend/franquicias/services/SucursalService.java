package com.franquiciasBackend.franquicias.services;

import com.franquiciasBackend.franquicias.DTO.ProductoDTO;
import com.franquiciasBackend.franquicias.DTO.SucursalDTO;
import com.franquiciasBackend.franquicias.entitys.Franquicia;
import com.franquiciasBackend.franquicias.entitys.Producto;
import com.franquiciasBackend.franquicias.entitys.Sucursal;
import com.franquiciasBackend.franquicias.repository.FranquiciaRepository;
import com.franquiciasBackend.franquicias.repository.ProductoRespository;
import com.franquiciasBackend.franquicias.repository.SucursalRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SucursalService {

    @Autowired
    private SucursalRespository sucursalRepo;

    @Autowired
    private ProductoRespository productoRepo;

    // 4. Agregar un nuevo producto a una sucursal
    public Producto agregarProducto(Long sucursalId, ProductoDTO productoDTO) {
        Sucursal sucursal = sucursalRepo.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setStock(productoDTO.getStock());
        producto.setSucursal(sucursal);
        sucursal.getProductos().add(producto);
        return productoRepo.save(producto);
    }
}
