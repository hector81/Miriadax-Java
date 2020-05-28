package Tema3.Colecciones_y_Clases_Genericas;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Mapas_Maps {
    public static void main(String[] args){
        Map<String, Float> hashmap = new HashMap<String,Float>();
        Map<String, Float> treemap = new TreeMap<String,Float>();
        Map<String, Float> linkedmap = new LinkedHashMap<String,Float>();
        
        
        String[] nombres = { "Teo", "Ramon", "Willy", "Alberto", "Gracia", "Maria" };
        float[] cuotas = { 1500, 1577, 1894, 899, 1258, 1369 };
        
        for (int i=0; i<nombres.length; i++){   
            hashmap.put(nombres[i], cuotas[i]);
            treemap.put(nombres[i], cuotas[i]);
            linkedmap.put(nombres[i], cuotas[i]);
        }
        
        System.out.println("Elementos de hashmap:" + hashmap.size());
        for (Map.Entry<String, Float> entrada : hashmap.entrySet()) {
            System.out.println( entrada.getKey()+ ":"+entrada.getValue());
        }
        
        System.out.println("Elementos de treemap:"+treemap.size());
        for (Map.Entry<String, Float> entrada : treemap.entrySet()) {
            System.out.println( entrada.getKey()+ ":"+entrada.getValue());
        }
        
        System.out.println("Elementos de linkedmap:"+linkedmap.size());
        for (Map.Entry<String, Float> entrada : linkedmap.entrySet()) {
             System.out.println( entrada.getKey()+ ":"+entrada.getValue());
        }
        
        
        
    }
}
