package com.softtek.herencia.ejercicios.ejercicio4.modelo;

public class Guitarra extends InstrumentoMusical{
    private String tipoCuerdas;

    public Guitarra() {
    }

    public Guitarra(String marca, String tipoCuerdas) {
        super(marca);
        this.tipoCuerdas = tipoCuerdas;
    }

    public String getTipoCuerdas() {
        return tipoCuerdas;
    }

    public void setTipoCuerdas(String tipoCuerdas) {
        this.tipoCuerdas = tipoCuerdas;
    }

    @Override
    public String emitirSonido() {
        return "Soy una guitarra";
    }

    @Override
    public String toString() {
        return "Guitarra{" +
                "tipoCuerdas='" + tipoCuerdas + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
