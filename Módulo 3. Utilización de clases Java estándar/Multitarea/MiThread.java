package Tema3.Multitarea;

class MiThread implements Runnable {
    Thread thread;
    static SumarArray sa = new SumarArray();
    int numeros[]; int suma;
    
    MiThread(String nombre, int numeros[]) {
        thread = new Thread(this, nombre);
        this.numeros = numeros;
        thread.start();
    }
    
    public void run() {
        int suma;
        System.out.println(thread.getName() + " EMPEZANDO");
        suma = sa.sumarArray(numeros);
        System.out.println("La suma en " + thread.getName() + " es " + suma);
        System.out.println(thread.getName() + " TERMINANDO");
    }
    
     
}