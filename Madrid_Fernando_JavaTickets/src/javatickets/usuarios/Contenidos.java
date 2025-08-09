package javatickets.usuarios;

import javatickets.utilidades.Enums;

public class Contenidos extends UserManager{
    
    public Contenidos(String nombre, String usuario, String password, int edad) {
        super(nombre, usuario, password, edad);
    }
    
    @Override
    public Enums.TipoUsuarios getTipo(){
        return Enums.TipoUsuarios.CONTENIDO;
    }
    
}
