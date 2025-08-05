package javatickets;

import javatickets.usuarios.Administrador;
import javatickets.usuarios.Usuarios;
import javatickets.ventanas.Principal;

public class JavaTickets {

    public static void main(String[] args) {

        Usuarios.agregar(new Administrador());
        new Principal().setVisible(true);

    }
}