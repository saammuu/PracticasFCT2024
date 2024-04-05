package com.softtek.herencia.ejercicios.ejercicio1.presentacion;

import com.softtek.herencia.ejercicios.ejercicio1.modelo.Producto;
import com.softtek.herencia.ejercicios.ejercicio1.modelo.ProductoPerecedero;

import java.time.LocalDate;

public class UsoEjercicio_1 {
    public static void main(String[] args) {
        ProductoPerecedero pp = new ProductoPerecedero(
                "Tomate Frito",
                4,
                3.45,
                LocalDate.of(2024, 10, 23),
                LocalDate.now()
        );

        System.out.println(pp);
        System.out.println("Tiempo de consumición: "+ pp.tiempoConsumicion() + " días");
    }
}
