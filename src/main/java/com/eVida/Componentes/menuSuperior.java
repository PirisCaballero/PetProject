package com.eVida.Componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

import com.eVida.Ventanas.venPrincipal;

import main.java.com.eVida.Ventanas.Controller;
import main.java.com.eVida.Ventanas.venGenerica;
import main.java.com.eVida.Ventanas.Lecturas.venPulso;

import java.awt.event.*;

public class menuSuperior extends JMenuBar {

    /**
     * Pet Project
     */
    private static final long serialVersionUID = 1L;
    private Font fuenteMenu;
    private Font fuenteMenu2;

    public menuSuperior() {

        fuenteMenu = new Font("Times New Roman", Font.PLAIN, 17);
        fuenteMenu2 = new Font("Times New Roman ", Font.PLAIN, 14);
        JMenu inicio = new JMenu("Inicio");
        inicio.setFont(fuenteMenu);
        inicio.setBackground(Color.white);
        this.add(inicio);
        JMenuItem salir = new JMenuItem("Salir");
        salir.setFont(fuenteMenu2);
        inicio.add(salir);
        /* ************************* */

        JMenu lecturas = new JMenu("Lecturas");
        lecturas.setBackground(Color.white);
        lecturas.setFont(fuenteMenu);
        this.add(lecturas);
        JMenuItem Lsensor = new JMenuItem("Lectura del sensor");
        Lsensor.setFont(fuenteMenu2);
        lecturas.add(Lsensor);
        JMenuItem Lpulso = new JMenuItem("Lectura del pulso");
        Lpulso.setFont(fuenteMenu2);
        lecturas.add(Lpulso);
        JMenuItem Laceleraciones = new JMenuItem("Lectura de las aceleraciones");
        Laceleraciones.setFont(fuenteMenu2);
        lecturas.add(Laceleraciones);
        JMenuItem Lmovimiento = new JMenuItem("Lectura del movimiento");
        Lmovimiento.setFont(fuenteMenu2);
        lecturas.add(Lmovimiento);

        ///////////////

        ActionListener pulsoL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller.panelSwitch("venPulso");
            }
        };
        Lpulso.addActionListener(pulsoL);

        /* ************************* */

        JMenu animales = new JMenu("Animales");
        animales.setBackground(Color.white);
        animales.setFont(fuenteMenu);
        this.add(animales);
        JMenuItem Aagregar = new JMenuItem("Agregar animal");
        Aagregar.setFont(fuenteMenu2);
        animales.add(Aagregar);
        JMenuItem Aver = new JMenuItem("Ver animal");
        Aver.setFont(fuenteMenu2);
        animales.add(Aver);
        JMenuItem Aeliminar = new JMenuItem("Eliminar animal");
        Aeliminar.setFont(fuenteMenu2);
        animales.add(Aeliminar);
        /* ************************* */

        JMenu quienesSomos = new JMenu("Quienes somos");
        quienesSomos.setFont(fuenteMenu);
        this.add(quienesSomos);
        /* ************************* */

        ActionListener salirL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        salir.addActionListener(salirL);

    }

}
