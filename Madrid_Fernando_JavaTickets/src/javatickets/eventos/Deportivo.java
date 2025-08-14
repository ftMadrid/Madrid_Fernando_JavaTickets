package javatickets.eventos;

import java.util.ArrayList;
import javatickets.utilidades.Enums;

public class Deportivo extends EventsManager{
    
    private Enums.TipoDeportes tipo;
    private String equipo1 = "";
    private String equipo2 = "";
    
    public static ArrayList<Deportivo> jugadores1 = new ArrayList<>();
    public static ArrayList<Deportivo> jugadores2 = new ArrayList<>();
    
    public Deportivo(int codigo, String titulo, String descripcion, double renta, int cantidadGente, int day, int month, int year, Enums.TipoDeportes tipo){
        super(codigo, titulo, descripcion, renta, cantidadGente, day, month, year);
        this.tipo = tipo;
    }
    
    public void setNombreEquipos(String equipo1, String equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }
    
    public String getEquipo1() {
        return equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }
    
    @Override
    public Enums.TipoEventos getTipo(){
        return Enums.TipoEventos.DEPORTIVO;
    }
    
    @Override
    public Enums.TipoDeportes getSubTipo(){
        return tipo;
    }
    
}