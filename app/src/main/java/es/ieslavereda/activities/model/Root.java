package es.ieslavereda.activities.model;

// Class obtained from https://json2csharp.com/code-converters/json-to-pojo
// and modified by adding Serializable interface

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.activities.model.contenido.Corto;
import es.ieslavereda.activities.model.contenido.Pelicula;
import es.ieslavereda.activities.model.contenido.Serie;
import es.ieslavereda.activities.model.usuario.Usuario;

public class Root implements Serializable {

    public ArrayList listaContenido;
    public List<Serie> series;
    public List<Pelicula> peliculas;
    public List<Corto> cortos;
    public Usuario usuario;
    public boolean existente;

    public ArrayList getListaContenido() {
        return listaContenido;
    }

    public void setCortos(ArrayList<Corto> cortos) {
        this.cortos = cortos;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public void setSeries(ArrayList<Serie> series) {
        this.series = series;
    }

    public void setListaContenido(ArrayList<Contenido> listaContenido) {
        this.listaContenido = listaContenido;
    }

    public boolean isExistente() {
        return existente;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

