package Tema4.CP_FuncionesStream;

import java.util.List;

/**
 *
 * @author Hector Garcia
 */
public class MainFunctions {
    //Main
    public static void main(String args[]) {
        List<Persona> mundo = Persona.crearMundo();//aqui creamos lista personas
        OperacionesImplementadas operaciones = new OperacionesImplementadas() {};
        System.out.println("---------- MOSTRANDO PERSONAS ---------- ");
        operaciones.mostrarPersonas(mundo);
        System.out.println("---------------------------------------- ");
        //System.out.println("Masculinos");
        System.out.println("---------- MOSTRANDO PERSONAS MASCULINAS ---------- ");
        System.out.println(operaciones.filtroPersonas(mundo, operaciones.esMasculino()));
        System.out.println("---------------------------------------- ");
        //System.out.println("Femenino");
        System.out.println("---------- MOSTRANDO PERSONAS FEMENINAS ---------- ");
        operaciones.mostrarFiltroPersonas(mundo, operaciones.esFemenino());
        System.out.println("---------------------------------------- ");
        //System.out.println("Masculinos y 25 ");
        System.out.println("---------- MOSTRANDO PERSONAS MASCULINAS MAYORES y DE 25 AÑOS EXACTOS ---------- ");
        operaciones.mostrarFiltroPersonas(mundo, operaciones.cumpleCondiciones(25, "Masculino"));
        System.out.println("---------------------------------------- ");
    }//fin main
}//fin clase
