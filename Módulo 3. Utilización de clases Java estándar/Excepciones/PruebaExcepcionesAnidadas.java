package Tema3.Excepciones;

public class PruebaExcepcionesAnidadas {
    public static void main(String[] args) {
        int numerador[] = { 6, 5, 8, 24, 120, 345, 654};
        int denominador[] = {2, 1, 0, 3, 0, 5};
        try{ //externo
            for( int i=0; i<numerador.length; i++){
                try{ //anidado
                    System.out.println(numerador[i] + "/" +denominador[i] + " = " +numerador[i]/denominador[i]);
                }
                catch (ArithmeticException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error fatal: programa terminado");
        }
    }
}
