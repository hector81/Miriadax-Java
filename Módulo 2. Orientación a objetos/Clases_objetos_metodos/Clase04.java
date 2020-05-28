package Tema2.Clases_objetos_metodos;

public class Clase04 {
    private static int numPersonas; //variable de clase
    private int numero;
    private String nombre;
    
    public static int cuentaPersonas(){
        return numPersonas;
    }
    
    //Constructor sin parámetros
    public Clase04 (){
        numPersonas++;
        numero = 99;
        nombre ="anonimo";
    }
    //Constructor que recibe referencia objeto de Clase02
    public Clase04(Clase04 o){
        numPersonas++;
        numero= o.numero;
        nombre= o.nombre;
    }
}
