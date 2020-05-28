package Tema1.Sentencias_Control_Flujo;

import java.util.Scanner;

public class Sentencia_break {
    public static void main(String[] args) {
        System.out.println("Teclea una opcion");
        Scanner sc = new Scanner (System.in); //Creación de un objeto Scanner e invocamos un método sobre un objeto Scanner
        
        for( ; ; ){
        int num1 = sc.nextInt();
        if (num1 == 0) break;
        int num2 = sc.nextInt();
        if (num2 == 0) break;
        System.out.print("num2: "+ num2 + " num1: " + num1 );
        System.out.print(" num2/num1 = "+ num2 / num1);
        System.out.println(" num2%num1 = "+  num2 % num1);
        }
        
    }
}
