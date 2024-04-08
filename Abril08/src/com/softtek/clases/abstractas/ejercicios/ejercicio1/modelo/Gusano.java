package com.softtek.clases.abstractas.ejercicios.ejercicio1.modelo;

public class Gusano extends Animal{
    public Gusano() {
    }

    @Override
    public String comer() {
        return "Como como un gusano";
    }

    @Override
    public String moverse() {
        return "Me muevo como un gusano";
    }
}
