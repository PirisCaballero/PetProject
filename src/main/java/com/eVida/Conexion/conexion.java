package com.eVida.Conexion;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class conexion {

    private final String HOST = "35.177.208.214";
    private final int PUERTO = 640;
    protected String mensajeServidor;
    protected ServerSocket ss;
    protected Socket sc;
    protected DataOutputStream salidaServidor, salidaCliente;

    public conexion(String tipo) {
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

}
