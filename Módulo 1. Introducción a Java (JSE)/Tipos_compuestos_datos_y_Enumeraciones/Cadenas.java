package Tema1.Tipos_compuestos_datos_y_Enumeraciones;

import java.util.Scanner;

public class Cadenas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Teclea dos palabras: ");
        String palabras = teclado.nextLine();
        System.out.println(palabras);
        System.out.println(palabras.toUpperCase());
        palabras = palabras.toLowerCase();
        System.out.println(palabras);
        palabras= " "+palabras;
        System.out.println(palabras);
        palabras = palabras.trim();
        System.out.println(palabras);
        String str1 = palabras.substring(4, 9);
        System.out.println(str1);
        long num = 9_876_543_211L;
        String str2= String.valueOf(num);
        System.out.println(str2);
        str2= str2.replace('1', '0');
        System.out.println(str2);
        teclado.close();
    }
}
