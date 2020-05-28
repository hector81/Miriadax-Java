package Tema3.Colecciones_y_Clases_Genericas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparadorTelefono implements Comparator
    <Persona>{
        @Override
        public int compare(Persona o1, Persona o2){
            return o1.getTelefono().compareTo(o2.getTelefono());
        }
        
        public static void main(String[] args) {
            List<Persona> per = new ArrayList<Persona>();
            per.add(new Persona("Zacarias", 25,"923566744"));
            per.add(new Persona("Rosa", 23,"918575732"));
            per.add(new Persona("Rosa", 18,"985467804"));
            per.add(new Persona("Blas", 34,"956589032"));
            per.add(new Persona("Zacarias", 25,"944556679"));
            Collections.sort(per, new ComparadorTelefono());
            for (Persona persona : per)
            System.out.println(persona);
        }
}
