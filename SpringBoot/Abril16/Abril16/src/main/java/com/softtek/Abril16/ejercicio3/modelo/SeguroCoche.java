package com.softtek.Abril16.ejercicio3.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeguroCoche {
    @Autowired
    private ITaller taller;
    private String aseguradora;
    public String reparar (Coche c){
        return taller.reparar(c);
    }

}
