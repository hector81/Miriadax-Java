package Tema2.Clases_objetos_metodos;

public class Clase09 {
    private static int numPersonas; //variable de clase
    final public static int EDAD_MAX= 65;
    private int numero;
    private String nombre;
    
    //Constructores
    public Clase09(int numero, String nombre){
        numero = EDAD_MAX;
        nombre = "anonimo";
    }
    
    @Override
    public String toString() {
        return "Clase09 [numero=" + numero + ", nombre=" + nombre + "]";
    }
    //Otras funciones de la clase
}
