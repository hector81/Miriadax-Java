package Tema4.Novedades_Java_8;

import java.util.Collections;
import java.util.Comparator;

public class ComparadorPuntos implements Comparator<Punto>{
    @Override
    public int compare(Punto o1, Punto o2) {
        if(o1.distancia()>o2.distancia())
            return 1;
        if(o1.distancia()<o2.distancia())
            return -1;
        return 0;
    }
    
    //Collections.sort(lista, new ComparadorPuntos());
    //Collections.sort(lista, new Comparator<Punto>(){
    //    public int compare(Punto o1, Punto o2) {
    //    if(o1.distancia()>o2.distancia())
    //         return 1;
    //    if(o1.distancia()<o2.distancia())
    //        return -1;
    //    return 0;
    //}
    //});
}
