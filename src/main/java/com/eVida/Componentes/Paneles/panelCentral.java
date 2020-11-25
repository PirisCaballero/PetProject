package com.eVida.Componentes.Paneles;

import javax.swing.BorderFactory;

import javax.swing.JPanel;
import java.awt.*;

public class panelCentral extends JPanel {

    /**
     * Pet Project
     */
    private static final long serialVersionUID = 1L;

    public panelCentral() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createTitledBorder("Panel Central"));
    }

}
