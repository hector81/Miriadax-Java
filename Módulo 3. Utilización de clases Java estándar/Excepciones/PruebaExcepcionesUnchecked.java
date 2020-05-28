package Tema3.Excepciones;

public class PruebaExcepcionesUnchecked{
    public static void main(String[] args) {
        //sentencias
        try{
            int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            for (int i = 10; i >= 0; i--){
                System.out.println(array[i]);
            }
	 //sentencias con llamadas a funciones que lanzan excepciones
        } //sentencias que con referencia “e” utilizan funcionalidades Throwable
        catch(ArrayIndexOutOfBoundsException excepcion)
        {
                System.out.println(" Error de índice en un array");
        }
        catch(ArithmeticException excepcion)
        {
                System.out.println(" Error de índice en un array");
        }
        catch(Exception excepcion)
        {
                System.out.println("Se ha generado un error que no es de índices, ni Aritmético");
                System.out.println("El objeto error es de tipo " + excepcion);
        }
        finally{
            //sentencias que se ejecutan siempre
            System.out.println(" Programa finalizado");
        }
        
    }
}