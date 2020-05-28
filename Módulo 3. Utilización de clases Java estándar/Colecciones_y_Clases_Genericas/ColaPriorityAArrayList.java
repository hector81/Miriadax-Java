package Tema3.Colecciones_y_Clases_Genericas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class ColaPriorityAArrayList {
    static public void main(String [] args){
        Random aleatorio = new Random();
        int cant = aleatorio.nextInt(15);
        int num=0;
        List<Integer> lista = new ArrayList<Integer>();
        
        for (int i=0; i<cant; i++){
            lista.add(num=aleatorio.nextInt(10));
        }
        System.out.println("ArrayList Antes");
        
        for(Integer n: lista){
            System.out.print(n+" ");
        }
        System.out.println();
        
        lista = ordenarLista(lista);
        System.out.println("ArrayList Despues");
        for(Integer n: lista){
            System.out.print(n+ "");

        }
         System.out.println();
    }
    
    static <E> List<E> ordenarLista(Collection<E> c){
        Queue<E> cola = new PriorityQueue<E>(c);
        List<E> lista = new ArrayList<E>();
        while (!cola.isEmpty())
        lista.add(cola.remove());
        return lista;
    }
}
