package com.softtek.clases.abstractas.ejercicios.ejercicio6.presentacion;

import com.softtek.clases.abstractas.ejercicios.ejercicio6.modelo.Cliente;
import com.softtek.clases.abstractas.ejercicios.ejercicio6.persistencia.AccesoProducción;
import com.softtek.clases.abstractas.ejercicios.ejercicio6.persistencia.AccessoDesarrollo;
import com.softtek.clases.abstractas.ejercicios.ejercicio6.persistencia.ClienteDAO;
import com.softtek.clases.abstractas.ejercicios.ejercicio6.persistencia.IDAO;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("John","09183091F");
        IDAO conexion = new AccessoDesarrollo();
        ClienteDAO clienteDAO = new ClienteDAO(conexion);
        System.out.println(clienteDAO.insertar(cliente));
    }
}
