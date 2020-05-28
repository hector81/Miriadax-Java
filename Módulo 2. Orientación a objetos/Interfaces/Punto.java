/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema2.Interfaces;

/**
 *
 * @author user
 */
class Punto implements LimitesSistema{
    private int x;
    private int y;
    
    private void normalizar(int x, int y){
        //con esta función se asegura que ningún punto estará
        //fuera de los límites del sistema
        if (x > XMAX) this.x = XMAX;
        else if (x < XMIN) this.x = XMIN;
        else this.x = x;
        if (y > YMAX) this.y = YMAX;
        else if (y < YMIN) this.y = YMIN;
        else this.y = y;
    }
    
    public Punto (int x, int y){
        normalizar(x, y);
    }
//otros constructores y otras funciones
}
