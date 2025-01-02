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
}
