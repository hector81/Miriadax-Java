package Tema1.Sentencias_Control_Flujo;
//Bucle sin cuerpo.
import java.util.Scanner;

public class bucle_for_6 {
    public static void main(String[] args) {
        System.out.println("Teclea un numero");       
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        //int numero= aleatorio.nextInt(200)+1;
        long suma=0;
        int i = 1;
        for( i = 1; i<numero; suma += i++);
            System.out.println("i : " + i + " suma: " + suma);
        
            
    }
}
