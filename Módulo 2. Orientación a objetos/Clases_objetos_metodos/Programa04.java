package Tema2.Clases_objetos_metodos;

import java.util.Random;

public class Programa04 {
    public static void main(String[] args) {
        int num= (new Random()).nextInt(11)+5;
        Clase04 [] personas = new Clase04 [num];

        for (int i=0; i<num; i++){
            //personas[i] = new Clase04(i,"Objeto" + i );
        }

        System.out.println("Se han creado " +Clase04.cuentaPersonas()+ " personas");
    }
}
