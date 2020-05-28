package Tema1.Sentencias_Control_Flujo;

import java.util.Scanner;

public class Sentencia_continue {
    public static void main(String[] args) {
        System.out.println("Teclea una opcion");
        Scanner sc = new Scanner (System.in); //Creación de un objeto Scanner e invocamos un método sobre un objeto Scanner
        int veces = 3;
        for( int i=1; i<= veces ; i++){
            System.out.println("iteración número: " + i + " ===>");
            int num1 = sc.nextInt();
            if (num1 == 0) continue;
                int num2 = sc.nextInt();
            if (num2 == 0) continue;
                System.out.print("num2: "+ num2 + " num1: " + num1);
                System.out.print(" num2/num1 = "+ num2 / num1);
                System.out.println(" num2%num1 = "+ num2 % num1);
        }
        
    }
}
