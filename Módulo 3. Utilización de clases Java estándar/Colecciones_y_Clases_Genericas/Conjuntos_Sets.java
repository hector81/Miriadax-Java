package Tema3.Colecciones_y_Clases_Genericas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Conjuntos_Sets {
    public static void main(String[] args){
        List<Integer> listnumeros = new ArrayList<Integer>();
        Set<Integer> hashsetnumeros = new HashSet<Integer>();
        Set<Integer> treesetnumeros = new TreeSet<Integer>();
        
        int cantidad = 10;
        for (int i = 1; i < cantidad; i++) {
            n = aleatorio.nextInt(49) + 1;
            listnumeros.add(n);
            hashsetnumeros.add(n);
            treesetnumeros.add(n);
        }


        System.out.println("Elementos en el ArrayList: " + listnumeros.size());
            for (Integer numero : listnumeros) {
                System.out.print(numero+ " ");
            }
        System.out.println();
        
        System.out.println("Elementos en el HashSet: " + hashsetnumeros.size());
            for (Integer numero : hashsetnumeros) {
                System.out.print(numero+ " ");
            }
        System.out.println();
        
        System.out.println("Elementos en el TreeSet: " + treesetnumeros.size());
            for (Integer numero : treesetnumeros) {
                System.out.print(numero+ " ");
            }
    }
}
