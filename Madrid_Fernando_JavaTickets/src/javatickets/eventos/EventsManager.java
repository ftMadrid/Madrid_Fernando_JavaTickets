package javatickets.eventos;

import java.util.ArrayList;
import java.util.Calendar;
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

    public EventsManager(int codigo, String titulo, String descripcion, double renta, int cantidadGente, int day, int month, int year) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.renta = renta;
        this.cantidadGente = cantidadGente;
        estado = true;
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
    
    public static void editarEvento(EventsManager target, String titulo, String descripcion, double renta, int cantidadGente, int day, int month, int year) {

        int indice = eventos.indexOf(target);
        if (indice == -1) {
            return;
        }

        EventsManager editado = null;

        switch (target.getTipo()) {
            case DEPORTIVO:
                Deportivo depTarget = (Deportivo) target;
                editado = new Deportivo(target.getCodigo(), titulo, descripcion, renta, cantidadGente, day, month, year, (Enums.TipoDeportes) target.getSubTipo(), depTarget.getEquipo1(), depTarget.getEquipo2());
                break;
            case MUSICAL:
                editado = new Musical(target.getCodigo(), titulo, descripcion, renta, cantidadGente, day, month, year, (Enums.TipoMusica) target.getSubTipo());
                break;
            case RELIGIOSO:
                editado = new Religioso(target.getCodigo(), titulo, descripcion, renta, cantidadGente, day, month, year);
                break;
        }

        eventos.set(indice, editado);
    }
    
    public static void eliminarEvento(EventsManager e) {
        eventosCancelados.add(e);
        e.setEstado(false);
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

    public String getDescripcion() {
        return descripcion;
    }

    public Calendar getFechaEvento() {
        return fechaEvento;
    }

    public double getRenta() {
        return renta;
    }
    
    public int getCantidadGente(){
        return cantidadGente;
    }
    
    public boolean getEstado() {
        return estado;
    }
    
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    
    public void setIndemnizacion(double monto) {
        indemnizacion = monto;
    }
    
    public double getIndemnizacion() {
        return indemnizacion;
    }

}
