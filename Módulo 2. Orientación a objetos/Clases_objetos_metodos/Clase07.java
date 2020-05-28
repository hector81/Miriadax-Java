package Tema2.Clases_objetos_metodos;

public class Clase07 {
    private static int numPersonas; //variable de clase
    final public static int EDAD_MAX= 65;
    private int numero;
    private String nombre;
    
    //Constructores
    public Clase07(){
        numero = EDAD_MAX;
        nombre = "anonimo";
    }
    
    public Clase07(int numero, String nombre){
        numero = EDAD_MAX;
        nombre = "anonimo";
    }
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero > EDAD_MAX ? EDAD_MAX : numero;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void modificaDatos(String nombre, int numero){
        this.numero = numero > EDAD_MAX ? EDAD_MAX : numero;
        this.nombre = nombre;
    }
	 // El resto de funciones
}