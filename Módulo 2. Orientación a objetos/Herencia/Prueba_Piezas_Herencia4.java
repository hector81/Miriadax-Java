/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema2.Herencia;

/**
 *
 * @author user
 */
public class Prueba_Piezas_Herencia4 {
    public static void main(String[] args) throws CloneNotSupportedException{
        Liso liso = new Liso (103, "Canal",11.2f,"mms", "verde",0.3F);
        Liso clonliso = (Liso) liso.clone();

        if( liso == clonliso){
            System.out.println("No son clones");
        }
        else{
            System.out.println("Son clones");
            System.out.println(liso);
            System.out.println(clonliso);
        }
    }
}
