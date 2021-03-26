package com.conexion.Conexion;

import java.io.IOException;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.persona;

public class mainCliente {

    public static void main(String[] args) throws IOException {
        Cliente cli1 = new Cliente("1004");
        // cli1.verificarUsuario("aitoooor98", "root");
        cli1.getRazasPerros();
    }

}
