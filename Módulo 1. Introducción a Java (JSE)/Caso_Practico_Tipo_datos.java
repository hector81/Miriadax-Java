/*
 * Crear una clase con función main, en la que se pida introducir por teclado:
 * • Dos enteros.
 * • Un float.
 * • Dos String
 * A continuación:
 * • Se suman los tres número y se muestran en pantalla.
 * • Se visualiza el entero mayor.
 * • Se visualiza el resultado de la división del float con el resto de la
 * división de los dos enteros.
 * • Se visualiza la concatenación de las dos cadenas leídas.
 */
package Tema1;
import java.util.Scanner; //Importación del código de la clase Scanner desde la biblioteca Java
/**
 *
 * @author Hector Garcia
 */
public class Caso_Practico_Tipo_datos {
    //variables sin inicializar. Son privadas, luego solo se pueden acceder desde la clase
    private static int entero1;
    private static int entero2;
    private static float flotante1;
    private static String cadena1;
    private static String cadena2;
  
    //metodo
    public static float sumar_3_numeros(int numero1, int numero2, float numero3){
        float suma = numero1 + numero2 + numero3;
        return suma;
    }//fin metodo
    
    //metodo
    public static float visualizar_numero_mayor(int numero1, int numero2, float numero3){
        float mayor = 0;
        float[]arrayNumeros =  {(float)numero1, (float)numero2, numero3};
        for (int i = 0; i < arrayNumeros.length; i++){
            if(arrayNumeros[i]>mayor){
                mayor = arrayNumeros[i];
            }
        }
        return mayor;
    }//fin metodo
    
    //metodo
    public static float dividir_float_entre_resto_enteros(int numero1, int numero2, float numero3){
        float resto_division_enteros = numero1%numero2;
        float dividir_float_entre_resto_enteros = numero3/resto_division_enteros;
        return dividir_float_entre_resto_enteros;
    }//fin metodo
    
    //metodo
    public static String concatenar_cadenas(String cadena1, String cadena2){
        String cadena_concatenada = cadena1.concat(cadena2);
        //cadena_concatenada = numero1 + numero2 + numero3;  
        return cadena_concatenada;
    }//fin metodo
    
    //main
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in); //Creación de un objeto Scanner e invocamos un método sobre un objeto Scanner
        System.out.println("Introduce el entero numero 1 : ");
        entero1 = sc.nextInt(); 
        System.out.println("El entero numero 1 es " + entero1);
        
        System.out.println("Introduce el entero numero 2 : ");
        entero2 = sc.nextInt(); 
        System.out.println("El entero numero 2 es " + entero2);
        
        System.out.println("Introduce el flotante numero 1 : ");
        flotante1 = sc.nextFloat(); 
        System.out.println("El flotante numero 1 es " + flotante1);
        
        System.out.println("Introduce la cadena numero 1 : ");
        cadena1 = sc.nextLine(); 
        System.out.println("La cadena numero 1 es " + cadena1);
        
        System.out.println ("Introduce la cadena numero 2 : ");
        cadena2 = sc.nextLine(); 
        System.out.println ("La cadena numero 2 es " + cadena2);
        
        //llamamos a metodos
        System.out.println ("La suma de los 3 números es " + sumar_3_numeros(entero1, entero2, flotante1));
        System.out.println ("El mayor de los 3 números es " + visualizar_numero_mayor(entero1, entero2, flotante1));
        System.out.println ("El resultado de la división del float con el resto de la división de los dos enteros " 
                + dividir_float_entre_resto_enteros(entero1, entero2, flotante1));
        System.out.println ("La concatenación de las 2 cadenas es " + concatenar_cadenas(cadena1, cadena2));
        
        
    }//fin main
}//fin clase
