package Tema4.CP_Metadatos;

import java.util.Objects;

/**
 *
 * @author user
 */
public class DTOSubcategorias extends DTOCategorias {
    //ATRIBUTOS
    private int idSubCategoria;// int(11) NOT NULL
    private String nombreSubCategoria;// varchar(100) NOT NULL
    private String descripcion_subcategoria; //varchar(200) NOT NULL
    
    //constructores
    //1ºConstructor sin parametros que llama con super al constructor de la clase DTOCategorias
    public DTOSubcategorias(){ 
        super();//con super llamamos al constructor de la clase DTOCategorias
    }//fin constructor
    
    //2ºConstructor que recibe como parámetro otro objeto de la clase DTOSubcategorias
    public DTOSubcategorias(DTOCategorias oDTOCategorias){
        super(oDTOCategorias);//con super llamamos al constructor de la clase DTOCategorias
        this.idSubCategoria = idSubCategoria;
        this.nombreSubCategoria = nombreSubCategoria;
        this.descripcion_subcategoria = descripcion_subcategoria;
    }//fin constructor
    
    //3ºConstructor que recibe como parámetro otro objeto de la clase DTOCategorias  y un dato para cada dato de DTOSubcategorias
    public DTOSubcategorias(DTOCategorias oDTOCategorias, int idSubCategoria, String nombreSubCategoria, String descripcion_subcategoria) {
        super(oDTOCategorias);//con super llamamos al constructor de la clase DTOCategorias
        this.idSubCategoria = idSubCategoria;
        this.nombreSubCategoria = nombreSubCategoria;
        this.descripcion_subcategoria = descripcion_subcategoria;
    }//fin constructor
    
    //4ºConstructor, Con un parámetro para cada dato heredado de DTOCategorias y un parámetro para cada dato de la propia clase
    public DTOSubcategorias(int idCategoria, String nombreCategoria, String descripcion_categoria, int idSubCategoria, String nombreSubCategoria, String descripcion_subcategoria) {
        super(idCategoria, nombreCategoria, descripcion_categoria);//con super llamamos al constructor de la clase categoria
        this.idSubCategoria = idSubCategoria;
        this.nombreSubCategoria = nombreSubCategoria;
        this.descripcion_subcategoria = descripcion_subcategoria;
    }//fin constructor
    
    //Métodos getters y setters
    public int getIdSubCategoria() {
        return this.idSubCategoria;
    }//fin metodo
    
    public String getNombreSubCategoria() {
        return this.nombreSubCategoria;
    }//fin metodo
    
    public String getDescripcion_subcategoria() {
        return this.descripcion_subcategoria;
    }//fin metodo
    
    public void setIdSubCategoria(int idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }//fin metodo
    
    public void setNombreSubCategoria(String nombreSubCategoria) {
        this.nombreSubCategoria = nombreSubCategoria;
    }//fin metodo
    
    public void setDescripcion_subcategoria(String descripcion_subcategoria) {
        this.descripcion_subcategoria = descripcion_subcategoria;
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
        
        DTOSubcategorias oDTOSubcategorias = (DTOSubcategorias) obj;
        
        if (!Objects.equals(this.idSubCategoria, oDTOSubcategorias.getIdSubCategoria())) {
            return false;
        }
        if (!Objects.equals(this.nombreSubCategoria, oDTOSubcategorias.getNombreSubCategoria())) {
            return false;
        }
        if (!Objects.equals(this.descripcion_subcategoria, oDTOSubcategorias.getDescripcion_subcategoria())) {
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
        + this.getNombreSubCategoria() + ", la descripción es = " + this.getDescripcion_subcategoria();
    }//fin metodo
    
    //metodo pintar
    public void mostrarDatos(){
        System.out.println("Categoria = El id de categoria es " + this.getIdCategoria() + ", el nombre de categoria es " +
        this.getNombreCategoria() + " y la descripción es = " + this.getDescripcion_categoria() +
        " .SubCategoria = El id de subcategoria es " + this.getIdSubCategoria() + ", el nombre de subcategoria es "
        + this.getNombreSubCategoria() + ", la descripción es = " + this.getDescripcion_subcategoria());
    }//fin metodo
   
}//fin clase
        