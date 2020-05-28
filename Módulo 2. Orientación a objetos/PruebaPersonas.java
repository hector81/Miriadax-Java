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
public class PruebaPersonas {
    //main
    public static void main(String[] args){
        //Cree objetos de las clases Persona y Empleado de acuerdo a cada uno de sus constructores.
        
        //objetos clase Persona
        Persona persona1 = new Persona();
        //como este objeto está vacio le envio los atributos
        persona1.setNombre("David");
        persona1.setEdad((byte) 39);
        persona1.setSexo('V');
        persona1.setDni("22889933-S");
        persona1.setBCasado(true);
                
        Persona persona2 = new Persona("Juan", (byte) 33, 'V', "11447788-Y", false);
        Persona persona3 = new Persona(persona1);
        
        //objetos clase Empleado
        Empleado empleado1 = new Empleado();
        //como este objeto está vacio le envio los atributos
        empleado1.setNombre("Raquel");
        empleado1.setEdad((byte) 36);
        empleado1.setSexo('M');
        empleado1.setDni("22553311-A");
        empleado1.setBCasado(true);
        empleado1.setIdPersonal("3333");
        empleado1.setSueldo((float) 1800.14);
        
        Empleado empleado2 = new Empleado(empleado1);
        Empleado empleado3 = new Empleado(persona2,"1111", (float) 1129.93);   
        Empleado empleado4 = new Empleado("Marta", (byte) 48, 'M', "18991899-F", true, "2222", (float) 1789.74);
        
        //Visualice los datos de los objetos utilizando toString y la función pintar.
        
        //para visualizar datos usando la funcion pintar
        System.out.println("Persona 1 - Metodo pintar");
        persona1.pintar();
        System.out.println("Persona 2 - Metodo pintar");
        persona2.pintar();
        System.out.println("Persona 3 - Metodo pintar");
        persona3.pintar();
        System.out.println("Empleado 1 - Metodo pintar");
        empleado1.pintar();
        System.out.println("Empleado 2 - Metodo pintar");
        empleado2.pintar();
        System.out.println("Empleado 3 - Metodo pintar");
        empleado3.pintar();
        System.out.println("Empleado 4 - Metodo pintar");
        empleado4.pintar();
        
        System.out.println("******************************");
        
        //para visualizar datos usando la funcion toString
        System.out.println("Persona 1 - Metodo toString");
        System.out.println(persona1.toString());
        System.out.println("Persona 2 - Metodo toString");
        System.out.println(persona2.toString());
        System.out.println("Persona 3 - Metodo toString");
        System.out.println(persona3.toString());
        System.out.println("Empleado 1 - Metodo toString");
        System.out.println(empleado1.toString());
        System.out.println("Empleado 2 - Metodo toString");
        System.out.println(empleado2.toString());
        System.out.println("Empleado 3 - Metodo toString");
        System.out.println(empleado3.toString());
        System.out.println("Empleado 4 - Metodo toString");
        System.out.println(empleado4.toString());
        
        System.out.println("******************************");
        
        //Compare objetos de clase Persona y Empleado con la función equals de Persona.
        System.out.println("Comparando persona 1 con persona 2");
        if(persona1.equals(persona2)){
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales");
        }
        
        System.out.println("Comparando persona 2 con persona 3");
        if(persona2.equals(persona3)){ 
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales");
        }
        
        System.out.println("Comparando persona 1 con persona 3");
        if(persona1.equals(persona3)){ 
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales");
        }
        
        System.out.println("Comparando empleado 1 con empleado 2");
        if(empleado1.equals(empleado2)){
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales");
        }
        
        System.out.println("Comparando empleado 2 con empleado 3");
        if(empleado2.equals(empleado3)){
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales");
        }
        
        System.out.println("Comparando persona 2 con empleado 3");
        if(persona2.equals(empleado3)){
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales");
        }
        
        System.out.println("Comparando persona 1 con empleado 4");
        if(persona1.equals(empleado4)){
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales");
        }
        
        
    }//fin main
}//fin clase
