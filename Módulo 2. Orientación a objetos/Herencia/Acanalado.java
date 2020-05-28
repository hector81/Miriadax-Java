package Tema2.Herencia;

public class Acanalado extends Tubo {
    //datos
    private String material;
    private boolean esFlexible;
    
    //constructor
    public Acanalado(int numero, String nombre, float calibre, String medida, String material, boolean esFlexible) {
        super(numero, nombre, calibre, medida);
        this.material = material;
        this.esFlexible = esFlexible;
    }
    
    //funciones
    @Override
    public String toString() {
        return "Acanalado [material=" + material + ", esFlexible=" + esFlexible + ", " + super.toString() + "]";
    }
}

