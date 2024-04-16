package com.softtek.Abril16.ejercicio5.persistencia;

import com.softtek.Abril16.ejercicio5.modelo.Cliente;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccesoProduccion implements IDAO{
    @Override
    public String insertar(Cliente c1) {
        return "Insertando al area de producción al Cliente: " + c1.getNombre() + " con NIF: " + c1.getNIF();
    }
}
