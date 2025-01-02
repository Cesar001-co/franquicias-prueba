package com.franquiciasBackend.franquicias.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sucursales")
public class Sucursal {

    // Id de la tabla sucursales
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Long idSucursal;

    // Campo que identifica el nombre de la sucursal
    @Column(nullable = false)
    private String nombre;

    // Campo que identifica la llave foránea de la tabla franquicias
    @ManyToOne
    @JoinColumn(name = "franquicia_id", nullable = false)
    private Franquicia franquicia;

    // Campo que identifica la llave foránea de la tabla productos
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal")
    @JsonBackReference
    private List<Producto> productos;

    public Sucursal(Long idSucursal, String nombre, Franquicia franquicia, List<Producto> productos) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.franquicia = franquicia;
        this.productos = productos;
    }

    public Sucursal() {
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
