package com.franquiciasBackend.franquicias.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "sucursales")
public class SucursalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Long idSucursal;

    @Column(nullable = false)
    private String nombre;

//    @ManyToOne
//    @JoinColumn(name = "franquicia_id", nullable = false)
//    private Franquicia franquicia;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "sucursal")
//    private List<Producto> productos;
}
