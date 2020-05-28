
package Tema4.Novedades_Java_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Diferencias_procesar_numeros {
    
    List<Integer> numerosJava8 = new ArrayList<>();
    List<Integer> numerosJava7 = new ArrayList<>();
    Random r = new Random();
    int cantidad = r.nextInt(100000000);
    int min = r.nextInt(100);
    int max = r.nextInt(100 - min) + min;
    // En Java 8
    long t1J8 = System.currentTimeMillis();
    r.ints(cantidad, 0, 100).forEach(numerosJava8::add);
    long cuentaJava8 = numerosJava8.stream().filter(i -> i >= min && i <= max).count();
    long totalJ8 = System.currentTimeMillis() - t1J8;
    // En Java 7
    long t2J8 = System.currentTimeMillis();
    for (int i = 0; i < cantidad; i++) {
        numerosJava7.add(r.nextInt(100));
        int cuentaJava7 = 0;
    
        for (Integer i : numerosJava7){
            if (i >= min && i <= max) cuentaJava7++;
            long totalJ7 = System.currentTimeMillis() - t1J8;
            System.out.println("Java8 ==> De un total de " + cantidad + " numeros, hay entre " + min + " y " +
                max + " : " + cuentaJava8 + " contados en " + totalJ8 + " milisegundos");
            System.out.println("Java7 ==> De un total de " + cantidad + " numeros, hay entre " + min + " y " +
                max + " : " + cuentaJava7 + " contados en " + totalJ7 + " milisegundos");
        }
    }
}
