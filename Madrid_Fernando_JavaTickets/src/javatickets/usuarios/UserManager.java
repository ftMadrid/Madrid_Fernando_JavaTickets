package javatickets.usuarios;

import java.util.ArrayList;
import javatickets.eventos.EventsManager;
import javatickets.utilidades.Enums;

public abstract class UserManager {

    public static ArrayList<UserManager> usuarios = new ArrayList<>();
    public static UserManager usuarioLogged = null;
    public static boolean logged = false;
    public static int cantidadUsuarios = 1;

    protected String nombre;
    protected String usuario;
    protected String password;
    protected int edad;
    protected ArrayList<EventsManager> eventosCreados = new ArrayList<>();
    protected int ctEventosCreados = 0;

    public UserManager(String nombre, String usuario, String password, int edad) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.edad = edad;
    }

    public static UserManager buscar(String usuario) {
        return buscarListado(usuario, 0);
    }

    private static UserManager buscarListado(String usuario, int indice) {
        if (indice >= usuarios.size()) {
            return null;
        }

        UserManager encontrado = usuarios.get(indice);

        if (encontrado != null && usuario.equals(encontrado.getUsuario())) {
            return encontrado;
        }

        return buscarListado(usuario, indice + 1);
    }

    public static void agregar(UserManager nuevoUsuario) {
        usuarios.add(nuevoUsuario);
        cantidadUsuarios++;
    }

    public static void borrar(UserManager user) {
        usuarios.remove(user);
        cantidadUsuarios--;
    }

    public static void editar(UserManager target, String nombre, String user, String password, int edad, Enums.TipoUsuarios tipo) {

        int indice = usuarios.indexOf(target);
        if (indice == -1) {
            return;
        }

        UserManager editado = null;

        switch (tipo) {
            case ADMINISTRADOR:
                editado = new Administrador(nombre, user, password, edad);
                break;
            case CONTENIDO:
                editado = new Contenidos(nombre, user, password, edad);
                break;
            case LIMITADO:
                editado = new Limitado(nombre, user, password, edad);
                break;
        }

        if (editado != null) {
            editado.eventosCreados = new ArrayList<>(target.getListaEventos());
            editado.ctEventosCreados = target.getCantEventosCreados();
            usuarios.set(indice, editado);
        }
    }

    public abstract Enums.TipoUsuarios getTipo();

    public static boolean esAdmin(UserManager user) {
        return user instanceof Administrador;
    }

    public static boolean esContenido(UserManager user) {
        return user instanceof Contenidos;
    }

    public static boolean esLimitado(UserManager user) {
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

    public static int getCantidadUsuarios() {
        return cantidadUsuarios;
    }

    public int getCantEventosCreados() {
        return ctEventosCreados;
    }

    public void eventoCreado(EventsManager evento) {
        eventosCreados.add(evento);
        ctEventosCreados++;
    }

    public ArrayList<EventsManager> getListaEventos() {
        return eventosCreados;
    }

    public String getEventosCreados() {

        if (eventosCreados.isEmpty()) {
            return "";
        }

        String info = "";

        for (EventsManager evento : eventosCreados) {
            info += "| Codigo: " + evento.getCodigo() + "\n";
            info += "| Tipo: " + evento.getTipo() + "\n";
            info += "| Titulo: " + evento.getTitulo() + "\n";
            info += "| Monto de Renta: L." + String.format("%.2f", evento.getRenta()) + "\n";
            info += "| Estado: " + (evento.getEstado() ? "Activo" : "Cancelado") + "\n";
            info += "\n-----------------------------\n";
            info += "\n";
        }

        return info;
    }

}
