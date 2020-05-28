package Tema4.CP_FuncionesStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Hector Garcia
 */
//CLASE EXTERNA PERSONA
public class Persona {
    //CLASE INTERNA MUNDO
    static class Mundo{
        //atributos
        private int edad;
        private String nombre;
        private String sexo;
      
        //metodos
        //Devuelve una nueva persona que ha sido creada en el mundo
        public Persona nacer(){
            Persona persona = new Persona(this.edad, this.nombre, this.sexo);
            return persona;
        }//fin metodo
    
        //Devuelve la edad que se le asignara a la persona creada en el mundo
        public Mundo ponEdad(int edad){
            this.edad = edad;
            return this;
        }//fin metodo
        
        //Devuelve el nombre que se le asignara a la persona creada en el mundo
        public Mundo ponNombre(String nombre){
            this.nombre = nombre;
            return this;
        }//fin metodo
        
        //Devuelve el sexo que se le asignara a la persona creada en el mundo. 
        //Como no le pasamos ningún parámetro, se lo tenemos que asignar aleatoriamente
        public Mundo ponSexo(){
            //generamos aleatorio entre 1 y 2
            int sexo_int = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);
            String sexo = "";
            if(sexo_int == 1){
                sexo = "Hombre";
            }else if(sexo_int == 2){
                sexo = "Mujer";
            }
            this.sexo = sexo;
            return this;
        }//fin metodo

    }//Fin clase interna Mundo
    
    //Función static crearMundo de la clase Persona
    public static List<Persona> crearMundo() {
        //creamos una lista de personas en el mundo con unas caracteristicas aleatorias
        List<Persona> personas = new ArrayList<>();    
        Random r = new Random();
        int num = r.nextInt(6) + 5;
        for (int i = 1; i <= num; i++) {
            int edad = r.nextInt(48) + 18;
            personas.add(new Persona.Mundo().
                ponNombre("Persona " + i).
                ponEdad(edad).
                ponSexo().
                nacer());
        }
        return personas;
    }//fin de funcion
    
   
    //atributos
    private int edad;
    private String nombre;
    private String sexo;
    
    //constructores
    //1ºConstructor sin parametros
    public Persona(){
        
    }//fin constructor
    
    //2ºConstructor que recibe parámetros propios de la persona
    public Persona(int edad, String nombre, String sexo){
        this.edad = edad; 
        this.nombre = nombre;
        this.sexo = sexo; 
    }//fin constructor
    
    //3ºConstructor que recibe como parámetro otro objeto de la clase Mundo
    public Persona(Mundo oMundo) {    
        this.edad = oMundo.edad; 
        this.nombre = oMundo.nombre;
        this.sexo = oMundo.sexo;
    }//fin constructor
    
    //METODOS
    //metodos getters
    public int getEdad(){
        return this.edad;
    }//fin metodo
    
    public String getNombre(){
        return this.nombre;
    }//fin metodo
    
    public String getSexo(){
        return this.sexo;
    }//fin metodo

    //metodos setters
    public void setEdad(int edad){
        this.edad = edad;
    }//fin metodo
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }//fin metodo
      
    public void setSexo(String sexo){
        this.sexo = sexo;
    }//fin metodo
    
    @Override
    //metodo toString sobreescrito
    public String toString(){
        return "[Persona] = El nombre es " + this.nombre + ", la edad es " + this.edad
            + " y el sexo es " + this.sexo;
    }//fin metodo

    
}//fin clase Persona
