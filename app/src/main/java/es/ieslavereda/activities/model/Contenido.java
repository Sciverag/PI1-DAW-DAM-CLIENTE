package es.ieslavereda.activities.model;

import java.io.Serializable;
import java.util.Date;

public abstract class Contenido implements Serializable {
    public String titulo, descripcion, actores, duracion, director;
    public Date fechaEstreno;
    public int puntuacion, puntuacioMedia;
    public String imagen;

    public Contenido(String titulo, String descripcion, String actores, String duracion, String director, Date fechaEstreno, int puntuacion, int puntuacioMedia, String imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.actores = actores;
        this.duracion = duracion;
        this.director = director;
        this.fechaEstreno = fechaEstreno;
        this.puntuacion = puntuacion;
        this.puntuacioMedia = puntuacioMedia;
        this.imagen = imagen;
    }
}
