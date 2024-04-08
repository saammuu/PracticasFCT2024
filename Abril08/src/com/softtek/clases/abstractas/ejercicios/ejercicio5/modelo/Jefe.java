package com.softtek.clases.abstractas.ejercicios.ejercicio5.modelo;

public class Jefe implements Empleado{
    private Informe informe;

    public Jefe(Informe informe) {
        this.informe = informe;
    }

    @Override
    public String getTareas() {
        return "Obteniendo tareas del Jefe...";
    }

    @Override
    public String getInformes() {
        return "Obteniendo informes para el Jefe";
    }
}
