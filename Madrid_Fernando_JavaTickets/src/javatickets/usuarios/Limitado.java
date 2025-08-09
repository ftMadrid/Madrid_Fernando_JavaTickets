package javatickets.usuarios;

public class Limitado extends UserManager{
    
    public Limitado(String nombre, String usuario, String password, int edad) {
        super(nombre, usuario, password, edad);
    }
    
    public String getTipo(){
        return "Limitado";
    }
    
}
