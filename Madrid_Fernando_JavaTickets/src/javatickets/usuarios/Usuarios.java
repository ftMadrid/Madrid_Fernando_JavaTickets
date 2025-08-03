package javatickets.usuarios;

import java.util.ArrayList;

public class Usuarios {

    public static ArrayList<Usuarios> usuarios = new ArrayList<>();
    public static Usuarios usuarioLogged = null;
    public static boolean logged = false;
    public static int cantidadUsuarios = 1;
    
    protected String nombre;
    protected String usuario;
    protected String password;
    protected int edad;

    public Usuarios(String nombre, String usuario, String password, int edad) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.edad = edad;
    }
    
    public static Usuarios buscar(String usuario){
        
        for (Usuarios user : usuarios) {
            if (user != null && usuario.equals(user.getUsuario())) {
                return user;
            }
        }
        return null;
    }
    
    public static void agregar(Usuarios nuevoUsuario){
        usuarios.add(nuevoUsuario);
    }
    
    public static boolean esAdmin(Usuarios user){
        return user instanceof Administrador;
    }
    
    public static boolean esContenido(Usuarios user){
        return user instanceof Contenidos;
    }
    
    public static boolean esLimitado(Usuarios user){
        return user instanceof Limitado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
