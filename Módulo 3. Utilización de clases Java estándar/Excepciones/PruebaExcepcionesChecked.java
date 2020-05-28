package Tema3.Excepciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class PruebaExcepcionesChecked{ 
    public static void main(String[] args) throws FileNotFoundException{
        File fichero=new File("C://Users//user//Documents//NetBeansProjects//Miriadax//src//Tema3//Excepciones//fichero.txt");
        FileReader fr = new FileReader(fichero);
    }
}
