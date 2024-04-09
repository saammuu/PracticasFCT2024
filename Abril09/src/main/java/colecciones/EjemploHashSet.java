package colecciones;

import java.sql.Array;
import java.util.*;

public class EjemploHashSet {
    public static void main(String[] args) {
        // Creamos el hashSet
        HashSet<String> miHashSet = new HashSet<>();

        // Agregamos elementos al conjunto
        miHashSet.add("Manzana");
        miHashSet.add("Plátano");
        miHashSet.add("Naranja");
        miHashSet.add("Uva");

        //Iteramos con un bucle for-each
        System.out.println("Frutas antes de añadir algo más:");
        for (String fruta : miHashSet) {
            System.out.println(fruta);
        }
        System.out.println("===================");
        // Creamos otra colección (por ejemplo, una lista)
        HashSet<String> otraColeccion = new HashSet<>(Arrays.asList("Pera", "Kiwi", "Melocotón"));

        // Agregar todos los elementos de la otra colección al conjunto
        miHashSet.addAll(otraColeccion);

        // Verificar si contiene un elemento específico
        System.out.println("¿Contiene 'Plátano'? " + miHashSet.contains("Plátano"));
        System.out.println("===================");


        // Eliminar un elemento
        miHashSet.remove("Naranja");

        // Tamaño del conjunto
        System.out.println("Tamaño del conjunto: " + miHashSet.size());
        System.out.println("===================");


        // Iterar a través de los elementos usando un iterador
        System.out.println("Colección con los elementos añadidos:");
        Iterator<String> iterador = miHashSet.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
        System.out.println("===================");

        //Ordenamos el hashset
        // 1. lo convertimos en una lista
        List<String> listaConvertida = new ArrayList<>(miHashSet);
        // 2. Ordenamos la lista
        Collections.sort(listaConvertida);
        System.out.println(listaConvertida);
        System.out.println("=====================");

        // Limpiar el conjunto
        miHashSet.clear();

        // Verificar si está vacío
        System.out.println("¿El conjunto está vacío? " + miHashSet.isEmpty());


    }
}

