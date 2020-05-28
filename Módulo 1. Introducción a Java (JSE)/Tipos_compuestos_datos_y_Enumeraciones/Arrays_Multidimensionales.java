package Tema1.Tipos_compuestos_datos_y_Enumeraciones;

import java.util.Random;

public class Arrays_Multidimensionales {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int apuestas = aleatorio.nextInt(10) + 1;
        // Crear array de dos dimensiones
        int[][] numeros = new int[apuestas][6];
        // Recorrer array de dos dimensiones
        // almacenando un valor en cada posición
        System.out.println("Apuestas: " + numeros.length);
        for (int i = 0; i < numeros.length; i++){
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = aleatorio.nextInt(49) + 1;
            }
        }
        // Recorrer array de dos dimensiones
        // accediendo a cada posición
        for (int[] apuesta : numeros) {
             for (int numero : apuesta) {
                System.out.print(numero + "\t");
             }
            System.out.println();

            String grupo [] []= { {"Pepe", "Madrid", "coordina"}, {"Ana", "Sevilla", "colabora"}, {"Luis", "Lugo", "escribe"}};
            for(String[] persona : grupo){
                for (String dato: persona){
                    System.out.print(dato + "\t\t");
                }
            System.out.print("\n");
            }
        }
    }      
}
