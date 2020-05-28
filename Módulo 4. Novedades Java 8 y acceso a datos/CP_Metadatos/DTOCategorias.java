package Tema4.CP_Metadatos;

import java.util.Objects;

/**
 *
 * @author Hector Garcia
 */
public class DTOCategorias {
    //ATRIBUTOS
    private int idCategoria;// int(11) NOT NULL,
    private String nombreCategoria;// varchar(100) NOT NULL,
    private String descripcion_categoria; //Descripcion_categoria varchar(200) DEFAULT NULL,
 
    //1-constructor vacio
    public DTOCategorias() {
    }//fin constructor
    
    //2-Constructor que recibe parámetros
    public DTOCategorias(int idCategoria, String nombreCategoria, String descripcion_categoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcion_categoria = descripcion_categoria;
    }//fin constructor
    
    //3ºConstructor que recibe como parámetro un objeto de tipo Persona
    //Con otro Persona que ya exista
    public DTOCategorias(DTOCategorias oDTOCategorias){
        this.idCategoria = oDTOCategorias.getIdCategoria();
        this.nombreCategoria = oDTOCategorias.getNombreCategoria(); 
        this.descripcion_categoria = oDTOCategorias.getDescripcion_categoria();
    }//fin constructor
    
    //Métodos getters y setters
    public int getIdCategoria() {
        return this.idCategoria;
    }//fin metodo
    
    public String getNombreCategoria() {
        return this.nombreCategoria;
    }//fin metodo
    
    public String getDescripcion_categoria() {
        return this.descripcion_categoria;
    }//fin metodo

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }//fin metodo
    
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }//fin metodo
    
    public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
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
        
        DTOCategorias oDTOCategorias = (DTOCategorias) obj;
        
        if (!Objects.equals(this.idCategoria, oDTOCategorias.getIdCategoria())) {
            return false;
        }
        if (!Objects.equals(this.nombreCategoria, oDTOCategorias.getNombreCategoria())) {
            return false;
        }
        if (!Objects.equals(this.descripcion_categoria, oDTOCategorias.getDescripcion_categoria())) {
            return false;
        }
        return true;
    }//fin metodo

    @Override
    //metodo toString sobreescrito
    public String toString(){
        return "Categoria = El id de categoria es " + this.getIdCategoria() + ", el nombre de categoria es "
                + this.getNombreCategoria() + " y la descripción es = " + this.getDescripcion_categoria();
    }//fin metodo
    
    //metodo pintar
    public void mostrarDatos(){
        System.out.println("Categoria = El id de categoria es " + this.getIdCategoria() +
                ", el nombre de categoria es "
                + this.getNombreCategoria() + " y la descripción es = " + this.getDescripcion_categoria());
    }//fin metodo
    
}//fin clase
