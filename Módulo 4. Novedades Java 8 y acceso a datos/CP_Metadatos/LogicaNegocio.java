package Tema4.CP_Metadatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hector Garcia
 */
public class LogicaNegocio implements InterfaceDAO{
    //atributos
    private static Scanner sc = new Scanner (System.in); //Creación de un objeto Scanner e invocamos un método sobre un objeto Scanner 
    DAO dao = new DAO();
    Connection conexion = null;
        
    //constructor
    public LogicaNegocio() {
        this.conexion = dao.getConexion();
    }
    //funciones
    
    @Override
    public void logicaNegocio() {
        System.out.println("=========MENU STATEMENTS========");
        System.out.println("1. Listar productos");
        System.out.println("2. Listar categorias");
        System.out.println("3. Listar subcategorias");
        System.out.println("4. Listar subcategorias por categorias");
        System.out.println("5. Listar productos por subcategorias y categorias");
        System.out.println("6. Insertar productos");
        System.out.println("7. Insertar subcategoria de productos");
        System.out.println("8. Insertar categoria de productos");
        System.out.println("9. Borrar productos");
        System.out.println("10. Borrar subcategoria de productos");
        System.out.println("11. Borrar categoria de productos");
        System.out.println("12. Actualizar productos");
        System.out.println("13. Actualizar subcategoria de productos");
        System.out.println("14. Actualizar categoria de productos");
        System.out.println("15. Contar produtos");
        System.out.println("16. Contar produtos por subcategoria");
        System.out.println("17. Contar produtos por categoria");
        System.out.println("18. Obtener información");
        System.out.println("19. Salir");
        System.out.println("================================");
    }//fin metodo
    
