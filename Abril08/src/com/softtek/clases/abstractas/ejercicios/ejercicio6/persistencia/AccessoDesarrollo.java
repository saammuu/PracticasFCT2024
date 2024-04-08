package com.softtek.clases.abstractas.ejercicios.ejercicio6.persistencia;

import com.softtek.clases.abstractas.ejercicios.ejercicio6.modelo.Cliente;

public class AccessoDesarrollo implements IDAO{
    public AccessoDesarrollo() {
    }

    @Override
    public String insertar(Cliente c1) {
        return "Insertando al area de desarrollo al Cliente: " + c1.getNombre() + " con NIF: " + c1.getNIF();
    }
}
