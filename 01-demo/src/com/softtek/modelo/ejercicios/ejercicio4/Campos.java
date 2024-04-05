package com.softtek.modelo.ejercicios.ejercicio4;

class Campos {
    /**
     * Realizar una clase llamada Campos con dos métodos uno muestra y el otro
     * incrementa. El método Muestra, es una función que da como resultado el valor de x, El
     * método Incrementa: Incrementa el valor de X.,El constructor el valor inicial al campo
     * X.,Crear una instancia en el módulo principal de la aplicación, incrementar y mostrar el
     * resultado.
     */

    private int x;

    public Campos(int x) {
        this.x = x;
    }

    public int muestra() {
        return x;
    }

    public int incrementa() {
        return this.x += 1;
    }
}

class UsoCampos{
    public static void main(String[] args) {
        Campos campo = new Campos(4);
        System.out.println(campo.muestra());
        System.out.println(campo.incrementa());
    }
}
