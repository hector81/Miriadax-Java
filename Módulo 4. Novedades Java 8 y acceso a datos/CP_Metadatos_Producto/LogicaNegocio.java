package Tema4.CP_Metadatos_Producto;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hector Garcia
 */
public class LogicaNegocio {
    //Atributos
    private static Scanner teclado = new Scanner(System.in);
    DAO dao = new DAO();
    Connection conexion = null;
    //Constructor
    public LogicaNegocio(){ 
        this.conexion = dao.getConexion();
    }//fin constructor
    
    public void listarProductos(DAO dao) {
        System.out.println("=======LISTADO DE PRODUCTOS========");
        ArrayList<DTOProducto> lista = new ArrayList<DTOProducto>();
        lista = listarProductos();
        for (DTOProducto producto : lista) {
            System.out.print(producto.getIdproducto() + " ==== ");
            System.out.print(producto.getNombre() + " ==== ");
            System.out.println(producto.getPrecio() + " ==== ");
        }

    }//fin metodo

    public void insertarProducto(DAO dao) {
        System.out.println("=======INSERTAR PRODUCTO==========");
        boolean incorrecto = true;
        String nombre="";
        float precio = 0.F;
        System.out.print("Nombre del producto: ");
        nombre= teclado.nextLine();
        do {			
            try {
                System.out.print("Precio del producto: ");
                precio = teclado.nextFloat();
                incorrecto = false;
            } catch (InputMismatchException ex) {
                System.out.println("=======Precio debe ser un numero");
                teclado.nextLine();
            }
        } while (incorrecto);
        DTOProducto producto = new DTOProducto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        if (insertarProducto(producto))
            System.out.println("====Producto insertado");
        else
            System.out.println("====Producto no se ha podido insertar");

    }//fin metodo

    public void borrarProducto(DAO dao) {
        System.out.println("=======BORRAR PRODUCTO============");
        boolean incorrecto = true;
        int idproducto = 0;
        do {
            try {
                System.out.print("ID del producto: ");
                idproducto = teclado.nextInt();
                incorrecto = false;
            } catch (InputMismatchException ex) {
                System.out.println("=======ID del producto debe ser un numero");
                teclado.nextLine();
            }
        } while (incorrecto);
        if (borrarProducto(idproducto))
            System.out.println("====Producto " + idproducto + " borrado");
        else
            System.out.println("====Producto " + idproducto + " no existe");
    }//fin metodo

    public void actualizarProducto(DAO dao) {
        System.out.println("=======ACTUALIZAR PRODUCTO=======");
        boolean incorrecto = true;
        int idproducto = 0;
        float precio=0.F;
        String nombre = "";
        do {
            try {
                System.out.print("ID del producto a modificar: ");
                idproducto = teclado.nextInt();
                incorrecto = false;
            } catch (InputMismatchException ex) {
                System.out.println("=======ID del producto debe ser un numero");
                teclado.nextLine();
            }               
            try {
                System.out.print("Nuevo precio del producto: ");
                precio = teclado.nextFloat();
                incorrecto = false;
            } catch (InputMismatchException ex) {
                System.out.println("=======El precio debe ser un numero");
                teclado.nextLine();
            }
        } while (incorrecto);
        
        if (actualizarProducto(idproducto,precio))
            System.out.println("====Producto " + idproducto + " actualizado precio");
        else
            System.out.println("====Producto " + idproducto + " no existe");

    }//fin metodo

    public void contarProductos(DAO dao) {
        System.out.println("PRODUCTOS ===> " + numeroProductos());
    }//fin metodo

