/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1;

/**
 *
 * @author Hector Garcia
 */
public class CP_ProgramaRepetirN {
    //main
    public static void main(String[] args){
        //declarar valores        
        int numeroAleatorio0_20;
        int numeroAleatorio18_65;        
        numeroAleatorio0_20 = (int)Math.floor(Math.random()*(20-0+1)+0); // Esto da valores entre 0 y 20
        System.out.println("Habra " + numeroAleatorio0_20 + " números aleatorios la lista que serán entre 18 y 65");
       
        for (int i = 0; i < numeroAleatorio0_20; i++){
            numeroAleatorio18_65 = (int)Math.floor(Math.random()*(65-18+1)+18); // Esto da valores entre 18 y 65
            System.out.println("Número " + (i+1) + " = " + numeroAleatorio18_65);
        }
 
    }//fin main
}
