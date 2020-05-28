package Tema2.Herencia;

import java.util.Random;

public class Prueba_Piezas_Herencia3 {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int metros = 0;
        int numVentas = aleatorio.nextInt(5) + 1;
        Pieza[] piezasvendidas = new
        Pieza[numVentas];

        for (int i = 0; i < piezasvendidas.length;i++) {
            int tipoPieza = aleatorio.nextInt(3) + 2;
            if (tipoPieza % 2 == 0) {
                piezasvendidas[i] = new Plancha(201, "Extra", 30.f, 4.5f, 0.3f);
            } else {
                piezasvendidas[i] =new Tubo(101, "Especial", 1.0f, "pulgadas");
            }
        }
        for (Pieza pieza : piezasvendidas) {
            int cantidad = aleatorio.nextInt(10) +1;
            pieza.vender(cantidad);
        }
    }
}
