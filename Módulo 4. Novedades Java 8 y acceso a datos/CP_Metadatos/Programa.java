package Tema4.CP_Metadatos;

import java.util.Scanner;

/**
 *
 * @author Hector Garcia
 */
public class Programa {
    //main
    public static void main(String[] args) {
        //atributos
        LogicaNegocio implementacionLogica = new LogicaNegocio();
        boolean salir = false;
        Scanner sc = new Scanner (System.in); //Creación de un objeto Scanner e invocamos un método sobre un objeto Scanner 
        String opcion_str = "";
        int opcion = 0;
        int id_subcategoria = 0;
        int id_categoria = 0;
        boolean comprobarCamposMetidos = false;
        String titulo = "";
        String descripcion = "";
        
        int indices_productos[] = {};
        
        //operaciones
        do{
            //enseñamos las opciones
            implementacionLogica.logicaNegocio();
            System.out.println("Introduce una opción valida : ");
            opcion_str = sc.nextLine();
            //comprobamos que la respuesta sea número y no tenga letras
            if(implementacionLogica.esNumerico(opcion_str)){
                //pasamos a int respuesta
                opcion = Integer.parseInt(opcion_str);
                switch(opcion){
                    case 1: //1. Listar productos
                        implementacionLogica.listarProductos();
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 2: //2. Listar categorias
                        implementacionLogica.listarCategorias();
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 3: //3. Listar subcategorias
                        implementacionLogica.listarSubCategorias();
                        salir = implementacionLogica.volver_menu_o_salir();///volver al menu o no
                        break;
                    case 4: //4. Listar subcategorias por categorias  
                        id_categoria = implementacionLogica.averiguarIndiceCategoria();
                        implementacionLogica.listar_SubCategorias_por_Categorias(id_categoria);
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 5: //5. Listar productos por subcategorias y categorias
                        id_subcategoria = implementacionLogica.averiguarIndiceSubCategoria();
                        implementacionLogica.listar_Productos_por_Subcategoria(id_subcategoria);
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 6: //6. Insertar productos                      
                        id_subcategoria = implementacionLogica.averiguarIndiceSubCategoria();
                        do{//mientras no ponga los campos correctos
                            //rellenamos campos del producto
                            System.out.println("Pon un título = ");
                            titulo = sc.nextLine();
                            System.out.println("Pon un precio = ");
                            String pvp = sc.nextLine();
                            System.out.println("Pon una descripción = ");
                            descripcion = sc.nextLine();
                            //comprobamos que los campos no esten vacíos o que haya solo espacios en blanco
                            if(titulo.isEmpty() || pvp.isEmpty() || descripcion.isEmpty()
                              || titulo.trim().length()== 0 || pvp.trim().length()== 0
                              || descripcion.trim().length()== 0){
                                System.out.println("Hay campos vacios");          
                            }else{
                                //nos aseguramos que el precio sea float
                                if(implementacionLogica.es_cadena_double(pvp)){
                                    double pvpDouble = Double.parseDouble(pvp);//pasamos a float el precio
                                    implementacionLogica.insertarProducto(titulo, pvpDouble, descripcion, id_subcategoria);
                                    comprobarCamposMetidos = true;
                                    System.out.println("Insertado producto");
                                }else{
                                    System.out.println("El precio debe ser un número con o sin decimales");
                                }     
                            }
                        }while(comprobarCamposMetidos == false); 
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 7: //7. Insertar subcategoria de productos
                        
                        id_categoria = implementacionLogica.averiguarIndiceCategoria();          
                        do{//mientras no ponga los campos correctos
                            //rellenamos campos del producto
                            System.out.println("Pon un título de subcategoria = ");
                            String nombreSubCategoria = sc.nextLine();
                            System.out.println("Pon una descripción de subcategoria = ");
                            descripcion = sc.nextLine();
                            //comprobamos que los campos no esten vacíos o que haya solo espacios en blanco
                            if(nombreSubCategoria.isEmpty() || descripcion.isEmpty()
                            || nombreSubCategoria.trim().length()== 0 || descripcion.trim().length()== 0){
                                System.out.println("Hay campos vacios");          
                            }else{
                                implementacionLogica.insertarSubcategoria(nombreSubCategoria, descripcion, id_categoria);
                                comprobarCamposMetidos = true;
                                System.out.println("Insertada subcategoria");   
                            }
                        }while(comprobarCamposMetidos == false);
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 8: //8. Insertar categoria de productos
                        do{//mientras no ponga los campos correctos
                            //rellenamos campos del producto
                            System.out.println("Pon un título de categoria = ");
                            String nombreCategoria = sc.nextLine();
                            System.out.println("Pon una descripción de categoria = ");
                            descripcion = sc.nextLine();
                            //comprobamos que los campos no esten vacíos o que haya solo espacios en blanco
                            if(nombreCategoria.isEmpty() || descripcion.isEmpty()
                            || nombreCategoria.trim().length()== 0 || descripcion.trim().length()== 0){
                                System.out.println("Hay campos vacios");          
                            }else{
                                implementacionLogica.insertarCategoria(nombreCategoria, descripcion);
                                comprobarCamposMetidos = true;
                                System.out.println("Insertada categoria");   
                            }
                        }while(comprobarCamposMetidos == false);
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 9:  //9. Borrar productos
                        System.out.println("PRODUCTOS: ");
                        indices_productos = implementacionLogica.devolver_Indices_Productos();
                        boolean compProducto = false;
                        do{//mientras no ponga los campos correctos
                            System.out.println("Elije el número de producto que quieres borrar: ");
                            String opcion_introducir_str = "";
                            opcion_introducir_str = sc.nextLine();
                            if(implementacionLogica.esNumerico(opcion_introducir_str)){
                                //pasamos a int respuesta
                                int opcion_producto = Integer.parseInt(opcion_introducir_str);
                                if(implementacionLogica.comprobarNumero_en_Array(indices_productos, opcion_producto)){
                                    implementacionLogica.borrarProducto(opcion_producto);
                                    compProducto = true;
                                    System.out.println("Borrado producto");
                                }else{
                                    System.out.println("La opción debe ser un número de la lista.");
                                }
                            }else{
                                System.out.println("la opción debe ser un número.");
                            }
                        }while(compProducto == false);
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 10: //10. Borrar subcategoria de productos
                        id_subcategoria = implementacionLogica.averiguarIndiceSubCategoria();
                        implementacionLogica.borrarSubCategoria(id_subcategoria);
                        System.out.println("Borrada subcategoría");
                        salir = implementacionLogica.volver_menu_o_salir();
                        break;
                    case 11: //11. Borrar categoria de productos
                        id_categoria = implementacionLogica.averiguarIndiceCategoria();
                        implementacionLogica.borrarCategoria(id_categoria);
                        System.out.println("Borrada categoria");
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 12: //12. Actualizar productos
                        int id_producto = 0;
                        id_producto = implementacionLogica.averiguarIndiceProducto();
                        //rellenamos campos del producto
                        System.out.println("Pon un título nuevo para modificar = ");
                        titulo = sc.nextLine();
                        System.out.println("Pon un precio nuevo para modificar = ");
                        String pvp = sc.nextLine();
                        System.out.println("Pon una descripción nueva para modificar = ");
                        descripcion = sc.nextLine();
                        //comprobamos que los campos no esten vacíos o que haya solo espacios en blanco
                        if(titulo.isEmpty() || pvp.isEmpty() || descripcion.isEmpty()
                          || titulo.trim().length()== 0 || pvp.trim().length()== 0
                          || descripcion.trim().length()== 0){
                            System.out.println("Hay campos vacios");          
                        }else{
                            //nos aseguramos que el precio sea float
                            if(implementacionLogica.es_cadena_double(pvp)){
                                double pvpDouble = Double.parseDouble(pvp);//pasamos a float el precio
                                implementacionLogica.actualizarProducto(titulo, pvpDouble, descripcion, id_producto);
                                System.out.println("Modificado producto");
                            }else{
                                System.out.println("El precio debe ser un número con o sin decimales");
                            }     
                        }
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 13: //13. Actualizar subcategoria de productos 
                        id_subcategoria = implementacionLogica.averiguarIndiceSubCategoria();
                        //rellenamos campos del producto
                        System.out.println("Pon un título nuevo para modificar = ");
                        titulo = sc.nextLine();
                        System.out.println("Pon una descripción nueva para modificar = ");
                        descripcion = sc.nextLine();
                        //comprobamos que los campos no esten vacíos o que haya solo espacios en blanco
                        if(titulo.isEmpty() || descripcion.isEmpty()
                          || titulo.trim().length()== 0 || descripcion.trim().length()== 0){
                            System.out.println("Hay campos vacios");          
                        }else{
                            implementacionLogica.actualizarSubCategoria(titulo, descripcion, id_subcategoria);
                            System.out.println("Modificada subcategoría");   
                        }
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 14: //14. Actualizar categoria de productos
                        id_categoria = implementacionLogica.averiguarIndiceCategoria();
                        //rellenamos campos del producto
                        System.out.println("Pon un título nuevo para modificar = ");
                        titulo = sc.nextLine();
                        System.out.println("Pon una descripción nueva para modificar = ");
                        descripcion = sc.nextLine();
                        //comprobamos que los campos no esten vacíos o que haya solo espacios en blanco
                        if(titulo.isEmpty() || descripcion.isEmpty()
                          || titulo.trim().length()== 0 || descripcion.trim().length()== 0){
                            System.out.println("Hay campos vacios");          
                        }else{
                            implementacionLogica.actualizarCategoria(titulo, descripcion, id_categoria);
                            System.out.println("Modificada categoría");   
                        }
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 15: //15. Contar productos
                        implementacionLogica.contarProductos();
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 16: //16. Contar productos por subcategoria
                        implementacionLogica.contarProductos_por_Subcategoria();
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 17: //17. Contar productos por categoria
                        implementacionLogica.contarProductos_por_Categoria();
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;
                    case 18: //18. Obtener información
                        implementacionLogica.obtenerInformacion();
                        salir = implementacionLogica.volver_menu_o_salir();//volver al menu o no
                        break;    
                    case 19: //19. Salir
                        salir = true;//salimos del programa
                        implementacionLogica.cerrarConexion();
                }
                
            }else{
                System.out.println("la opción debe ser un número.");
            }
        }while(salir == false);
    }//fin main
    
}//fin clase
