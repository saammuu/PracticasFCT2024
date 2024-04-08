package com.softtek.clases.abstractas.ejercicios.ejercicio5.modelo;

public class Director implements Empleado{
    private Informe informe;

    public Director(Informe informe) {
        this.informe = informe;
    }

    @Override
    public String getTareas() {
        return "Obteniendo tareas para el Director...";
    }

    @Override
    public String getInformes() {
        return "Obteniendo informes para el Director";
    }
}
