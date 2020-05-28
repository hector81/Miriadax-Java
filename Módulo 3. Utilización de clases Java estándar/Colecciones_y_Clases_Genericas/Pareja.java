package Tema3.Colecciones_y_Clases_Genericas;

public class Pareja<E> {
    private E primero;
    private E segundo;
    
    public Pareja(){
        primero = null;
        segundo = null;
    }
    
    public Pareja(E primero, E segundo){
        this.primero = primero;
        this.segundo = segundo;
    }
    
    public E getPrimero(){ 
        return primero;
    }
    
    public E getSegundo(){ 
        return segundo;
    }
    
    public void setPrimero(E valor){ 
        primero = valor;
    }
    
    public void setSegundo(E valor){ 
        segundo = valor;
    }
}
