package com.ecodeup.jdbc;

import Insert.Insert;
import Delete.Delete;
import Select.ConsultasSelect;
import Update.Update;

import java.util.Scanner;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    public static void escoger_otra()
    {
        boolean i = true;
        System.out.println("¿Desea realizar otra operación?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        while (i)
        {
            String opcion = sc.nextLine();
            switch (opcion)
            {
                case "1":
                    menu();
                    i = false;
                    break;
                case "2":
                    System.out.println("Gracias por usar el programa");
                    i = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public static void menu()
    {
        boolean i = true;
        System.out.println("Bienvenid@");
        System.out.println("Este programa le permitirá realizar operaciones CRUD en la tabla empleados");
        System.out.println("Esta es la tabla en la que se realizarán las operaciones:");
        ConsultasSelect.select();
        System.out.println("¿Qué operación desea realizar?");
        System.out.println("1. Consulta Select");
        System.out.println("2. Insertar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        while (i)
        {
            int opc = sc.nextInt();
            sc.nextLine();
            switch (opc)
            {
                case 1:
                    ConsultasSelect.preguntarColumna();
                    i = false;
                    break;
                case 2:
                    Insert.insertar();
                    i = false;
                    break;
                case 3:
                    Update.update();
                    i = false;
                    break;
                case 4:
                    Delete.delete();
                    i = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        escoger_otra();
    }

    public static void main(String[] args)
    {
        menu();
    }
}