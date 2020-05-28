package Tema1.Sentencias_Control_Flujo;
//La expresión condicional puede ser cualquier expresión
//booleana, no tiene porque depender de la variable o variables

import java.io.IOException;

//de la expresión de inicialización.
public class bucle_for_5 {
    public static void main(String[] args) throws IOException {
       System.out.println("Teclea x para parar");
        //System.in.read lee un carácter y lo retorna como int
        //un int son 4 char, se leen los 4 del buffer
        for(int i=1; ((char)System.in.read()) != 'x'; i++)
            System.out.println("Iteración número: " + i);
    }
}
