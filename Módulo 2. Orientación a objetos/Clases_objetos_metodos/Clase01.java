package Tema2.Clases_objetos_metodos;

public class Clase01 {
    private int numero;
    private String nombre;
    
    //Constructor sin parámetros
    public Clase01 (){
        numero = 99;
        nombre ="anonimo";
    }
    
    public void definirDatos(){
        this.numero = numero;
        this.nombre = nombre;
   }
    
    public void leerDatos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Numero: " + numero);
   }
}
