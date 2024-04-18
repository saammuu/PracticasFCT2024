package ejercicio1;

import java.util.Optional;
import java.util.Scanner;

public class Uso_Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese nombre de usuario: ");
        String username = sc.nextLine();

        Optional<String> usuarioOpt = Optional.ofNullable(username);

        usuarioOpt.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Nombre de usuario inválido")
        );
        sc.close();
    }
}
