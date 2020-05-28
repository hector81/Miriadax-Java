/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema2.Clases_objetos_metodos;

/**
 *
 * @author user
 */
public class Programa {
    public static void main(String[] args) {
        Clase01 objeto12= new Clase01();
        objeto12.definirDatos();
        objeto12.leerDatos();
        Clase01 referencia=objeto12;
        referencia.leerDatos();
        
        Clase02 objeto1= new Clase02();
        objeto1.leerDatos();
        Clase02 objeto2= new Clase02(18, "Pepe Perez");
        objeto2.leerDatos();
        Clase02 objeto3= new Clase02(objeto2);
        objeto3.leerDatos();
    }
}
