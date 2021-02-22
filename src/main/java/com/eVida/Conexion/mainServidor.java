package com.eVida.Conexion;

import java.io.IOException;

import com.eVida.Conexion.Servidor;

public class mainServidor {

    public static void main(String[] args) throws IOException {
        Servidor serv = new Servidor();
        System.out.println("iniciado el servidor y a la escucha \n");
        serv.startOver();
    }

}
