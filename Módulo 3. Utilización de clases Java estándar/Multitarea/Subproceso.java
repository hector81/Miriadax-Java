package Tema3.Multitarea;

public class Subproceso extends Thread {
    //public class Subproceso implements Runnable{
    public Subproceso(String nombre) {
        super(nombre);
    }
    public void run(){
        //definir run...
    }
    
    //En otro código, por ejemplo una función main
    //se crean diferentes subprocesos
    public static void main(String [] args){
        Subproceso subproceso1 = new Subproceso("Subproceso 1");
        Subproceso subproceso2 = new Subproceso("Supproceso 2");
        //otras sentencias
        subproceso1.start();//start inicia el proceso llamando a run
        subproceso2.start();//start inicia el proceso llamando a run
        //new Thread(subproceso1).start();
         //new Thread(subproceso2).start();
        //otras sentencias
    }
}