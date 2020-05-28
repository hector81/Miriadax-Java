/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema2;

/**
 *
 * @author Hector Garcia
 */
public class Punto {
    //La clase Punto tendrá dos variables de tipo int que representarán
    //las coordenadas del punto en un sistema cartesiano.
    private int coordenadaX;
    private int coordenadaY;
    
    //constructores
    //1ºConstructor sin parametros y que por defecto que inicialice las propiedades
    public Punto(){      
        this.coordenadaX = 95;
        this.coordenadaY = 67;        
    }//fin constructor
    
    
    //2ºConstructor que recibe dos parámetros de tipo entero
    public Punto(int coordenadaX, int coordenadaY){
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY; 
    }//fin constructor
    
    //3ºConstructor que recibe como parámetro un objeto de tipo Punto
    //Con otro Punto que ya exista
    public Punto(Punto otroPunto){
        this.coordenadaX = otroPunto.getCoordenadaX();
        this.coordenadaY = otroPunto.getCoordenadaY();
    }//fin constructor
    
    //METODOS
    //metodos getters
    public int getCoordenadaX(){
        return this.coordenadaX;
    }//fin metodo
    
    public int getCoordenadaY(){
        return this.coordenadaY;
    }//fin metodo
    
    //metodos setters
    public void setCoordenadaX(int coordenadaX){
        this.coordenadaX = coordenadaX;
    }//fin metodo
    
    public void setCoordenadaY(int coordenadaY){
        this.coordenadaY = coordenadaY;
    }//fin metodo
    
    //metodo pintar o función “void pintar()”, que permita visualizar las coordenadas del Punto.
    public void pintar(){
        System.out.println("En este punto la coordenadas X son = " + this.coordenadaX + " y las coordenadas Y son = " + this.coordenadaY);
    }//fin metodo

}//fin clase
