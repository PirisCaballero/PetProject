package com.eVida.Componentes.Paneles;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class panelLateralDerecho extends JPanel {

    /**
     * Pet Project
     */
    private static final long serialVersionUID = 7476546081972622282L;

    public panelLateralDerecho() {

        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createTitledBorder("Panel Este"));

        JLabel titulo = new JLabel();
        titulo.setText("Navegación");

        this.add(titulo);
    }

}
