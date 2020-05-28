package Tema4.Novedades_Java_8;

import java.util.Comparator;

public class ComparadorCadenas implements Comparator<String> {
    
    @Override
    public int compare(String arg0, String arg1) {
        return arg0.compareTo(arg1);
    }
}