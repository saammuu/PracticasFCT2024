package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellidos;
    private int jefe;
}
