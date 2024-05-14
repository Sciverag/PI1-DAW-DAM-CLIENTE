package es.ieslavereda.activities.model;

// Class obtained from https://json2csharp.com/code-converters/json-to-pojo
// and modified by adding Serializable interface

import es.ieslavereda.activities.model.usuario.Usuario;

import java.io.Serializable;
import java.util.ArrayList;

public class Root implements Serializable {

    public ArrayList<Contenido> list;
    public Usuario usuario;



}

