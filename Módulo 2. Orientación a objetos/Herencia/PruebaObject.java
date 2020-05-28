package Tema2.Herencia;

public class PruebaObject {
    public static void main(String[] args) {
        Object objeto;
        //Se puede utilizar una variable Object para referenciar cualquier tipo
        objeto = new Acanalado (102,"Humos", 30.5f,"mms","plastico", true);
        System.out.println("objeto es Acanalado: " + (objeto instanceof Acanalado? "SI":"NO"));
        System.out.println("La clase de objeto es: "+objeto.getClass());
        //objeto.
        Acanalado tubo= (Acanalado) objeto;
        //tubo.
    }
}
