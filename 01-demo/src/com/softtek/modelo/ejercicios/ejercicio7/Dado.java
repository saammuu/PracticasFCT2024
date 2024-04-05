package com.softtek.modelo.ejercicios.ejercicio7;

import java.util.Scanner;

//Model
class Dado {
    /**
     * Realizar la clase Dado su objetivo será lanzar un dado, mostrando el resultado por
     * pantalla. Se aconseja estructurar el programa de la siguiente forma. En el main se
     * invoca a los métodos de la clase dado. Una clase dado, que dispondrá de: Un
     * constructor que usa el método random de Math multiplicado por (6-1)+1.
     * La llamada a Math.random() devuelve un número aleatorio entre 0.0 y 1.0, excluido
     * este último valor, es decir, puede devolver 0.346442, 0.2344234, 0.98345,....
     * En muchas de nuestras aplicaciones no nos servirá este rango de valores. Por ejemplo,
     * si queremos simular una tirada de dado, queremos números entre 1 y 6 sin decimales.
     * Debemos echar unas cuentas para obtener lo deseado.
     * En primer lugar, miramos cuántos valores queremos. En nuestro caso del dado son 6
     * valores, del 1 al 6 ambos incluido. Debemos entonces multiplicar Math.random() por 6
     * (que es (maximo-minimimo)+1, es decir, (6-1)+1)Los métodos serán: Seis para
     * dibujar por pantalla la imagen de los números. Otro para lanzar(), que generará un
     * número aleatorio entre 1 y 6, invocará al método dibujar que le corresponda.
     */
    public int lanzar(){
        return (int) (Math.random() * 6) + 1;
    }

    public StringBuilder dibujar(int resultado) {
        StringBuilder sb = new StringBuilder("");
        switch (resultado){
            case 1:
                sb.append("---\n")
                        .append("-*-\n")
                        .append("---");
                break;
            case 2:
                sb.append("*--\n")
                        .append("---\n")
                        .append("--*");
                break;
            case 3:
                sb.append("*--\n")
                        .append("-*-\n")
                        .append("--*");
                break;
            case 4:
                sb.append("*-*\n")
                        .append("---\n")
                        .append("*-*");
                break;
            case 5:
                sb.append("*-*\n")
                        .append("-*-\n")
                        .append("*-*");
                break;
            case 6:
                sb.append("*-*\n")
                        .append("*-*\n")
                        .append("*-*");
                break;
        }
        return sb;
    }
}

//View
class usoDado{
    public static void main(String[] args) {
        Dado dado = new Dado();
        Scanner sc = new Scanner(System.in);
        String res;

        do {
            int resultado = dado.lanzar();
            System.out.println(dado.dibujar(resultado));
            System.out.println("Quieres lanzar otra vez? (S/N)");
            res = sc.nextLine();
        }while (res.equalsIgnoreCase("s"));
        sc.close();
    }
}