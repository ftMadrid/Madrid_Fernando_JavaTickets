package javatickets.eventos;

import java.util.ArrayList;
import javatickets.utilidades.Enums;

public class Musical extends EventsManager{
    
    private Enums.TipoMusica tipo;
    private ArrayList<String> integrantes = new ArrayList<>();
    
    public Musical(int codigo, String titulo, String descripcion, double renta, int cantidadGente, int day, int month, int year, Enums.TipoMusica tipo){
        super(codigo, titulo, descripcion, (renta+(renta*0.3)), cantidadGente, day, month, year);
        this.tipo = tipo;
    }
    
    public ArrayList<String> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(ArrayList<String> integrantes) {
        this.integrantes = integrantes;
    }
    
    public String getListaIntegrantes() {
        
        if(integrantes.isEmpty()){
            return "";
        }
        
        String info = "";
        info += "Listado: \n";
        info += "\n";
        for(String listado : integrantes){
            info += "| "+listado+"\n";
        }
        
        return info;
        
    }
    
    @Override
    public Enums.TipoEventos getTipo(){
        return Enums.TipoEventos.MUSICAL;
    }
    
    public Enums.TipoMusica getSubTipo(){
        return tipo;
    }
    
}
