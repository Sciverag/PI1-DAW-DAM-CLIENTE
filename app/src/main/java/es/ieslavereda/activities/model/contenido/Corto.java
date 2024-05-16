package es.ieslavereda.activities.model.contenido;

import java.io.Serializable;
import java.util.Date;

import es.ieslavereda.activities.model.Contenido;

public class Corto extends Contenido implements Serializable {

    public Corto(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa) {
        super(id, titulo, descripcion, URL_image, actores, puntMedia, fechaEstreno, duracion_minutos, director, idGenero, idTarifa);
    }

    @Override
    public String toString() {
        return "Corto{}";
    }
}
