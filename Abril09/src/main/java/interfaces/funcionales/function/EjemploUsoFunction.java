package interfaces.funcionales.function;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.function.Function;

public class EjemploUsoFunction {

    /**
     * Filtrado de elementos de una lista: Define una función que tome una lista de
     * números como entrada y devuelva una lista que solo contenga los números
     * pares. Utiliza la interfaz funcional Function para filtrar los elementos de la
     * lista.
     *
     */
    public static void metodo1(){
        int[] arrayNumeros = {0,1,2,3,4,6,8,7,9,2,-3,-2,2};
        Function<int[], ArrayList> lista = x -> {
            ArrayList<Integer> miArrayList = new ArrayList<>();
            for(int i = 0; i < x.length; i++){
                if(x[i]%2 == 0){
                    miArrayList.add(x[i]);
                }
            }
            return miArrayList;
        };
        for (Integer numero : (ArrayList<Integer>)lista.apply(arrayNumeros)) {
            System.out.println(numero);
        }
    }

    /**
     *Cálculo de estadísticas:Escribe una función que tome una lista de números
     * como entrada y devuelva un objeto Stats que contenga estadísticas como el
     * mínimo, el máximo, la media de los números en la lista. Utiliza la interfaz
     * funcional Function para realizar los cálculos necesarios.
     */
    private static void metodo2(){
        double[] arrayNumeros = {0,1,2,3,4};
        Function<double[], Stats> lista = x -> {
            double min = getMinimo(x);
            double max = getMaximo(x);
            double suma = 0;
            for (int i = 0; i < x.length; i++) {
              suma += x[i];
            }
            return new Stats(min,max,suma/x.length);
        };

        System.out.println(lista.apply(arrayNumeros));

    }

    private static double getMinimo(double[] numeros){
        double numMin = numeros[0];
        for (double numero : numeros) {
            if (numero < numMin) {
                numMin = numero;
            }
        }
        return numMin;
    }
    private static double getMaximo(double[] numeros){
        double numMax = numeros[0];
        for (double numero : numeros) {
            if (numero > numMax) {
                numMax = numero;
            }
        }
        return numMax;
    }

    /**
     *Validación de contraseñas:Crea una función que tome una cadena que
     * representa una contraseña y devuelva true si la contraseña cumple con ciertos
     * criterios de validación, como tener al menos ocho caracteres, incluir al menos
     * una letra mayúscula, una letra minúscula, un número y un carácter especial.
     * Utiliza la interfaz funcional Function para representar cada criterio de
     * validación como una función independiente y combina estas funciones para
     * verificar la contraseña completa.
     */
    private static void metodo3(){
        Function<String, Boolean> lg = x->x.length()>8;
        Function<String, Boolean> mayus = x->x.chars().anyMatch(Character::isUpperCase);
        Function<String, Boolean> minus = x->x.chars().anyMatch(Character::isLowerCase);
        Function<String, Boolean> num = x->x.chars().anyMatch(Character::isDigit);
        Function<String, Boolean> esp = x->x.chars().anyMatch(c -> "!@#$%^&*()_-+=|<>?{}[]".indexOf(c) != -1);
        String contra=("Contraseña1.");
        boolean rpta = lg.apply(contra)&& mayus.apply(contra)&& minus.apply(contra)&& num.apply(contra)&& esp.apply(contra);
        System.out.println(rpta);
    }



    public static void main(String[] args) {
        metodo1();
        System.out.println("===========");
        metodo2();
        System.out.println("===========");
        metodo3();
    }


}

@AllArgsConstructor
@Data
class Stats{
    private double min;
    private double max;
    private double media;
}
