package ejercicio2.modelo;

public class Calculadora {
    public static double sumar(double n1, double n2){
        return n1 + n2;
    }
    public static double restar(double n1, double n2){
        return n1 - n2;
    }
    public static double multiplicar(double n1, double n2){
        return n1 * n2;
    }
    public static double dividir (double n1, double n2){
        if (n2 == 0) throw new ArithmeticException("No se puede dividir por 0 ");
        return n1/n2;
    }
}
