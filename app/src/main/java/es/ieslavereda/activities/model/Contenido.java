package es.ieslavereda.activities.model;

import java.io.Serializable;
import java.util.Date;

public class Contenido implements Serializable {
    public String titulo, descripcion, actores, duracion, director;
    public Date fechaEstreno;
    public int puntuacion, puntuacioMedia;
    public String imagen;
}
