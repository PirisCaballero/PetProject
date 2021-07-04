package com.conexion.Conexion;

import java.io.IOException;
import java.util.ArrayList;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.animal;
import com.conexion.Recursos.persona;

public class mainCliente {

    public static void main(String[] args) throws IOException {
        Cliente cli1 = new Cliente("1011");
        // cli1.verificarUsuario("aitoooor98", "root");
        // System.out.println(cli1.getCellId("razasPerros", "Beagle"));
        // persona p = cli1.getPersona("aitoooor98", "root");
        // p.toString();
        // animal a = new animal("pp", "pop", "tip", "9", "O", "22/22/22");
        // cli1.agregarAnimal(a);
        String codPerro = "5";
        String codPersona = "22 ";
        ArrayList<String> regs = cli1.getMediciones(codPerro, codPersona);
       for(String s : regs){
           System.out.println(s);
       }
    }

}
