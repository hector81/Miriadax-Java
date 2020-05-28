package Tema1.Tipos_compuestos_datos_y_Enumeraciones;

import java.util.Random;

public class For_Each {
    //main
    public static void main(String[] args){
        Random aleatorio = new Random();
        int size = aleatorio.nextInt(25)+1;
        int lista [] = new int[size];
        //Recorrer el array y almacenar un valor en cada posición
        for (int i=0; i< lista.length; i++){
        lista[i] = aleatorio.nextInt(1000);
        }
        //Recorrer el array y obtener el valor de cada posición
        int pos=0;
        for(int n : lista)
        System.out.println("Posicion "+(++pos)+": "+n);
        
        
    }//fin main
}
