package Tema4.CP_FuncionesStream;

import java.util.List;

/**
 *
 * @author Hector Garcia
 */
public class PruebaMundo {
    //Main
    public static void main(String args[]) {
        List<Persona> mundo = Persona.crearMundo();
        for(Persona persona : mundo){
            System.out.println(persona);
        }
    }//fin main
}// fin clase
