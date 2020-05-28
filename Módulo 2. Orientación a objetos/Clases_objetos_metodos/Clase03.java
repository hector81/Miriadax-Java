package Tema2.Clases_objetos_metodos;

public class Clase03 {
    private int numero;
    private String nombre;
    
    //Constructor con dos parámetros
    public Clase03(int numero, String nombre){
        this.numero = numero;
         this.nombre = nombre;
    }
    //Función que accede a las variables de instancia y cambia su valor
    public void modificaDatos(String nombre, int numero){
         this.numero = numero;
         this.nombre = nombre;
    }
}
