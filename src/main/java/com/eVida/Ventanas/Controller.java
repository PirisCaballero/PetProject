package com.eVida.Ventanas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.plaf.synth.SynthScrollPaneUI;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.persona;
import com.eVida.Componentes.Paneles.panelSesionIniciada;
import com.eVida.Ventanas.Lecturas.venPulso;

public class Controller {

    private static HashMap<String, venGenerica> arrayPaneles;
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
    private static venUsuario vU;
    private static venAgregarMascota vAM;

    public static void init() {
        arrayPaneles = new HashMap<String, venGenerica>();
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
            vU = new venUsuario(venPrincipal.Usuario);
            arrayPaneles.put(vU.getName(), vU);
            vAM = new venAgregarMascota(venPrincipal.Usuario);
            arrayPaneles.put(vAM.getName(), vAM);
        } else {
            Controller.panelSwitch("venInicio");
        }
    }

    public static void panelSwitch(String panelName) {
        if (panelName.equals("venPulso")) {
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
            activarPaneles(panelName);
            desactivarPaneles(panelName);
        } else if (panelName.equals("venInicio")) {
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
            activarPaneles(panelName);
            desactivarPaneles(panelName);
        } else if (panelName.equals("venSesionIniciada")) {
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
            activarPaneles(panelName);
            desactivarPaneles(panelName);
        } else if (panelName.equals("venRegistro")) {
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
            activarPaneles(panelName);
            desactivarPaneles(panelName);
        } else if (panelName.equals("venMascotas")) {
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
            activarPaneles(panelName);
            desactivarPaneles(panelName);
        } else if (panelName.equals("venUsuario")) {
            if (!arrayPaneles.containsKey("venUsuario")) {
                vU = new venUsuario(venPrincipal.Usuario);
                arrayPaneles.put(vU.getName(), vU);
            }
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
            activarPaneles(panelName);
            desactivarPaneles(panelName);
        } else if (panelName.equals("venAgregarMascota")) {
            if (!arrayPaneles.containsKey("venAgregarMascota")) {
                vAM = new venAgregarMascota(venPrincipal.Usuario);
                arrayPaneles.put(vAM.getName(), vAM);
            }
            System.out.println(venPrincipal.addComponent(arrayPaneles.get(panelName)));
            activarPaneles(panelName);
            desactivarPaneles(panelName);
        }
    }

    private static void desactivarPaneles(String nombre) {
        // for (Map.Entry<String, venGenerica> entry : arrayPaneles.entrySet()) {
        // if (!entry.getKey().equals(nombre)) {
        // entry.getValue().setEnabled(false);
        // }
        // System.out.println(entry.getValue().getName() + "---" +
        // entry.getValue().isEnabled());
        // }
    }

    private static void activarPaneles(String nombre) {
        // for (Map.Entry<String, venGenerica> entry : arrayPaneles.entrySet()) {
        // if (entry.getKey().equals(nombre)) {
        // entry.getValue().setEnabled(true);
        // }
        // }
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
