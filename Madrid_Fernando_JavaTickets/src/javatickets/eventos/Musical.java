package javatickets.eventos;

import javatickets.utilidades.Enums;

public class Musical extends EventsManager{
    
    private Enums.TipoMusica tipo;
    
    public Musical(int codigo, String titulo, String descripcion, double renta, int cantidadGente, int day, int month, int year, Enums.TipoMusica tipo){
        super(codigo, titulo, descripcion, renta, cantidadGente, day, month, year);
        this.tipo = tipo;
    }
    
    @Override
    public Enums.TipoEventos getTipo(){
        return Enums.TipoEventos.MUSICAL;
    }
    
    public String getSubTipo(){
        return tipo.toString();
    }
    
}
