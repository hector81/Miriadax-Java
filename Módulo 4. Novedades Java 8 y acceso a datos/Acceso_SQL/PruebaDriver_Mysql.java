package Tema4.Acceso_SQL;

public class PruebaDriver_Mysql {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {         
            System.out.println("Error: No se puede cargar el driver: " + ex.getMessage());
            System.exit(1);
        }
        System.out.println("Driver cargado con éxito");
    }
}
