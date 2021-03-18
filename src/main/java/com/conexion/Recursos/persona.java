package com.conexion.Recursos;

public class persona extends serVivo {

    private String apellidos;
    private String dni;
    private String correo;
    private String apodo;
    private String contrasenia;
    private String id;

    public persona() {
    }

    public persona(String nombre, String apellidos, String dni, String correo, String apodo, String contrasenia) {
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo = correo;
        this.apodo = apodo;
        this.contrasenia = contrasenia;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

}
