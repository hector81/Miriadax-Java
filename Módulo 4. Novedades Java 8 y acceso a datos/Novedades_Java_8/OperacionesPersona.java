/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema4.Novedades_Java_8;

public class OperacionesPersona {
    private Persona persona;
    
    public OperacionesPersona(Persona persona) {
     this.persona = persona;
    }
    
    public Persona getPersona() {
     return persona;
    }
    
    public void setPersona(Persona persona) {
     this.persona = persona;
    }
    
    public OperacionesPersona setNombre(String nombre){
        persona.setNombre(nombre);
        return this;
    }
    
    public OperacionesPersona setEdad(int edad){
        persona.setEdad(edad);
        return this;
    }
    
    public OperacionesPersona pintaPersona(){
        System.out.println(persona);
        return this;
    }
}
