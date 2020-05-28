package Tema2.Clases_objetos_metodos;

public class Clase10 {
    private int numero;
    private String nombre;
    
    //Constructores
    public Clase10(){
        numero = 44;
        nombre = "anonimo";
    }
    
    public Clase10(int numero, String nombre){
        numero = 44;
        nombre = "anonimo";
    }
    
    public Clase10(Clase10 clase10){
        this.numero = clase10.numero;
        this.nombre = clase10.nombre; 
    }//fin constructor
    
    //metodos getters
    public int getNumero(){
        return this.numero;
    }//fin metodo
    
    public String getNombre(){
        return this.nombre;
    }//fin metodo
    
    public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
        Clase10 other = (Clase10) obj;
    if (nombre == null) {
    if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
        return false;
    if (numero != other.numero)
        return false;
        return true;
    }
}
