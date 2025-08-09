package javatickets.usuarios;

import javatickets.utilidades.Enums;

public class Limitado extends UserManager{
    
    public Limitado(String nombre, String usuario, String password, int edad) {
        super(nombre, usuario, password, edad);
    }
    
    @Override
    public Enums.TipoUsuarios getTipo(){
        return Enums.TipoUsuarios.LIMITADO;
    }
    
}
