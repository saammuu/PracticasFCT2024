package com.softtek.herencia.ejercicios.ejercicio4.modelo;

public class InstrumentoMusical {
    protected String marca;

    public InstrumentoMusical() {
    }

    public InstrumentoMusical(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String emitirSonido(){
        return "Sonido por defecto";
    }

    @Override
    public String toString() {
        return "InstrumentoMusical{" +
                "marca='" + marca + '\'' +
                '}';
    }
}
