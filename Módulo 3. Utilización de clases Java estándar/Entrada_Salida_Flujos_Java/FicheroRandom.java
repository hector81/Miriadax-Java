package Tema3.Entrada_Salida_Flujos_Java;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FicheroRandom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile fichero = null;
        int numero;
        try {
            fichero = new RandomAccessFile("C://Users//user//Documents//NetBeansProjects//Miriadax//src//Tema3//Entrada_Salida_Flujos_Java//numeros.dat","rw");
            mostrarFichero(fichero);
            System.out.print("Introduce un número entero: ");
            numero = sc.nextInt();
            fichero.seek(fichero.length());
            fichero.writeInt(numero);
            mostrarFichero(fichero);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("No se ha introducido un numero");
        } finally {
            try {
                if (fichero != null) {
                        fichero.close();
                }
                sc.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void mostrarFichero(RandomAccessFile fichero) {
        int n;
            try {
	 	fichero.seek(0);
                System.out.println("Inicio de fichero");
                while (true) {
                    n = fichero.readInt();
                    System.out.println(n);
                }
            } catch (EOFException e) {
                System.out.println("Fin de fichero");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }
}
