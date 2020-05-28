package Tema1.Sentencias_Control_Flujo;
//Varias variables contadoras o de control
public class bucle_for_2 {
    public static void main(String[] args) {
        int i=0, j=0;
        for (i=10, j=1; i>j; i--, j++) //dos variables contadoras
         System.out.println("i: " + i + " j: " + j); // una sentencia
        //i y j siguen existiendo fuera del bucle for
        System.out.println("i: " + i + " j: " + j); //después del for
    }
}
