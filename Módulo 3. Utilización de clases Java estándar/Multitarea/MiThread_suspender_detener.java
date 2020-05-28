package Tema3.Multitarea;

public class MiThread_suspender_detener implements Runnable {
    Thread thread;
    boolean suspendido;
    boolean parado;
    MiThread_suspender_detener(String nombre) {
        thread = new Thread(this, nombre);
        suspendido = false;
        parado = false;
        thread.start();
    }

    public void run() {
        System.out.println(thread.getName() + " ARRANCANDO");
        try {
            for (int i = 1; i < 1000; i++) {
                System.out.print(i + " ");
                if ((i % 10) == 0) {
                    System.out.println();
                    Thread.sleep(400);
                }
                //Bucle en run que hace las comprobaciones periódicas
                //Sincronizar para acceder a suspendido y parado
                synchronized (this) {
                    while (suspendido) {
                        wait();
                    }
                if (parado)
                    break;
                }
            }
        } catch (InterruptedException exc) {
            System.out.println(thread.getName() + " INTERRUMPIDO");
        }
        System.out.println(thread.getName() + " FINALIZADO");
    }

    
    
    synchronized void stop() {
        parado = true;
        suspendido = false;
        notify();
    }
    
    synchronized void suspend() {
        suspendido = true;
    }
    
    synchronized void resume() {
        suspendido = false;
        notify();
    }
    

}
