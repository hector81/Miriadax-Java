package Tema1.Tipos_compuestos_datos_y_Enumeraciones;

import java.util.Random;

public class Enumeracion {
    
    enum EstadoCivil {SOLTERO, CASADO, VIUDO, SEPARADO, DIVORCIADO}

    public static void main(String[] args) {
        Random aleatorio = new Random();
        int num = aleatorio.nextInt(9)+1;

        int posicion=0;
        EstadoCivil [] valores_enumeracion = EstadoCivil.values();
        for(EstadoCivil estado: valores_enumeracion){
            posicion = estado.ordinal();
            System.out.println("La constante número "+ posicion+ " es "+estado.toString());
        }

        EstadoCivil [] estados = new EstadoCivil[num];
        int nestados = EstadoCivil.values().length;
        for (int i=0; i<num; i++ ){
            estados[i]=valores_enumeracion[aleatorio.nextInt(nestados)];
        }

        posicion=0;
        for(EstadoCivil estado: estados){
            System.out.println("estados["+posicion+"]:"+estado);
            posicion++;
        }
    }
}
