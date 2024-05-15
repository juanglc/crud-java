package Insert;

import Conexion.Conexion;
import Select.ConsultasSelect;

import java.sql.*;
import java.util.Scanner;

public class Insert
{
    public static void insertar()
    {
        Connection connection = Conexion.crearConexion();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del empleado");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el apellido del empleado");
        String apellido = sc.nextLine();
        System.out.println("Ingrese la edad del empleado");
        String edad = sc.nextLine();
        System.out.println("Ingrese la especialidad del empleado");
        String especialidad = sc.nextLine();
        System.out.println("Ingrese el número telefónico del empleado");
        String numero_telefonico = sc.nextLine();
        try
        {
            String query = "INSERT INTO empleados (nombre, apellido, edad, especialidad, numero_telefonico) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, edad);
            statement.setString(4, especialidad);
            statement.setString(5, numero_telefonico);
            statement.executeUpdate();
            System.out.println("Registro insertado correctamente");
            connection.close();
            statement.close();
            ConsultasSelect.select();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}