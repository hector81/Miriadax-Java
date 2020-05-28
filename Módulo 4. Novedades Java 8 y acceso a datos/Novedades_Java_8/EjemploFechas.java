package Tema4.Novedades_Java_8;

import java.time.LocalDate;
import java.time.LocalTime;

public class EjemploFechas {
    public static void main(String[] args) {
        LocalDate hoy = LocalDate.now();
        System.out.println("Hoy formato por omisión: "+hoy);
        System.out.println("Con otro formato: " + hoy.getDayOfMonth() + "-" +
            hoy.getMonthValue() + "-" + hoy.getYear());
        LocalDate fecha = LocalDate.of(1957, 9, 25);
        System.out.println("Una fecha: "+fecha.getDayOfMonth()+ "-" +
            fecha.getMonthValue() + "-" +fecha.getYear());
        LocalTime ahora = LocalTime.now();
        System.out.println("Ahora formato por omisión: " + ahora);
        System.out.println("Dentro de un rato: "+ahora.plusHours(2));
        System.out.println("Hace un rato: "+ahora.minusHours(2));
    }
}
