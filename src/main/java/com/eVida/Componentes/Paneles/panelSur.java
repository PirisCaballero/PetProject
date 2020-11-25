package com.eVida.Componentes.Paneles;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.*;

public class panelSur extends JPanel {

    /**
     * Pet Project
     */
    private static final long serialVersionUID = 1L;
    private java.awt.Font fuenteLabel;

    public panelSur() {

        fuenteLabel = new java.awt.Font("Times New Roman ", java.awt.Font.PLAIN, 15);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);
        // this.setBorder(BorderFactory.createTitledBorder("Panel Sur"));

        JLabel finPag = new JLabel("PET PROJECT, eVida");
        finPag.setHorizontalAlignment(JLabel.CENTER);
        // finPag.setBorder(BorderFactory.createLineBorder(Color.green));
        finPag.setForeground(Color.green);
        finPag.setFont(fuenteLabel);

        this.add(finPag, BorderLayout.EAST);

    }

}
