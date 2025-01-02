package com.franquiciasBackend.franquicias.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sucursales")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Long idSucursal;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "franquicia_id", nullable = false)
    private Franquicia franquicia;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "sucursal")
    private List<Producto> productos;

    public Sucursal(Long idSucursal, String nombre, Franquicia franquicia, List<Producto> productos) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.franquicia = franquicia;
        this.productos = productos;
    }

    public Long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
