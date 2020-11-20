package com.eVida.Ventanas;

//https://stackoverflow.com/questions/21375255/jpanel-positions-and-sizes-changes-according-to-screensize
//http://www.chuidiang.org/java/layout/BorderLayout.php
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import com.eVida.Componentes.menuSuperior;
import com.eVida.Componentes.Paneles.panelTitulo;

public class venPrincipal {

    /**
     * PetProject
     */
    private JFrame vP;
    private Thread hiloPrincipal;

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

                JPanel pT = new panelTitulo();
                vP.add(pT , BorderLayout.PAGE_START);

                vP.setJMenuBar(menu);
                vP.setVisible(true);
            }

        };
        hiloPrincipal.start();
        
        
    }
    
}
