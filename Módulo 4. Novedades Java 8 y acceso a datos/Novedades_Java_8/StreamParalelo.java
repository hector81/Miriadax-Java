package Tema4.Novedades_Java_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamParalelo {
    public static void main(String args[]) throws InterruptedException {
     Random aleatorio = new Random();
     List<Integer> numeros = new ArrayList<Integer>();
     
     for (int i = 0; i < 1_000_000; i++) {
        numeros.add(aleatorio.nextInt());
     }
     
     long inicio = System.currentTimeMillis();
     List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).sorted().collect(Collectors.toList());
     
     System.out.println("SERIE: "+pares.size()+" elementos computados en "
         + (System.currentTimeMillis() - inicio) + " con " + Thread.activeCount() + " threads");
         
     inicio = System.currentTimeMillis();
     List<Integer> paresParalelo = numeros.parallelStream().filter(n -> n % 2 == 0).sorted().collect(Collectors.toList());
     
     System.out.println("PARALELO: "+paresParalelo.size()+ " elementos computados en "
         + (System.currentTimeMillis() - inicio) + " con "+ Thread.activeCount() + "threads");
    }
}