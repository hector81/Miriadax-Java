/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema3.Colecciones_y_Clases_Genericas;

import Tema2.*;
import java.util.Objects;

/**
 *
 * @author Hector Garcia
 */
public class Persona {
    //atributos
    private String nombre;
    private byte edad;
    private char sexo;
    private String dni;
    private boolean bCasado;
    
    //constructores
    //1ºConstructor sin parametros
    public Persona(){
        
    }//fin constructor
    
    
    //2ºConstructor que recibe parámetros
    public Persona(String nombre, byte edad, char sexo, String dni, boolean bCasado){
        this.nombre = nombre;
        this.edad = edad; 
        this.sexo = sexo;
        this.dni = dni; 
        this.bCasado = bCasado; 
    }//fin constructor
    
    //3ºConstructor que recibe como parámetro un objeto de tipo Persona
    //Con otro Persona que ya exista
    public Persona(Persona otraPersona){
        this.nombre = otraPersona.getNombre();
        this.edad = otraPersona.getEdad(); 
        this.sexo = otraPersona.getSexo();
        this.dni = otraPersona.getDni(); 
        this.bCasado = otraPersona.getBCasado();
    }//fin constructor
    
    //METODOS
    //metodos getters
    public String getNombre(){
        return this.nombre;
    }//fin metodo
    
    public byte getEdad(){
        return this.edad;
    }//fin metodo
    
    public char getSexo(){
        return this.sexo;
    }//fin metodo
    
    public String getDni(){
        return this.dni;
    }//fin metodo
    
    public boolean getBCasado(){
        return this.bCasado;
    }//fin metodo
    
    //metodos setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }//fin metodo
    
    public void setEdad(byte edad){
        this.edad = edad;
    }//fin metodo
    
    public void setSexo(char sexo){
        this.sexo = sexo;
    }//fin metodo
    
    public void setDni(String dni){
        this.dni = dni;
    }//fin metodo
    
    public void setBCasado(boolean bCasado){
        this.bCasado = bCasado;
    }//fin metodo

    @Override
    //metodo equals sobreescrito
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        
        Persona oPersona = (Persona) obj;
        
        if (!Objects.equals(this.nombre, oPersona.getNombre())) {
            return false;
        }
        if (!Objects.equals(this.edad, oPersona.getEdad())) {
            return false;
        }
        if (!Objects.equals(this.sexo, oPersona.getSexo())) {
            return false;
        }
        if (!Objects.equals(this.dni, oPersona.getDni())) {
            return false;
        }
        if (!Objects.equals(this.bCasado, oPersona.getBCasado())) {
            return false;
        }
        return true;
    }//fin metodo

    @Override
    //metodo toString sobreescrito
    public String toString(){
        return "Persona = El nombre es " + this.nombre + ", la edad es " + this.edad
            + ", el sexo es " + this.sexo + ", el dni es " + this.dni + " y ¿está casado? " + this.bCasado;
    }//fin metodo
    
    //metodo pintar
    public void pintar(){
        System.out.println("Persona = El nombre es " + this.getNombre() + ", la edad es " + this.getEdad() + 
            ", el sexo es " + this.getSexo() + ", el dni es " + this.getDni() + " y ¿está casado? " + this.getBCasado());
    }//fin metodo
    
}//fin clase