    @Override
    public void actualizarProducto(String titulo, double pvpDouble, String descripcion , int id_producto) {
        try (PreparedStatement preparestatement = conexion.prepareStatement(
        "UPDATE Productos SET titulo = ?, pvp = ? , descripcion_producto = ? WHERE idProducto = ? ;",
        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            preparestatement.setString(1, titulo);
            preparestatement.setDouble(2, pvpDouble);
            preparestatement.setString(3, descripcion);
            preparestatement.setInt(4, id_producto);
            preparestatement.executeUpdate();
            preparestatement.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
    }//fin metodo
    
    @Override
    public void borrarProducto(int id_producto) {
        try (PreparedStatement preparestatement = conexion.prepareStatement(
        "DELETE FROM Productos WHERE idProducto = ? ;",
        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            preparestatement.setInt(1, id_producto);
            preparestatement.executeUpdate();
            preparestatement.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
    }//fin metodo
    
    @Override
    public void contarProductos(){
        int contador = 0;
        try (Statement statement = conexion.createStatement(
        ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT * FROM Productos;";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next())
                contador++;
            resultset.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
        System.out.println("Hay " + contador + " productos en total");
    }//fin metodo
    
    @Override
    public void insertarProducto(String titulo, double pvp, String descripcion, int id_subcategoria) {
        try (PreparedStatement preparestatement = conexion.prepareStatement(
        "INSERT INTO Productos (idSubCategoria, titulo, pvp, descripcion_producto) " +
        "VALUES(?, ?, ?, ?);",
        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            preparestatement.setInt(1, id_subcategoria);
            preparestatement.setString(2, titulo);
            preparestatement.setDouble(3, pvp);
            preparestatement.setString(4, descripcion);
            preparestatement.executeUpdate();
            preparestatement.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
    }//fin metodo
    
    @Override
    public void listarProductos(){
        ArrayList<DTOProductos> lista_productos = new ArrayList<DTOProductos>();
        try (Statement statement = conexion.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT categorias.idCategoria , categorias.NombreCategoria ,\n" +
            "categorias.descripcion_categoria , subcategorias.idSubCategoria ,subcategorias.NombreSubCategoria ,\n" +
            "subcategorias.descripcion_subcategoria ,\n" +
            "productos.idProducto ,productos.titulo , ROUND(productos.pvp, 2) ,\n" +
            "productos.descripcion_producto\n" +
            "FROM productos \n" +
            "INNER JOIN subcategorias ON productos.IdSubCategoria = subcategorias.IdSubCategoria \n" +
            "INNER JOIN categorias ON categorias.IdCategoria = subcategorias.IdCategoria \n" +
            "GROUP BY categorias.nombreCategoria, subcategorias.NombreSubCategoria, productos.titulo \n" +
            "ORDER BY categorias.IdCategoria, subcategorias.IdSubCategoria ASC;";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                //creamos productos con sus propiedades propias y heredadas
                DTOProductos producto = new DTOProductos();
                producto.setIdCategoria(resultset.getInt(1));//int idCategoria 
                producto.setNombreCategoria(resultset.getString(2));//String nombreCategoria
                producto.setDescripcion_categoria(resultset.getString(3));//String descripcion_categoria
                producto.setIdSubCategoria(resultset.getInt(4));//int idSubCategoria
                producto.setNombreSubCategoria(resultset.getString(5));//String nombreSubCategoria
                producto.setDescripcion_subcategoria(resultset.getString(6));//String descripcion_subcategoria
                producto.setIdProducto(resultset.getInt(7));//int idProducto
                producto.setTitulo(resultset.getString(8));//String titulo
                producto.setPvp(resultset.getFloat(9));//float pvp
                producto.setDescripcion(resultset.getString(10));//String descripcion
                //lo agregamos a la lista
                lista_productos.add(producto);
            }
            resultset.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
        //recorremos el arraylist
        for(int i = 0; i < lista_productos.size(); i++){
            System.out.println("\nPRODUCTO " + (i+1) + "\n");
            DTOProductos producto = lista_productos.get(i);
            System.out.println(producto.toString());
        }
    }//fin metodo
    
    @Override
    public void cerrarConexion(){
        dao.cerrarConexion();
    }//fin metodo
    
    @Override
    public boolean volver_menu_o_salir(){
        boolean compRespuesta = false;
        boolean salir = false;
        do{ 
            System.out.println("================================");
            System.out.println("¿Quieres volver al menú o salir?. Opcion 1 - Volver | Opcion 2-Salir ");
            String respuesta = "";
            respuesta = sc.nextLine();
            //comprobamos que la respuesta sea número y no tenga letras
            if(esNumerico(respuesta)){
                int respuesta_int = Integer.parseInt(respuesta);
                if(respuesta_int == 1 || respuesta_int == 2){
                    if(respuesta_int == 1){
                        salir = false;
                    }else{
                        salir = true;
                        cerrarConexion();
                    }
                    compRespuesta = true;
                }else{
                    System.out.println("Solo puedes elegir 1 (Volver al menú) o 2 (Salir).");
                }
            }else{
                System.out.println("La opción deber ser un número.");
            }
        }while(compRespuesta == false);
        return salir;
    }//fin metodo
    
    @Override
    public boolean comprobarNumero_en_Array(int arrayNumeros[], int opcion){
        boolean comprobar = false;
	for (int element : arrayNumeros) {
            if (element == opcion) {
                comprobar = true;
            }
        }
        return comprobar;
    }//fin metodo
    
    //funcion para comprobar si una cadena es numerica
    @Override
    public boolean esNumerico(String cadena){
	try{
            Integer.parseInt(cadena);
            return true;
	}catch(NumberFormatException nfe){
            return false;
	}
    }//fin metodo
    
    @Override
    public boolean es_cadena_double(String cadena){
	try{
            Double.parseDouble(cadena); 
            return true;      
	}catch(NumberFormatException nfe){
            return false;
	}
    }//fin metodo

    @Override
    public void listarCategorias() {
        ArrayList<DTOCategorias> lista_categorias = new ArrayList<DTOCategorias>();
        try (Statement statement = conexion.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT categorias.idCategoria , categorias.nombreCategoria,\n" +
            "categorias.descripcion_categoria FROM categorias\n" +
            "ORDER BY categorias.IdCategoria ASC;";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                //creamos productos con sus propiedades propias y heredadas
                DTOCategorias categoria = new DTOCategorias();
                categoria.setIdCategoria(resultset.getInt(1));//int idCategoria 
                categoria.setNombreCategoria(resultset.getString(2));//String nombreCategoria
                categoria.setDescripcion_categoria(resultset.getString(3));//String descripcion_categoria
                //lo agregamos a la lista
                lista_categorias.add(categoria);
            }
            resultset.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
        //recorremos el arraylist
        for(int i = 0; i < lista_categorias.size(); i++){
            System.out.println("\nCATEGORIA " + (i+1) + "\n");
            DTOCategorias categoria = lista_categorias.get(i);
            System.out.println(categoria.toString());
        }
    }//fin metodo
  
    @Override
    public void listarSubCategorias(){
        ArrayList<DTOSubcategorias> lista_subcategorias = new ArrayList<DTOSubcategorias>();
        try (Statement statement = conexion.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT categorias.idCategoria , categorias.nombreCategoria,\n" +
            "categorias.descripcion_categoria ,subCategorias.idSubCategoria , subCategorias.nombreSubCategoria , \n" +
            "subCategorias.descripcion_subcategoria FROM subCategorias\n" +
            "INNER JOIN categorias ON categorias.IdCategoria = subcategorias.IdCategoria \n" +
            "ORDER BY subCategorias.idSubCategoria ASC;";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                //creamos productos con sus propiedades propias y heredadas
                DTOSubcategorias subcategoria = new DTOSubcategorias();
                subcategoria.setIdCategoria(resultset.getInt(1));//int idCategoria 
                subcategoria.setNombreCategoria(resultset.getString(2));//String nombreCategoria
                subcategoria.setDescripcion_categoria(resultset.getString(3));//String descripcion_categoria
                subcategoria.setIdSubCategoria(resultset.getInt(4));//int idSubCategoria
                subcategoria.setNombreSubCategoria(resultset.getString(5));//String nombreSubCategoria
                subcategoria.setDescripcion_subcategoria(resultset.getString(6));//String descripcion_subcategoria
                //lo agregamos a la lista
                lista_subcategorias.add(subcategoria);
            }
            resultset.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
        //recorremos el arraylist
        for(int i = 0; i < lista_subcategorias.size(); i++){
            System.out.println("\nSUBCATEGORIA " + (i+1) + "\n");
            DTOSubcategorias subcategoria = lista_subcategorias.get(i);
            System.out.println(subcategoria.toString());
        }
    }//fin metodo
    
    @Override
    public int[] devolver_Indices_Categorias() {
        int categorias_numero = contar_Categorias_Disponibles();
        int indices_Categorias[] = new int[categorias_numero];
        int contador = 0;
        try (Statement statement = conexion.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT categorias.idCategoria , categorias.nombreCategoria "
                + "FROM categorias ORDER BY categorias.IdCategoria ASC;";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                //esto es para imprimir en la ejecucion del man del programa
                System.out.println(resultset.getInt(1) + " = " + resultset.getString(2));
                //añadimos al array
                indices_Categorias[contador] = resultset.getInt(1);//int idCategoria 
                contador++;
            }
            resultset.close();
        } catch (SQLException ex) {
                System.out.println("Error: Problemas: " + ex.getMessage());
        }
        return indices_Categorias;
    }//fin metodo
  
    @Override
    public void listar_SubCategorias_por_Categorias(int id_categoria) {
        ArrayList<DTOSubcategorias> lista_subcategorias = new ArrayList<DTOSubcategorias>();
        try (Statement statement = conexion.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT categorias.idCategoria , categorias.nombreCategoria,\n" +
            "categorias.descripcion_categoria ,subCategorias.idSubCategoria , subCategorias.nombreSubCategoria , \n" +
            "subCategorias.descripcion_subcategoria FROM subCategorias\n" +
            "INNER JOIN categorias ON categorias.IdCategoria = subcategorias.IdCategoria \n" +
            "WHERE categorias.IdCategoria = ? \n" + //En esta linea le pasamos el parametro
            "ORDER BY subCategorias.idSubCategoria ASC;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_categoria);//le pasamos el parametro
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //creamos productos con sus propiedades propias y heredadas
                DTOSubcategorias subcategoria = new DTOSubcategorias();
                subcategoria.setIdCategoria(rs.getInt(1));//int idCategoria 
                subcategoria.setNombreCategoria(rs.getString(2));//String nombreCategoria
                subcategoria.setDescripcion_categoria(rs.getString(3));//String descripcion_categoria
                subcategoria.setIdSubCategoria(rs.getInt(4));//int idSubCategoria
                subcategoria.setNombreSubCategoria(rs.getString(5));//String nombreSubCategoria
                subcategoria.setDescripcion_subcategoria(rs.getString(6));//String descripcion_subcategoria
                //lo agregamos a la lista
                lista_subcategorias.add(subcategoria);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
        //recorremos el arraylist
        for(int i = 0; i < lista_subcategorias.size(); i++){
            System.out.println("\nCATEGORIA " + (i+1) + "\n");
            DTOSubcategorias subcategoria = lista_subcategorias.get(i);
            System.out.println(subcategoria.toString());
        }
    }//fin metodo
    
    @Override
    public int[] devolver_Indices_SubCategorias_por_Categorias(int id_categoria) {
        int sucategorias_numero = contar_SubCategorias_Disponibles_por_Categoria(id_categoria);
        int indices_Categorias[] = new int[sucategorias_numero];
        int contador = 0;
        try (Statement statement = conexion.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT subCategorias.idSubCategoria , subCategorias.NombreSubCategoria \n" +
            "FROM subCategorias INNER JOIN categorias ON categorias.IdCategoria = subcategorias.IdCategoria \n" +
            "WHERE categorias.IdCategoria = ? ORDER BY subCategorias.idSubCategoria ASC;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_categoria);//le pasamos el parametro
            ResultSet rs = ps.executeQuery();
            //ponemos los valores por orden
            //leemos los resultados y los recorremos
            while(rs.next()){
                //esto es para imprimir en la ejecucion del man del programa
                System.out.println(rs.getInt(1) + " = " + rs.getString(2));
                //añadimos al array
                indices_Categorias[contador] = rs.getInt(1);//int idCategoria 
                contador++;
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
        return indices_Categorias;
    }//fin metodo
 
    @Override
    public void listar_Productos_por_Subcategoria(int id_subcategoria) {
        ArrayList<DTOProductos> lista_productos = new ArrayList<DTOProductos>();
        try (Statement statement = conexion.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT categorias.idCategoria , categorias.NombreCategoria ,\n" +
            "categorias.descripcion_categoria , subcategorias.idSubCategoria ,subcategorias.NombreSubCategoria ,\n" +
            "subcategorias.descripcion_subcategoria ,\n" +
            "productos.idProducto ,productos.titulo , ROUND(productos.pvp, 2) ,\n" +
            "productos.descripcion_producto\n" +
            "FROM productos \n" +
            "INNER JOIN subcategorias ON productos.IdSubCategoria = subcategorias.IdSubCategoria \n" +
            "INNER JOIN categorias ON categorias.IdCategoria = subcategorias.IdCategoria \n" +
            "WHERE subcategorias.idSubCategoria = ? \n" + //EN ESTA LINEA LE PASAMOS EL PARAMETRO
            "GROUP BY categorias.nombreCategoria, subcategorias.NombreSubCategoria, productos.titulo \n" +
            "ORDER BY productos.idProducto ASC;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_subcategoria);//le pasamos el parametro
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //creamos productos con sus propiedades propias y heredadas
                DTOProductos producto = new DTOProductos();
                producto.setIdCategoria(rs.getInt(1));//int idCategoria 
                producto.setNombreCategoria(rs.getString(2));//String nombreCategoria
                producto.setDescripcion_categoria(rs.getString(3));//String descripcion_categoria
                producto.setIdSubCategoria(rs.getInt(4));//int idSubCategoria
                producto.setNombreSubCategoria(rs.getString(5));//String nombreSubCategoria
                producto.setDescripcion_subcategoria(rs.getString(6));//String descripcion_subcategoria
                producto.setIdProducto(rs.getInt(7));//int idProducto
                producto.setTitulo(rs.getString(8));//String titulo
                producto.setPvp(rs.getFloat(9));//float pvp
                producto.setDescripcion(rs.getString(10));//String descripcion
                //lo agregamos a la lista
                lista_productos.add(producto);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
        //recorremos el arraylist
        for(int i = 0; i < lista_productos.size(); i++){
            System.out.println("\nPRODUCTO " + (i+1) + "\n");
            DTOProductos producto = lista_productos.get(i);
            System.out.println(producto.toString());
        }
    }//fin metodo

    @Override
    public void insertarSubcategoria(String nombreSubCategoria, String descripcion, int opcion_categoria) {
        try (PreparedStatement preparestatement = conexion.prepareStatement(
        "INSERT INTO SubCategorias (nombreSubCategoria, descripcion_subcategoria, idCategoria) VALUES"
        + "(?, ?, ?);",
        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            preparestatement.setString(1, nombreSubCategoria);
            preparestatement.setString(2, descripcion);
            preparestatement.setInt(3, opcion_categoria);
            preparestatement.executeUpdate();
            preparestatement.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
    }//fin metodo
    
    @Override
    public void insertarCategoria(String nombreCategoria, String descripcion) {
        try (PreparedStatement preparestatement = conexion.prepareStatement(
        "INSERT INTO Categorias (nombreCategoria, descripcion_categoria) VALUES (?, ?);",
        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            preparestatement.setString(1, nombreCategoria);
            preparestatement.setString(2, descripcion);
            preparestatement.executeUpdate();
            preparestatement.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
    }//fin metodo
    
    @Override
    public void borrarCategoria(int id_categoria) {
        try (PreparedStatement preparestatement = conexion.prepareStatement(
        "DELETE FROM Categorias WHERE idCategoria = ? ;",
        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            preparestatement.setInt(1, id_categoria);
            preparestatement.executeUpdate();
            preparestatement.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
    }//fin metodo
    
    @Override
    public void borrarSubCategoria(int id_subcategoria) {
        try (PreparedStatement preparestatement = conexion.prepareStatement(
        "DELETE FROM SubCategorias WHERE idSubCategoria = ? ;",
        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            preparestatement.setInt(1, id_subcategoria);
            preparestatement.executeUpdate();
            preparestatement.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
    }//fin metodo
    
    @Override
    public int[] devolver_Indices_Productos() {
        int producto_numero = contarProductos_int();
        int indices_productos[] = new int[producto_numero];
        int contador = 0;
        try (Statement statement = conexion.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT Productos.idProducto , Productos.titulo "
                + "FROM Productos ORDER BY Productos.idProducto ASC;";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                //esto es para imprimir en la ejecucion del man del programa
                System.out.println(resultset.getInt(1) + " = " + resultset.getString(2));
                //añadimos al array
                indices_productos[contador] = resultset.getInt(1);//int idCategoria 
                contador++;
            }
            resultset.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
        return indices_productos;
    }//fin metodo
    
    @Override
    public int[] devolver_Indices_Productos_por_SubCategoria(int idSubcategoria) {
        int producto_numero = contarProductos_int();
        int indices_productos[] = new int[producto_numero];
        int contador = 0;
        try (Statement statement = conexion.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT Productos.idProducto , Productos.titulo FROM Productos "
                + "WHERE idSubCategoria = ? ORDER BY Productos.idProducto ASC;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idSubcategoria);
            ResultSet rs = ps.executeQuery();
            //ponemos los valores por orden
            //leemos los resultados y los recorremos
            while(rs.next()){
                //esto es para imprimir en la ejecucion del man del programa
                System.out.println(rs.getInt(1) + " = " + rs.getString(2));
                //añadimos al array
                indices_productos[contador] = rs.getInt(1);//int idCategoria 
                contador++;
            }
            //cerramos de ultimo a primero
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
        return indices_productos;
    }//fin metodo
  
    @Override
    public void actualizarSubCategoria(String titulo, String descripcion, int id_subcategoria) {
        try (PreparedStatement preparestatement = conexion.prepareStatement(
        "UPDATE SubCategorias SET nombreSubCategoria = ?, descripcion_subcategoria = ? "
                + " WHERE idSubCategoria = ? ;",
        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            preparestatement.setString(1, titulo);
            preparestatement.setString(2, descripcion);
            preparestatement.setInt(3, id_subcategoria);
            preparestatement.executeUpdate();
            preparestatement.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
    }//fin metodo
    
    @Override
    public void actualizarCategoria(String titulo, String descripcion, int id_categoria){
        try (PreparedStatement preparestatement = conexion.prepareStatement(
        "UPDATE Categorias SET nombreCategoria = ?, descripcion_categoria = ? "
                + " WHERE idCategoria = ? ;",
        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            preparestatement.setString(1, titulo);
            preparestatement.setString(2, descripcion);
            preparestatement.setInt(3, id_categoria);
            preparestatement.executeUpdate();
            preparestatement.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
    }//fin metodo
 
    @Override
    public int contarProductos_int(){
        int contador = 0;
        try (Statement statement = conexion.createStatement(
        ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT * FROM productos;";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next())
                contador++;
            resultset.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
        return contador;
    }//fin metodo
    
    @Override
    public void contarProductos_por_Subcategoria(){
        try (Statement statement = conexion.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT categorias.nombreCategoria, subcategorias.NombreSubCategoria, COUNT(idProducto) "
                + "FROM Productos\n" +
            "INNER JOIN subcategorias ON productos.IdSubCategoria = subcategorias.IdSubCategoria \n" +
            "INNER JOIN categorias ON categorias.IdCategoria = subcategorias.IdCategoria \n" +
            "GROUP BY categorias.nombreCategoria, subcategorias.NombreSubCategoria \n" +
            "ORDER BY categorias.IdCategoria, subcategorias.IdSubCategoria ASC;";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                System.out.println("Categoria: " + resultset.getString(1) + " . SubCategoria: " + resultset.getString(2) 
                        + " . Número de productos: " + resultset.getInt(3));
            }
            resultset.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
    }//fin metodo
    
    @Override
    public void contarProductos_por_Categoria(){
        try (Statement statement = conexion.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT categorias.nombreCategoria, COUNT(idProducto) FROM Productos\n" +
            "INNER JOIN subcategorias ON productos.IdSubCategoria = subcategorias.IdSubCategoria \n" +
            "INNER JOIN categorias ON categorias.IdCategoria = subcategorias.IdCategoria \n" +
            "GROUP BY categorias.nombreCategoria\n" +
            "ORDER BY categorias.IdCategoria ASC;";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                System.out.println("Categoria: " + resultset.getString(1) + " . Número de productos: " + resultset.getInt(2));
            }
            resultset.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
    }//fin metodo
    
    @Override
    public int contar_Categorias_Disponibles() {
        int contador = 0;
        try (Statement statement = conexion.createStatement(
        ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT * FROM categorias;";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next())
                contador++;
            resultset.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
        return contador;
    }//fin metodo
    
    @Override
    public int contar_SubCategorias_Disponibles_por_Categoria(int id_categoria){
        int contador = 0;
        try (Statement statement = conexion.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            String sql = "SELECT COUNT(subCategorias.idSubCategoria) FROM subCategorias\n" +
            "INNER JOIN categorias ON categorias.IdCategoria = subcategorias.IdCategoria \n" +
            "WHERE categorias.IdCategoria = ? ;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_categoria);//le pasamos el parametro
            ResultSet rs = ps.executeQuery();
            //ponemos los valores por orden
            //leemos los resultados y los recorremos
            while(rs.next()){
                contador = (int)(rs.getInt(1));
            }
            //cerramos de ultimo a primero
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error: Problemas: " + ex.getMessage());
        }
        return contador;
    }//fin metodo
    
    @Override
    public int averiguarIndiceCategoria(){
        int indices_Categorias[] = {};
        int opcion_categoria = 0;
        //averiguamos los id de categoria y los imprimimos con esta funcion
        System.out.println("CATEGORIAS: ");
        indices_Categorias = devolver_Indices_Categorias();
        boolean compCategoria = false;
        do{ //aqui lo que hacemos es que el usuario tenga que elegir la opcion que quiera ver
            System.out.println("Elije el número de categoría: ");
            String opcion_introducir_str1 = "";
            opcion_introducir_str1 = sc.nextLine();
            //comprobamos que la respuesta sea número y no tenga letras
            if(esNumerico(opcion_introducir_str1)){
                //pasamos a int respuesta
                opcion_categoria = Integer.parseInt(opcion_introducir_str1);
                if(comprobarNumero_en_Array(indices_Categorias, opcion_categoria)){
                    opcion_categoria = opcion_categoria;
                    compCategoria = true;
                }else{
                    System.out.println("La opción debe ser un número de la lista.");
                }
            }else{
                System.out.println("la opción debe ser un número.");
            }
        }while(compCategoria == false);
        return opcion_categoria;
    }//fin metodo
    
    @Override
    public int averiguarIndiceSubCategoria(){
        int indices_Categorias[] = {};
        int indices_SubCategorias[] = {};
        int opcion_categoria = 0;
        int opcion_subcategoria = 0;
        //////////////ESTA PARTE ES PARA LAS CATEGORIAS///////////////////////////////
        //averiguamos los id de categoria y los imprimimos con esta funcion
        System.out.println("CATEGORIAS: ");       
        boolean compCategoria = false;
        do{ //mientras no ponga los campos correctos
            indices_Categorias = devolver_Indices_Categorias();
            System.out.println("Elije el número de categoría donde está la subcategoría: ");
            String opcion_introducir_str1 = "";
            opcion_introducir_str1 = sc.nextLine();
            //comprobamos que la respuesta sea número y no tenga letras
            if(esNumerico(opcion_introducir_str1)){
                //pasamos a int respuesta
                opcion_categoria = Integer.parseInt(opcion_introducir_str1);
                if(comprobarNumero_en_Array(indices_Categorias, opcion_categoria)){
                    ////////////ESTA PARTE ES PARA LAS SUBCATEGORIAS////////////
                    System.out.println("SUBCATEGORIAS: ");  
                    boolean compSubCategoria = false;
                    do{//mientras no ponga los campos correctos
                        indices_SubCategorias = devolver_Indices_SubCategorias_por_Categorias(opcion_categoria);
                        System.out.println("Elije el número de subcategoría: ");
                        String opcion_introducir_str2 = "";
                        opcion_introducir_str2 = sc.nextLine();
                        if(esNumerico(opcion_introducir_str2)){
                            //pasamos a int respuesta
                            opcion_subcategoria = Integer.parseInt(opcion_introducir_str2);
                            if(comprobarNumero_en_Array(indices_SubCategorias, opcion_subcategoria)){
                                opcion_subcategoria = opcion_subcategoria;
                                compCategoria = true;
                                compSubCategoria = true;
                            }else{
                                System.out.println("La opción debe ser un número de la lista.");
                            }
                        }else{
                            System.out.println("la opción debe ser un número.");
                        }
                    }while(compSubCategoria == false);
                    ///////////////FIN PARTE SUBCATEGORIAS////////////////////////
                }else{
                    System.out.println("La opción debe ser un número de la lista.");
                }
            }else{
                System.out.println("la opción debe ser un número.");
            }
        }while(compCategoria == false);
        ////////////////////FIN PARTE CATEGORIAS////////////////////////////
        return opcion_subcategoria;
    }//fin metodo
    
    @Override
    public int averiguarIndiceProducto(){
        int indices_Categorias[] = {};
        int indices_SubCategorias[] = {};
        int indices_productos[] = {};
        int opcion_categoria = 0;
        int opcion_subcategoria = 0;
        int opcion_producto = 0;
        //////////////ESTA PARTE ES PARA LAS CATEGORIAS///////////////////////////////
        //averiguamos los id de categoria y los imprimimos con esta funcion
        System.out.println("CATEGORIAS: ");
        indices_Categorias = devolver_Indices_Categorias();
        boolean compCategoria = false;
        do{ //aqui lo que hacemos es que el usuario tenga que elegir la opcion que quiera ver
            System.out.println("Elije el número de categoría: ");
            String opcion_introducir_str1 = "";
            opcion_introducir_str1 = sc.nextLine();
            //comprobamos que la respuesta sea número y no tenga letras
            if(esNumerico(opcion_introducir_str1)){
                //pasamos a int respuesta
                opcion_categoria = Integer.parseInt(opcion_introducir_str1);
                if(comprobarNumero_en_Array(indices_Categorias, opcion_categoria)){
                    ////////////ESTA PARTE ES PARA LAS SUBCATEGORIAS////////////
                    System.out.println("SUBCATEGORIAS: ");
                    indices_SubCategorias = devolver_Indices_SubCategorias_por_Categorias(opcion_categoria);
                    boolean compSubCategoria = false;
                    do{
                        System.out.println("Elije el número de subcategoría: ");
                        String opcion_introducir_str2 = "";
                        opcion_introducir_str2 = sc.nextLine();
                        if(esNumerico(opcion_introducir_str2)){
                            //pasamos a int respuesta
                            opcion_subcategoria = Integer.parseInt(opcion_introducir_str2);
                            if(comprobarNumero_en_Array(indices_SubCategorias, opcion_subcategoria)){
                                ////ESTA PARTE ES DE PRODUCTOS//////////////////////////////
                                boolean compProducto = false;
                                do{//mientras no ponga los campos correctos
                                    indices_productos = devolver_Indices_Productos_por_SubCategoria(opcion_subcategoria);
                                    System.out.println("Elije el número de producto: ");
                                    String opcion_introducir_str3 = "";
                                    opcion_introducir_str3 = sc.nextLine();
                                    if(esNumerico(opcion_introducir_str3)){
                                        //pasamos a int respuesta
                                        opcion_producto = Integer.parseInt(opcion_introducir_str3);
                                        if(comprobarNumero_en_Array(indices_SubCategorias, opcion_subcategoria)){
                                            opcion_producto = opcion_producto;
                                            compSubCategoria = true;
                                            compCategoria = true;
                                            compProducto = true;
                                        }else{
                                            System.out.println("La opción debe ser un número de la lista.");
                                        }
                                    }else{
                                        System.out.println("la opción debe ser un número.");
                                    }
                                }while(compProducto == false);
                                ////////FIN PARTE PRODUCTO////////////////////////////////
                            }else{
                                System.out.println("La opción debe ser un número de la lista.");
                            }
                        }else{
                            System.out.println("la opción debe ser un número.");
                        }
                    }while(compSubCategoria == false);
                    ///////////////FIN PARTE SUBCATEGORIAS////////////////////////
                }else{
                    System.out.println("La opción debe ser un número de la lista.");
                }
            }else{
                System.out.println("la opción debe ser un número.");
            }
        }while(compCategoria == false);
        ////////////////////FIN PARTE CATEGORIAS////////////////////////////
        return opcion_producto;
    }//fin metodo

    @Override
    public void obtenerInformacion(){   
        try {
            System.out.println("==============INFORMACION DE DATABASE==============");
            DatabaseMetaData metadatos;
            metadatos = conexion.getMetaData();
            //Nombre de producto
            System.out.println("Nombre de Producto: " + metadatos.getDatabaseProductName());
            //Version de producto
            System.out.println("Version de Producto: " + metadatos.getDatabaseProductVersion());
            //Nombre de driver
            System.out.println("Nombre de Driver: " + metadatos.getDriverName());
            //Version de driver
            System.out.println("Version de Driver: " + metadatos.getDriverVersion());
            
            System.out.println("==============INFORMACION DE RESULTSET==============");
            System.out.println("\nObteniendo Informacion sobre una consulta con un ResultSet");
            //ResultSetMetaData rsmetadatos;
            Statement st;
            st = conexion.createStatement();
            
            //averiguamos el numero de tablas que hay en la base de datos y hacemos un array de tablas
            String array_tablas[] = crearArrayTablasBaseDatos();
            //recorremos las tablas y por cada una de ellas sacamos los datos
            for (int i=0;i<array_tablas.length;i++){
                String tabla = array_tablas[i];
                ResultSet rs = st.executeQuery("select * from " + tabla +" ;");
                ResultSetMetaData rsmetadatos =  rs.getMetaData();
                //obteniendo numero de columnas
                int col = rsmetadatos.getColumnCount();//cuenta de columnas
                System.out.println("Tabla " + tabla);
                //recorriendo columnas
                for(int y = 1 ;y <= col ;y++){
                    System.out.println("====Columna "+ rsmetadatos.getColumnName(y) + " de tipo " 
                    + rsmetadatos.getColumnTypeName(y) + " de tabla " + rsmetadatos.getTableName(y));
                }
                rs.close(); //cerramos el resultSet       
            }
            st.close();//cerramos el Statement
        } catch (SQLException ex) {
            Logger.getLogger(LogicaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("===================================================");
    }//fin metodo
    
    @Override
    public int devolverNumeroTablasBaseDatos(){
	int numero_tablas = 0;
        try {
            DatabaseMetaData metadatos;
            metadatos = conexion.getMetaData();
            //Tablas
            ResultSet rst = metadatos.getTables(null, null, null, null);
            while(rst.next()){
                numero_tablas++;
            }
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(LogicaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numero_tablas;
    }//fin metodo
    
    @Override
    public String[] crearArrayTablasBaseDatos(){
        //averiguamos el numero de tablas que hay en la base de datos
        int numero_tablas = devolverNumeroTablasBaseDatos();
        //y hacemos un array de tablas
        String array_tablas[] = new String[numero_tablas];
        int contador = 0;
        String tabla="";
        try {
            DatabaseMetaData metadatos;
            metadatos = conexion.getMetaData();
            //Tablas
            ResultSet rst = metadatos.getTables(null, null, null, null);
            while(rst.next()){
                tabla = rst.getObject(3).toString();
                array_tablas[contador] = tabla;
                contador++;
            }
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(LogicaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array_tablas;
    }//fin metodo
    
}//fin clase
