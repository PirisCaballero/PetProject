package com.conexion.Conexion;

import java.io.IOException;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.persona;

public class mainCliente {

    public static void main(String[] args) throws IOException {
        Cliente cli1 = new Cliente("1002");
        persona p = new persona("elena", "Alonso Porto", "00000011", "elena.alonso@opendeusto.es", "pusssyHelen",
                "Helenlamejor1!");
        cli1.registrarUsuario(p);
    }

}
