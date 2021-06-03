package com.eVida.Ventanas;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.eVida.Componentes.menuSuperior;

import java.awt.Image.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.*;

public class venGenerica extends JPanel {

    /**
     * Pet Project
     */
    private static final long serialVersionUID = 1L;
    protected Font fuenteTitulo = new Font("Times New Roman", Font.ROMAN_BASELINE, 50);
    protected Font fuenteLabels = new Font("Times New Roman", Font.ROMAN_BASELINE, 22);
    protected Font fuenteBtn = new Font("Times New Roman", Font.ROMAN_BASELINE, 20);
    protected Font fuenteTT = new Font("Times New Roman", Font.ROMAN_BASELINE, 17);
    protected Font fuenteLabels2 = new Font("Times New Roman", Font.ROMAN_BASELINE, 19);
    protected JLabel titulo;
    protected JButton btnAdelante, btnAtras;
    protected String nomTit;
    public static boolean inicio = false;
    protected JButton btnSesionIniciada;
    protected Thread actualiza;
    protected JpanelC contenedor2;
    protected JScrollPane scroll;
    protected Point mouseLocation;
    protected JButton btnSalir;

    public venGenerica() {
        setName("venGenerica");
        setLayout(null);
        setBounds(0, 0, venPrincipal.getPanelCentral().getWidth(), venPrincipal.getPanelCentral().getHeight());
        setBackground(Color.white);
    }

    public void setTitulo(String nombreTitulo) {

        contenedor2 = new JpanelC();
                contenedor2.setBounds(0, 0,
                        venPrincipal.getPanelCentral().getWidth(),
                        venPrincipal.getPanelCentral().getHeight()+1000);
                contenedor2.setLayout(null);
                contenedor2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                contenedor2.setBackground(Color.white);

                Color col = Color.decode("#1660a9");
                btnSalir = new JButton("Salir");
                btnSalir.setBackground(col);
                btnSalir.setForeground(Color.white);
                btnSalir.setBounds(venPrincipal.getPanelCentral().getWidth()-400 , 700 , 100 , 40);
                btnSalir.setFocusable(false);
                btnSalir.setToolTipText("Salir");
                //btnSalir.setBorder(new Border(10));
                contenedor2.add(btnSalir);


        nomTit = nombreTitulo;
        titulo = new JLabel(nomTit);
        titulo.setBounds(0, 64, venPrincipal.getPanelCentral().getWidth(), 150);
        titulo.setFont(fuenteTitulo);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVerticalAlignment(SwingConstants.CENTER);
        // titulo.setBorder(BorderFactory.createLineBorder(Color.red));
        titulo.setOpaque(true);
        titulo.setBackground(Color.white);

        btnSesionIniciada = new JButton("");
        btnSesionIniciada.setBounds(0, titulo.getHeight() + 5, 150, 50);
        btnSesionIniciada.setBackground(Color.white);
        btnSesionIniciada.setFocusable(false);
        btnSesionIniciada.setFont(fuenteBtn);
        btnSesionIniciada.setBorder(null);
        btnSesionIniciada.setVisible(false);

        Icon icon = new ImageIcon("src/main/java/com/eVida/Recursos/img/flechaDerecha.png");
        btnAdelante = new JButton(icon);
        btnAdelante.setBounds(venPrincipal.getPanelCentral().getWidth() - 64, 0, 64, 64);
        btnAdelante.setBackground(Color.white);
        btnAdelante.setFocusable(false);
        btnAdelante.setBorder(null);

        Icon icon2 = new ImageIcon("src/main/java/com/eVida/Recursos/img/flechaIzquierda.png");
        btnAtras = new JButton(icon2);
        btnAtras.setBounds(0, 0, 64, 64);
        btnAtras.setBackground(Color.white);
        btnAtras.setFocusable(false);
        btnAtras.setBorder(null);

        add(btnSesionIniciada);
        contenedor2.repaint();
        repaint();
    }

    public void setComponentes() {
    }

    public static JPanel getPanel() {
        return null;
    }

    public void reSet() {

    }

    public void setData() {

    }

}
