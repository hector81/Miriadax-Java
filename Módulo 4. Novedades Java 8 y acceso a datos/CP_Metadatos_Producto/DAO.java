package Tema4.CP_Metadatos_Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private String url = "jdbc:mysql://localhost:3306/Curso_Java_miriadax";
    private String user = "root";
    private String password = "";
    private Connection conexion = null;

    public boolean registrarDriver() {
        boolean exito = true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver cargado con exito");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: No se puede cargar el driver: " + ex.getMessage());
            exito = false;
        }

        return exito;
    }//fin metodo

    public Connection getConexion() {

        try {
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Hecha la conexión con éxito");
        } catch (SQLException ex) {
            System.out.println("Error: No se puede hacer la conexión: " + ex.getMessage());
        }
        return conexion;
    }//fin metodo

    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException ex) {
                System.out.println("Error: No se puede cerrar la conexión: " + ex);
            }
        }
    }//fin metodo

    
    
}//fin clase
