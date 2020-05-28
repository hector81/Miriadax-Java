package Tema3.Excepciones;

import java.util.Random;

public class PruebaExcepcionesPersonalizadas {
    public static void main(String[] args) {
        Clase p = new Clase();
        try {
            for (int i = 1; i <= 5; i++)
            p.ejecutaAlgo();
        } catch (MiExcepcion miex) {
            System.out.println(miex);
            System.out.println(miex.getMessage());
        }
    }
}

class Clase {
    public void ejecutaAlgo() throws MiExcepcion {
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt(5);
        System.out.println("el numero generado es " + numero);
        if (numero == 0)
                throw new MiExcepcion("se ha generado un cero");
        if (numero == 4)
                throw new MiExcepcion("se ha generado un cuatro");
    }
}

class MiExcepcion extends Exception {
    private String mensaje;

    public MiExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getMessage() {
        // TODO Auto-generated method stub
        return "Se ha producido MiExcepcion: " + mensaje;
    }
    
    public String toString() {
        // TODO Auto-generated method stub
        return "Se ha producido MiExcepcion: " + mensaje;
    }
}
