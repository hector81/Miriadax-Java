package Tema3.Multitarea;

public class ClaseThread extends Thread {
    private int n;
    
    public ClaseThread(int n) {
        this.n = n;
    }
    
    public void run() {
        int i = 1;
        while (true) {
            System.out.println("Run del thread " + this.getName() + " de " + getClass().getSimpleName()
                + " con ID " + this.getId() + ". Iteracion " + i++);
            if (i > n) {
                break;
            }
        }
    }
}

