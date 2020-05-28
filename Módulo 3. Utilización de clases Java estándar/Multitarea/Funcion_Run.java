package Tema3.Multitarea;

public class Funcion_Run {
    Prueba p1 = new Prueba("---thread 1---");
    Prueba p2 = new Prueba("---thread 2---");
        
    public void run() {
        /*
        for (int i = 1; i <= 3; i++) {
            System.out.println("INICIO DE CICLO "+ i + " DE " + p1.getName() + " ===> "+ 
                (System.currentTimeMillis() - inicio)
                + " milisegundos”);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("INTERRUMPIDO: " + p1.getName() + " ===> " + 
                        (System. currentTimeMillis() - inicio)
                + " milisegundos”);
            } finally {
                System.out.println("FIN DE CICLO "+ i  + " DE " 
                        + getName() + " ===> " + (System. currentTimeMillis() - inicio)
                + " milisegundos”);
            }
        }
        */
    }

}
