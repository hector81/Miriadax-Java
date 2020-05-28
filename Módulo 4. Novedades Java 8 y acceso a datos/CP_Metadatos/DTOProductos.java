package Tema4.CP_Metadatos;

import java.util.Objects;

/**
 *
 * @author Hector Garcia
 */
public class DTOProductos extends DTOSubcategorias {
    //ATRIBUTOS
    private int idProducto;// int(11) NOT NULL,
    private String titulo;// varchar(200) NOT NULL,
    private float pvp;// decimal(15,4) NOT NULL,
    private String descripcion;// varchar(500) NOT NULL,
    
    //constructores
    //1ºConstructor sin parametros que llama con super al constructor de la clase DTOSubCategorias
    public DTOProductos(){ 
        super();//con super llamamos al constructor de la clase DTOCategorias
    }//fin constructor
    
    //2ºConstructor que recibe como parámetro otro objeto de la clase DTOSubcategorias
    public DTOProductos(DTOSubcategorias oDTOSubcategorias){
        super(oDTOSubcategorias);//con super llamamos al constructor de la clase DTOSubcategorias
        this.idProducto = idProducto;
        this.titulo = titulo;
        this.pvp = pvp;
        this.descripcion = descripcion;
    }//fin constructor
    
    //3ºConstructor que recibe como parámetro otro objeto de la clase DTOSubcategorias  y un dato para cada dato de DTOProductos
    public DTOProductos(DTOSubcategorias oDTOSubcategorias, int idProducto, String titulo, float pvp, String descripcion) {
        super(oDTOSubcategorias);//con super llamamos al constructor de la clase DTOSubcategorias
        this.idProducto = idProducto;
        this.titulo = titulo;
        this.pvp = pvp;
        this.descripcion = descripcion;
    }//fin constructor
    
    //4ºConstructor, Con un parámetro para cada dato heredado de DTOCategorias y un parámetro para cada dato de la propia clase
    public DTOProductos(int idCategoria, String nombreCategoria, String descripcion_categoria, int idSubCategoria, String nombreSubCategoria, String descripcion_subcategoria, int idProducto, String titulo, float pvp, String descripcion) {
        super(idCategoria, nombreCategoria, descripcion_categoria, idSubCategoria, nombreSubCategoria, descripcion_subcategoria);//con super llamamos al constructor de la clase DTOSubcategorias
        this.idProducto = idProducto;
        this.titulo = titulo;
        this.pvp = pvp;
        this.descripcion = descripcion;
    }//fin constructor

    
    //Métodos getters y setters
    public int getIdProducto() {
        return this.idProducto;
    }//fin metodo
    
    public String getTitulo() {
        return this.titulo;
    }//fin metodo

    public float getPvp() {
        return this.pvp;
    }//fin metodo
    
    public String getDescripcion() {
        return this.descripcion;
    }//fin metodo
    
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }//fin metodo
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }//fin metodo
    
    public void setPvp(float pvp) {
        this.pvp = pvp;
    }//fin metodo
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }//fin metodo
    
    @Override
    //metodo equals sobreescrito
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        
        DTOProductos oDTOProductos = (DTOProductos) obj;
        
        if (!Objects.equals(this.idProducto, oDTOProductos.getIdProducto())) {
            return false;
        }
        if (!Objects.equals(this.titulo, oDTOProductos.getTitulo())) {
            return false;
        }
        if (!Objects.equals(this.pvp, oDTOProductos.getPvp())) {
            return false;
        }
        if (!Objects.equals(this.descripcion, oDTOProductos.getDescripcion())) {
            return false;
        }
        return true;
    }//fin metodo

    @Override
    //metodo toString sobreescrito
    public String toString(){
        return "Categoria = El id de categoria es " + this.getIdCategoria() + ", el nombre de categoria es " +
        this.getNombreCategoria() + " y la descripción es = " + this.getDescripcion_categoria() +
        " .SubCategoria = El id de subcategoria es " + this.getIdSubCategoria() + ", el nombre de subcategoria es "
        + this.getNombreSubCategoria() + ", la descripción es = " + this.getDescripcion_subcategoria() + 
        " .Producto = El id de producto es " + this.getIdProducto() + 
        ", el titulo es = " + this.getTitulo()
        + ", su precio PVP es = " + this.getPvp()
        + " y la descripción es = " + this.getDescripcion();
    }//fin metodo
    
    //metodo pintar
    public void mostrarDatos(){
        System.out.println("Categoria = El id de categoria es " + this.getIdCategoria() + ", el nombre de categoria es " +
        this.getNombreCategoria() + " y la descripción es = " + this.getDescripcion_categoria() +
        " .SubCategoria = El id de subcategoria es " + this.getIdSubCategoria() + ", el nombre de subcategoria es "
        + this.getNombreSubCategoria() + ", la descripción es = " + this.getDescripcion_subcategoria() + 
        " .Producto = El id de producto es " + this.getIdProducto() + 
        ", el titulo es = " + this.getTitulo()
        + ", su precio PVP es = " + this.getPvp()
        + " y la descripción es = " + this.getDescripcion());
    }//fin metodo
    
}//fin clase
