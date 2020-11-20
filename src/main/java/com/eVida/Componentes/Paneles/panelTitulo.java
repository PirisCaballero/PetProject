package com.eVida.Componentes.Paneles;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.*;

public class panelTitulo extends JPanel{

    /**
     *PetProject
     */
    private static final long serialVersionUID = 1L;
    private java.awt.Font fuenteLabel;
    private java.awt.Font fuenteLabel2;

    public panelTitulo(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createTitledBorder("Panel Norte"));

        fuenteLabel = new java.awt.Font("Times New Roman ", java.awt.Font.PLAIN, 40);
        fuenteLabel2 = new java.awt.Font("Times New Roman ", java.awt.Font.PLAIN, 25);

        JLabel titulo = new JLabel("Pet Project");
        titulo.setFont(fuenteLabel);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel subTitulo = new JLabel("eVida");
        subTitulo.setFont(fuenteLabel2);
        subTitulo.setHorizontalAlignment(JLabel.CENTER);
        subTitulo.setBorder(BorderFactory.createLineBorder(Color.green));


        this.add(titulo , BorderLayout.CENTER);
        this.add(subTitulo , BorderLayout.SOUTH);
    }
    
}
