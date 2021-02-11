package com.eVida.Ventanas;

import javax.swing.JComponent;
//https://stackoverflow.com/questions/21375255/jpanel-positions-and-sizes-changes-according-to-screensize
//http://www.chuidiang.org/java/layout/BorderLayout.php
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

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
    private JFrame vP;
    private Thread hiloPrincipal;
    private panelCentral pC;

    public venPrincipal() {
        vP = new JFrame();
        vP.setTitle("Pet Project");
        vP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vP.setResizable(false);
        vP.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vP.setUndecorated(true);
        vP.setLayout(new BorderLayout());
        vP.setLocationRelativeTo(null);

        hiloPrincipal = new Thread() {
            @Override
            public void run() {
                System.out.println("El hilo funciona");
                menuSuperior menu = new menuSuperior();
                menu.setBackground(Color.white);

                panelTitulo pT = new panelTitulo();
                vP.add(pT, BorderLayout.PAGE_START);
                panelSur pS = new panelSur();
                vP.add(pS, BorderLayout.PAGE_END);
                panelLateralIzquierdo pLI = new panelLateralIzquierdo();
                vP.add(pLI, BorderLayout.LINE_START);
                panelLateralDerecho pLD = new panelLateralDerecho();
                vP.add(pLD, BorderLayout.LINE_END);
                pC = new panelCentral();
                vP.add(pC, BorderLayout.CENTER);

                vP.setJMenuBar(menu);
                vP.setVisible(true);

                while(true){
                    vP.repaint();
                }
            }

        };
        hiloPrincipal.start();

    }
    public panelCentral getPanelCentral(){
        return this.pC;
    }
    public JFrame getVp(){
        return this.vP;
    }

}
