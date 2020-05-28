package Tema3.Excepciones;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class PruebExcepcionesMultiCatch {
    public static void main(String a[]) {
        PruebExcepcionesMultiCatch prueba = new PruebExcepcionesMultiCatch();
        prueba.probar(1);
        prueba.probar(2);
    }
    
    public void probar(int i) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe algo:");
	String str = teclado.nextLine();
        
        try {
            if (i == 1)	Integer.parseInt(str);
            else new URL(str);
	 	 /*catch (NumberFormatException nfe){
	 	 * System.out.println(
	 	 * “NumberFormatException: “+nfe.getMessage());
	 	 *	 }
	 	 * catch (MalformedURLException mue){
	 	 * System.out.println(
	 	 * “MalformedURLException: “+mue.getMessage());
	 	 *	 }
	 	 * catch (Exception ex){
	 	 * System.out.println(“Exception... “+ex.getMessage());
	 	 *	 }*/
               }
             catch (NumberFormatException | MalformedURLException e) {
                 System.out.println(e.getMessage());
            }
        }
}