package javatickets.eventos;

import javatickets.utilidades.Enums;

public class Religioso extends EventsManager{
    
    public Religioso(int codigo, String titulo, String descripcion, double renta, int cantidadGente, int day, int month, int year){
        super(codigo, titulo, descripcion, renta, cantidadGente, day, month, year);
    }
    
    @Override
    public Enums.TipoEventos getTipo(){
        return Enums.TipoEventos.RELIGIOSO;
    }
    
    @Override
    public String getSubTipo(){
        return null;
    }
    
}
