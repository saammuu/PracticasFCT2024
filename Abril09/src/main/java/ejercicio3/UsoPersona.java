package ejercicio3;

import ejercicio1.modelo.Globo;
import ejercicio3.modelo.Persona;

public class UsoPersona {
    public static void main(String[] args) {
        Persona p1 = new Persona("Pepe", 23, EstadoCivil.SOLTERO);
        Persona p2 = new Persona("Maria", 20, EstadoCivil.SOLTERO);
        Globo g1 = new Globo();

        System.out.println(p1);
        System.out.println(p2);

        System.out.println("¿Son el mismo?");
        System.out.println(p1.equals(p2));

        System.out.println("¿Son el mismo?");
        System.out.println(p1.equals(g1));
    }
}
