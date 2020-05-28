package Tema4.Acceso_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ObtenerObjetoStatement {
    public static void main(String[] args) {
        Connection conexion = null;
        Statement statement = null;
        PreparedStatement preparedstatement = null;

        //jdbc:mysql://localhost:3306/nba?zeroDateTimeBehavior=convertToNull", "root", "");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nba","root", "");
            statement = conexion.createStatement();
            System.out.println("Creado Statement");
            int codigo = 1;
            preparedstatement = conexion.prepareStatement( "SELECT * FROM nba.jugadores WHERE codigo = " + codigo + " ;");
            System.out.println("Creado PreparedStatement");
	} catch (ClassNotFoundException ex) {
            System.out.println("Error: No se puede cargar driver: " + ex.getMessage());
            System.exit(1);
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
            System.exit(1);
	} finally {
            if (statement != null){
                try { 
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println("Error: No se puede cerrar statement: " + ex.getMessage());
                }
            }
            if (conexion != null) {
                try { 
                    conexion.close();
                } catch (SQLException ex) {
                    System.out.println("Error: Al cerrar conexión: " + ex.getMessage());
                }
            }
        }//fin finally
    }//fin main
 
}//fin clase
