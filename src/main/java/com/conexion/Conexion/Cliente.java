package com.conexion.Conexion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

import com.conexion.Recursos.persona;

public class Cliente extends conexion {
    public String cod;

    public Cliente(String codigo) throws IOException {
        super("cliente");
        this.cod = codigo;
    }

    public boolean verificarUsuario(String apodo, String contrasenia) {
        try {
            apodo = apodo.replaceAll("\\s*", "");
            apodo = apodo.trim();
            contrasenia = contrasenia.replaceAll("\\s*", "");
            contrasenia = contrasenia.trim();

            salidaServidor = new DataOutputStream(sc.getOutputStream());
            salidaServidor.writeUTF(this.cod + "-" + apodo + "," + contrasenia + "\n");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String mensaje = entrada.readLine();
            System.out.println(mensaje);
            mensaje = mensaje.replaceAll("\\s*", "");
            mensaje = mensaje.trim();
            if (mensaje.equals("true")) {
                sc.close();
                return true;
            } else {
                sc.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println(e + "cl");
            e.printStackTrace();
            return false;
        }
    }

    public void registrarUsuario(persona p) {
        try {
            salidaServidor = new DataOutputStream(sc.getOutputStream());
            salidaServidor.writeUTF(this.cod + "-" + p.getNombre() + "," + p.getApellidos() + "," + p.getDni() + ","
                    + p.getCorreo() + "," + p.getApodo() + "," + p.getContrasenia() + "\n");
            salidaServidor.flush();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String mensaje = entrada.readLine();
            System.out.println(mensaje);
            sc.close();
        } catch (Exception e) {
            System.out.println(e + "cl");
            e.printStackTrace();
            try {
                sc.close();
            } catch (IOException e2) {
                System.out.println(e2);
                e.printStackTrace();
            }
        }
    }

    public persona getPersona(String apodo, String contrasenia) {
        if (apodo != "" && contrasenia != "") {
            persona p;
            try {
                salidaServidor = new DataOutputStream(sc.getOutputStream());
                salidaServidor = new DataOutputStream(sc.getOutputStream());
                salidaServidor.writeUTF(this.cod + "-" + apodo + "," + contrasenia + "\n");
                BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
                String mensaje = entrada.readLine();
                mensaje = mensaje.replaceAll("\\s*", "");
                mensaje = mensaje.trim();
                System.out.println(mensaje);
                List<String> dataUsuario = Arrays.asList(mensaje.split(","));
                p = new persona();
                if (!Character.isDigit(dataUsuario.get(0).charAt(0))) {
                    String id = dataUsuario.get(0).substring(1);
                    p.setId(id);
                } else {
                    p.setId(dataUsuario.get(0));
                }

                p.setNombre(dataUsuario.get(1));
                p.setApellidos(dataUsuario.get(2));
                p.setDni(dataUsuario.get(3));
                p.setCorreo(dataUsuario.get(4));
                p.setApodo(dataUsuario.get(5));
                p.setContrasenia(dataUsuario.get(6));
                return p;
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

}
