/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema3.Ejercicio_CP_ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Hector Garcia
 */
public class ProgramaPersona {
    //main
    public static void main(String[] args){
        Random aleatorio = new Random();
        ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
        /*se utilizarán los constructores sin parámetros. Se
        crearan objetos Persona y se irán añadiendo al ArrayList. El objeto
        creado será Persona, Obrero o Técnico dependiendo de un número
        obtenido de forma aleatoria, por ejemplo si es 1 será Persona, si es 2 o
        4 será Obrero y si es 1 o 3 Técnico
        El ArrayList tendrá un número aleatorio de elementos que no excederá
        de 20.
        */
        int numeroPersonas = aleatorio.nextInt(20)+1;
        for(int i = 1; i < numeroPersonas; i++){
            int tipoPersona = aleatorio.nextInt(4)+1;
            switch(tipoPersona){
                case 1:
                    listaPersonas.add(new Persona()); break;
                case 2: 
                    listaPersonas.add(new Obrero()); break;
                case 3: 
                    listaPersonas.add(new Tecnico()); break;
                case 4: 
                    listaPersonas.add(new Obrero()); break;
            }
        }

        System.out.println("En la lista hay " + listaPersonas.size() + " personas");
        int numeroPersons = 0;
        int numeroObreros = 0;
        int numeroTecnicos = 0;
        
        for (Persona persona : listaPersonas){
            if(persona.devolver_string_tipo_objeto() == "PERSONA"){
                numeroPersons++;
            }else if(persona.devolver_string_tipo_objeto() == "TECNICO"){
                numeroTecnicos++;
            }else if(persona.devolver_string_tipo_objeto() == "OBRERO"){
                numeroObreros++;
            }
        }
        
        System.out.println("En la lista hay " + numeroPersons + " objetos de tipo Persona");
        System.out.println("En la lista hay " + numeroObreros + " objetos de tipo Técnico");
        System.out.println("En la lista hay " + numeroTecnicos + " objetos de tipo Obrero");
        
        /*
        El programa después de añadir los objetos Persona (recordad Obrero
        y Técnico son Persona, porque son Empleado), recorrerá el ArrayList
        visualizando la información de cada objeto.
        */
        
        //Hay 2 formas de recorrerlo
        //con FOR
        for (Persona persona : listaPersonas){
            System.out.println(persona.toString());
        }
        
        
        //Y con iterador
        /*
        //Creamos el iterador 
        Iterator itr=listaPersonas.iterator();  
        //recorremos con el iterador el objeto ArrayList  
        while(itr.hasNext()){  
            Persona person=(Persona)itr.next();  
            System.out.println(person.toString());  
        }
        */
        
        
    }//fin main
}//fin clase
