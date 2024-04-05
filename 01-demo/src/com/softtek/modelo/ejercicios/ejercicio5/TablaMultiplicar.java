package com.softtek.modelo.ejercicios.ejercicio5;

class TablaMultiplicar {
    private int num;

    public TablaMultiplicar(int num) {
        this.num = num;
    }

    public String mostrarResultado(){
        String mensaje = "";
        for (int i = 1; i <= 10; i++) {
            mensaje += num + " * " + i +" = "+ (num * i) + "\n";
        }
        return mensaje;
    }
}
 class usoTabla{
     public static void main(String[] args) {
         TablaMultiplicar tbl = new TablaMultiplicar(5);
         System.out.println(tbl.mostrarResultado());
     }
 }