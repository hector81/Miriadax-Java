/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema4.Novedades_Java_8;

@FunctionalInterface
interface TestearNumero1 {
    boolean test(int n);
    
    }

class MiTesteadorNumero1 {
    private int n;
    MiTesteadorNumero1(int n) {
        this.n = n;
    }
    int getNumero() ;
    return n;
    boolean isFactor(int x) 
    return (n % x) == 0;
}