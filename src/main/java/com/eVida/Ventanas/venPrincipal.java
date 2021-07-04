package com.eVida.Ventanas;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
//https://stackoverflow.com/questions/21375255/jpanel-positions-and-sizes-changes-according-to-screensize
//http://www.chuidiang.org/java/layout/BorderLayout.php
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import com.conexion.Recursos.persona;
import com.eVida.Componentes.menuSuperior;
import com.eVida.Componentes.Paneles.panelCentral;
import com.eVida.Componentes.Paneles.panelLateralDerecho;
import com.eVida.Componentes.Paneles.panelLateralIzquierdo;
import com.eVida.Componentes.Paneles.panelSur;
import com.eVida.Componentes.Paneles.panelTitulo;

public class venPrincipal {

    /**
     * PetProject
     */
    private static JFrame vP;
    private Thread hiloPrincipal;
    private static panelCentral pC;
    public static persona Usuario = new persona();

    public venPrincipal() {
        vP = new JFrame();
        vP.setTitle("Pet Project");
        vP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vP.setResizable(true);
        vP.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vP.setUndecorated(true);
        // vP.setSize(800, 720);
        vP.setLocationRelativeTo(null);
        vP.setLayout(new BorderLayout());
        vP.setLocationRelativeTo(null);

        hiloPrincipal = new Thread() {
            @Override
            public void run() {
                menuSuperior menu = new menuSuperior();
                menu.setBackground(Color.white);

                panelTitulo pT = new panelTitulo();
                pT.setVisible(true);
                pT.setOpaque(true);
                vP.add(pT, BorderLayout.PAGE_START);
                panelSur pS = new panelSur();
                vP.add(pS, BorderLayout.PAGE_END);
                pC = new panelCentral();
                pC.setLayout(null);
                vP.add(pC, BorderLayout.CENTER);
                vP.setJMenuBar(menu);
                vP.setVisible(true);
                Controller.init();
                vP.repaint();
                System.out.println(pT.getComponentCount());

            }

        };
        hiloPrincipal.start();

    }

    public static panelCentral getPanelCentral() {
        return pC;
    }

    public static JFrame getVp() {
        return vP;
    }

    public static boolean addComponent(JComponent c) {
        pC.removeAll();
        try {
            pC.add(c);
            pC.getComponent(0).repaint();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
