package com.softtek.modelo.ejercicios.strings;

import java.util.Locale;

public class PruebaString {
    /*
        Crear la cadena de texto: “Nunca mates una mosca sobre la cabeza de un tigre.”
        • Mostrar la cadena toda en mayúsculas
        • Mostrar la cadena en minúsculas
        • Mostrar solo la palabra Nunca
        • Mostrar solo la palabra mosca
        • Mostrar la palabra cabeza
        • Mostrar la posición de la letra primera m
        • Devolver la longitud de la cadena
         */
    public static void main(String[] args) {
        String texto = "Nunca mates una mosca sobre la cabeza de un tigre.";
        System.out.println(texto.toUpperCase());
        System.out.println(texto.toLowerCase());
        String palabras[] = texto.split(" ");
        System.out.println(palabras[0]);
        System.out.println(palabras[1]);
        for (String palabra : palabras){
            if (palabra.contains("cabeza")){
                System.out.println(palabra);
            }
        }
        System.out.println(texto.indexOf('m'));

        System.out.println(texto.length());

    }
}
