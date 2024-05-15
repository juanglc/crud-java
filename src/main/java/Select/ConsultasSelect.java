package Select;

import Conexion.Conexion;

import java.sql.*;
import java.util.Scanner;

public class ConsultasSelect
{
    static Scanner sc = new Scanner(System.in);

    public static void preguntarColumna()
    {
        boolean i = true;
        System.out.println("¿Por medio de qué columna quiere realizar la selección?");
        System.out.println("1. id_empleado");
        System.out.println("2. nombre");
        System.out.println("3. especialidad");
        System.out.println("4. toda la tabla");
        while (i)
        {
            String columna = sc.nextLine();
            switch (columna)
            {
                case "1":
                    System.out.println("Ingrese el id a buscar");
                    String id = sc.nextLine();
                    selectId(id);
                    i = false;
                    break;
                case "2":
                    System.out.println("Ingrese el nombre a buscar");
                    String nombre = sc.nextLine();
                    selectNombre(nombre);
                    i = false;
                    break;
                case "3":
                    System.out.println("Ingrese la especialidad a buscar");
                    String esp = sc.nextLine();
                    selectEspecialidad(esp);
                    i = false;
                    break;
                case "4":
                    select();
                    i = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        escoger_otra();
    }

    public static void escoger_otra()
    {
        boolean i = true;
        System.out.println("¿Desea realizar otra consulta?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        while (i)
        {
            String opcion = sc.nextLine();
            switch (opcion)
            {
                case "1":
                    i = false;
                    preguntarColumna();
                    break;
                case "2":
                    i = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public static void selectId(String opcion)
    {
        Connection connection = Conexion.crearConexion();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM empleados WHERE id_empleado = " + opcion);


            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id_empleado") + " | " + resultSet.getString("nombre") + " | " + resultSet.getString("apellido") + " | " + resultSet.getString("edad") + " | " + resultSet.getString("especialidad") + " | " + resultSet.getString("numero_telefonico"));
            }
            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void selectNombre(String nombrecin)
    {
        Connection connection = Conexion.crearConexion();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM empleados WHERE nombre = '" + nombrecin+"'");
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id_empleado") + " | " + resultSet.getString("nombre") + " | " + resultSet.getString("apellido") + " | " + resultSet.getString("edad") + " | " + resultSet.getString("especialidad") + " | " + resultSet.getString("numero_telefonico"));
            }
            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void selectEspecialidad(String u)
    {
        Connection connection = Conexion.crearConexion();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM empleados WHERE especialidad = " + u);
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id_empleado") + " | " + resultSet.getString("nombre") + " | " + resultSet.getString("apellido") + " | " + resultSet.getString("edad") + " | " + resultSet.getString("especialidad") + " | " + resultSet.getString("numero_telefonico"));
            }
            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void select()
    {
        Connection connection = Conexion.crearConexion();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM empleados");
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id_empleado") + " | " + resultSet.getString("nombre") + " | " + resultSet.getString("apellido") + " | " + resultSet.getString("edad") + " | " + resultSet.getString("especialidad") + " | " + resultSet.getString("numero_telefonico"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
