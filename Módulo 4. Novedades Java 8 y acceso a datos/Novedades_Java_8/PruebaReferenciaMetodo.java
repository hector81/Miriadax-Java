package Tema4.Novedades_Java_8;

import java.util.Random;

public class PruebaReferenciaMetodo {
// Esta función recibe como primer parámetro una referencia
// a la interfaz funcional TestearNumero.
// Por tanto el puede ser cualquier instancia a la interface,
// incluida una creada por una referencia a método
    static boolean testNumero(TestearNumero p, int n){
        return p.test(n);
    }
    
    public static void main(String args[]) {
        Random aleatorio = new Random();
        boolean resultado;
        int numero=0;
        for(int i=1; i<=10; i++){
            numero= aleatorio.nextInt(100)-50;
            System.out.print("\n"+numero);
            TestearNumero tn = n
        ->MiTesteadorNumero.isPrimo(n);
            resultado = tn.test(numero);
            //resultado = testNumero(MiTesteadorNumero::isPrimo, numero);
            
            if (resultado) System.out.print(" ES PRIMO");
                resultado = testNumero(MiTesteadorNumero::isPar, numero);

            if (resultado) System.out.print(" ES PAR");
                resultado = testNumero
                (MiTesteadorNumero::isImpar, numero);
            if (resultado) System.out.print(" ES IMPAR");
                resultado = testNumero
                (MiTesteadorNumero::isPositivo,numero);
            if (resultado) System.out.print(" ES POSITIVO ");
                resultado = testNumero
                (MiTesteadorNumero::isNegativo, numero);
            if (resultado) System.out.print(" ES NEGATIVO ");
        }
    }
}