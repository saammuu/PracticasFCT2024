package com.softtek.Abril18.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private int idProducto;
    private String nombreProducto;
    private double precioUnitario;
    private int discontinuado;
}
