/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema2;

/**
 *
 * @author Hector Garcia
 */
public class PruebaPunto {
    //main
    public static void main(String[] args){
        //Crear un Punto de acuerdo con cada uno de los tres constructores.
        Punto punto1 = new Punto();// en este caso ya tiene los atributos iniciados
        Punto punto2 = new Punto(57, 38);
        Punto punto3 = new Punto(punto1);
        
        //Visualizar los tres puntos con su función pintar().
        punto1.pintar(); //llamamos al metodo pintar del objeto punto
        punto2.pintar(); //llamamos al metodo pintar del objeto punto
        punto3.pintar(); //llamamos al metodo pintar del objeto punto
     
        //Crear un array de Puntos con el tamaño obtenido por la
        //generación de un aleatorio no mayor que 20. Las coordenadas
        //de cada punto serán también números aleatorios comprendidos
        //en el rango de 0 a 100.
        int tamanioArray;        
        tamanioArray = (int)Math.floor(Math.random()*(20-0+1)+0); // Esto da valores entre 0 y 20
        //declaramos un array que contiene objetos de tipo Punto con su tamaño
        Punto arrayPuntos[] = new Punto[tamanioArray];
        //recorremos y por cada vuelta creamos un objeto Punto dentro del array
        for(int i = 0 ; i< arrayPuntos.length; i++){
            int coordenadaX = (int)Math.floor(Math.random()*(100-0+1)+0); // Esto da valores entre 0 y 100
            int coordenadaY = (int)Math.floor(Math.random()*(100-0+1)+0); // Esto da valores entre 0 y 10
            arrayPuntos[i] = new Punto(coordenadaX,coordenadaY);
        }

        //Visualizar las coordenadas de todos los elementos del array de Puntos.
        for(int i = 0 ; i< arrayPuntos.length; i++){
            System.out.println("Coordenadas del Punto " + (i+1));
            arrayPuntos[i].pintar(); //llamamos a su método
        }
        
    }//fin main
}//fin clase
