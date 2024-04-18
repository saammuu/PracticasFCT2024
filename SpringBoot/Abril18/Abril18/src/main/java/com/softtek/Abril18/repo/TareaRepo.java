package com.softtek.Abril18.repo;

import com.softtek.Abril18.modelo.Tarea;
import org.springframework.stereotype.Repository;

@Repository
public class TareaRepo implements ITareaRepo{
    public Tarea obtenerTarea(){
        return new Tarea(10, "Crear juego");
    }

    @Override
    public Tarea crearTarea(Tarea t) {
        t.setIdTarea(1);
        return t;
    }

    @Override
    public void eliminarTarea(int id) {
    }
}
