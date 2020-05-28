package Tema2.Clases_objetos_metodos;

public class Clase11 {
    private static int numero;
    private String nombre;
    
    //Constructores
    public Clase11(){
        numero = 44;
        nombre = "anonimo";
    }
    
    public Clase11(int numero, String nombre){
        numero = 44;
        nombre = "anonimo";
    }
    
    public Clase11(Clase11 clase11){
        this.numero = clase11.numero;
        this.nombre = clase11.nombre; 
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
        Clase11 other = (Clase11) obj;
    if (nombre == null) {
    if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
        return false;
    if (numero != other.numero)
        return false;
        return true;
    }
    
    @Override
    protected void finalize() throws Throwable {
        //numPersonas--;
        //System.out.println("Objeto que finaliza: " + this + " Quedan " + numPersonas);
    }
    
    public static int cuentaPersonas(){
        return Clase11.numero;
    }//fin metodo
}
