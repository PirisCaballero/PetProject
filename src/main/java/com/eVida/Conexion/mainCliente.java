package com.eVida.Conexion;

import java.io.IOException;

import com.eVida.Conexion.Cliente;

public class mainCliente {

    public static void main(String[] args) throws IOException {
        Cliente cli = new Cliente();
        System.out.println("iniciando el cliente \n");
        cli.startCliente();
    }

}
