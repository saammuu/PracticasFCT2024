package com.softtek.modelo.ejercicios.ejercicio6;

class Alumno {
    /**
     * Construir una aplicación que muestre por pantalla el nombre de alumno y su nota final.
     * Para ello construir una clase Alumno que contenga:
     * • Un campo que sea una matriz para almacenar las calificaciones de los parciales.
     * • El constructor deberá inicializar las variables de NombreCompleto y dimensionar
     * el array de Parciales.
     * • Una propiedad de escritura para asignar los valores de los parciales.
     * • Un método para calcular el promedio de los parciales.
     * • Un método para mostrar las calificaciones de los parciales.
     */

    private String nombre;
    private double calificaciones [];

    public Alumno() {
    }

    public Alumno(String nombre, int parciales) {
        this.nombre = nombre;
        this.calificaciones = new double[parciales];
    }

    public void setCalificaciones(double[] calificaciones) {
        this.calificaciones = calificaciones;
    }

    public double calcularPromedio(){
        double res = 0;
        for (double nota:calificaciones) {
            res += nota;
        }
        return res/calificaciones.length;
    }

    public void mostrarCalificaciones(){
        System.out.println("========== NOTAS DE LOS PARCIALES ==========");
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Parcial: " + (i + 1) + ": " + calificaciones[i]);
        }
    }
}

class usoAlumno{
    public static void main(String[] args) {
        Alumno alumno = new Alumno("Pepe", 4);
        double calificaciones [] = {9, 5.9, 8.6, 10};
        alumno.setCalificaciones(calificaciones);
        alumno.mostrarCalificaciones();
        System.out.println("El promedio de los parciales es: " + alumno.calcularPromedio());
    }
}
