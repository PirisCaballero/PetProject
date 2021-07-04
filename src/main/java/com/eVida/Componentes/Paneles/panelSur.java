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
        Color col = Color.decode("#1660a9");
        fuenteLabel = new java.awt.Font("Times New Roman ", java.awt.Font.PLAIN, 15);
        this.setLayout(new BorderLayout());
        this.setBackground(col);
        // this.setBorder(BorderFactory.createTitledBorder("Panel Sur"));

        JLabel finPagDch = new JLabel("PET PROJECT, eVida");
        finPagDch.setHorizontalAlignment(JLabel.CENTER);
        finPagDch.setForeground(Color.white);
        finPagDch.setFont(fuenteLabel);

        JLabel finPagIzq = new JLabel("DeustoTech 2021 ©");
        finPagIzq.setHorizontalAlignment(JLabel.CENTER);
        finPagIzq.setForeground(Color.white);
        finPagIzq.setFont(fuenteLabel);

        this.add(finPagDch, BorderLayout.EAST);
        this.add(finPagIzq, BorderLayout.WEST);

    }

}
