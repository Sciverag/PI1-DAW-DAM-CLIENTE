package es.ieslavereda.activities.model.contenido;

import es.ieslavereda.activities.model.Contenido;

import java.io.Serializable;
import java.util.Date;

public class Capitulo extends Contenido implements Serializable {
    public int temporada;

    public Capitulo(String titulo, String descripcion, String actores, String duracion, String director, Date fechaEstreno, int puntuacion, int puntuacioMedia, String imagen, int temporada) {
        super(titulo, descripcion, actores, duracion, director, fechaEstreno, puntuacion, puntuacioMedia, imagen);
        this.temporada = temporada;
    }
}
