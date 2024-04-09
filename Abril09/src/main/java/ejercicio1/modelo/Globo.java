package ejercicio1.modelo;

import lombok.Data;

@Data
public class Globo {
    public static int CONTADOR = 0;
    private final int ID;

    public Globo() {
        this.ID = ++CONTADOR;
    }
}
