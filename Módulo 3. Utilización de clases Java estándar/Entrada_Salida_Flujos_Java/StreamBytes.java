package Tema3.Entrada_Salida_Flujos_Java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamBytes {
    public static void main(String args[]) throws IOException {
        FileInputStream entrada = null;
        FileOutputStream salida = null;
        try {
            entrada = new FileInputStream("C://Users//user//Documents//NetBeansProjects//Miriadax//src//Tema3//Entrada_Salida_Flujos_Java//input.txt");
            salida = new FileOutputStream("C://Users//user//Documents//NetBeansProjects//Miriadax//src//Tema3//Entrada_Salida_Flujos_Java//output.txt");
            int i;
            while ((i = entrada.read()) != -1) {
                System.out.print((char)i);
                salida.write(i);
            }
        }catch (IOException ioex){
            System.out.println(ioex.getMessage());
        }finally {
            if (entrada != null) entrada.
                close();
            if (salida != null) salida.
                close();
        }
    }
}
