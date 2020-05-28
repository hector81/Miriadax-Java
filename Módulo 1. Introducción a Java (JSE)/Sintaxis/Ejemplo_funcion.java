/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1.Sintaxis;

/**
 *
 * @author user
 */
public class Ejemplo_funcion {
    
    private static boolean esMultiplo(int numero, int divisor){
        boolean esmultiplo= false;
        if(numero % divisor == 0){
                esmultiplo = true;
        }
        else{
            esmultiplo = false;
        }
        return esmultiplo;
    }
    
    public static void main(String[] args) {
      int numero = 18;
      int divisor = 7;
      System.out.println("Numero " + numero + " .Divisor " + divisor);
      System.out.println("Este numero es multiplo = " + esMultiplo(numero,divisor));
        
    }
}
