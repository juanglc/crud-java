package Update;

import Conexion.Conexion;
import Select.ConsultasSelect;

import java.sql.*;
import java.util.Scanner;

public class Update
{
    public static void update()
    {
        Connection connection = Conexion.crearConexion();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el id del empleado a modificar");
        String id = sc.nextLine();
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
            String query = "UPDATE empleados SET nombre = ?, apellido = ?, edad = ?, especialidad = ?, numero_telefonico = ? WHERE id_empleado = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, edad);
            statement.setString(4, especialidad);
            statement.setString(5, numero_telefonico);
            statement.setString(6, id);
            statement.executeUpdate();
            System.out.println("Registro actualizado correctamente");
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
