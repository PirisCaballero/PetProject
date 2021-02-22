package com.eVida.Conexion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Servidor extends conexion {

    public Servidor() throws IOException {
        super("servidor");
    }

    public void startOver() {

        try {

            System.out.println("Esperando...");
            sc = ss.accept(); // Acepta el socket y se queda a la espera de una conexion
            System.out.println("Cliente en linea...");
            salidaCliente = new DataOutputStream(sc.getOutputStream());
            salidaCliente.writeUTF("Peticion recibida y aceptada");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            while ((mensajeServidor = entrada.readLine()) != null) {
                System.out.println(mensajeServidor);
            }
            System.out.println("Fin de la conexion");
            ss.close();//

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
