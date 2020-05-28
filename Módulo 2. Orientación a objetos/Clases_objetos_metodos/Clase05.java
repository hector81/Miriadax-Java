package Tema2.Clases_objetos_metodos;

public class Clase05 {
    private static int numPersonas; //variable de clase
    final public static int EDAD_MAX= 65;
    private int numero;
    private String nombre;
    
    public Clase05 (){
        numero = EDAD_MAX;
        nombre = "anonimo";
    }
    
    public Clase05(int numero, String nombre){
        this.numero = numero > EDAD_MAX ? EDAD_MAX : numero;
        this.nombre = nombre;
    }
    
    public void modificaDatos(String nombre, int numero){
        this.numero = numero > EDAD_MAX ? EDAD_MAX : numero;
        this.nombre = nombre;
    }
    //Otras funciones miembro de la clase
}
