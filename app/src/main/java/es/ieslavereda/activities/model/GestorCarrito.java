package es.ieslavereda.activities.model;

import java.util.ArrayList;
import java.util.List;

public class GestorCarrito {
    private static GestorCarrito instance;
    private List<Contenido> contenidoCarrito;

    private GestorCarrito() {
        contenidoCarrito = new ArrayList<>();
    }

    public static synchronized GestorCarrito getInstance() {
        if (instance == null) {
            instance = new GestorCarrito();
        }
        return instance;
    }

    public void addProduct(Contenido product) {
        contenidoCarrito.add(product);
    }

    public List<Contenido> obtenerCarrito() {
        return contenidoCarrito;
    }

    public void limpiarCarrito() {
        contenidoCarrito.clear();
    }
}

