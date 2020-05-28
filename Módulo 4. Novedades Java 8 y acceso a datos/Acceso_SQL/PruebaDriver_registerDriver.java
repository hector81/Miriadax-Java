/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema4.Acceso_SQL;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

//jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull", "root", "");



public class PruebaDriver_registerDriver {
    public static void main(String[] args) {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver( driver );
        } catch (SQLException ex){
     System.out.println("Error: No se puede cargar driver: " + ex.getMessage());
     System.exit(1);
     }
     System.out.println("Driver cargado con éxito");
    }
}
