/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * 
 */
package Tema4.Novedades_Java_8;

import Tema4.CP_FuncionesStream.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 *
 * @author user
 */
public class Persona {
    //atributos
    private int edad;
    private String nombre;
    
    //constructores
    //1ºConstructor sin parametros
    public Persona(){
        
    }//fin constructor
    
    //2ºConstructor que recibe parámetros propios de la persona
    public Persona(String nombre, int edad){
        this.edad = edad; 
        this.nombre = nombre;
    }//fin constructor
    
    
    
    //METODOS
    //metodos getters
    public int getEdad(){
        return this.edad;
    }//fin metodo
    
    public String getNombre(){
        return this.nombre;
    }//fin metodo

    //metodos setters
    public void setEdad(int edad){
        this.edad = edad;
    }//fin metodo
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }//fin metodo
    
    @Override
    //metodo toString sobreescrito
    public String toString(){
        return "[Persona] = El nombre es " + this.nombre + ", la edad es " + this.edad
            ;
    }//fin metodo
    
    //Otros metodos
    public void nacer(){
        Calendar fechaActual = Calendar.getInstance();//fecha actual
        int year_fechaActual = fechaActual.get(Calendar.YEAR);
        int year_nacimiento =  year_fechaActual - this.edad;
        System.out.println("Esta persona nacio en " + year_nacimiento + ".");
    }//fin metodo
    
    
    
}//fin clase Persona
