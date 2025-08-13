package javatickets.eventos;

public class Religioso extends EventsManager{
    
    public Religioso(int codigo, String titulo, String descripcion, int cantidadGente, int day, int month, int year){
        super(codigo, titulo, descripcion, cantidadGente, day, month, year);
    }
    
    public String getSubTipo(){
        return null;
    }
    
}
