
package Tema3.Colecciones_y_Clases_Genericas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Colection_Iterator_Array_List {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        List <Number> listanumeros = new ArrayList<Number>();
        
        //Código que añade elementos a listanumeros
        for (Number numero : listanumeros){
            System.out.println(numero);
        }
        
        Iterator <Number> iterador= listanumeros.iterator();
        
        while(iterador.hasNext()){
            Class clase= iterador.next().getClass();
            if(clase.equals(Float.class)|| clase.equals(Double.class)){
                iterador.remove();
            }
        }
        
        for (Number numero : listanumeros){
            System.out.println(numero);
        }
    }
}

