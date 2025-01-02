package com.franquiciasBackend.franquicias.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    // Id de la tabla productos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    //Campo que identifica el nombre del producto
    @Column(nullable = false)
    private String nombre;

    //Campo que identifica la cantidad del stock
    @Column(nullable = false)
    private int stock;

    //Campo que identifica la llave foranea de la tabla sucursales
    @ManyToOne
    @JoinColumn(name = "sucursal_id", nullable = false)
    private Sucursal sucursal;

    public Producto(Long idProducto, String nombre, int stock, Sucursal sucursal) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.sucursal = sucursal;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
