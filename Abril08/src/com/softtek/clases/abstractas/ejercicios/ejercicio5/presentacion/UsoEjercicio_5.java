package com.softtek.clases.abstractas.ejercicios.ejercicio5.presentacion;

import com.softtek.clases.abstractas.ejercicios.ejercicio5.modelo.*;

public class UsoEjercicio_5 {
    public static void main(String[] args) {
        InformeTrimestre1 inf1 = new InformeTrimestre1();
        InformeTrimestre2 inf2 = new InformeTrimestre2();

        Empleado director = new Director(inf2);
        System.out.println(director.getTareas());
        System.out.println(director.getInformes());

    }
}
