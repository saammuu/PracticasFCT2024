package com.softtek.presentacion;

public class Primitivos {
    public static double areaCuadrado (double lado){
        return lado*lado;
    }
    public static double areaCirculo (double radio){
        return Math.PI * (radio * radio);
    }
    public static double perimetroRectangulo (double base, double altura){
        return 2 * (base * altura);
    }

    public static void main(String[] args) {
        System.out.println("Área del cuadrado " + areaCuadrado(6));
        System.out.println("Área del circulo " +areaCirculo(3));
        System.out.println("Perimetro del rectangulo " +perimetroRectangulo(4,3));


/*        //--------------------
        int x = 6, y = 5, z = 6;
        y = ++x;
        z = --y;
        System.out.println(x , y, z);*/
    }
}
