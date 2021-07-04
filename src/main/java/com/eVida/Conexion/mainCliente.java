package com.eVida.Conexion;

import java.io.IOException;

import com.eVida.Conexion.Cliente;

public class mainCliente {

    public static void main(String[] args) throws IOException {
        Thread servidor = new Thread() {
            @Override
            public void run() {
                mainServidor mS = new mainServidor();
                try {
                    mS.startUp();
                } catch (IOException e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
        };
        // servidor.start();
        Cliente cli1 = new Cliente(10);
        cli1.startCliente();

        Cliente cli2 = new Cliente(20);
        cli2.startCliente();
    }

}
