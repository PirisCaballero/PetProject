package com.eVida.Conexion;

import java.io.DataOutputStream;
import java.io.IOException;

public class Cliente extends conexion {

    public Cliente() throws IOException {
        super("cliente");
    }

    public void startCliente() {
        try {
            salidaServidor = new DataOutputStream(sc.getOutputStream());
            for (int i = 0; i < 2; i++) {
                salidaServidor.writeUTF("Ests es el mensaje numero: " + i + 1 + "\n");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();//rastreo del error
        }
    }

}
