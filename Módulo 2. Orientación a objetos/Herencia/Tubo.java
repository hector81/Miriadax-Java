package Tema2.Herencia;

public class Tubo extends Pieza {
    //datos
    float calibre;
    String medida;
    
    //constructor
    public Tubo(int numero, String nombre,float calibre,String medida) {
        super(numero, nombre); //constructor de Pieza
        this.calibre = calibre;
        this.medida = medida;
    }
    
    //funciones
    @Override
    public String toString() {
        return "Tubo [calibre=" + calibre + ", medida=" + medida + ", " + super.toString() + "]";
    }
    
    @Override
    public void vender(int cantidad) {
        System.out.println("VENDIDO TUBO " + this.nombre);
    }
}
