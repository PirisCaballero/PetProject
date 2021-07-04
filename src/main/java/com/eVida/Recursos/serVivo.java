package com.eVida.Recursos;

public class serVivo {

    public int id;
    public String nombre;

    public serVivo() {
    };

    public serVivo(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

}
