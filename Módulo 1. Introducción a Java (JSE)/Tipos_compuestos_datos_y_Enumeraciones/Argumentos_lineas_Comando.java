package Tema1.Tipos_compuestos_datos_y_Enumeraciones;

public class Argumentos_lineas_Comando {
    public static void main(String[] args) {
        int nArgumentos = args.length;
        if(nArgumentos == 0){
            System.out.println("Se ejecuto Programa sin argumentos");
        }else{
            int num=1;
            for(String argumento: args){
                System.out.print("Argumento " + num + ": ");
                System.out.println(argumento);
                num++;
            }
        }
    }
}
