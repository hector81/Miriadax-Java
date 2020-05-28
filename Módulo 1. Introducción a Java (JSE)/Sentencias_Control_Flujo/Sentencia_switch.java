package Tema1.Sentencias_Control_Flujo;

import java.util.Scanner;

public class Sentencia_switch {
    public static void abrirArchivo(){
        
    } 
    
    public static void borrarArchivo(){
        
    } 
    
    public static void crearArchivo(){
        
    } 
    
    public static void listarArchivo(){
        
    } 
    
    public static void terminar(){
        
    } 
    
  
    
    public static void main(String[] args) {
        System.out.println("Teclea una opcion");
        Scanner sc = new Scanner (System.in); //Creación de un objeto Scanner e invocamos un método sobre un objeto Scanner
        String opcion = sc.nextLine();
        //String opcion = teclado.next(); boolean opcionvalida=
        boolean opcionvalida=true;
        switch(opcion){
         case "A": abrirArchivo();
         break;
         case "B": borrarArchivo();
         break;
         case "C": crearArchivo();
         break;
         case "L": listarArchivo();
         break;
         case "X": terminar();
         break;
         default: opcionvalida=false;
        }
    }
}
