package es.ieslavereda.activities.model;

import java.util.Date;

/**
 * Clase abstracta que representa el contenido general.
 * Puede ser extendida para crear diferentes tipos de contenido, como películas o capítulos de series.
 */
public abstract class Contenido {

    /**
     * El ID del contenido.
     */
    private int id;

    /**
     * El título del contenido.
     */
    private String titulo;

    /**
     * La descripción del contenido.
     */
    private String descripcion;

    /**
     * La URL de la imagen asociada con el contenido.
     */
    private String URL_image;

    /**
     * Los actores que participan en el contenido.
     */
    private String actores;

    /**
     * La puntuación media del contenido.
     */
    private float puntMedia;

    /**
     * La fecha de estreno del contenido.
     */
    private Date fechaEstreno;

    /**
     * La duración del contenido en minutos.
     */
    private float duracion_minutos;

    /**
     * El director del contenido.
     */
    private String director;

    /**
     * El ID del género al que pertenece el contenido.
     */
    private int idGenero;

    /**
     * El ID de la tarifa asociada con el contenido.
     */
    private int idTarifa;

    /**
     * La fecha de la última modificación del contenido.
     */
    private Date changedTs;

    public Contenido(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.URL_image = URL_image;
        this.actores = actores;
        this.puntMedia = puntMedia;
        this.fechaEstreno = fechaEstreno;
        this.duracion_minutos = duracion_minutos;
        this.director = director;
        this.idGenero = idGenero;
        this.idTarifa = idTarifa;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getURL_image() {
        return URL_image;
    }

    public String getActores() {
        return actores;
    }

    public float getPuntMedia() {
        return puntMedia;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public float getDuracion_minutos() {
        return duracion_minutos;
    }

    public String getDirector() {
        return director;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public int getIdTarifa() {
        return idTarifa;
    }

    public Date getChangedTs() {
        return changedTs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setURL_image(String URL_image) {
        this.URL_image = URL_image;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public void setPuntMedia(float puntMedia) {
        this.puntMedia = puntMedia;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public void setDuracion_minutos(float duracion_minutos) {
        this.duracion_minutos = duracion_minutos;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public void setChangedTs(Date changedTs) {
        this.changedTs = changedTs;
    }

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo ID), false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Contenido)) {
            return false;
        }
        Contenido contenido = (Contenido) object;

        return id == contenido.getId();
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

