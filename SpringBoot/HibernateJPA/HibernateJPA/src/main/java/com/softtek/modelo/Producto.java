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
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(length = 30, nullable = false)
    private String nombre;

    @Column(length = 30, nullable = false)
    private String descripcion;

    private double precio;
    private int cantidadExistencia;

    @ManyToMany
    @JoinTable(
            name = "producto_proveedores",
            joinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "idProducto"),
            inverseJoinColumns = @JoinColumn(name = "id_proveedor", referencedColumnName = "idProveedor")
    )
    private List<Proveedor> proveedores;

}
