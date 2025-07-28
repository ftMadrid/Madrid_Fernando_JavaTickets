package javatickets.usuarios;

public class Usuarios {

    public static Usuarios[] usuarios = new Usuarios[100];
    public static Usuarios usuarioLogged = null;
    public static boolean logged = false;
    public static int cantidadUsuarios = 2;
    
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

    public static boolean esAdmin() {
        return usuarioLogged instanceof Administrador;
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
