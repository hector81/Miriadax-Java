package Tema1.Tipos_compuestos_datos_y_Enumeraciones;

public class Envoltorio_tipos {
    public static void main(String[] args) {
        float sueldo = (float)1.245;
        Float oSueldo= new Float(sueldo);

        String sueldo1 = "1245,8";
        Float oSueldo1 = new Float(sueldo1);

        Float peso = Float.valueOf("73,2");
        //byte unbyte = Float.valueOf("00101011",2);

        //int oNif = new Long("05221791");
        //long nif = oNif.longValue();

        int numero = Integer.parseInt("89789");

        Double d = new Double(897_789_456E14);
        String strd = d.toString();
        System.out.println(strd); //es lo mismo que System.out.prinltn(d);
        String cadena = "cadena de Java";
        //String cadena1 = cadena+ ": tiene de longitud " + long.toString(cadena.length);

        String octal = Long.toOctalString(4567895689L);
        String binario = Integer.toBinaryString(44444);
        String hexadecimal = Integer.toHexString(65535);

        System.out.println("byte ===> MAYOR " + Byte.MAX_VALUE + " MENOR: "+ Byte.MIN_VALUE+ " SIZE: "+Byte.SIZE + " BYTES: "+ Byte.BYTES);
        // La salida en pantalla es:
        // byte ===> MAYOR 127 MENOR: -128
        // SIZE: 8 BYTES: 1
    }
}
