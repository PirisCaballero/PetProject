package com.eVida.Ventanas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.persona;
import com.eVida.Componentes.Paneles.panelSesionIniciada;
import com.eVida.Ventanas.Lecturas.venPulso;

public class Controller {

    private static HashMap<String, JPanel> arrayPaneles;
    private static venPulso vPl;
    private static venInicio vI;
    private static panelSesionIniciada pSI;
    private static FileWriter file;
    private static PrintWriter pw;
    private static File archivo = null;
    private static FileReader fr = null;
    private static BufferedReader br = null;

    public static void init() {
        arrayPaneles = new HashMap<String, JPanel>();
        vPl = new venPulso();
        vI = new venInicio();
        pSI = new panelSesionIniciada();

        arrayPaneles.put(vPl.getName(), vPl);
        arrayPaneles.put(vI.getName(), vI);
        arrayPaneles.put(pSI.getName(), pSI);
        if (Controller.verificarSesionIniciada()) {
            Controller.panelSwitch("venSesionIniciada");
        } else {
            Controller.panelSwitch("venInicio");
        }
    }

    public static void panelSwitch(String panelName) {
        if (panelName.equals("venPulso")) {
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
        } else if (panelName.equals("venInicio")) {
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
        } else if (panelName.equals("venSesionIniciada")) {
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
        }
    }

    public static boolean guardarSesion(String apodo, String contrasenia) {
        String url = "src/main/java/com/eVida/Data/" + "PetProject.txt";
        try {
            file = new FileWriter(url);
            pw = new PrintWriter(file);
            pw.println(apodo + "," + contrasenia);
            venGenerica.inicio = true;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return false;
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (Exception e2) {
                    System.out.println(e2);
                    e2.printStackTrace();
                }
            }
        }

    }

    public static boolean verificarSesionIniciada() {
        try {
            archivo = new File("src/main/java/com/eVida/Data/" + "PetProject.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                List<String> dataUsuario = Arrays.asList(linea.split(","));
                Cliente cl = new Cliente("1003");
                persona p = cl.getPersona(dataUsuario.get(0), dataUsuario.get(1));
                venPrincipal.Usuario = p;
            }
            venGenerica.inicio = true;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return false;
        }
    }
}
