package Tema3.Colecciones_y_Clases_Genericas;

public class PruebaPareja{
    public static void main(String[] args){
        String[] palabras = { "tenedor", "cuchillo", "cuchara", "taza", "vaso", "plato"};
        Pareja<String> mm = ArrayAlgo.minmax(palabras);
        System.out.println("menor = " +mm.getPrimero());
        System.out.println("mayor = " +mm.getSegundo());
    }
}

class ArrayAlgo {
/**Devuelve una pareja de palabras.
 * min es la menor en orden alfabético. max
 * es la mayor en orden alfabético */
    public static Pareja<String> minmax(String[] a){
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for(int i = 1; i < a.length; i++){
            if (min.compareTo(a[i]) > 0)
                min = a[i];
            if (max.compareTo(a[i]) < 0)
                max = a[i];
        }
        return new Pareja<String>(min, max);
    }
}
