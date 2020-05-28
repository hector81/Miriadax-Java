package Tema2.Clases_objetos_metodos;

public class UsuarioBean implements java.io.Serializable{
    private String usuario;
    private String clave;
    private String email;
    private byte edad;
    
    public UsuarioBean() {

    }
    
    public String getUsuario() {
     return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

}
