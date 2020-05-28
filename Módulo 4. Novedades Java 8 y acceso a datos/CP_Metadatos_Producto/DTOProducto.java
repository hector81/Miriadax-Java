package Tema4.CP_Metadatos_Producto;

import java.util.Objects;
/**
 *
 * @author Hector Garcia
 */
public class DTOProducto  {
    //Atributos
    private int idproducto;
    private String nombre;
    private float precio;
    
    //constructores
    //1ºConstructor sin parametros
    public DTOProducto(){ 

    }//fin constructor
    
    //2ºConstructor con parametros
    public DTOProducto(int idproducto, String nombre, float precio){
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.precio = precio;
    }//fin constructor
    
    //Funciones getter y setters
    public int getIdproducto() {
        return idproducto;
    }//fin metodo
    
    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }//fin metodo
    
    public String getNombre() {
        return nombre;
    }//fin metodo
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }//fin metodo
    
    public float getPrecio() {
        return precio;
    }//fin metodo
    
    public void setPrecio(float precio) {
        this.precio = precio;
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
        
        DTOProducto oDTOProducto = (DTOProducto) obj;
        
        if (!Objects.equals(this.idproducto, oDTOProducto.getIdproducto())) {
            return false;
        }
        if (!Objects.equals(this.nombre, oDTOProducto.getNombre())) {
            return false;
        }
        if (!Objects.equals(this.precio, oDTOProducto.getPrecio())) {
            return false;
        }
        return true;
    }//fin metodo

    @Override
    //metodo toString sobreescrito
    public String toString(){
        return "El id de producto es " + this.getIdproducto() + 
        ", el nombre es = " + this.getNombre()
        + ", su precio PVP es = " + this.getPrecio();
    }//fin metodo
    
    //metodo pintar
    public void mostrarDatos(){
        System.out.println("El id de producto es " + this.getIdproducto() + 
        ", el nombre es = " + this.getNombre()
        + ", su precio PVP es = " + this.getPrecio());
    }//fin metodo

}//fin clase
