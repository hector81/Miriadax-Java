package Tema1.Sentencias_Control_Flujo;

import java.util.Random;

public class Sentencia_If_Anidados {
    public static void main(String[] args) {
        String marcha = "";
        String categoria = "";
        
        int operacion = (int)Math.floor(Math.random()*(3-0+1)+0);
        if( operacion < 0 ) marcha = "frenar";
        else if ( operacion == 0 ) marcha = "continuar";
        else marcha = "acelerar";
        System.out.println(marcha);
        
        int edad = (int)Math.floor(Math.random()*(100-0+1)+0);
        if (edad > 55 ) categoria = "veterano C";
        else if (edad > 45 ) categoria = "veterano B";
        else if (edad > 35 ) categoria = "veterano A";
        else if (edad > 19 ) categoria = "senior";
        else if (edad > 16 ) categoria = "junior";
        else categoria = "no puede participar";
        System.out.println(categoria);
    }
}