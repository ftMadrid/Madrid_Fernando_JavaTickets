package javatickets.usuarios;

public class Contenidos extends UserManager{
    
    public Contenidos(String nombre, String usuario, String password, int edad) {
        super(nombre, usuario, password, edad);
    }
    
    public String getTipo(){
        return "Contenidos";
    }
    
}
