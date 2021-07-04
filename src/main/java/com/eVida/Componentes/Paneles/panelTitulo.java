package com.eVida.Componentes.Paneles;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import com.eVida.Ventanas.venPrincipal;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

public class panelTitulo extends JPanel {

    /**
     * PetProject
     */
    private static final long serialVersionUID = 1L;
    private Font fuenteLabel;
    private Font fuenteLabel2;
    private Thread componentes;

    public panelTitulo() {

        setName("panelTitulo");
        this.setSize(venPrincipal.getVp().getWidth(), 150);
        this.setBackground(Color.white);
        // this.setBorder(BorderFactory.createTitledBorder("Panel Norte"));
        setLayout(new BorderLayout());

        componentes = new Thread() {
            @Override
            public void run() {

                fuenteLabel = new Font("Times New Roman", Font.PLAIN, 40);
                fuenteLabel2 = new Font("Times New Roman ", Font.PLAIN, 20);

                JLabel logo = new JLabel("");
                Icon icon = new ImageIcon("src/main/java/com/eVida/Recursos/img/logo_evida_2.png");
                logo.setIcon(icon);
                logo.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

                JLabel logoEvida = new JLabel();
                // Icon icon2 = new
                // ImageIcon("src/main/java/com/eVida/Recursos/img/eVida-logo-final.png");
                // logoEvida.setIcon(icon2);
                logoEvida.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

                add(logo, BorderLayout.WEST);
                add(logoEvida, BorderLayout.EAST);
                repaint();
            }
        };
        componentes.start();

    }

}
