package com.softtek.herencia.ejercicios.ejercicio2.presentacion;

import com.softtek.herencia.ejercicios.ejercicio2.modelo.Empleado;
import com.softtek.herencia.ejercicios.ejercicio2.modelo.Gerente;
import com.softtek.herencia.ejercicios.ejercicio2.modelo.Operador;
import com.softtek.herencia.ejercicios.ejercicio2.modelo.Vendedor;

public class UsoEjercicio_2 {
    public static void main(String[] args) {
        Empleado emp = new Empleado("Pedro", 1200);
        Gerente grn = new Gerente("Ramon", 1700, 200);
        Vendedor vnd = new Vendedor("Maria", 1500, 200, 0.3);
        Operador op = new Operador("Sofia", 1400, 600, 1.5);

        System.out.println(emp);
        System.out.println("Nomina calculada: " + emp.calcularNomina());
        System.out.println("===================================================");

        System.out.println(grn);
        System.out.println("Nomina calculada: " + grn.calcularNomina());
        System.out.println("===================================================");

        System.out.println(vnd);
        System.out.println("Nomina calculada: " + vnd.calcularNomina());
        System.out.println("===================================================");

        System.out.println(op);
        System.out.println("Nomina calculada: " + op.calcularNomina());
        System.out.println("===================================================");
    }
}
