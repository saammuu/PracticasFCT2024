package com.softtek.clases.abstractas.ejercicios.ejercicio6.persistencia;

import com.softtek.clases.abstractas.ejercicios.ejercicio6.modelo.Cliente;

public class ClienteDAO {
    private IDAO conexion;

    public ClienteDAO() {
    }

    public ClienteDAO(IDAO conexion) {
        this.conexion = conexion;
    }

    public String insertar(Cliente c1){
        return conexion.insertar(c1);
    }
}
