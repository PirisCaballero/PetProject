package com.eVida.Componentes.Paneles;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class panelLateralIzquierdo extends JPanel {

    /**
     * Pet Project
     */
    private static final long serialVersionUID = 1L;
    Font fuenteLabel = new Font("Times New Roman ", Font.PLAIN, 18);

    public panelLateralIzquierdo() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createTitledBorder("Panel Oeste"));
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new FlowLayout());

        JLabel titulo = new JLabel();
        titulo.setText("Navegación");
        titulo.setFont(fuenteLabel);

        JButton inicio = new JButton("Inicio");
        JButton sensores = new JButton("Sensores");
        JButton animales = new JButton("Animales");

        panelPrincipal.add(titulo, BorderLayout.NORTH);
        // panelPrincipal.add(inicio);
        // panelPrincipal.add(sensores);
        // panelPrincipal.add(animales);
        this.add(panelPrincipal, BorderLayout.CENTER);
    }

}
