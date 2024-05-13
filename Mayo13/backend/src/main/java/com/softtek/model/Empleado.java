package com.softtek.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;

    @Column(length = 60, nullable = false)
    private String nombreEmpleado;

    @Column(nullable = false)
    private double sueldoEmpleado;

    @Column(length = 40, nullable = false, unique = true)
    private String correoEmpleado;
}
