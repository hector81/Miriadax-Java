package Tema2.Clases_objetos_metodos;

import java.util.Random;

public class Programa11 {
    public static void main(String[] args) throws InterruptedException {
    Clase11 objeto1= new Clase11(28,"uno");
    Clase11 objeto2= new Clase11(38,"dos");
    System.out.println("Hay "+Clase11.cuentaPersonas()+" objetos");
    int num= (new Random()).nextInt(9)+1;
    for(int i=1; i<=num; i++){
        new Clase11(i, "objeto "+i);
        System.out.println("Hay "+Clase11.cuentaPersonas()+" objetos");
        Runtime garbage = Runtime.getRuntime();
        garbage.gc();
    } //Fin del ámbito de cada objeto que
    //se crea en cada iteración
    Thread.sleep(5000); //Retraso de la ejecución de 5 segundos
    System.out.println("Hay "+ Clase11.cuentaPersonas()+" objetos");
   }
}
