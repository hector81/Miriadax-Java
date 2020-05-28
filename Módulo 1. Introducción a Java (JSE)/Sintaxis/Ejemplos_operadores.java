/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1.Sintaxis;

/**
 *
 * @author user
 */
public class Ejemplos_operadores {
    public static void main(String[] args) {
        int x = 137, y = 6, z = 19, i=1, j=5, k=6;
        x%=y+z++; // x: 12 y: 6 z: 20
        i++;
        j=--k+i; // i: 2 j: 7 k: 5

        boolean a=true, b=false ,c=true;
        b = a | c; //a: true b: true c: true
        c = !a; //a: true b: true c: false
        b = c && a && b; //a: true b: false c: false
        c= a ^ !b; //a: true b: false c: false

        String cadena=" la cadena ";
        float numero= 3_456_789e-5f;
        boolean booleano= false;
        cadena = numero + cadena + booleano; // "34.56789 cadena false"
    }
}
