package Tema1.Sentencias_Control_Flujo;

import java.util.Random;
import java.util.Scanner;

public class bucle_do_while {
    public static void main(String[] args) {
        Random aleatorio= new Random();
        Scanner teclado= new Scanner(System.in);
        int menor=1, mayor=49, numero=0;
        boolean seguir=false;
        do{
            numero= aleatorio.nextInt(mayor-menor+1) + menor;
            System.out.println("Numero: " + numero);
            System.out.print("Quieres otro número? ");
            String opcion= teclado.next();
            seguir = opcion.equals("s") || opcion.equals("S") ? true : false;
        }while( seguir );
        System.out.println("FIN");
        
    }
}
