/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema4.CP_Metadatos;

/**
 *
 * @author Hector Garcia
 */
import java.util.ArrayList;

/**
 *
 * @author Hector Garcia
 */
public interface InterfaceDAO {
    ////metodos abstractos a implementar
    ///////////////////////////////////////////////////
    public abstract void logicaNegocio();
    
    public abstract void actualizarProducto(String titulo, double pvpDouble, String descripcion , int id_producto);
    
    public abstract void borrarProducto(int id_producto);
    
    public abstract void contarProductos();
    
    public abstract void insertarProducto(String titulo, double pvp, String descripcion, int id_subcategoria);
    
    public abstract void listarProductos();
    
    public abstract void obtenerInformacion();
    /////////////////////////////////////////////////////
    public abstract void cerrarConexion();
    
    public abstract boolean volver_menu_o_salir();
    
    public abstract boolean comprobarNumero_en_Array(int arrayNumeros[], int opcion);
    
    public abstract boolean esNumerico(String cadena);
    
    public abstract boolean es_cadena_double(String cadena);
    
    public abstract void listarCategorias();
    
    public abstract void listarSubCategorias();
    
    public abstract int[] devolver_Indices_Categorias();
    
    public abstract void listar_SubCategorias_por_Categorias(int id_categoria);
    
    public abstract int[] devolver_Indices_SubCategorias_por_Categorias(int id_categoria);
    
    public abstract void listar_Productos_por_Subcategoria(int id_subcategoria);

    public abstract void insertarSubcategoria(String nombreSubCategoria, String descripcion, int opcion_categoria);
    
    public abstract void insertarCategoria(String nombreCategoria, String descripcion);
    
    public abstract void borrarCategoria(int id_categoria);
    
    public abstract void borrarSubCategoria(int id_subcategoria);
    
    public abstract int[] devolver_Indices_Productos();
  
    public abstract int[] devolver_Indices_Productos_por_SubCategoria(int idSubcategoria);
 
    public abstract void actualizarSubCategoria(String titulo, String descripcion, int id_subcategoria);
    
    public abstract void actualizarCategoria(String titulo, String descripcion, int id_categoria);
 
    public abstract int contarProductos_int();
    
    public abstract void contarProductos_por_Subcategoria();
    
    public abstract void contarProductos_por_Categoria();
    
    public abstract int contar_Categorias_Disponibles();
    
    public abstract int contar_SubCategorias_Disponibles_por_Categoria(int id_categoria);
    
    public abstract int averiguarIndiceCategoria();
    
    public abstract int averiguarIndiceSubCategoria();
    
    public abstract int averiguarIndiceProducto();

    public abstract int devolverNumeroTablasBaseDatos();
    
    public abstract String[] crearArrayTablasBaseDatos();
            
}//fin clase
