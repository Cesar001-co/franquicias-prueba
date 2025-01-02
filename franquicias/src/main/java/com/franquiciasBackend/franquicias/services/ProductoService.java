package com.franquiciasBackend.franquicias.services;

import com.franquiciasBackend.franquicias.DTO.ProductoConSucursalDTO;
import com.franquiciasBackend.franquicias.DTO.StockDTO;
import com.franquiciasBackend.franquicias.entitys.Franquicia;
import com.franquiciasBackend.franquicias.entitys.Producto;
import com.franquiciasBackend.franquicias.repository.FranquiciaRepository;
import com.franquiciasBackend.franquicias.repository.ProductoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private ProductoRespository productoRepo;

    @Autowired
    private FranquiciaRepository franquiciaRepo;

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

    // 7. Obtener productos con más stock por sucursal para una franquicia
    public List<ProductoConSucursalDTO> obtenerProductosConMasStockPorFranquicia(Long franquiciaId) {
        // validar si franquisia existe
        Franquicia franquicia = franquiciaRepo.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        List<Producto> productos = productoRepo.findMaxStockProductsByFranquiciaId(franquiciaId);
        return productos.stream()
                .map(p -> new ProductoConSucursalDTO(
                        p.getIdProducto(),
                        p.getNombre(),
                        p.getStock(),
                        p.getSucursal().getNombre(),
                        p.getSucursal().getIdSucursal()
                ))
                .collect(Collectors.toList());
    }

    // Plus: Actualizar nombre producto
    public Producto actualizarNombreProducto(Long productoId, String nuevoNombre) {
        // verificar si producto existe
        Producto producto = productoRepo.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        String nombre = nuevoNombre.toUpperCase(Locale.ROOT);
        producto.setNombre(nombre);

        return productoRepo.save(producto);
    }
}
