package Tema1.Sentencias_Control_Flujo;

import java.util.Random;
import java.util.Scanner;

public class bucle_while {
    //main
    public static void main(String[] args){
        //variables o atributos
        //System.out.println("Introduce tu número ");
        Random aleatorio= new Random();
        Scanner teclado= new Scanner(System.in);
        int menor=1, mayor=49, numero=0;
        boolean seguir=true;
        while(seguir){
            numero= aleatorio.nextInt(mayor-menor+1) + menor;
            System.out.println("Numero: " + numero);
            System.out.print("Quieres otro número? ");
            //String opcion = sc.nextLine();
            String opcion= teclado.next();
            seguir = opcion.equals("s") || opcion.equals("S") ? true : false;
        }
        System.out.println("FIN");
        
    }//fin main
}
