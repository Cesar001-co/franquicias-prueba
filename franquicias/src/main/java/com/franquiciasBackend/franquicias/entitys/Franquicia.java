package com.franquiciasBackend.franquicias.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "franquicias")
public class Franquicia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_franquicia")
    private long idFranquicia;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "franquicia")
    private List<Sucursal> sucursales;

    public Franquicia(long idFranquicia, String nombre, List<Sucursal> sucursales) {
        this.idFranquicia = idFranquicia;
        this.nombre = nombre;
        this.sucursales = sucursales;
    }

    public long getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(long idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }
}
