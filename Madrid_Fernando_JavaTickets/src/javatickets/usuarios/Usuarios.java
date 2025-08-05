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

    public static Usuarios buscar(String usuario) {
        return buscarListado(usuario, 0);
    }

    private static Usuarios buscarListado(String usuario, int indice) {
        if (indice >= usuarios.size()) {
            return null;
        }

        Usuarios encontrado = usuarios.get(indice);

        if (encontrado != null && usuario.equals(encontrado.getUsuario())) {
            return encontrado;
        }

        return buscarListado(usuario, indice + 1);
    }

    public static void agregar(Usuarios nuevoUsuario) {
        usuarios.add(nuevoUsuario);
    }

    public static void borrar(Usuarios user) {
        usuarios.remove(user);
    }

    public static void editar(Usuarios target, String nombre, String user, String password, int edad, String tipo) {

        int indice = usuarios.indexOf(target);
        if (indice == -1) {
            return;
        }

        Usuarios editado = null;

        switch (tipo) {
            case "Administrador":
                editado = new Administrador(nombre, user, password, edad);
                break;
            case "Contenido":
                editado = new Contenidos(nombre, user, password, edad);
                break;
            case "Limitado":
                editado = new Limitado(nombre, user, password, edad);
                break;
        }

        usuarios.set(indice, editado);
    }

    public static boolean esAdmin(Usuarios user) {
        return user instanceof Administrador;
    }

    public static boolean esContenido(Usuarios user) {
        return user instanceof Contenidos;
    }

    public static boolean esLimitado(Usuarios user) {
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

    public static boolean validarPassword(String password) {
        String parametros = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#+_=<>.,;:]).{8,}$";
        return password.matches(parametros);
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
