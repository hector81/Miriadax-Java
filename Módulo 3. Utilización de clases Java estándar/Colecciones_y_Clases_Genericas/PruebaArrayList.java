package Tema3.Colecciones_y_Clases_Genericas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PruebaArrayList {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        List <Number> listanumeros = new ArrayList<Number>();
        int limite = aleatorio.nextInt(24)+1;
        
        for(int i=1; i<limite; i++){
            int tipo = aleatorio.nextInt(4)+1;
            switch(tipo){
                case 1:
                    listanumeros.add(aleatorio.nextInt(1000)+1); break;
                case 2: 
                    listanumeros.add(aleatorio.nextLong()); break;
                case 3: 
                    listanumeros.add(aleatorio.nextFloat()); break;
                case 4: 
                    listanumeros.add(aleatorio.nextDouble()); break;
            }
        }
        
        System.out.println("Elementos lista: " + listanumeros.size());
        for (Number numero : listanumeros){
            System.out.println(numero);
        }

        int indice = aleatorio.nextInt(limite-1);
        System.out.println("Elemento " + indice + ": " + listanumeros.get(indice));
        listanumeros.remove(indice);
        System.out.println("Elementos lista: " + listanumeros.size());
    }
}
