package javatickets.eventos;

public class Religioso extends EventsManager{
    
    public Religioso(int codigo, String titulo, String descripcion, int day, int month, int year){
        super(codigo, titulo, descripcion, day, month, year);
    }
    
    public String getSubTipo(){
        return null;
    }
    
}
