package Tema2.Paquetes_librerias_clases;


import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.System.*;
import static java.lang.Math.*;
import java.util.Scanner;

public class ImportEstatico {
    public static void main(String[] args) {
    Scanner teclado= new Scanner(in);
    double d = teclado.nextDouble();
    System.out.println("La raíz de " + d + " es " + sqrt(d));
    System.out.println("Redondeado a menor " + d + " es " + floor(d));
    System.out.println("Redondeado a mayor " + d + " es " + ceil(d));
    System.out.println("Rango de byte es: "+ MAX_VALUE + " a " + MIN_VALUE);
    }
}