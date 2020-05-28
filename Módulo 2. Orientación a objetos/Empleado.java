/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema2;

/**
 *
 * @author Hector Garcia
 */
public class Empleado extends Persona{
    //atributos
    private String idPersonal; //identificador de empleado en la empresa.
    private float sueldo; //sueldo del empleado en la empresa
    
    //constructores
    //1ºConstructor sin parametros que llama con super al constructor de la clase Persona
    public Empleado(){ 
        super();//con super llamamos al constructor de la clase persona
    }//fin constructor
    
    //2ºConstructor que recibe como parámetro otro objeto de la clase Empleado
    public Empleado(Empleado oEmpleado){
        super(oEmpleado);//con super llamamos al constructor de la clase persona
        idPersonal = oEmpleado.idPersonal;
        sueldo = oEmpleado.sueldo;
    }
    
    //3ºConstructor que recibe como parámetro otro objeto de la clase Persona  y un dato para cada dato de Empleado
    public Empleado(Persona oPersona, String idPersonal, float sueldo) {
        super(oPersona);//con super llamamos al constructor de la clase persona
        this.idPersonal = idPersonal;
        this.sueldo = sueldo;
    }
    
    //4ºConstructor, Con un parámetro para cada dato heredado de Persona y un parámetro para cada dato de la propia clase
    public Empleado(String nombre, byte edad, char sexo, String dni, boolean bCasado, String idPersonal, float sueldo) {
        super(nombre, edad, sexo, dni, bCasado);//con super llamamos al constructor de la clase persona
        this.idPersonal = idPersonal;
        this.sueldo = sueldo;
    }
    
    //METODOS
    //metodos getters
    public String getIdPersonal(){
        return this.idPersonal;
    }//fin metodo
    
    public float getSueldo(){
        return this.sueldo;
    }//fin metodo
    
    //metodos setters
    public void setIdPersonal(String idPersonal){
        this.idPersonal = idPersonal;
    }//fin metodo
    
    public void setSueldo(float sueldo){
        this.sueldo = sueldo;
    }//fin metodo
    
    @Override
    //metodo toString sobreescrito
    public String toString(){
        return "Persona = El nombre es " + this.getNombre() + ", la edad es " + this.getEdad() + 
            ", el sexo es " + this.getSexo() + ", el dni es " + this.getDni() + ", ¿está casado? " + this.getBCasado()
            + ", su identificador personal es" + this.getIdPersonal() + " y su sueldo actual es " + this.getSueldo();
    }

    
    @Override
    //metodo pintar sobreescrito
    public void pintar(){
        System.out.println("Persona = El nombre es " + this.getNombre() + ", la edad es " + this.getEdad() + 
            ", el sexo es " + this.getSexo() + ", el dni es " + this.getDni() + ", ¿está casado? " + this.getBCasado()
            + ", su identificador personal es" + this.getIdPersonal() + " y su sueldo actual es " + this.getSueldo());
    }//fin metodo
        
}//fin clase
