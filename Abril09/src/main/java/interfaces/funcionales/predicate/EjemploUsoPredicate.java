package interfaces.funcionales.predicate;

import java.util.function.Predicate;

public class EjemploUsoPredicate {
    // Predicado para números positivos: Verificar si un número entero es positivo.
    private static void metodo1(){
        Predicate<Integer> esMayor = x -> x >0;
        System.out.println(esMayor.test(56));
    }
    // Predicado para cadenas no vacías: Comprobar si una cadena de texto no está vacía.
    private static void metodo2(){
        Predicate<String> esVacio = cadena -> cadena.length() > 0;
        System.out.println(esVacio.test("No soy vacio"));
    }

    // Predicado para números pares: Determinar si un número entero es par.
    private static void metodo3(){
        Predicate<Integer> esPar = x -> x%2 == 0;
        System.out.println(esPar.test(4));
    }

    //Predicado para números mayores que un valor dado:Comprobar si un número entero
    //es mayor que un valor específico.
    private static void metodo4(){
        int n = 20;
        Predicate<Integer> esMayorQue = x -> x > n;
        System.out.println(esMayorQue.test(15));
    }

    //Predicado para números primos:Determinar si un número entero es primo.
    private static void metodo5(){
        Predicate<Integer> esPrimo = x -> {
            if (x<=1) return false;
            for (int i = 2; i <= Math.sqrt(x); i++){
                if (x % i == 0) return false;
            }
          return true;
        };
        System.out.println(esPrimo.test(4));
    }

    public static void main(String[] args) {
        metodo1();
        metodo2();
        metodo3();
        metodo4();
        metodo5();
    }
}
