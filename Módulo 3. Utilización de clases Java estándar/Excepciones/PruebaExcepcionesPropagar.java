package Tema3.Excepciones;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class PruebaExcepcionesPropagar {
    public static void main(String [] args) throws IOException{
        Scanner teclado =new Scanner(System.in);
        System.out.print ("Teclea nombre de fichero: ");	
        String nombre= teclado.nextLine();
        fichero(nombre);	 	
    }
    
    static void fichero(String nombre) throws IOException{
        File file = new File(nombre);
        if(file.createNewFile()) System.out.println("fichero creado con exito");
        else System.out.println("no se puede crear fichero");
    }
}
