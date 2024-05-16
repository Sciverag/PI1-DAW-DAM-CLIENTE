package es.ieslavereda.activities.model.contenido;

import java.io.Serializable;
import java.util.Date;

import es.ieslavereda.activities.model.Contenido;

public class Pelicula extends Contenido implements Serializable {
    /**
     * La fecha hasta la cual la película está disponible.
     */
    private Date disponible_hasta;

    public Pelicula(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa, Date disponible_hasta) {
        super(id, titulo, descripcion, URL_image, actores, puntMedia, fechaEstreno, duracion_minutos, director, idGenero, idTarifa);
        this.disponible_hasta = disponible_hasta;
    }

    public Date getDisponible_hasta() {
        return disponible_hasta;
    }

    public void setDisponible_hasta(Date disponible_hasta) {
        this.disponible_hasta = disponible_hasta;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "disponible_hasta=" + disponible_hasta +
                '}';
    }
}
