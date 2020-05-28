package Tema1.Sintaxis;

import java.util.Scanner;

public class Entrada_Scanner {
    public static void main(String[] args) {
        System.out.print("Teclea una cadena: ");
        //Se crea objeto Scanner para el flujo “in”
        Scanner teclado = new Scanner(System.in);
        //La función nextLine de Scanner devuelve todos los
        //caracteres teclados hasta el caracter “fin de línea”
        String cadena = teclado.nextLine();

        System.out.print("Teclea un número: ");
        //Teclear número y almacenarlo en variable
        int n=teclado.nextInt();
        //Declarar una referencia para cadenas de caracteres
        String nombre;
        System.out.print("Teclea tu nombre: ");
        //Teclear una cadena de caracteres
        //Hay que recoger el CR (fin de línea) pulsado para introducir número
        teclado.nextLine();
        nombre=teclado.nextLine();
    }
}
