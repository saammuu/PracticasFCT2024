package com.softtek.clases.abstractas.ejercicios.ejercicio1.modelo;

public class Pajaro extends Animal{
    public Pajaro() {
    }

    @Override
    public String comer() {
        return "Como como un pajaro";
    }

    @Override
    public String moverse() {
        return "Me muevo como un pajaro";
    }
}
