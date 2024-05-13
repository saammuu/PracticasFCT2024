package com.softtek.dto;

import com.softtek.model.Empleado;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpleadoDTO {
    private int idEmpleado;
    @NotEmpty
    @Size(min=3, max=60)
    private String nombreEmpleado;

    @Min(16000)
    @Max(32000)
    private double sueldoEmpleado;

    @NotNull
    private String correoEmpleado;

    // Pasa de DTO a modelo
    public Empleado castToEmpleado(){
        Empleado e1 = new Empleado();
        e1.setIdEmpleado(idEmpleado);
        e1.setNombreEmpleado(nombreEmpleado);
        e1.setSueldoEmpleado(sueldoEmpleado);
        e1.setCorreoEmpleado(correoEmpleado);
        return e1;
    }

    // Pasa de modelo a DTO
    public EmpleadoDTO castToDTO(Empleado e){
        idEmpleado = e.getIdEmpleado();
        nombreEmpleado = e.getNombreEmpleado();
        sueldoEmpleado = e.getSueldoEmpleado();
        correoEmpleado = e.getCorreoEmpleado();
        return this;
    }
}
