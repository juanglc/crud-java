package Delete;

import Conexion.Conexion;
import Select.ConsultasSelect;
import java.sql.*;
import java.util.Scanner;

public class Delete
{
    public static void delete()
    {
        Connection connection = Conexion.crearConexion();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el id del empleado a eliminar");
        String id = sc.nextLine();
        try
        {
            String query = "DELETE FROM empleados WHERE id_empleado = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.executeUpdate();
            System.out.println("Registro eliminado correctamente");
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
