package javatickets.eventos;

import java.util.ArrayList;
import java.util.Calendar;
import javatickets.usuarios.UserManager;
import javatickets.utilidades.Enums;

public abstract class EventsManager {

    public static ArrayList<EventsManager> eventos = new ArrayList<>();
    public static ArrayList<EventsManager> eventosCancelados = new ArrayList<>();
    public static int cantidadEventos;

    protected int codigo;
    protected String titulo;
    protected String descripcion;
    protected Calendar fechaEvento;
    protected double renta;
    protected int cantidadGente;
    protected boolean estado;
    protected double indemnizacion;
    protected UserManager creador;

    public EventsManager(int codigo, String titulo, String descripcion, double renta, int cantidadGente, int day, int month, int year) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.renta = renta;
        this.cantidadGente = cantidadGente;
        estado = true;
        creador = UserManager.usuarioLogged;
        indemnizacion = 0;
        fechaEvento = Calendar.getInstance();
        fechaEvento.set(year, month, day);
    }

    public static EventsManager buscar(int codigo) {
        return buscarListado(codigo, 0);
    }

    public static EventsManager buscarListado(int codigo, int indice) {
        if (indice >= eventos.size()) {
            return null;
        }

        EventsManager encontrado = eventos.get(indice);

        if (encontrado != null && codigo == encontrado.getCodigo()) {
            return encontrado;
        }

        return buscarListado(codigo, indice + 1);

    }

    public static boolean buscarFecha(int day, int month, int year) {
        return buscarListadoFecha(day, month, year, 0);
    }

    private static boolean buscarListadoFecha(int day, int month, int year, int indice) {
        if (indice >= eventos.size()) {
            return false;
        }

        EventsManager encontrado = eventos.get(indice);
        if (encontrado != null && encontrado.getEstado()) {
            Calendar fecha = encontrado.fechaEvento;
            if (fecha.get(Calendar.DAY_OF_MONTH) == day
                    && fecha.get(Calendar.MONTH) == month
                    && fecha.get(Calendar.YEAR) == year) {
                return true;
            }
        }

        return buscarListadoFecha(day, month, year, indice + 1);
    }

    public static void agregarEvento(EventsManager evento) {
        eventos.add(evento);
        UserManager.usuarioLogged.eventoCreado(evento);
        cantidadEventos++;
    }

    public static void editarEvento(EventsManager target, String titulo, String descripcion, double renta, int cantidadGente, int day, int month, int year) {

        target.setTitulo(titulo);
        target.setDescripcion(descripcion);

        if (target.getRenta() != renta) {
            switch (target.getTipo()) {
                case DEPORTIVO:
                    target.setRenta(renta);
                    break;
                case MUSICAL:
                    target.setRenta(renta * 0.3);
                    break;
                case RELIGIOSO:
                    target.setRenta(renta + 2000);
                    break;
            }
        } else {
            target.setRenta(renta);
        }

        target.setCantidadGente(cantidadGente);
        Calendar nuevaFecha = Calendar.getInstance();
        nuevaFecha.set(year, month, day);
        target.setFechaEvento(nuevaFecha);

    }

    public static void eliminarEvento(EventsManager evento) {
        eventosCancelados.add(evento);
        evento.setEstado(false);
    }

    public abstract Enums.TipoEventos getTipo();

    public abstract Object getSubTipo();

    public static int getCantidadEventos() {
        return cantidadEventos;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Calendar getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Calendar fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public double getRenta() {
        return renta;
    }

    public void setRenta(double renta) {
        this.renta = renta;
    }

    public int getCantidadGente() {
        return cantidadGente;
    }

    public void setCantidadGente(int cantidadGente) {
        this.cantidadGente = cantidadGente;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public UserManager getCreador() {
        return creador;
    }

    public void setIndemnizacion(double monto) {
        indemnizacion = monto;
    }

    public double getIndemnizacion() {
        return indemnizacion;
    }

}
