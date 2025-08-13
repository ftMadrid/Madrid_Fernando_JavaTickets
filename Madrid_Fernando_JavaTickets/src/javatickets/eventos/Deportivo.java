package javatickets.eventos;

import javatickets.utilidades.Enums;

public class Deportivo extends EventsManager{
    
    private Enums.TipoDeportes tipo;
    
    public Deportivo(int codigo, String titulo, String descripcion, double renta, int cantidadGente, int day, int month, int year, Enums.TipoDeportes tipo){
        super(codigo, titulo, descripcion, renta, cantidadGente, day, month, year);
        this.tipo = tipo;
    }
    
    @Override
    public Enums.TipoEventos getTipo(){
        return Enums.TipoEventos.DEPORTIVO;
    }
    
    public String getSubTipo(){
        return tipo.toString();
    }
    
}