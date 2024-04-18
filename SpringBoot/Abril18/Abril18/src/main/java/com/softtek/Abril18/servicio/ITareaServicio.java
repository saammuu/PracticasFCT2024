package com.softtek.Abril18.servicio;

import com.softtek.Abril18.modelo.Tarea;

public interface ITareaServicio {
    Tarea obtenerTarea();
    Tarea crearTarea(Tarea t);
    void eliminarTarea(int id);
}
