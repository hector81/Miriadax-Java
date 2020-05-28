package Tema4.Novedades_Java_8;

import java.util.Random;

public class PruebaReferenciaMetodo2 {
    public static void main(String args[]) {
     Random aleatorio = new Random();
     boolean resultado;
     TestearNumero interfacepredicado;
     int factor=0;
     
     for(int i=1; i<=10; i++){
        MiTesteadorNumero numero = new MiTesteadorNumero(aleatorio.nextInt(50)+1);
        //interfacepredicado = y -> numero.isFactor(y);
        interfacepredicado= numero::isFactor;
        resultado =
     interfacepredicado.
    test(factor=aleatorio.nextInt(4)+2);
     if (resultado)
     System.out.println( numero.
    getNumero()+ 
    " ES MULTIPLO DE " + factor);
     else
     System.out.println( numero.
    getNumero()+
     " NO ES MULTIPLO DE " + factor);
     } }
    }
}