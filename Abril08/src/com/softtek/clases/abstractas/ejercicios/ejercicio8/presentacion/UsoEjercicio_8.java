package com.softtek.clases.abstractas.ejercicios.ejercicio8.presentacion;

import com.softtek.clases.abstractas.ejercicios.ejercicio8.ProductoException;
import com.softtek.clases.abstractas.ejercicios.ejercicio8.modelo.Producto;

public class UsoEjercicio_8 {
    public static void main(String[] args) {
        Producto p = new Producto(2, "Iphone");
        try {
            p.comprobar();
        } catch (ProductoException e) {
            e.printStackTrace();
        }
    }
}
