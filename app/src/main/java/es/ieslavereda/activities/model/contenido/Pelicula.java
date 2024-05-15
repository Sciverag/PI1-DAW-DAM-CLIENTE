package es.ieslavereda.activities.model.contenido;

import es.ieslavereda.activities.model.Contenido;

import java.io.Serializable;
import java.util.Date;

public class Pelicula extends Contenido implements Serializable {
    public Date disponibleHasta;

    public Pelicula(String titulo, String descripcion, String actores, String duracion, String director, Date fechaEstreno, int puntuacion, int puntuacioMedia, String imagen, Date disponibleHasta) {
        super(titulo, descripcion, actores, duracion, director, fechaEstreno, puntuacion, puntuacioMedia, imagen);
        this.disponibleHasta = disponibleHasta;
    }
}
