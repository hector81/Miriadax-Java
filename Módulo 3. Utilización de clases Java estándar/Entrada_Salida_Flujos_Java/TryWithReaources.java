package Tema3.Entrada_Salida_Flujos_Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TryWithReaources {
    public static void main(String []args){
        File origen = new File("C://Users//user//Documents//NetBeansProjects//Miriadax//src//Tema3//Entrada_Salida_Flujos_Java//origen.txt");
        File destino = new File("C://Users//user//Documents//NetBeansProjects//Miriadax//src//Tema3//Entrada_Salida_Flujos_Java//destino.txt");
        copiarFicheros(origen, destino);
    }

    private static void copiarFicheros(
        File origen, File destino) {
        try (InputStream forigen = new FileInputStream(origen);
            OutputStream fdestino =
            new FileOutputStream(destino)){byte[] buf = new byte[9000];
            int i;
 
            while ((i = forigen.read(buf)) != -1) {
                fdestino.write(buf, 0, i);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}