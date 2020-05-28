package Tema3.Colecciones_y_Clases_Genericas;

public class Comparable {
    
    Persona persona = new Persona("Juan", (byte) 33, 'V', "11447788-Y", false);
    
    public int compareTo(Persona persona) {
        if (this.equals(persona)) return 0;
        if (this.hashCode() == persona.hashCode()) return 0;
        if (this.edad != persona.edad) {
        int n = this.nombre.compareTo(persona.nombre);
        if (n == 0) {
            if (this.edad > persona.edad) return 1;
                 return -1;
        }
        }
        return this.nombre.compareTo(persona.nombre);
    }
}
