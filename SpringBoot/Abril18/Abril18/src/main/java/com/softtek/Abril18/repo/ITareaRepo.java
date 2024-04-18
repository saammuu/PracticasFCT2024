package com.softtek.Abril18.repo;

import com.softtek.Abril18.modelo.Tarea;

public interface ITareaRepo {
    Tarea obtenerTarea();
    Tarea crearTarea(Tarea t);
    void eliminarTarea (int id);
}
