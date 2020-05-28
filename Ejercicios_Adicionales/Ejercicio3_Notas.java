/*
 Ejercicio 3. Gestión de notas 
Realizar un programa para la gestión de notas. Al iniciarse el programa, 
se mostrará el siguiente menú:  
1.Agregar nota 
2. Ver nota media 
3. Ver aprobados 
4. Salir 
El funcionamiento del programa es el siguiente: 
 Al elegir 1, se le pedirá al usuario la introducción de una nota. Hay que tener 
en cuenta que el programa almacena un máximo de 10 notas, por lo que si ha llegado
ya a ese máximo se le mostrará un mensaje de advertencia 
 Si elige la opción 2, 
se mostrará la media actual de las registradas hasta el momento 
 Si elige la 
opción 3, se mostrará el número de aprobados existentes hasta el momento. 
 Después de procesar cualquier opción, el programa volverá a mostrar el menú 
para elegir de nuevo una opción.  
 Si se elige 4, el programa finaliza. 
 */
package Ejercicios_Adicionales;

import java.util.Scanner;

/**
 *
 * @author Hector Garcia
 */
public class Ejercicio3_Notas {
    //funcion para mostrar el menu
    private static void mostrar_opciones_menu(){
	System.out.println("Mostrando menú:");
        System.out.println("1. Agregar nota"); 
        System.out.println("2. Ver nota media"); 
        System.out.println("3. Ver aprobados"); 
        System.out.println("4. Salir"); 
    }//fin metodo
    
    //funcion para comprobar que un elemento este dentro de un array
    private static boolean comprobar_elemento_array(int[] arrayRespuestasValidas, int opcion){
        boolean comprobar = false;
	for (int element : arrayRespuestasValidas) {
            if (element == opcion) {
                comprobar = true;
            }
        }
        return comprobar;
    }//fin metodo
    
    //funcion para comprobar si una cadena es numerica
    private static boolean esNumerico(String cadena){
	try{
            Integer.parseInt(cadena);
            return true;
	}catch(NumberFormatException nfe){
            return false;
	}
    }//fin metodo
    
    //funcion para agregar una nota por posicion a un array
    public static double[] agregar_Array_Notas(double[] arrayNotas, String nota, int posicion){
        double notaDouble = Double.parseDouble(nota);
        //redondeamos a dos decimales
        notaDouble= (double)Math.round(notaDouble * 100d) / 100d;
        arrayNotas[posicion] = notaDouble;
        return arrayNotas;
    }//fin metodo
    
    //funcion para comprobar si la nota que queremos meter en una array es numerica, y que
    //esta entre 0 y 10
    public static boolean puede_agregar_Array_Notas(String nota){
        int notaInt = 0;
	try{
            Double.parseDouble(nota);
            double notaDouble = Double.parseDouble(nota);  
            if(notaDouble >= 0 && notaDouble <= 10){
                return true;
            }else{
                System.out.println("La nota debe ser de 0 a 10");
                return false;
            }      
	}catch(NumberFormatException nfe){
            System.out.println("La nota debe ser numérica y de 0 a 10");
            return false;
	}
    }//fin metodo
    
    //funcion para imprimir el array de notas con las notas puestas hasta el momento
    public static String imprimir_String_Array(double[] arrayNotas, int posicion){
        String texto = "";
        for(int i = 0; i < posicion; i++){
            if(i == posicion-1){
                texto += arrayNotas[i] + "";
            }else{
                texto += arrayNotas[i] + " , ";
            }
        }
        return texto;
    }//fin metodo 
    
    //funcion para devolver nota media
    public static double devolver_nota_media(double[] arrayNotas, int posicion){
        double nota_media = 0.0;
        double acumulado = 0.0;
        for(int i = 0; i < posicion; i++){
            acumulado += arrayNotas[i];
        }
        nota_media = acumulado/posicion;
        //redondeamos a dos decimales
        nota_media= (double)Math.round(nota_media * 100d) / 100d;
        return nota_media;
    }//fin metodo
    
    //funcion para devolver el numero de aprobados
    public static int devolver_numero_aprobados(double[] arrayNotas, int posicion){
        double nota_media = 0.0;
        int aprobados = 0;
        for(int i = 0; i < posicion; i++){
            if(arrayNotas[i] >= 5.0){
                aprobados++;
            }
        }
        return aprobados;
    }//fin metodo
    
    //main
    public static final void main(String[] args) {
        //inicializar variables
        int opcion = 0;
        int posicion = 0;
        String nota = "";
        String opcion_str = "";
        int arrayRespuestasValidas[] = {1, 2, 3, 4};
        double arrayNotas[] = new double[10];
        Scanner sc = new Scanner (System.in); //Creación de un objeto Scanner e invocamos un método sobre un objeto Scanner
        //mientras la opcion no sea 4 que es salir
        //hacemos las operaciones y las comprobaciones
        do{
            mostrar_opciones_menu();//mostramos cada vuelta las opciones de menu
            System.out.println("Introduce opción deseada : ");
            opcion_str = sc.nextLine();
            //comprobamos que la respuesta sea número y no tenga letras
            if(esNumerico(opcion_str)){
                //pasamos a int respuesta
                opcion = Integer.parseInt(opcion_str);
                //si la respuesta está entre las respuestas posibles
                if(comprobar_elemento_array(arrayRespuestasValidas, opcion)){
                    if(opcion == 1){//agregamos notas
                        //en este paso comprobamos que no haya más de 10 notas metidas
                        if(posicion < 10){
                            System.out.println("Pon una nota ");
                            nota = sc.nextLine();
                            if(puede_agregar_Array_Notas(nota)){//comprobamos que la nota sea valida
                                //si se agrega la nota aumentamos posicion
                                arrayNotas = agregar_Array_Notas(arrayNotas, nota, posicion);
                                posicion++;
                                //imprimimos array hasta la nota ultima introducida
                                System.out.println("Notas agregadas hasta el momento. Se han redondeado a dos decimales.");
                                System.out.println(imprimir_String_Array(arrayNotas, posicion));
                            }else{
                                System.out.println("No se ha podido agregar la nota.");
                            }
                        }else{
                            System.out.println("Ya has agregado las 10 notas posibles. No se pueden agregar más.");
                        }      
                    }else if(opcion == 2){//ver nota media
                        double nota_media = 0.0;
                        nota_media =  devolver_nota_media(arrayNotas, posicion);
                        System.out.println("Has metido " + posicion + " notas hasta ahora.");
                        System.out.println("La nota media actual es de " + nota_media);
                    }
                    else if(opcion == 3){//ver aprobados
                        int aprobados = devolver_numero_aprobados(arrayNotas, posicion);
                        System.out.println("Has metido " + posicion + " notas hasta ahora.");
                        System.out.println("Ha habido " + aprobados + " aprobados hasta ahora.");
                    }
                    else if(opcion == 4){//Salimos del programa
                        System.out.println("Se cierra el programa");
                    }
                }else{
                    System.out.println("El número de opción debe ser del 1 al 4");
                }
            }else{
                System.out.println("No puedes incluir caracteres, solo números enteros positivos del 1 al 4");
            } 

        } while(opcion != 4);
        
        
    }//fin main
}//fin clase
