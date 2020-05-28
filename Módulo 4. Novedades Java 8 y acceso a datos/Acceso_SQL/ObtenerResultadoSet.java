package Tema4.Acceso_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ObtenerResultadoSet {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultset = null;
        //String sqlSelect="SELECT socio.nombre, producto.nombre As articulo, " + 
        //"producto.precio, ventas.cantidad, " + "producto.precio * ventas.cantidad AS total";
        
        //String sqlFrom=	"FROM cursojdbc.socio, cursojdbc.producto,"+ " cursojdbc.ventas";
        //String sqlWhere="WHERE socio.idsocio = ventas.socio and " + "producto.idproducto = ventas.producto and " 
        //        + "producto.precio * ventas.cantidad > 30.0";
        //String sqlOrder="ORDER BY socio.nombre, producto.nombre";
        //String sql = sqlSelect+" "+ sqlFrom+" "+sqlWhere+" "+sqlOrder;
        String sql = "SELECT equipos.Nombre FROM nba.equipos ";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nba","root", "");
            statement = conexion.createStatement();
            System.out.println("Creado Statement");
            resultset = statement.executeQuery(sql);
            System.out.println("Columnas del ResultSet: " + resultset.getMetaData().getColumnCount());
            System.out.println(resultset);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: No se puede cargar driver: " + ex.getMessage());
            System.exit(1);
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
            System.exit(1);
	}
    }//fin main
}//fin clase
    

