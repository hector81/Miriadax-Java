package Tema1.Sentencias_Control_Flujo;

public class Operador_Ternario {
    public static boolean esMayorEdad(int edad){
        return edad>=18 ? true : false;
    } 
    
    public static void main(String[] args) {
        int edad = 89;
        System.out.println("¿ES MAYOR DE EDAD?" + esMayorEdad(edad));
    }    
    
}
