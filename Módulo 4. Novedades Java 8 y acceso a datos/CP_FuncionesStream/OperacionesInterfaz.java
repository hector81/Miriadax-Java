package Tema4.CP_FuncionesStream;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Hector Garcia
 */
public interface OperacionesInterfaz {
    ////metodos abstractos a implementar
    public abstract Predicate<Persona> cumpleCondiciones(int edad, String nombre);
    
    public abstract Predicate<Persona> esDeGenero(String nombre);
    
    public abstract Predicate<Persona> esFemenino();
    
    public abstract Predicate<Persona> esMasculino();
    
    public abstract List<Persona> filtroPersonas(List<Persona> per, Predicate<Persona> pre);
    
    public abstract void mostrarFiltroPersonas(List<Persona> per, Predicate<Persona> pre);
    
    public abstract void mostrarPersonas(List<Persona> per);
    
    public abstract Predicate<Persona> tieneMasDe(int edad);
}//fin interfaz

    