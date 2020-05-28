package Tema1.Sentencias_Control_Flujo;

import java.util.Scanner;

public class bucle_for_1 {
    public static void main(String[] args) {
        System.out.println("Teclea un numero");       
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        for (int i=1; i<=10; i++){
            System.out.println(numero + " * " + i + " = " + numero*i);
        }
    }
}
