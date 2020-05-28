package Tema2.Herencia;

import java.util.Random;

public class Prueba_Piezas_Herencia1 {
    public static void main(String[] args) {
        Pieza pieza = new Pieza(25, "Arandela centifugadora") {
            @Override
            public void vender(int cantidad) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Tubo tubo = new Tubo(101, "Especial", 1.0f, "pulgadas");
        Plancha plancha = new Plancha(201,"Extra", 2.1f, 3.5f, 0.2f );
        Acanalado acanalado = new Acanalado (102,"Humos", 30.5f,"mms","plastico", true);
        Liso liso = new Liso (103, "Canal", 11.2f,"mms", "verde",0.3F);
        System.out.println(pieza);
        System.out.println(tubo);
        System.out.println(plancha);
        System.out.println(acanalado);
        System.out.println(liso);
        
        
        Plancha plancha1 = new Plancha(201,"Extra", 25.4f, 3.5f, 0.2f );
        Random aleatorio = new Random();
        int metros=0;
        System.out.println(plancha);
        do{
            metros = aleatorio.nextInt(10)+1;
        }while(plancha.cortar(metros)); 

    }
}
