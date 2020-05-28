package Tema2.Herencia;

import java.text.DecimalFormat;

public class Plancha extends Pieza {
    //datos
    private float largo;
    private float ancho;
    private float espesor;
    
    //constructor
    public Plancha(int numero, String nombre, float largo, float ancho, float espesor) {
        super(numero, nombre); //constructor de Pieza
        this.largo = largo;
        this.ancho = ancho;
        this.espesor = espesor;
    }
    
    //funciones
    @Override
    public String toString() {
        return "Plancha [largo=" + largo + ",  ancho=" + ancho
        + ", espesor=" + espesor + ", " + super.toString()+ "]";
    }

    public boolean cortar(int metros){
        DecimalFormat df = new DecimalFormat("#,###.##");
        //System.out.println("De " + nombre +  " con numero " + numero);
        if (largo < metros){
            System.out.println(" no se pueden cortar " + metros + " metros ");
            System.out.println(" solo quedan " + df.format(largo) + " metros ");
            return false;
        }
        largo -= metros;
        System.out.println(" se han cortado " + metros + " metros ");
        System.out.println(" quedan " + df.format(largo) + " metros ");
         return true;
    }
    
    @Override
    public void vender(int metros) {
        if( cortar(metros)){
        System.out.println("==== VENDIDO =====");
        }
    }
}


