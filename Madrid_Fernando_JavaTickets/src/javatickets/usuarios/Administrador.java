package javatickets.usuarios;

public class Administrador extends Usuarios{
    
    public Administrador() {
        super("Administrador", "admin", "supersecreto", 100);
    }

    public Administrador(String nombre, String usuario, String password, int edad) {
        super(nombre, usuario, password, edad);
    }
}
