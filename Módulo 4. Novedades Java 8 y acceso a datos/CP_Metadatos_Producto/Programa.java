package Tema4.CP_Metadatos_Producto;

import java.sql.Connection;
import java.util.Scanner;

public class Programa {
    static Scanner teclado = new Scanner(System.in);
    //main
    public static void main(String[] args) {
        DAO dao = new DAO();
        LogicaNegocio lg = new LogicaNegocio();
        
        if (!dao.registrarDriver())
            return;
        Connection conexion = dao.getConexion();
        if (conexion == null)
            return;

        boolean seguir = true;
        do {
            System.out.println("=====MENU STATEMENTS=====");
            System.out.println("1. Listar productos");
            System.out.println("2. Insertar productos");
            System.out.println("3. Borrar productos");
            System.out.println("4. Actualizar productos");
            System.out.println("5. Contar productos");
            System.out.println("6. Obtener información");
            System.out.println("7. Salir");
            System.out.println("==============================");
            boolean erroneo = true;
            int opcion = 0;
            do {
                System.out.print("Teclea opcion: ");
                String opcion_str = teclado.nextLine();
                //pasamos a int respuesta
                opcion = Integer.parseInt(opcion_str);
                if (opcion >= 1 && opcion <= 8)
                    erroneo = false;
            } while (erroneo);

            switch (opcion) {
            case 1:
                lg.listarProductos(dao);
                break;
            case 2:
                lg.insertarProducto(dao);
                break;
            case 3:
                lg.borrarProducto(dao);
                break;
            case 4:
                lg.actualizarProducto(dao);
                break;
            case 5:
                lg.contarProductos(dao);
                break;
            case 6:
                lg.obtenerInformacion();
                break;
            case 7:
                seguir = false;
            }

        } while (seguir);
        dao.cerrarConexion();

    }//fin main

    

}//fin clase
