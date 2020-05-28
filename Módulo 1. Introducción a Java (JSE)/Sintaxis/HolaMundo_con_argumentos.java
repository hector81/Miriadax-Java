package Tema1.Sintaxis;

public class HolaMundo_con_argumentos {
    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Hola mundo");
        }else{
            System.out.println("Hola mundo, " + args[0]);
        }
  
    }
}