    public int numeroProductos() {
        int filas = 0;
        try (Statement statement = conexion.createStatement(
        ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT * FROM producto;";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next())
                filas++;
            resultset.close();
        } catch (SQLException ex) {
            System.out.println("Error: SQL" + ex);
        }
        return filas;
    }//fin metodo

    public ArrayList<DTOProducto> listarProductos() {
        ArrayList<DTOProducto> lista = new ArrayList<DTOProducto>();
        try (Statement statement = conexion.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT * FROM producto;";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                DTOProducto producto = new DTOProducto();
                producto.setIdproducto(resultset.getInt(1));
                producto.setNombre(resultset.getString(2));
                producto.setPrecio(resultset.getFloat(3));
                lista.add(producto);
            }
            resultset.close();
        } catch (SQLException ex) {
                System.out.println("Error: SQL" + ex);
        }
        return lista;
    }//fin metodo

    public boolean insertarProducto(DTOProducto producto) {
        boolean exito = true;
        try (PreparedStatement preparestatement = conexion.prepareStatement(
        "INSERT INTO producto (nombre, precio) VALUES (?,?)",
        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            preparestatement.setString(1, producto.getNombre());
            preparestatement.setFloat(2, producto.getPrecio());
            int filas = preparestatement.executeUpdate();
            exito = filas == 0 ? false: true;

        } catch (SQLException ex) {
            System.out.println("Error: SQL" + ex);
            exito = false;
        }
        return exito;
    }//fin metodo

    public boolean borrarProducto(int idproducto) {
        boolean exito = true;	
        try (PreparedStatement preparestatement = conexion.prepareStatement(
        "DELETE FROM producto WHERE idproducto=?",
        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            preparestatement.setInt(1, idproducto);
            int filas = preparestatement.executeUpdate();
            exito = filas == 0 ? false: true;
        } catch (SQLException ex) {
            System.out.println("Error: SQL" + ex);
            exito = false;
        }
        return exito;
    }//fin metodo

    public boolean actualizarProducto(int idproducto, float precio) {
        boolean exito = true;		
        try (PreparedStatement preparestatement = conexion.prepareStatement(
        "UPDATE Producto SET precio = ? WHERE idproducto = ?",
        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            preparestatement.setFloat(1, precio);
            preparestatement.setInt(2, idproducto);
            int filas = preparestatement.executeUpdate();
            exito = filas == 0 ? false: true;
        } catch (SQLException ex) {
            System.out.println("Error: SQL" + ex);
            exito = false;
        }
        return exito;
    }//fin metodo
    
    public void obtenerInformacion(){   
        try (Statement statement = conexion.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            System.out.println("==============INFORMACION DE DATABASE==============");
            DatabaseMetaData metadatos;
            metadatos = conexion.getMetaData();
            //Nombre de producto
            System.out.println("Nombre de Producto: " + metadatos.getDatabaseProductName());
            //Version de producto
            System.out.println("Version de Producto: " + metadatos.getDatabaseProductVersion());
            //Nombre de driver
            System.out.println("Nombre de Driver: " + metadatos.getDriverName());
            //Version de driver
            System.out.println("Version de Driver: " + metadatos.getDriverVersion());
            
            System.out.println("==============INFORMACION DE RESULTSET==============");
            System.out.println("\nObteniendo Informacion sobre una consulta con un ResultSet");
            //ResultSetMetaData rsmetadatos;
            //sacamos los datos
            String tabla = "Producto";
            ResultSet rs = statement.executeQuery("select * from " + tabla +" ;");
            ResultSetMetaData rsmetadatos =  rs.getMetaData();
            //obteniendo numero de columnas
            int col = rsmetadatos.getColumnCount();//cuenta de columnas
            System.out.println("Tabla " + tabla);
            //recorriendo columnas
            for(int y = 1 ;y <= col ;y++){
                System.out.println("====Columna "+ rsmetadatos.getColumnName(y) + " de tipo " 
                + rsmetadatos.getColumnTypeName(y) + " de tabla " + rsmetadatos.getTableName(y));
            }           
            rs.close(); //cerramos el resultSet       
            statement.close();//cerramos el Statement
        } catch (SQLException ex) {
                System.out.println("Error: SQL" + ex);
        }
        System.out.println("===================================================");
    }//fin metodo

}//fin clase
