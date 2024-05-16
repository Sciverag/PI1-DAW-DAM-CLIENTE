package es.ieslavereda.activities.model;

import java.util.Date;

/**
 * Clase que representa una factura.
 */
public class Factura {

    /**
     * El número de la factura.
     */
    private int numero;

    /**
     * La fecha de emisión de la factura.
     */
    private Date fecha;

    /**
     * El importe base de la factura, sin incluir el IVA.
     */
    private Double importe_base;

    /**
     * El importe del IVA de la factura.
     */
    private Double importe_IVA;

    /**
     * El ID del usuario al que pertenece la factura.
     */
    private int idUsuario;

    public Factura(int numero, Date fecha, Double importe_base, Double importe_IVA, int idUsuario) {
        this.numero = numero;
        this.fecha = fecha;
        this.importe_base = importe_base;
        this.importe_IVA = importe_IVA;
        this.idUsuario = idUsuario;
    }

    public int getNumero() {
        return numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public Double getImporte_base() {
        return importe_base;
    }

    public Double getImporte_IVA() {
        return importe_IVA;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setImporte_base(Double importe_base) {
        this.importe_base = importe_base;
    }

    public void setImporte_IVA(Double importe_IVA) {
        this.importe_IVA = importe_IVA;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo número de factura), false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Factura)) {
            return false;
        }

        Factura factura = (Factura) object;

        return numero == factura.getNumero();
    }

    /**
     * Calcula el código hash de este objeto.
     * @return El código hash del objeto basado en su número de factura.
     */
    @Override
    public int hashCode() {
        return numero;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "numero=" + numero +
                ", fecha=" + fecha +
                ", importe_base=" + importe_base +
                ", importe_IVA=" + importe_IVA +
                ", idUsuario=" + idUsuario +
                '}';
    }
}

