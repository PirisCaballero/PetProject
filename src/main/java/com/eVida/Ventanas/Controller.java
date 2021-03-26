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
import javax.swing.plaf.synth.SynthScrollPaneUI;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.persona;
import com.eVida.Componentes.Paneles.panelSesionIniciada;
import com.eVida.Ventanas.Lecturas.venPulso;

public class Controller {

    private static HashMap<String, JPanel> arrayPaneles;
    private static venPulso vPl;
    private static venInicio vI;
    private static venRegistro vR;
    private static panelSesionIniciada pSI;
    private static FileWriter file;
    private static PrintWriter pw;
    private static File archivo = null;
    private static FileReader fr = null;
    private static BufferedReader br = null;
    private static venMascotas vM;

    public static void init() {
        arrayPaneles = new HashMap<String, JPanel>();
        vPl = new venPulso();
        vI = new venInicio();
        pSI = new panelSesionIniciada();
        vR = new venRegistro();
        vM = new venMascotas();

        arrayPaneles.put(vPl.getName(), vPl);
        arrayPaneles.put(vI.getName(), vI);
        arrayPaneles.put(pSI.getName(), pSI);
        arrayPaneles.put(vR.getName(), vR);
        arrayPaneles.put(vM.getName(), vM);
        if (Controller.verificarSesionIniciada()) {
            Controller.panelSwitch("venSesionIniciada");
        } else {
            Controller.panelSwitch("venInicio");
        }
        Thread actualiza = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int i = venPrincipal.getPanelCentral().getComponentCount();
                    if (i == 1) {
                        venPrincipal.getPanelCentral().getComponent(0).repaint();
                    }
                }
            }
        };
        actualiza.start();
    }

    public static void panelSwitch(String panelName) {
        if (panelName.equals("venPulso")) {
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
        } else if (panelName.equals("venInicio")) {
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
        } else if (panelName.equals("venSesionIniciada")) {
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
        } else if (panelName.equals("venRegistro")) {
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
        } else if (panelName.equals("venMascotas")) {
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
        }
    }

    public static boolean guardarSesion(String apodo, String contrasenia) {
        String url = "src/main/java/com/eVida/Data/" + "PetProject.txt";
        try {
            file = new FileWriter(url);
            pw = new PrintWriter(file);
            pw.print(1 + "," + apodo + "," + contrasenia);
            pw.close();
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
            linea = br.readLine();
            if (linea != null && linea != "" && linea.charAt(0) == '1') {
                List<String> dataUsuario = Arrays.asList(linea.split(","));
                Cliente cl = new Cliente("1003");
                persona p = cl.getPersona(dataUsuario.get(1), dataUsuario.get(2));
                venPrincipal.Usuario = p;
                venGenerica.inicio = true;
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return false;
        }
    }

    public static void cerrarSesion() {
        try {
            String url = "src/main/java/com/eVida/Data/" + "PetProject.txt";
            file = new FileWriter(url);
            pw = new PrintWriter(file);
            pw.print("");
            pw.close();
            venGenerica.inicio = false;
            Controller.panelSwitch("venInicio");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
