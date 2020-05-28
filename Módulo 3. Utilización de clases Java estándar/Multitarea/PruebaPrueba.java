package Tema3.Multitarea;

public class PruebaPrueba {
    public static void main(String[] args) throws InterruptedException {
        Prueba p1 = new Prueba("---thread 1---");
        Prueba p2 = new Prueba("---thread 2---");
        System.out.println("ESTADO DE " + p1. getName()+ " ===> " + p1.getState());
        System.out.println("COMIENZO: " + System.currentTimeMillis());
        p1.start();
        
        System.out.println("ESTADO DE " + p2.getName() + " ===> " + p2.getState());
        p2.start();
                
        Thread.sleep(100);
        p1.interrupt();
        Thread.sleep(100);
        p1.interrupt();
        p2.interrupt();
        Thread.sleep(100);
        p2.interrupt();
        int i=0;

        do{ } while(!( p1.getState() == Thread.State.TERMINATED && p2.getState() == Thread.State.TERMINATED));

        System.out.println("ESTADO DE " + p1.getName()+ " ===> "+ p1.getState());
        System.out.println("FINALIZACION: " + System.currentTimeMillis());
    }
        
}
