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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VESPERTINO
 */
public class ConsutlaPrueba {
    public static void main(String[] args) throws SQLException {
        //atributo
        Connection conexion;
        try {
            //abrimos el driver
            Class.forName("com.mysql.jdbc.Driver");
            //ruta  ///  "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String bd = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            //creamos la conexion
            conexion = DriverManager.getConnection(bd, "root", ""); 
            //decimos el tipo de consultas
            PreparedStatement ps = conexion.prepareStatement("SELECT productos.titulo FROM productos where idproducto = ?");
            
            ps.setInt(1, 15); //mayor que 3 cantidad
            //resultset para ejecutar consulta
            ResultSet rs = ps.executeQuery();
            
            //ponemos los valores por orden
            //leemos los resultados y los recorremos
            while(rs.next()){
//                System.out.println(rs.getInt("1"));
                System.out.println(rs.getString(1));
            }
            
            //cerramos de ultimo a primero
            rs.close();
            ps.close();
            conexion.close();
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConsutlaPrueba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
        
        
    }
            
}
