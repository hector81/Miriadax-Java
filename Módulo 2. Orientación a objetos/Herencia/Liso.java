package Tema2.Herencia;

public class Liso extends Tubo {
    //datos
    private String color;
    private float espesor;
    
    //constructor
    public Liso(int numero, String nombre, float calibre, String medida, String color, float espesor) {
        super(numero, nombre, calibre, medida);
        this.color = color;
        this.espesor = espesor;
    }
    
    //funciones
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Liso(numero, nombre, calibre, medida, color, espesor);
    }
    //Otras funciones


}
