/*
 * Realizar un programa que simule el lanzamiento de un dado 1000 veces. 
 * Después, el programa nos mostrará el porcentaje de veces que ha aparecido cada número.
 */
package Ejercicios_Adicionales;

/**
 *
 * @author Hector Garcia
 */
public class Ejercicio1_Dado {
    //funcion para saber cuentas veces ha salido un numero
    public static int devolver_numero_veces_numero(int[] array_resultados_dado, int numero){
        int veces = 0;
        for(int i = 0; i < array_resultados_dado.length; i++){
            if(array_resultados_dado[i] == numero){
                veces++;
            }
        }
        return veces;
    }//fin metodo
    
    //funcion para saber porcentaje de cuentas veces ha salido un numero
    public static double devolver_porcentaje_veces_numero(int[] array_resultados_dado, int numero){
        double porcentaje = 0;
        double veces = (double)(devolver_numero_veces_numero(array_resultados_dado, numero));
        int longitud = array_resultados_dado.length;
        porcentaje = (veces/longitud)*100;
        //redondeamos a dos decimales
        porcentaje= (double)Math.round(porcentaje * 100d) / 100d;
        return porcentaje;
    }//fin metodo
    
    //main
    public static void main(String[] args) {
        //inicializar variables
        int array_resultados_dado[] = new int[1000];
        int inicio = 0;
        int minimo = 1;
        int maximo = 6;
        do {
            //generamos aleatorio entre 1 y 6
            array_resultados_dado[inicio] = (int) Math.floor(Math.random() * (maximo - minimo + 1) + minimo);
            inicio++;
        } while (inicio < 1000);
        //imprimimos y calculamos porcentajes
        System.out.println("El 1 ha salido " + devolver_numero_veces_numero(array_resultados_dado, 1) + " veces y su porcentaje es de " + devolver_porcentaje_veces_numero(array_resultados_dado, 1) + "%");
        System.out.println("El 2 ha salido " + devolver_numero_veces_numero(array_resultados_dado, 2) + " veces y su porcentaje es de " + devolver_porcentaje_veces_numero(array_resultados_dado, 2) + "%");
        System.out.println("El 3 ha salido " + devolver_numero_veces_numero(array_resultados_dado, 3) + " veces y su porcentaje es de " + devolver_porcentaje_veces_numero(array_resultados_dado, 3) + "%");
        System.out.println("El 4 ha salido " + devolver_numero_veces_numero(array_resultados_dado, 4) + " veces y su porcentaje es de " + devolver_porcentaje_veces_numero(array_resultados_dado, 4) + "%");
        System.out.println("El 5 ha salido " + devolver_numero_veces_numero(array_resultados_dado, 5) + " veces y su porcentaje es de " + devolver_porcentaje_veces_numero(array_resultados_dado, 5) + "%");
        System.out.println("El 6 ha salido " + devolver_numero_veces_numero(array_resultados_dado, 6) + " veces y su porcentaje es de " + devolver_porcentaje_veces_numero(array_resultados_dado, 6) + "%");
    }//fin main
}
