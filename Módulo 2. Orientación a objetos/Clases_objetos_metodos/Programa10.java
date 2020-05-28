package Tema2.Clases_objetos_metodos;

public class Programa10 {
    public static void main(String[] args) {
        Clase10 objeto1 = new Clase10(52, "Anacleto");
        Clase10 objeto2 = new Clase10(57, "Mortadelo y Filemon");
        Clase10 clonobjeto2 = new Clase10(objeto2);
        Clase10 objeto3 = new Clase10(objeto1.getNumero(),"Carpanta");
        Clase10 objeto4 = new Clase10(27, objeto1.getNombre());
        Clase10 objetonull=null;
        Clase10 objeto=objeto1;
        System.out.println(objeto1.equals(objeto)); //true
        System.out.println(objeto1.equals(objetonull));//false
        System.out.println(objeto1.equals("Anacleto"));	//false
        System.out.println(objeto1.equals(objeto3)); //false
        System.out.println(objeto1.equals(objeto4)); //false
        System.out.println(objeto2.equals(objeto1)); //false
        System.out.println(objeto2.equals(clonobjeto2)); //true
}
}
