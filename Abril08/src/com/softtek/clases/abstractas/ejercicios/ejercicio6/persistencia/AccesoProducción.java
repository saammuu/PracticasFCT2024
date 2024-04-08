package com.softtek.clases.abstractas.ejercicios.ejercicio6.persistencia;

import com.softtek.clases.abstractas.ejercicios.ejercicio6.modelo.Cliente;

public class AccesoProducción implements IDAO{
    public AccesoProducción() {
    }

    @Override
    public String insertar(Cliente c1) {
        return "Insertando al area de producción al Cliente: " + c1.getNombre() + " con NIF: " + c1.getNIF();
    }
}
