package com.franquiciasBackend.franquicias.services;

import com.franquiciasBackend.franquicias.DTO.StockDTO;
import com.franquiciasBackend.franquicias.entitys.Producto;
import com.franquiciasBackend.franquicias.repository.ProductoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRespository productoRepo;

    // 5. Eliminar un producto de una sucursal
    public void eliminarProducto(Long sucursalId, Long productoId) {
        // validar si producto existe
        Producto producto = productoRepo.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // verificar si el producto pertenece a la sucursal
        if (!producto.getSucursal().getIdSucursal().equals(sucursalId)) {
            throw new RuntimeException("El producto no pertenece a la sucursal especificada");
        }
        productoRepo.delete(producto);
    }

    // 6. Modificar el stock de un producto
    public Producto modificarStockProducto(Long productoId, StockDTO stockDTO) {
        // validar si producto existe
        Producto producto = productoRepo.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setStock(stockDTO.getNuevoStock());
        return productoRepo.save(producto);
    }
}
