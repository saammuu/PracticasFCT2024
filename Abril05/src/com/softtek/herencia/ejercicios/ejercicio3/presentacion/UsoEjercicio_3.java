package com.softtek.herencia.ejercicios.ejercicio3.presentacion;

import com.softtek.herencia.ejercicios.ejercicio3.modelo.Cuadrado;
import com.softtek.herencia.ejercicios.ejercicio3.modelo.Figura;
import com.softtek.herencia.ejercicios.ejercicio3.modelo.Triangulo;

public class UsoEjercicio_3 {
    public static void main(String[] args) {
        Cuadrado cPeque = new Cuadrado();
        cPeque.setLado(4.5);
        System.out.println(cPeque);

        Cuadrado cMediano = new Cuadrado(2,2, 8.3);
        System.out.println(cMediano);

        Triangulo tPeque = new Triangulo();
        tPeque.setX(3);
        tPeque.setY(5);
        tPeque.setAltura(3);
        tPeque.setBase(6);
        System.out.println(tPeque);

        Triangulo tMediano = new Triangulo(2,3,6,4);
        System.out.println(tMediano);

        Figura figuras [] = {cPeque, tPeque, cMediano, tMediano};
        for (Figura figura : figuras) {
            System.out.println("El area de la figura: " + figura.calcularArea());
        }


    }
}
