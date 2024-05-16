package es.ieslavereda.activities.model;

/**
 * Clase que representa una línea de factura.
 */
public class LineaFactura {

    /**
     * El ID de la línea de factura.
     */
    private int id;

    /**
     * El ID del carro de compra asociado con esta línea de factura.
     */
    private int idCarro;

    /**
     * El ID de la factura a la que pertenece esta línea de factura.
     */
    private int idFactura;

    public LineaFactura(int id, int idCarro, int idFactura) {
        this.id = id;
        this.idCarro = idCarro;
        this.idFactura = idFactura;
    }

    public int getId() {
        return id;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo ID), false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof LineaFactura)) {
            return false;
        }

        LineaFactura lineaFactura = (LineaFactura) object;

        return id == lineaFactura.getId();
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
        return "LineaFactura{" +
                "id=" + id +
                ", idCarro=" + idCarro +
                ", idFactura=" + idFactura +
                '}';
    }
}

