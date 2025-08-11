package javatickets.eventos;

import javatickets.utilidades.Enums;

public class Deportivo extends EventsManager{
    
    private Enums.TipoDeportes tipo;
    
    public Deportivo(int codigo, String titulo, String descripcion, int day, int month, int year, Enums.TipoDeportes tipo){
        super(codigo, titulo, descripcion, day, month, year);
        this.tipo = tipo;
    }
    
    public String getSubTipo(){
        return tipo.toString();
    }
    
}
