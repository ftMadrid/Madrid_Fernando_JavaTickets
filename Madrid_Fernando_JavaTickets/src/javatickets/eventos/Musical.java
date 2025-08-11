package javatickets.eventos;

import javatickets.utilidades.Enums;

public class Musical extends EventsManager{
    
    private Enums.TipoMusica tipo;
    
    public Musical(int codigo, String titulo, String descripcion, int day, int month, int year, Enums.TipoMusica tipo){
        super(codigo, titulo, descripcion, day, month, year);
        this.tipo = tipo;
    }
    
    public String getSubTipo(){
        return tipo.toString();
    }
    
}
