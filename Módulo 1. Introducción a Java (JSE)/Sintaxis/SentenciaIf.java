package Tema1.Sintaxis;

import java.util.Scanner;

public class SentenciaIf {
    public static void main(String[] args) {
        System.out.println("Teclea Número ");
        Scanner sc = new Scanner (System.in);
        int i=0; //Sentencia de creación de variable
        i = sc.nextInt();
        //i = teclado.nexInt(); //Sentencia de asignación
        boolean esPar = i % 2 == 0 ? true : false; //Sentencia de asignación
        if( esPar == true){ //sentencia de decisión simple
            System.out.println("Se ha tecleado un número par");
        }else{
            System.out.println("Se ha tecleado un número par");
        }
  
    }
}
