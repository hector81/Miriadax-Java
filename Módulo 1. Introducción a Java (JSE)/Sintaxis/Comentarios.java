/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1.Sintaxis;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Comentarios {
    public static void main(String[] args) {
        int n; //Crear una variable
        System.out.print("Teclea un número: ");
        //Teclear número y almacenarlo en variable
        //n=teclado.nextInt();
        Scanner teclado = new Scanner(System.in);
        n=teclado.nextInt();
        //Declarar una referencia para cadenas de caracteres
        String nombre;
        System.out.print("Teclea tu nombre: ");
        /*Teclear una cadena de caracteres
        Hay que recoger el CR pulsado para introducir número*/
        teclado.nextLine();
        nombre=teclado.nextLine();

        
        
    }
}
