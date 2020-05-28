package Tema2.Clases_objetos_metodos;

public class Programa07 {
    public static void main(String[] args) {
        Clase07 objeto1= new Clase07();
        objeto1.modificaDatos("Luis Ruiz", 27);
        System.out.print("El nombre es "+objeto1.getNombre());
        System.out.println(" y tiene un numero igual a "+objeto1.getNumero());
        Clase07 objeto2 = new Clase07(objeto1.getNumero(),"Rodolfo Atilez");
        objeto2.setNumero(objeto2.getNumero()+1);
        System.out.print("El nombre es "+objeto2.getNombre());
        System.out.println(" y tiene un numero igual a "+objeto2.getNumero());
    }
}
