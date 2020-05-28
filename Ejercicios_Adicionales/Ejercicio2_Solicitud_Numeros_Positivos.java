/*
 * Realizar un programa que lea 10 números positivos por teclado y después nos 
 * muestre dichos números ordenados de mayor a menor. Si se introduce un número 
 * negativo, se volverá a solicitar al usuario, así hasta conseguir los 10 positivos.
 */
package Ejercicios_Adicionales;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Hector Garcia
 */
public class Ejercicio2_Solicitud_Numeros_Positivos {
    //funciones
    //devolvemos un string con el texto de todos los numeros
    public static String devolver_String_Array(double[] arrayNumeros){
        String texto = "";
        for(int i = 0; i < arrayNumeros.length; i++){
            if(i == arrayNumeros.length-1){
                texto += arrayNumeros[i] + "";
            }else{
                texto += arrayNumeros[i] + " , ";
            }
        }
        return texto;
    }//fin metodo 
    
    //funcion para devolver el array ordenado con sort
    public static double[] devolver_Array_Ordenado(double[] arrayNumeros){
        Arrays.sort(arrayNumeros);
        return arrayNumeros;
    }//fin metodo 
    //funcion para comprobar que la cadena es numerica
    private static boolean esNumerico(String cadena){
	try{
            double notaDouble = Double.parseDouble(cadena);
            return true;
	}catch(NumberFormatException nfe){
            return false;
	}
    }//fin metodo
    
   //main
    public static void main(String[] args) {
        //inicializar variables
        double numero_double = 0;
        String numero_str = "";
        int limite = 0;
        double arrayNumeros[] = new double[10];
        Scanner sc = new Scanner (System.in); //Creación de un objeto Scanner e invocamos un método sobre un objeto Scanner
     
        do {
            System.out.println("Introduce el número " + (limite+1)  + " : ");
            numero_str = sc.nextLine();
            //comprobamos que sea número y no tenga letras
            if(esNumerico(numero_str)){
                numero_double = Double.parseDouble(numero_str);
                //redondeamos a dos decimales
                numero_double= (double)Math.round(numero_double * 100d) / 100d;
                //comprobamos que sea positivo
                if(numero_double < 0){
                    System.out.println("Has introducido un número negativo no válido.");
                }else{
                    arrayNumeros[limite] = numero_double;
                    limite++;
                }
            }else{
                System.out.println("No puedes incluir caracteres, solo números positivos");
            } 
        } while(limite < 10);
        //ordenamos array
        double arrayNumeros_ordenado[] = devolver_Array_Ordenado(arrayNumeros);
        //imprimimos array 
        System.out.println(devolver_String_Array(arrayNumeros_ordenado));
    }//fin main
}//fin clase
