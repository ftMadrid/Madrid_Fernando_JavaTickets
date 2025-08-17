package javatickets.eventos;

import javatickets.utilidades.Enums;

public class Religioso extends EventsManager{
    
    private int convertidos = 0;

    public int getConvertidos() {
        return convertidos;
    }

    public void setConvertidos(int convertidos) {
        this.convertidos = convertidos;
    }
    
    public Religioso(int codigo, String titulo, String descripcion, double renta, int cantidadGente, int day, int month, int year){
        super(codigo, titulo, descripcion, (renta+2000), cantidadGente, day, month, year);
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
