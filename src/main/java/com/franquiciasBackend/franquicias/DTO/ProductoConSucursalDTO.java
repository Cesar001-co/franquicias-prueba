package com.franquiciasBackend.franquicias.DTO;

public class ProductoConSucursalDTO {
    private Long idProducto;
    private String nombre;
    private Integer stock;
    private String nombreSucursal;
    private Long sucursal_id;

    public ProductoConSucursalDTO(Long idProducto, String nombre, Integer stock, String nombreSucursal, Long sucursal_id) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.nombreSucursal = nombreSucursal;
        this.sucursal_id = sucursal_id;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public Long getSucursal_id() {
        return sucursal_id;
    }

    public void setSucursal_id(Long sucursal_id) {
        this.sucursal_id = sucursal_id;
    }
}
