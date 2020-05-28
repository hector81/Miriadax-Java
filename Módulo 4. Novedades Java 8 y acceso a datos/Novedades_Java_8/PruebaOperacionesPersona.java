/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema4.Novedades_Java_8;

/**
 *
 * @author user
 */
public class PruebaOperacionesPersona {
    
    public static void main(String args []){
        Persona p = new Persona("pepe", 45);
        OperacionesPersona o = new OperacionesPersona(p);
        o.setNombre("antonio").setEdad(46).pintaPersona();

    }
}
