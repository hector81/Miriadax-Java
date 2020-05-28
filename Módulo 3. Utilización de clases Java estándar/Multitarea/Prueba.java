package Tema3.Multitarea;

public class Prueba extends Thread {
    private long inicio;
    
    public Prueba(String str) {
        super(str);
        inicio = System.currentTimeMillis();
    }
    
    public void run() { /*sentencias*/ }
    
    public static void main(String[] args)
        throws InterruptedException { /*sentencias*/
    }
}
