package es.ieslavereda.activities.model;

/**
 * Clase que representa una tarifa.
 */
public class Tarifa {

    /**
     * El código de la tarifa.
     */
    private int codigo;

    /**
     * El precio de la tarifa.
     */
    private Double precio;

    public Tarifa(int codigo, Double precio) {
        this.codigo = codigo;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo código de tarifa), false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Tarifa)) {
            return false;
        }

        Tarifa tarifa = (Tarifa) object;
        return codigo == tarifa.getCodigo();
    }

    /**
     * Calcula el código hash de este objeto.
     * @return El código hash del objeto basado en su código.
     */
    @Override
    public int hashCode() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Tarifa{" +
                "codigo=" + codigo +
                ", precio=" + precio +
                '}';
    }
}

