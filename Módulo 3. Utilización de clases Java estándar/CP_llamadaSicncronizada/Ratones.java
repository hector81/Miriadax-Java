/*
 * Implementar todo en una clase Ratones que herede de Thread
 */
package Tema3.CP_llamadaSicncronizada;

import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hector Garcia
 */
public class Ratones extends Thread {
    //El plato puede ser una variable static que se inicializa y llena cada vez con 100.
    private static int plato = 100;
    //atributos
    private String nombre;
    private int cantidad;

    //constructores
    //1ºLa clase Ratones tiene un constructor que recibe como parámetro el 
    // nombre del ratón y la cantidad de comida que llena cada vez.
    public Ratones(String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
    }//fin constructor
    
    //METODOS
    //metodos getters
    public String getNombre(){
        return this.nombre;
    }//fin metodo
    
    public int getCantidad(){
        return this.cantidad;
    }//fin metodo
    
    //metodos setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }//fin metodo
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }//fin metodo
    
    @Override
    //metodo equals sobreescrito
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        
        Ratones oRaton = (Ratones) obj;
        
        if (!Objects.equals(this.nombre, oRaton.getNombre())) {
            return false;
        }
        if (!Objects.equals(this.cantidad, oRaton.getCantidad())) {
            return false;
        }
        return true;
    }//fin metodo

    @Override
    //metodo toString sobreescrito
    public String toString(){
        return this.nombre + " se ha comido " + this.getCantidad() + " unidades.";
    }//fin metodo
    
    //metodo pintar
    public void pintar(){
        System.out.println("[Ratones] = El nombre del raton es " + this.getNombre() + ", y la cantidad que come es " + this.getCantidad());
    }//fin metodo
    
    
    /* La funciones comer y llenar estarán sincronizadas, para que sólo un
    subproceso pueda ejecutarlas simultáneamente. */
    
    /*Se crean dos subprocesos que simulan ser cada uno de ellos un ratón que come una cierta
     cantidad, siempre la misma de un plato. Esto se realiza con una función comer*/  
    synchronized public void comer(){
        plato = plato - this.cantidad;
        System.out.println(this.getNombre() + " se está comiendo " + this.cantidad + " unidades. Espera un segundo a que coma. En el plato quedan " + this.plato + " unidades.");   
    }//fin metodo
    
    /*Si un ratón va a comer y no hay suficiente comida se llena el plato. Esto se realiza con una función
    llenar.*/
    synchronized public void llenar(){
        System.out.println(this.getNombre() + " queria comerse " + this.getCantidad() + " unidades"
            + " pero en el plato solo quedaban " + plato + " unidades.");
        plato = 100;//volvemos a llenar con 100
        System.out.println("Rellenamos el plato y ahora tiene " + plato + " unidades.");
    }//fin metodo

    @Override
    //Corriendo el subproceso
    public void run() {
        if(this.cantidad > plato){
            try {
                //El plato no tiene tanta cantidad y hay que rellenar primero
                llenar();
                Thread.sleep(200);//0.2 segundos espera
                //Ahora, una vez rellenado el plato, el raton puede comer
                comer();
                Thread.sleep(200);//0.2 segundos espera
            } catch (InterruptedException ex) {
                Logger.getLogger(Ratones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                comer();//tiene suficiente comida en el plato
                Thread.sleep(200);//0.2 segundos espera
            } catch (InterruptedException ex) {
                Logger.getLogger(Ratones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          
    }//fin metodo
    
    public static boolean esCorrectaRespuesta(String respuesta){
        int numero = 0;
	try {
            numero =Integer.parseInt(respuesta);
            if(numero == 1 || numero == 2){
                return true;
            }else{
               return false; 
            }
	} catch (NumberFormatException nfe){
            System.out.println("Fallo en la respuesta = " + nfe);
            return false;
	}
    }

    //MAIN
    public static void main(String args[]) throws InterruptedException {
        String respuesta = "1";
        Scanner sc = new Scanner (System.in);
        
        System.out.println("En el plato sobre la mesa hay " + plato + " unidades.");
        do{
            System.out.println("¿Quieres dar de comer a los ratones ? (1 es Sí / 2 es No) ");
            respuesta = sc.nextLine();
            if(esCorrectaRespuesta(respuesta) == true){
                if(respuesta.equals("1")){
                    //en caso afirmativo iniciamos los hilos            
                    Ratones raton1 = new Ratones("Raton1", 5); //objeto subproceso
                    Ratones raton2 = new Ratones("Raton2", 10); //objeto subproceso

                    try {
                        //System.out.println("INICIO DE CICLO DE " + getName());
                        raton1.start();//arrancamos con start el objeto subproceso y el run
                        Thread.sleep(1000);//1 segundos espera
                        raton2.start();//arrancamos con start el objeto subproceso y el run
                        Thread.sleep(1000);//1 segundos espera
                    } catch(InterruptedException e) { 
                        raton1.interrupt(); //interrumpimos el subproceso
                        raton2.interrupt(); //interrumpimos el subproceso
                        System.out.println("Interrumpido con la excepción = " + e);
                    //System.out.println("INTERRUMPIDO: " + getName());
                    } finally {
                        System.out.println("Los ratones han comido. "); 
                        raton1.interrupt(); //interrumpimos el subproceso
                        raton2.interrupt(); //interrumpimos el subproceso
                        respuesta = "1";//para volver a preguntar
                    }   
                }else{
                    System.out.println("Salimos ");
                } 
            }else{
                System.out.println("Respuesta incorrecta. La respuesta debe ser 1 (SI) o 2 (NO)");
                respuesta = "1";//para volver a preguntar
            }     
        }while(respuesta == "1");          
    }//fin MAIN
    
}//fin clase
