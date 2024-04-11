package persistencia;

import modelo.Empleado;
import modelo.EmpleadoStream;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccesoEmpleados extends Conexion {
        public List<EmpleadoStream> obtenerTodos() throws SQLException, ClassNotFoundException {
                PreparedStatement sentencia;
                ResultSet resultado;
                String sql = "SELECT employee_id, last_name, first_name, birth_date, city FROM employees;";
                List<EmpleadoStream> empleados = new ArrayList<>();
                abrirConexion();
                sentencia = miConexion.prepareStatement(sql);
                resultado = sentencia.executeQuery();
                while (resultado.next()){
                        empleados.add(
                                new EmpleadoStream(
                                        resultado.getInt("employee_id"),
                                        resultado.getString("first_name"),
                                        resultado.getDate("birth_date").toLocalDate(),
                                        resultado.getString("city")
                                )
                        );
                }

                return empleados;

        }


        public EmpleadoStream obtenerEmpleadoPorId(int id) throws SQLException, ClassNotFoundException {
                String sql = "SELECT employee_id, last_name, first_name, birth_date, city FROM employees WHERE employee_id = ?";
                try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
                        statement.setInt(1, id);
                        try (ResultSet resultSet = statement.executeQuery()) {
                                if (resultSet.next()) {
                                        return new EmpleadoStream(
                                                resultSet.getInt("employee_id"),
                                                resultSet.getString("first_name") + " " + resultSet.getString("last_name"),
                                                resultSet.getDate("birth_date").toLocalDate(),
                                                resultSet.getString("city")
                                        );
                                }
                        }
                }
                return null;
        }

        public boolean añadir(EmpleadoStream e) throws SQLException, ClassNotFoundException {
                String sql = "INSERT INTO employees (employee_id, first_name, last_name, birth_date, city) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
                        statement.setInt(1, e.getIdEmpleado());
                        String[] nombreCompleto = e.getNombre().split(" ");
                        statement.setString(2, nombreCompleto[0]);
                        statement.setString(3, nombreCompleto[1]);
                        statement.setDate(4, java.sql.Date.valueOf(e.getNacimiento()));
                        statement.setString(5, e.getCiudad());
                        return statement.executeUpdate() > 0;
                }
        }

        public boolean borrarEmpleado(int id) throws SQLException, ClassNotFoundException {
                String sql = "DELETE FROM employees WHERE employee_id = ?";
                try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
                        statement.setInt(1, id);
                        return statement.executeUpdate() > 0;
                }
        }

        public boolean modificarEmpleado(EmpleadoStream e) throws SQLException, ClassNotFoundException {
                String sql = "UPDATE employees SET first_name = ?, last_name = ?, birth_date = ?, city = ? WHERE employee_id = ?";
                try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
                        String[] nombreCompleto = e.getNombre().split(" ");
                        statement.setString(1, nombreCompleto[0]);
                        statement.setString(2, nombreCompleto[1]);
                        statement.setDate(3, java.sql.Date.valueOf(e.getNacimiento()));
                        statement.setString(4, e.getCiudad());
                        statement.setInt(5, e.getIdEmpleado());
                        return statement.executeUpdate() > 0;
                }
        }
}


