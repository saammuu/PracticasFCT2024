package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public final class Producto {
    public static int CONTADOR = 0;
    private final int ID;
    private String nombre;
    private double precio;

    public Producto() {
        this.ID = ++CONTADOR;
    }


    public double importe(int cantidad){
        return cantidad * precio;
    }
}
