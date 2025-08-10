package javatickets.eventos;

import java.util.ArrayList;
import java.util.Calendar;

public class EventsManager {
    
    public static ArrayList<EventsManager> eventos = new ArrayList<>();
    public static int cantidadEventos;
    
    protected int codigo;
    protected String titulo;
    protected String descripcion;
    protected Calendar fechaEvento;
    protected double renta;
    
    public EventsManager(int codigo, String titulo, String descripcion, int day, int month, int year){
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        fechaEvento = Calendar.getInstance();
        fechaEvento.set(year, month, day);
    }
    
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
