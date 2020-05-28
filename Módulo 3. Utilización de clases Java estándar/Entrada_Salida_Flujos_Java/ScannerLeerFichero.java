package Tema3.Entrada_Salida_Flujos_Java;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class ScannerLeerFichero {
    public static void main(String[] args) throws IOException{
        String carpeta="C://Users//user//Documents//NetBeansProjects//Miriadax//src//Tema3//Entrada_Salida_Flujos_Java//";
        String archivo="leerfichero.txt";
        //Path path =
        //FileSystems.getDefault().getPath(carpeta, archivo);
        //Scanner leerfichero = new Scanner(path);
        File fichero = new File(carpeta+archivo);
        Scanner leerfichero = new Scanner(fichero);
        leerfichero.useDelimiter("=");

        while (leerfichero.hasNext()) {
            String cadena = leerfichero.next();
            System.out.print(cadena + " ");
        }
        leerfichero.close();
    }
}
