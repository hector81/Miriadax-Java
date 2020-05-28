package Tema3.Colecciones_y_Clases_Genericas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ContadorCola {
    
    public static void main(String[] args) throws InterruptedException {
        Random aleatorio = new Random();
        //int time = Integer.parseInt("2015");
        int time = Integer.parseInt(args[0]);
        int n =0;
        Queue<Integer> cola = new LinkedList<Integer>();
 
        for (int i = time; i >= 0; i--) {
            System.out.print("primero: " + cola.peek());
            n=aleatorio.nextInt(1000);
            if(cola.offer(n)){
                System.out.println(" ultimo: " + n);
            }else{
                System.out.println(" no se ha podido añadir " + n);
            }
        }   
        
        for (Integer num : cola) {
            System.out.print(num + " ");
        }
        
        System.out.println();
        while (!cola.isEmpty()) {
            System.out.println("El primer elemento es: " + cola.poll());
            Thread.sleep(1000);
        }
        System.out.println("El primer elemento es: " + cola.poll());
    }
}
