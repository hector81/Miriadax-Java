/*
 * Crear una clase que tenga como dato miembro un array de seis int y las funciones.
 * Se utilizarán las funciones apropiadas de la clase Arrays de java.
 * util para rellenar, buscar y ordenar.
 */
package Tema2;

import java.util.Arrays;
/**
 *
 * @author Hector Garcia
 */
public class CP_ArrayEncapsulado {
    //atributos
    private static int[] arrayNumeros = new int[6]; //array de enteros con 6 posiciones
    
    //METODOS
    //• public void rellenar(int i), en cada elemento del array almacena el int que recibe como parámetro.
    public static void rellenar(int i){
        //hay dos formas, la primera sería así array[posicion] = valor; y la segunda =
        Arrays.fill(arrayNumeros, i); //rellena las posiciones el numero i
    }//fin metodo      
    
    //• public void rellenar(), en cada elemento del array almacena un
    //int aleatorio del 1 al 49 y que no exista en otras posiciones; es
    //decir, sin repetidos.
    public static boolean comprobarRepetidos(int arrayNumeros[], int numero){
        boolean comp = false;
        for(int i = 0; i < arrayNumeros.length; i++){
            if(numero == arrayNumeros[i]){
                comp = true;
                break;
            }
        }
        return comp;
    }//fin metodo 
    
    public static void rellenar(){
        int i = 0;
        while(i < arrayNumeros.length){
            if(i == 0){//si es la primera posicion le ponemos directamente el numero
                int numeroAleatorio = (int)Math.floor(Math.random()*(49-1+1)+1); // Esto da valores entre 1 y 49
                arrayNumeros[i] = numeroAleatorio;
                i++;
            }else{
                //pero si la posicion no es cero, hay que comprobar que no este repetido
                int numeroAleatorio = (int)Math.floor(Math.random()*(49-1+1)+1); // Esto da valores entre 1 y 49        
                if(comprobarRepetidos(arrayNumeros, numeroAleatorio) == true){
                    i--;//esta repetido, en este caso restamos una posicion
                }else{
                    arrayNumeros[i] = numeroAleatorio;
                }
                i++;
            }
            
        }//fin while          
    } //fin metodo    
    
    //• public void ordenar(), ordena los elementos del array de menor a mayor
    public static void ordenar(){
        Arrays.sort(arrayNumeros);//sort ordena el array de menor a mayor
    }//fin metodo
        
    //• public void visualizar(), visualiza en pantalla los elementos del array
    public static void visualizar(){
        String listaNumeros = "";
        for(int numero : arrayNumeros){
            listaNumeros += numero + " ";
        }
        System.out.println(listaNumeros);
    }//fin metodo
    
    //• public static void main (String args []), que tendrá la lógica
    //de la aplicación, creando el objeto de la clase y llamando a las funciones anteriores.
    public static void main(String[] args){
        CP_ArrayEncapsulado cpa = new CP_ArrayEncapsulado();
        cpa.rellenar(589);
        cpa.visualizar();
        cpa.rellenar();
        cpa.visualizar();
        cpa.ordenar();
        cpa.visualizar();
        
    }//fin main
}//fin clase
