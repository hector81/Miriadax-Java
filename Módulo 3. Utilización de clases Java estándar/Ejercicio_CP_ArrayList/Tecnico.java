/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema3.Ejercicio_CP_ArrayList;

/**
 *
 * @author Hector Garcia
 */
public class Tecnico extends Empleado{
    //atributos
    private String turno; //puede ser turno de mañana, tarde o noche
    private int horas_trabajadas; //horas trabajadas por dia
    private int horas_extras; //horas extras por mes
    
    //constructores
    //1ºConstructor sin parametros que llama con super al constructor de la clase Empleado
    public Tecnico(){ 
        super();//con super llamamos al constructor de la clase Empleado
    }//fin constructor
    
    //2ºConstructor que recibe como parámetro otro objeto de la clase Tecnico
    public Tecnico(Tecnico oTecnico){
        super(oTecnico);//con super llamamos al constructor de la clase Empleado
        turno = oTecnico.turno;
        horas_trabajadas = oTecnico.horas_trabajadas;
        horas_trabajadas = oTecnico.horas_trabajadas;
    }
    
    //3ºConstructor que recibe como parámetro otro objeto de la clase Empleado  y un dato para cada dato de Tecnico
    public Tecnico(Empleado oEmpleado, String turno, int horas_trabajadas, int horas_extras) {
        super(oEmpleado);//con super llamamos al constructor de la clase Empleado
        this.turno = turno;
        this.horas_trabajadas = horas_trabajadas;
        this.horas_extras = horas_extras;
    }
    
    //4ºConstructor, Con un parámetro para cada dato heredado de Empleado y un parámetro para cada dato de la propia clase
    public Tecnico(String nombre, byte edad, char sexo, String dni, boolean bCasado, String idPersonal, float sueldo, String turno, int horas_trabajadas, int horas_extras) {
        super(nombre, edad, sexo, dni, bCasado, idPersonal, sueldo);//con super llamamos al constructor de la clase Empleado
        this.turno = turno;
        this.horas_trabajadas = horas_trabajadas;
        this.horas_extras = horas_extras;
    }
    
    //METODOS
    //metodos getters
    public String getTurno(){
        return this.turno;
    }//fin metodo
    
    public int getHoras_trabajadas(){
        return this.horas_trabajadas;
    }//fin metodo
    
    public int getHoras_extras(){
        return this.horas_extras;
    }//fin metodo
    
    //metodos setters
    public void setTurno(String turno){
        this.turno = turno;
    }//fin metodo
    
    public void setHoras_trabajadas(int horas_trabajadas){
        this.horas_trabajadas = horas_trabajadas;
    }//fin metodo
    
    public void setHoras_extras(int horas_extras){
        this.horas_extras = horas_extras;
    }//fin metodo
    
    @Override
    //metodo toString sobreescrito
    public String toString(){
        return "[Persona] = El nombre es " + this.getNombre() + ", la edad es " + this.getEdad() + 
            ", el sexo es " + this.getSexo() + ", el dni es " + this.getDni() + ", ¿está casado? " + this.getBCasado()
            + ", [Empleado] su identificador personal es " + this.getIdPersonal() + " , su sueldo actual es " 
            + this.getSueldo() + ", [Tecnico] sus turno es de " + this.getTurno() + " , su horas de trabajo diarias son "
            + this.getHoras_trabajadas() + " y sus horas extras al mes son " + this.getHoras_extras();
    }

    
    @Override
    //metodo pintar sobreescrito
    public void pintar(){
        System.out.println("[Persona] = El nombre es " + this.getNombre() + ", la edad es " + this.getEdad() + 
            ", el sexo es " + this.getSexo() + ", el dni es " + this.getDni() + ", ¿está casado? " + this.getBCasado()
            + ", [Empleado] su identificador personal es " + this.getIdPersonal() + " , su sueldo actual es " 
            + this.getSueldo() + ", [Tecnico] sus turno es de " + this.getTurno() + " , su horas de trabajo diarias son "
            + this.getHoras_trabajadas() + " y sus horas extras al mes son " + this.getHoras_extras());
    }//fin metodo
    
    @Override
    //metodo clone sobreescrito
    protected Object clone() throws CloneNotSupportedException {
        return new Tecnico(this.getNombre(), this.getEdad(), this.getSexo(), this.getDni(), this.getBCasado(), this.getIdPersonal(), this.getSueldo(), this.getTurno(), this.getHoras_trabajadas(), this.getHoras_extras());
    }
    
    @Override
    //metodo devolver string tipo objeto
    public String devolver_string_tipo_objeto(){
        return "TECNICO";
    }//fin metodo
        
}//fin clase