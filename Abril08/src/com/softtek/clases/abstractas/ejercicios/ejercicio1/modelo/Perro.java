package com.softtek.clases.abstractas.ejercicios.ejercicio1.modelo;

public class Perro extends Animal{
    public Perro() {
    }

    @Override
    public String comer() {
        return "Como como un perro";
    }

    @Override
    public String moverse() {
        return "Me muevo como un perro";
    }
}
