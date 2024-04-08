package com.softtek.clases.abstractas.ejercicios.ejercicio1.modelo;

public class Pez extends Animal{
    public Pez() {
    }

    @Override
    public String comer() {
        return "Como como un pez";
    }

    @Override
    public String moverse() {
        return "Me muevo como un pez";
    }
}
