package com.softtek.time.ejercicios;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class SolucionFechas {
    public static void main(String[] args) {
        System.out.println("EJERCICIO A");
        LocalDate fechaInicioCurso = LocalDate.of(2024, 4, 2);
        LocalDate fechaFinCurso = fechaInicioCurso.plusDays(10);
        System.out.println("Fecha de inicio del curso: " + fechaInicioCurso);
        System.out.println("Fecha de fin del curso (10 días después): " + fechaFinCurso);
        System.out.println();

        System.out.println("EJERCICIO B");
        LocalDate fechaDefecto = LocalDate.now();
        System.out.println("Fecha de hoy con zona horaria por defecto: " + fechaDefecto);
        System.out.println();

        System.out.println("EJERCICIO C");
        LocalDate fechaAutralia = LocalDate.now(ZoneId.of("Australia/Sydney"));
        System.out.println("Fecha de hoy con zona horaria de Australia/Sydney: " + fechaAutralia);
        System.out.println();

        System.out.println("EJERCICIO D");
        LocalDate dia = LocalDate.ofYearDay(2024, 100);
        System.out.println("Día 100 de 2024: " + dia);
        System.out.println();

        System.out.println("EJERCICIO E");
        LocalDate navidad = LocalDate.of(2024, 12, 25);
        LocalDate nocheVieja = LocalDate.of(2024, 12, 31);
        if (navidad.isBefore(nocheVieja)) {
            System.out.println("Navidad va antes de Nochevieja");
        } else if (navidad.isAfter(nocheVieja)) {
            System.out.println("Navidad va después de Nochevieja");
        } else {
            System.out.println("Navidad coincide el mismo día que Nochevieja");
        }
        System.out.println();

        System.out.println("EJERCICIO F");
        LocalDate fechaInicial = LocalDate.of(2024, 3, 15);
        LocalDate res = fechaInicial.plusWeeks(35);
        System.out.println("La fecha al sumar 35 semanas al 15 de marzo de 2024: " + res);
        System.out.println();

        System.out.println("EJERCICIO G");
        LocalDate inicio = LocalDate.of(2012, 7, 6);
        LocalDate hoy = LocalDate.now();
        long años = ChronoUnit.YEARS.between(inicio, hoy);
        System.out.println("Años trabajados en la empresa: " + años);
        System.out.println();

        System.out.println("EJERCICIO H");
        LocalDate fechaNacimiento = LocalDate.of(2007, 8, 7);
        long edad = ChronoUnit.YEARS.between(fechaNacimiento, hoy);
        System.out.println("Edad de la persona: " + edad);
        System.out.println();

        System.out.println("EJERCICIO I");
        LocalDate entregaProy = LocalDate.of(2024, 10, 2);
        LocalDate inicioProy = entregaProy.minusDays(200);
        System.out.println("Fecha de inicio del proyecto: " + inicioProy);
        System.out.println();

        System.out.println("EJERCICIO J");
        LocalDate inicioProy2 = LocalDate.of(2024, 3, 15);
        LocalDate entregaProy2 = LocalDate.of(2024, 10, 20);
        long periodo = ChronoUnit.DAYS.between(inicioProy2, entregaProy2);
        System.out.println("Periodo del proyecto en días: " + periodo);
    }

}
