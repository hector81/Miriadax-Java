/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema4.Acceso_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Consulta {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultset = null;
        String sql = "SELECT productos.titulo FROM Curso_Java_miriadax.productos ";    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Curso_Java_miriadax","root", "");
            //decimos el tipo de consultas
            PreparedStatement ps = conexion.prepareStatement("SELECT productos.titulo FROM Curso_Java_miriadax.productos ");
            ResultSet rs = ps.executeQuery();
            //ponemos los valores por orden
            //leemos los resultados y los recorremos
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            //cerramos de ultimo a primero
            rs.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: No se puede cargar driver: " + ex.getMessage());
            System.exit(1);
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
            System.exit(1);
	}
    }//fin main
}
