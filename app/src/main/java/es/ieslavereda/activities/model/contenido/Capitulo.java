package es.ieslavereda.activities.model.contenido;

import java.io.Serializable;
import java.sql.Date;

import es.ieslavereda.activities.model.Contenido;

public class Capitulo extends Contenido implements Serializable {
    /**
     * El ID de la serie a la que pertenece el capítulo.
     */
    private int idSerie;

    /**
     * La temporada a la que pertenece el capítulo.
     */
    private int temporada;

    public Capitulo(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa) {
        super(id, titulo, descripcion, URL_image, actores, puntMedia, fechaEstreno, duracion_minutos, director, idGenero, idTarifa);
    }
}
