package Tema2.Clases_objetos_metodos;

public class Clase06{
    private static int numPersonas; //variable de clase
    final public static int EDAD_MAX= 65;
    private int numero;
    private String nombre;
    
    //Constructores
    public Clase06(){
        numero = EDAD_MAX;
        nombre = "anonimo";
    }
    
    public Clase06(int numero, String nombre){
        numero = EDAD_MAX;
        nombre = "anonimo";
    }
    
    public Clase06(Clase06 clase06){
        this.numero = clase06.numero;
        this.nombre = clase06.nombre; 
    }//fin constructor
    
    //Función que accede a las variables de instancia y cambia su valor
    //sobrecargada de 4 formas
    public void modificaDatos(String nombre, int numero){
        this.numero = numero > EDAD_MAX ? EDAD_MAX : numero;
        this.nombre = nombre;
    }
	
    public void modificaDatos(String nombre){	
        this.nombre = nombre;
    }
    
    public void modificaDatos(int numero){
            this.numero = numero > EDAD_MAX ? EDAD_MAX : numero;
    }
    
    public void modificaDatos(){
       this.nombre = "anonimo";
       this.numero = EDAD_MAX;
    }
//Otras funciones
}