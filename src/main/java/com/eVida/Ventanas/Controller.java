package com.eVida.Ventanas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.plaf.synth.SynthScrollPaneUI;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.persona;
import com.eVida.Componentes.Paneles.panelSesionIniciada;
import com.eVida.Recursos.buffer;
import com.eVida.Ventanas.Lecturas.venGraficas;
import com.eVida.Ventanas.Lecturas.venVerMascotas;

public class Controller {

    private static HashMap<String, venGenerica> arrayPaneles;
    private static venGraficas vPl;
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
    private static venVerMascotas vVM;
    private static ArrayList <venGenerica> paneles;
    protected static ArrayList<String> historico;

    public static void init() {
        //arrayPaneles = new HashMap<String, venGenerica>();
        paneles = new ArrayList<venGenerica>();
        historico = new ArrayList<String>();
        //vPl = new venPulso();
        //vI = new venInicio();
        //pSI = new panelSesionIniciada();
        //vR = new venRegistro();
        //vM = new venMascotas();

        //arrayPaneles.put(vPl.getName(), vPl);
        //arrayPaneles.put(vI.getName(), vI);
        //arrayPaneles.put(pSI.getName(), pSI);
        //arrayPaneles.put(vR.getName(), vR);
        //arrayPaneles.put(vM.getName(), vM);
        if (Controller.verificarSesionIniciada()) {
            Controller.panelSwitch("venSesionIniciada");
        } else {
            Controller.panelSwitch("venInicio");
        }
    }

    public static void panelSwitch(String panelName) {
        if (panelName.equals("venGraficas")) {

            paneles.clear();
            vPl = new venGraficas(buffer.anim);
            System.out.println(venPrincipal.addComponent(vPl));
            paneles.add(vPl);
            historico.add(vPl.getName());
            
        } else if (panelName.equals("venInicio")) {

            paneles.clear();
            vI = new venInicio();
            System.out.println(venPrincipal.addComponent(vI));
            paneles.add(pSI);
            historico.add(vI.getName());

        } else if (panelName.equals("venSesionIniciada")) {

            paneles.clear();
            pSI = new panelSesionIniciada();
            System.out.println(venPrincipal.addComponent(pSI));
            paneles.add(pSI);
            historico.add(pSI.getName());

        } else if (panelName.equals("venRegistro")) {

            paneles.clear();
            vR = new venRegistro();
            System.out.println(venPrincipal.addComponent(vR));
            paneles.add(vR);    
            historico.add(vR.getName());    
    
        } else if (panelName.equals("venMascotas")) {

            paneles.clear();
            vM = new venMascotas();
            System.out.println(venPrincipal.addComponent(vM));
            paneles.add(vM);
            historico.add(vM.getName());

        } else if (panelName.equals("venUsuario")) {
            
            paneles.clear();
            vU = new venUsuario(venPrincipal.Usuario);
            System.out.println(venPrincipal.addComponent(vU));
            paneles.add(vU);
            historico.add(vU.getName());

        } else if (panelName.equals("venAgregarMascota")) {

            paneles.clear();
            vAM = new venAgregarMascota(venPrincipal.Usuario);
            System.out.println(venPrincipal.addComponent(vAM));
            paneles.add(vAM);
            historico.add(vAM.getName());

        } else if (panelName.equals("venVerMascotas")) {
            
            paneles.clear();
            vVM = new venVerMascotas(venPrincipal.Usuario);
            System.out.println(venPrincipal.addComponent(vVM));
            paneles.add(vVM);
            historico.add(vVM.getName());
        }
    }

    public static void atras(){
        int lastPos = historico.size()-1;
        Controller.panelSwitch(historico.get(lastPos-1));
        historico.remove(lastPos-1);
    }

    public static void adelante(){


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
            System.out.println("Sesion cerrasa ");
            Controller.panelSwitch("venInicio");
            // arrayPaneles.get("venUsuario") = new venUsuario();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void setData() {
        
    }
}
