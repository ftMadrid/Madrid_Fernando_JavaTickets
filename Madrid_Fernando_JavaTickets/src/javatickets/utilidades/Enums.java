package javatickets.utilidades;

public class Enums {
    
    public enum TipoUsuarios {
        
        ADMINISTRADOR("Administrador"),
        CONTENIDO("Contenido"),
        LIMITADO("Limitado");
        
        private final String nombre;
        
        TipoUsuarios(String nombre) {
            this.nombre = nombre;
        }
        
        @Override
        public String toString(){
            return nombre;
        }
        
    }
    
}
