package com.conexion.Conexion;

import java.io.IOException;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.animal;
import com.conexion.Recursos.persona;

public class mainCliente {

    public static void main(String[] args) throws IOException {
        Cliente cli1 = new Cliente("1010");
        // cli1.verificarUsuario("aitoooor98", "root");
        // System.out.println(cli1.getCellId("razasPerros", "Beagle"));
        // persona p = cli1.getPersona("aitoooor98", "root");
        // p.toString();
        // animal a = new animal("pp", "pop", "tip", "9", "O", "22/22/22");
        // cli1.agregarAnimal(a);
        animal a = cli1.getAnimal("12");
        System.out.println(a.toString());
    }

}
