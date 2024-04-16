package com.softtek.Abril16.ejercicio4.modelo;

public class Jefe implements Empleado{
    private Informe informe;

    public Jefe() {
    }

    public Jefe(Informe informe) {
        this.informe = informe;
    }

    @Override
    public String getTareas() {
        return "Obteniendo tareas del Jefe...";
    }

    @Override
    public String getInformes() {
        return informe.getInforme();
    }
}
