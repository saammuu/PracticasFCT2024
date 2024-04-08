package com.softtek.clases.abstractas.ejercicios.ejercicio9.presentación;

import com.softtek.clases.abstractas.ejercicios.ejercicio9.modelo.Calculadora;

public class UsoCalculadora {
    public static void main(String[] args) {
        Calculadora c = new Calculadora();

        double num1 = 3;
        double num2 = 0;

        try {
            System.out.println("Suma: " + c.sumar(num1, num2));
            System.out.println("Resta: " + c.restar(num1, num2));
            System.out.println("Multriplicacion: " + c.multiplicar(num1, num2));
            System.out.println("Division: " + c.dividir(num1, num2));
        }catch (ArithmeticException ae){
            ae.printStackTrace();
        }
    }
}
