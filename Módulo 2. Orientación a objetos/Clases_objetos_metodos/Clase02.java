package Tema2.Clases_objetos_metodos;

public class Clase02 {
    private int numero;
    private String nombre;
    
    //Constructor sin parámetros
    public Clase02 (){
        numero = 99;
        nombre ="anonimo";
    }
    //Constructor con dos parámetros
    public Clase02(int num, String cad){
        numero = num;
        nombre = cad;
    }
    //Constructor que recibe referencia objeto de Clase02
    public Clase02(Clase02 o){
        numero= o.numero;
        nombre= o.nombre;
    }
    
    public void leerDatos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Numero: " + numero);
   }
}