package Tema1;

import java.util.Scanner;

/**
 *
 * @author Hector Garcia
 */
public class CP_NIF_DNI {
    //main
    public static void main(String[] args){
        //variables o atributos
        int numeroDni;
        char letra;
        String stringDni;
        char letras[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
        boolean numeroDniValido = false;
        Scanner sc = new Scanner (System.in); //Creación de un objeto Scanner e invocamos un método sobre un objeto Scanner
        
        while(numeroDniValido == false){
            System.out.println("Introduce tu número de DNI : ");
            stringDni = sc.nextLine(); 
            if(stringDni.length() == 8){ // comprobamos que sean 8 numeros
                //comprobamos que sean numeros       
                if(!stringDni.matches("[0-9]*")){//lo hacemos a traves de patrones
                    System.out.println("El número tiene caracteres no permitidos ");
                    numeroDniValido = false;
                }else{
                    numeroDni = Integer.parseInt(stringDni);//pasamos string a entero
                    numeroDniValido = true;//para parar el buble
                    //calculamos posicion en el array de letras con el resto de dividir por 23
                    int resto = numeroDni%23;
                    letra = letras[resto];
                    System.out.println("Tu DNI completo con su letra es " + numeroDni + "-" + letra);
                }
                
            }else{
                System.out.println("El número debe tener 8 números ");
                numeroDniValido = false;
            }
        }
        
        
        
    }//fin main
}//fin clase
