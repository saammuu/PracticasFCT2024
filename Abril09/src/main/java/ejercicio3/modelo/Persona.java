package ejercicio3.modelo;

import ejercicio3.EstadoCivil;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {
    private String nombre;
    private int edad;
    private EstadoCivil estadoCivil;


    @Override
    public String toString() {
        return "PERSONA = {Nombre:"+this.getNombre() + ", edad: "+ this.getEdad() +", estado civil: "+this.getEstadoCivil()+"  }";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Persona p = (Persona) obj;
        if (this.edad != p.getEdad()) return false;

        if (estadoCivil != p.getEstadoCivil()) return false;

        return true;

    }
}
