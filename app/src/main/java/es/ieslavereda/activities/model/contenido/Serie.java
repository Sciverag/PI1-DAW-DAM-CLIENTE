package es.ieslavereda.activities.model.contenido;

import java.util.Date;

/**
 * Clase que representa una serie.
 */
public class Serie {

    /**
     * El ID de la serie.
     */
    private int id;

    /**
     * La fecha hasta la cual la serie está disponible.
     */
    private Date disponible_hasta;

    /**
     * El título de la serie.
     */
    private String titulo;

    /**
     * La URL de la imagen.
     */
    private String url_image;

    /**
     * La descripción de la serie.
     */
    private String descripcion;

    public Serie(int id, Date disponible_hasta, String titulo, String descripcion) {
        this.id = id;
        this.disponible_hasta = disponible_hasta;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public Date getDisponible_hasta() {
        return disponible_hasta;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrl_image() {
        return url_image;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDisponible_hasta(Date disponible_hasta) {
        this.disponible_hasta = disponible_hasta;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo ID), false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Serie)) {
            return false;
        }
        Serie serie = (Serie) object;

        return id == serie.getId();
    }

    /**
     * Calcula el código hash de este objeto.
     * @return El código hash del objeto basado en su ID.
     */
    @Override
    public int hashCode() {
        return id;
    }
}

