package com.softtek.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;

    @Column(length = 60, nullable = false)
    private String nombre;

    @Column(length = 60, nullable = false)
    private String ubicacion;

    //Por si el front lo pide
    // Por ej: Proveedores y sus productos
    @ManyToMany(
            mappedBy = "proveedores",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    List<Producto> productos;
}
