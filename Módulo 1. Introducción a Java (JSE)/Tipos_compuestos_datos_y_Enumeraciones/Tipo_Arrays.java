package Tema1.Tipos_compuestos_datos_y_Enumeraciones;

import java.util.Random;

public class Tipo_Arrays {
     //main
    public static void main(String[] args){
        //array de cinco char
        char vocales [] = {'A', 'E', 'I', 'O', 'U'};
        //recorrer
        String texto1 = "";
        for(int i = 0; i <vocales.length; i++){
            texto1 += vocales[i] + " ";
        }
        System.out.println(texto1);
        
        //array de 10 números, es opcional poner el tamaño
        int lista[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        //recorrer
        String texto2 = "";
        for(int i = 0; i <lista.length; i++){
            texto2 += lista[i] + " ";
        }
        System.out.println(texto2);
        
        //array de tres cadenas
        String nombres [] = {"Pepe Pérez", "Gil Lopez", "Ana Ruiz"};
        //recorrer
        String texto3 = "";
        for(int i = 0; i <nombres.length; i++){
            texto3 += nombres[i] + " ";
        }
        System.out.println(texto3);
        
        
        Random aleatorio = new Random();
        int size = aleatorio.nextInt(25)+1;
        int listaNumeros [] = new int[size];
        //Recorrer el array y almacenar un valor en cada posición
        for (int i=0; i< listaNumeros.length; i++){
            listaNumeros[i] = aleatorio.nextInt(1000);
        }
        //Recorrer el array y obtener el valor de cada posición
        for (int i=0; i< listaNumeros.length; i++){
            System.out.println("listaNumeros["+i+"] :"+listaNumeros[i]);
        }
        
        
        
    }//fin main
}
