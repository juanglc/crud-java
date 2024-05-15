package Conexion;

import java.sql.*;

public class Conexion
{
    public static Connection crearConexion()
    {
        String url = "jdbc:mysql://127.0.0.1:3306/circo?serverTimezone=UTC";
        String user = "root";
        String password = "Juan0606";
        try
        {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}