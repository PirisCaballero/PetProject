package com.eVida.Conexion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente extends conexion {
    public int cod;

    public Cliente(int codigo) throws IOException {
        super("cliente");
        this.cod = codigo;
    }

    public void startCliente() {
        try {
            salidaServidor = new DataOutputStream(sc.getOutputStream());
            salidaServidor.write(this.cod);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String mensaje = entrada.readLine();
            System.out.println(mensaje);
            sc.close();

        } catch (Exception e) {
            System.out.println(e + "cl");
            e.printStackTrace();// rastreo del error
        }
    }

    public void verificarUsuario() {
        try {
            salidaServidor = new DataOutputStream(sc.getOutputStream());
            System.out.println("pppp");
            salidaServidor.writeUTF(this.cod + "|" + "aitoooor98,root,\n");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String mensaje = entrada.readLine();
            System.out.println(mensaje);
            sc.close();
        } catch (Exception e) {
            System.out.println(e + "cl");
            e.printStackTrace();
        }
    }

}
