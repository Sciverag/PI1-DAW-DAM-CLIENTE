package es.ieslavereda.activities.model;

/**
 * Clase que representa un género.
 */
public class Genero {
    /**
     * El ID del género.
     */
    private int id;

    /**
     * El tipo de género.
     */
    private String tipo;

    public Genero(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo ID), false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Genero)) {
            return false;
        }
        Genero genero = (Genero) object;

        return id == genero.getId();
    }

    /**
     * Calcula el código hash de este objeto.
     * @return El código hash del objeto basado en su ID.
     */
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }

}

