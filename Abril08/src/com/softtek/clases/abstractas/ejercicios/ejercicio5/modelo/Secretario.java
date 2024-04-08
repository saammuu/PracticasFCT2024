package com.softtek.clases.abstractas.ejercicios.ejercicio5.modelo;

public class Secretario implements Empleado{
    private Informe informe;
    private String empresa;
    private String email;

    public Secretario() {
    }

    public Secretario(Informe informe, String empresa, String email) {
        this.informe = informe;
        this.empresa = empresa;
        this.email = email;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getTareas() {
        return "Obteniendo tareas para el Secretario";
    }

    @Override
    public String getInformes() {
        return informe.getInforme();
    }
}
