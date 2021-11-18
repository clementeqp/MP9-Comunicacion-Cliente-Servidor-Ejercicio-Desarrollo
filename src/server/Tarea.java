package server;

public class Tarea {

    // atributos descripcion y estado
    private String descripcion;
    private String estado;

    //constructor
    public Tarea(String descripcion, String estado) {
        this.descripcion = descripcion;
        this.estado = estado;
    }

    //getters y setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //toString
    @Override
    public String toString() {
        return " descripcion = " + descripcion + ", estado = " + estado + '}';
    }
}


// Apuntes, pdf y videtutorias Ilerna Programacion de servicios y procesos 2ºDAM
//https://www.programarya.com/Cursos-Avanzados/Java/Sockets