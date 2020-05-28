package Tema1.Sentencias_Control_Flujo;

import java.util.Random;

public class Sentencia_If {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int num = aleatorio.nextInt()+2;
        if( num % 2 == 0)System.out.println("El numero " + num + " es par");
        else System.out.println("El numero " + num + " no es par");
        int num1 = aleatorio.nextInt(5),
        num2 = aleatorio.nextInt(2500);
        if (num1 == 0)
            num++;
        System.out.println(num2 / num1);
  
    }
}
