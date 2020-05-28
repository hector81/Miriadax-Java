package Tema3.Entrada_Salida_Flujos_Java;

import java.util.Random;
import java.io.*;
public class EscribirBinario {
    public static void main(String args[])throws IOException {
        Random aleatorio = new Random();
        boolean b = aleatorio.nextBoolean();
        int n = aleatorio.nextInt();
        long l = aleatorio.nextInt()*10L;
        float f = aleatorio.nextFloat();

        //escribir datos binarios
        DataOutputStream escribir=null;
        try {
            escribir = new DataOutputStream(new
            FileOutputStream("C://Users//user//Documents//NetBeansProjects//Miriadax//src//Tema3//Entrada_Salida_Flujos_Java//outputDatos.txt"));
            escribir.writeBoolean(b);
            escribir.writeInt(n);
            escribir.writeLong(l);
            escribir.writeFloat(f);
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        } finally {
            if (escribir != null) {
                escribir.close();
            }
        }
        
        //leer datos binarios
        DataInputStream leer=null;
        try {
            leer = new DataInputStream(new FileInputStream("C://Users//user//Documents//NetBeansProjects//Miriadax//src//Tema3//Entrada_Salida_Flujos_Java//outputDatos.txt"));
            System.out.println("Booleano: " +leer.readBoolean());
            System.out.println("Entero: " +leer.readInt());
            System.out.println("Long: " +leer.readLong());
            System.out.println("Float: " +leer.readFloat());
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        } finally {
            if (leer != null) {
                leer.close();
            }
        }
            
            
 
    }
}
