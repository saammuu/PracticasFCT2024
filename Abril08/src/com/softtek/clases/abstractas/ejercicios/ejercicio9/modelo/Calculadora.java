package com.softtek.clases.abstractas.ejercicios.ejercicio9.modelo;

public class Calculadora {
    public  double sumar(double n1, double n2){
        return n1 + n2;
    }
    public  double restar(double n1, double n2){
        return n1 - n2;
    }
    public  double multiplicar(double n1, double n2){
        return n1 * n2;
    }
    public  double dividir (double n1, double n2){
        if (n2 == 0) throw new ArithmeticException("No se puede dividir por 0 ");
        return n1/n2;
    }
}
