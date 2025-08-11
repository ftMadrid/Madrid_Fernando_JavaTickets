package javatickets.eventos;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class EventsManager {

    public static ArrayList<EventsManager> eventos = new ArrayList<>();
    public static int cantidadEventos;

    protected int codigo;
    protected String titulo;
    protected String descripcion;
    protected Calendar fechaEvento;
    protected double renta;

    public EventsManager(int codigo, String titulo, String descripcion, int day, int month, int year) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
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
        if (encontrado != null) {
            Calendar fecha = encontrado.fechaEvento;
            if (fecha.get(Calendar.DAY_OF_MONTH) == day
                    && fecha.get(Calendar.MONTH) == month
                    && fecha.get(Calendar.YEAR) == year) {
                return true;
            }
        }

        return buscarListadoFecha(day, month, year, indice + 1);
    }
    
    public static void agregarEvento(EventsManager e) {
        eventos.add(e);
        cantidadEventos++;
    }
    
    public abstract String getSubTipo();

    public static int getCantidadEventos() {
        return cantidadEventos;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Calendar getFechaEvento() {
        return fechaEvento;
    }

    public double getRenta() {
        return renta;
    }

}
