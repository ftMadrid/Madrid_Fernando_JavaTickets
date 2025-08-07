package javatickets;

import javatickets.usuarios.Administrador;
import javatickets.usuarios.UserManager;
import javatickets.ventanas.Principal;

public class JavaTickets {

    public static void main(String[] args) {

        UserManager.agregar(new Administrador());
        new Principal().setVisible(true);

    }
}