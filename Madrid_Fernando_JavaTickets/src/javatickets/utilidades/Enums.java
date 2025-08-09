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
    
    public enum TipoEventos {
        
        DEPORTIVO("Deportivo"),
        MUSICAL("Musical"),
        RELIGIOSO("Religioso");
        
        private final String nombre;
        
        TipoEventos(String nombre){
            this.nombre = nombre;
        }
        
        @Override
        public String toString(){
            return nombre;
        }
    }
    
    public enum TipoDeportes {
        
        FUTBOL("Futbol"),
        TENIS("Tenis"),
        RUGBY("Rugby"),
        BASEBALL("Baseball");
        
        private final String nombre;
        
        TipoDeportes(String nombre) {
            this.nombre = nombre;
        }
        
        @Override
        public String toString(){
            return nombre;
        }
    }
    
    public enum TipoMusica {
        
        POP("POP"),
        ROCK("Rock"),
        RAP("RAP"),
        CLASICA("Clasica"),
        REGGEATON("Reggeaton"),
        OTRP("Otro");
        
        private final String nombre;
        
        TipoMusica(String nombre) {
            this.nombre = nombre;
        }
        
        @Override
        public String toString(){
            return nombre;
        }
    }
}
