package com.eVida.Conexion;

import java.io.IOException;

import com.eVida.Conexion.Servidor;

public class mainServidor {

    public static void main(String[] args) throws IOException {
        Servidor serv = new Servidor();
        System.out.println("iniciado el servidor y a la escucha \n");
        serv.startOver();
    }

    public void startUp() throws IOException {
        Thread prueba = new Thread() {
            @Override
            public void run() {
                Servidor serv;
                try {
                    serv = new Servidor();
                    System.out.println("iniciado el servidor y a la escucha \n");
                    serv.startOver();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        prueba.start();
    }

}
