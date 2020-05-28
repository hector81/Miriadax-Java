package Tema4.Novedades_Java_8;

@FunctionalInterface
interface TestearNumero {
    boolean test(int numero);
}
// Clase que define tres métodos estáticos que se pasan
// como referencias de método para el “predicado” que se
// aplica a el numero que se recibe como segundo parámetro
class MiTesteadorNumero {
    static boolean isPrimo(int n) {
        n = Math.abs(n);
        if (n < 2) return false;
            for (int i = 2; i <= n / i; i++)
        if ((n % i) == 0) return false;
            return true;
    }
    
    static boolean isPar(int n) {
        return (n % 2) == 0;
    }
    static boolean isImpar(int n) {
        return (n % 2) != 0;
    }

    static boolean isPositivo(int n) {
        return n > 0;
    }
    static boolean isNegativo(int n) {
        return n < 0;
    }
}