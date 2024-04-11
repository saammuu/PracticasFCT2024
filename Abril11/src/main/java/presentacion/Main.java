package presentacion;

import modelo.Empleado;
import persistencia.EmpleadoSQL;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmpleadoSQL emp = new EmpleadoSQL();
        Scanner sc = new Scanner(System.in);

        List<String> opciones = List.of("1. Ver Empleados", "2. Añadir empleado", "3. Eliminar empleado", "4. Modificar nombre empleado","5. Mostrar empleado por ID", "6. Salir");
        while (true){
            System.out.println(opciones);
            switch (sc.nextInt()){
                case 1:
                    try {
                        emp.obtenerTodos().forEach(System.out::println);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Introduzca el id del empleado");
                    int idA = sc.nextInt();
                    System.out.println("Introduzca el nombre del empleado");
                    String nombreA = sc.next();
                    System.out.println("Introduzca el apellido del empleado");
                    String apellidoA = sc.next();
                    System.out.println("Introduzca el id del jefe del empleado");
                    int jefeA = sc.nextInt();
                    Empleado e = new Empleado(idA,nombreA,apellidoA,jefeA);
                    try {
                       if (emp.añadir(e)) System.out.println("Empleado Añadido");
                       else System.out.println("No se ha podido añadir");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("ID del elemento a eliminar: ");
                    int idE = sc.nextInt();
                    try {
                        if (emp.borrarEmpleado(idE)) System.out.println("Empleado Borrado");
                        else System.out.println("No se ha podido borrar");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("ID del empleado a modificar: ");
                    int idM = sc.nextInt();
                    try {
                        Empleado empleado = emp.obtenerEmpleadoPorId(idM);
                        if (empleado != null) {
                            System.out.println("Empleado encontrado:");
                            System.out.println(empleado);

                            System.out.println("Nuevo apellido: ");
                            String nuevoApellido = sc.next();
                            empleado.setApellidos(nuevoApellido);
                            System.out.println("Nuevo nombre: ");
                            String nuevoNombre = sc.next();
                            empleado.setNombre(nuevoNombre);
                            System.out.println("Nuevo jefe (ID): ");
                            int nuevoJefe = sc.nextInt();
                            empleado.setJefe(nuevoJefe);

                           if ( emp.modificarEmpleado(empleado)) System.out.println("Empleado modificado");
                           else System.out.println("No ser ha podido modificar");
                        } else {
                            System.out.println("No se encontró ningún empleado con ese ID.");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("ID del producto a modificar: ");
                    int idU = sc.nextInt();
                    try {
                        System.out.println(emp.obtenerEmpleadoPorId(idU));
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 6:
                    return;

            }
        }

    }
}
