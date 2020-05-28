package Tema2.Clases_objetos_metodos;

public class Programa06 {
    public static void main(String[] args) {
        Clase06 objeto1= new Clase06();
        objeto1.modificaDatos("Luis Ruiz", 72);

        Clase06 objeto2= new Clase06(18, "Pepe Perez");
        objeto2.modificaDatos(Clase06.EDAD_MAX);

        Clase06 objeto3= new Clase06(objeto2);
        objeto3.modificaDatos("Antonio Gil");

        Clase06 objeto4 = new Clase06(objeto1);
        objeto4.modificaDatos();
    }
}
