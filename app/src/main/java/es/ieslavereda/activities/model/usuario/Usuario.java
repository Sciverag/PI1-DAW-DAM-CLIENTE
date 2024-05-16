package es.ieslavereda.activities.model.usuario;

import java.util.Date;

public class Usuario {
    private String nombreUsuario, nombre, apellido, email, contrasenya, domicilio;
    private int CP, num_tarjeta;
    private Date fechaNacimiento;
    private String url_imagen;

    public Usuario(String nombreUsuario, String nombre, String apellido, String email, String contrasenya, String domicilio, int CP, int num_tarjeta, Date fechaNacimiento, String url_imagen) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenya = contrasenya;
        this.domicilio = domicilio;
        this.CP = CP;
        this.num_tarjeta = num_tarjeta;
        this.fechaNacimiento = fechaNacimiento;
        this.url_imagen = url_imagen;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public int getCP() {
        return CP;
    }

    public int getNum_tarjeta() {
        return num_tarjeta;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public void setNum_tarjeta(int num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
}
