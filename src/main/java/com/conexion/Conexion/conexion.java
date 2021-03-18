package com.conexion.Conexion;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

public class conexion {

    // private final String HOST = "35.176.13.206";
    private final String HOST = "83.213.207.43";
    private final int PUERTO = 3333;
    protected String mensajeServidor;
    protected String mensajeCliente;
    protected ServerSocket ss;
    protected Socket sc;
    protected DataOutputStream salidaServidor, salidaCliente;

    public conexion(String tipo) throws ConnectException {
        if (tipo.equalsIgnoreCase("servidor")) {
            try {

                ss = new ServerSocket(PUERTO); // Se crea el socket para el servidor en el puerto
                sc = new Socket(); // Se crea el socket para el cliente

            } catch (IOException e) {

                System.out.println(e);
                e.printStackTrace();
            }
        } else {

            try {
                sc = new Socket(HOST, PUERTO);

            } catch (IOException e) {
                System.out.println(e);
                e.printStackTrace();
            }

        }
    }

    public String getHost() {
        return this.HOST;
    }

    public int getPort() {
        return this.PUERTO;
    }

}
