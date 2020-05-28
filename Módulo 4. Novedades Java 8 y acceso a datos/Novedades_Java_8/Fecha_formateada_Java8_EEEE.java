package Tema4.Novedades_Java_8;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Fecha_formateada_Java8_EEEE {
    public static void main(String[] args) {
    // Escribir la fecha de hoy con Java 8
    LocalDate hoy = LocalDate.now();
    System.out.println("JAVA 8 ===> Hoy es: " + hoy);
    System.out.println("JAVA 8 ===> Hoy es: " + hoy.format(DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy")));
    // Escribir la fecha de hoy con Java 7
    Date fecha = new Date();
    System.out.println("JAVA 7 ===> Hoy es: " + fecha);
    System.out.println("JAVA 7 ===> Hoy es: " + DateFormat.getDateInstance(DateFormat.LONG, new Locale("ES"))
     .format(fecha));
    }
}
