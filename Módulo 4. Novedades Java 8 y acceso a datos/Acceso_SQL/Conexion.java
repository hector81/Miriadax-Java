/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema4.Acceso_SQL;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VESPERTINO
 */
public class Conexion {

    public static void main(String[] args) {
        Connection con;

        try {

            //abrimos el driver
            Class.forName("com.mysql.jdbc.Driver");

            //obtener conexion            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull", "root", "");

            //Cursor
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT nomempleado, idempleado FROM negocios2011.empleados");

            //RECORREMOS
            while (rs.next()) {
                String s = rs.getString("nomempleado");//pasamos a string el elemento
                int i = rs.getInt("idempleado");//pasamos a int el elemento
                //imprimos las filas
                System.out.println("Nombre: " + s + " Id: " + i);
            }

            rs.close();//Cerramos
            stm.close();//Cerramos
            con.close();//Cerramos

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}