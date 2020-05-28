package Tema4.CP_FuncionesStream;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Hector Garcia
 */
public abstract class  OperacionesImplementadas implements OperacionesInterfaz{
    //metodos
    
    @Override
    public Predicate<Persona> cumpleCondiciones(int edad, String sexo){ 
        //devuelve objeto predicate (interface funcional que define una condición que un objeto determinado debe cumplir)
        return (Persona persona_interfaz) -> persona_interfaz.getEdad() == edad && persona_interfaz.getSexo().equals(sexo);
    }//fin metodo
    
    @Override
    public Predicate<Persona> esDeGenero(String sexo){
        //devuelve objeto predicate (interface funcional que define una condición que un objeto determinado debe cumplir)
        return (Persona persona_interfaz) -> persona_interfaz.getSexo().equals(sexo);
    }//fin metodo
    
    @Override
    public Predicate<Persona> esFemenino(){
        //devuelve objeto predicate (interface funcional que define una condición que un objeto determinado debe cumplir)
        return (Persona persona_interfaz) -> "Mujer".equals(persona_interfaz.getSexo());
    }//fin metodo
    
    @Override
    public Predicate<Persona> esMasculino(){
        //devuelve objeto predicate (interface funcional que define una condición que un objeto determinado debe cumplir)
        return (Persona persona_interfaz) -> "Hombre".equals(persona_interfaz.getSexo());
    }//fin metodo
    
    @Override
    public List<Persona> filtroPersonas(List<Persona> ListaPersonas, Predicate<Persona> persona){
        //usamos los Java Stream Collectors y convertir nuestro stream a una Lista o Conjunto , utilizando la clase Collectors y su método toList() 
        return ListaPersonas.stream().filter(persona).collect(Collectors.<Persona>toList());
    }//fin metodo
    
    @Override
    public void mostrarFiltroPersonas(List<Persona> ListaPersonas, Predicate<Persona> persona){
        //es un bucle forEach que nos permite acceder a los valores del diccionario o lista
        //en este caso le pasamos el objeto por el que queremos filtrar con filter
        ListaPersonas.stream().filter(persona).forEach((persona_interfaz)-> {
            System.out.println("La edad de la persona es = " + persona_interfaz.getEdad());
            System.out.println("El nombre de la persona es = " + persona_interfaz.getNombre());
            System.out.println("El sexo de la persona es = " + persona_interfaz.getSexo());
        });
    }//fin metodo
    
    @Override
    public void mostrarPersonas(List<Persona> ListaPersonas){       
        //es un bucle forEach que nos permite acceder a los valores del diccionario o lista
        ListaPersonas.stream().forEach(new Consumer<Persona>() {
            int contador = 1;
            @Override
            public void accept(Persona persona_interfaz) {
                System.out.println("PERSONA NUMERO " + contador);
                System.out.println("La edad de la persona es = " + persona_interfaz.getEdad());
                System.out.println("El nombre de la persona es = " + persona_interfaz.getNombre());
                System.out.println("El sexo de la persona es = " + persona_interfaz.getSexo());
                contador++;
                //tambien podriamos usar
                //System.out.println(persona_interfaz.toString());//usamos metodo toString de persona
            }
        });
    }//fin metodo
    
    @Override
    public Predicate<Persona> tieneMasDe(int edad){
        //devuelve objeto predicate (interface funcional que define una condición que un objeto determinado debe cumplir)
        return (Persona persona_interfaz) -> persona_interfaz.getEdad() > edad;
    }//fin metodo

}//fin clase
