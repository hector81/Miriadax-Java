package Tema2.Herencia;

public abstract class Pieza {
    //datos
    protected int numero;
    protected String nombre;
    
    //constructor
    public Pieza(int numero, String nombre) {
        super(); //constructor de Object, no hace falta
        this.numero = numero;
        this.nombre = nombre;
    } 
    
    //funciones
    //función abstracta
    abstract public void vender(int cantidad);
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + numero;
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pieza other = (Pieza) obj;
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
