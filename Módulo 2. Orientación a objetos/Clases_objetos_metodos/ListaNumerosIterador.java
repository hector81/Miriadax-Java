/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema2.Clases_objetos_metodos;

/**
 *
 * @author user
 */
public class ListaNumerosIterador {
    private Integer [] lista;
    private int numElementos;
    public ListaNumerosIterador(int maxElementos){
        lista = new Integer[maxElementos];
    }
             
    public int get(int i){
        return lista[i];
    }
    
    public void add(int i){
        lista[numElementos++]=i;
    }
    
    public Iterador getIterador(){
     return new Iterador();
    }
}

class Iterador{
    int indice;
    int numElementos;
    //lista = new Integer[numElementos];
    
    //Integer siguiente(){
    //    if(indice < numElementos)
    //       // return lista[indice++];
    //    else
    //        return (Integer) null;
    //} //fin de la clase interna

} //fin de la clase contenedora