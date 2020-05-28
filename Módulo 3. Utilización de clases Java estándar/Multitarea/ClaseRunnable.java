package Tema3.Multitarea;

import java.util.Random;

public class ClaseRunnable implements Runnable{
    private int n;
    
    public ClaseRunnable(int n){
        this.n=n;
    }

    @Override
    public void run() {
        int i = 1;
            while (true) {
                System.out.println("Run del thread " + getClass().getSimpleName() + ". Iteracion " + i++);
                if (i > n) {
                    break;
                }
            }
    }

    public static void main(String[] args) {
        Random aleatorio = new Random();
        ClaseThread t1= new ClaseThread(aleatorio.nextInt(5)+1);
        ClaseThread t2= new ClaseThread(aleatorio.nextInt(6)+1);
        ClaseRunnable r1 = new ClaseRunnable(aleatorio.nextInt(4)+1);
        ClaseRunnable r2 = new ClaseRunnable(aleatorio.nextInt(7)+1);
        t1.start();
        t2.start();
        new Thread(r1).start();
        new Thread(r2).start();
    }
}