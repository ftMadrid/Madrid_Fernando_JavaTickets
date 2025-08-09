package javatickets.usuarios;

import javatickets.utilidades.Enums;

public class Administrador extends UserManager{
    
    public Administrador() {
        super("Administrador", "admin", "supersecreto", 100);
    }

    public Administrador(String nombre, String usuario, String password, int edad) {
        super(nombre, usuario, password, edad);
    }
    
    @Override
    public Enums.TipoUsuarios getTipo(){
        return Enums.TipoUsuarios.ADMINISTRADOR;
    }
}
