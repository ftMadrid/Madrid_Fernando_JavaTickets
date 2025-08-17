package javatickets.eventos;

import java.util.ArrayList;
import javatickets.utilidades.Enums;

public class Deportivo extends EventsManager{
    
    private final Enums.TipoDeportes tipo;
    private String equipo1;
    private String equipo2;
    
    public ArrayList<String> jugadores1 = new ArrayList<>();
    public ArrayList<String> jugadores2 = new ArrayList<>();
    
    public Deportivo(int codigo, String titulo, String descripcion, double renta, int cantidadGente, int day, int month, int year, Enums.TipoDeportes tipo, String equipo1, String equipo2){
        super(codigo, titulo, descripcion, renta, cantidadGente, day, month, year);
        this.tipo = tipo;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }
    
    public void setNombreEquipos(String equipo1, String equipo2){
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }
    
    public String getEquipo1() {
        return equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }
    
    public ArrayList<String> getJugadores1() {
        return jugadores1;
    }

    public void setJugadores1(ArrayList<String> jugadores1) {
        this.jugadores1 = jugadores1;
    }

    public ArrayList<String> getJugadores2() {
        return jugadores2;
    }

    public void setJugadores2(ArrayList<String> jugadores2) {
        this.jugadores2 = jugadores2;
    }
    
    public String getListadoJugadores() {
        
        if(jugadores1.isEmpty() && jugadores2.isEmpty()){
            return "";
        }
        
        String info = "";
        
        info += "Integrantes del "+equipo1+": \n";
        info += "\n";
        for(String jugador : jugadores1) {
            info += "| "+jugador+"\n";
        }
        
        info += "\nIntegrantes del "+equipo2+": \n";
        info += "\n";
        for(String jugador : jugadores2) {
            info += "| "+jugador+"\n";
        }
        
        return info;
        
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