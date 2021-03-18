package com.eVida.Ventanas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image.*;
import java.awt.Color;
import java.awt.Font;

public class venGenerica extends JPanel {

    /**
     * Pet Project
     */
    private static final long serialVersionUID = 1L;
    protected Font fuenteTitulo = new Font("Times New Roman", Font.ROMAN_BASELINE, 50);
    protected Font fuenteLabels = new Font("Times New Roman", Font.ROMAN_BASELINE, 22);
    protected Font fuenteBtn = new Font("Times New Roman", Font.ROMAN_BASELINE, 20);
    protected JLabel titulo;
    protected JButton btnAdelante, btnAtras;
    protected String nomTit;
    protected static boolean inicio = false;
    protected JButton btnSesionIniciada;
    protected Thread actualiza;

    public venGenerica() {
        setName("venGenerica");
        setLayout(null);
        setBounds(0, 0, venPrincipal.getPanelCentral().getWidth(), venPrincipal.getPanelCentral().getHeight());
        setBackground(Color.white);

    }

    public void setTitulo(String nombreTitulo) {
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

        add(btnAdelante);
        add(btnSesionIniciada);
        add(btnAtras);
        add(titulo);
        repaint();
        actualiza = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (!venGenerica.inicio) {
                        btnSesionIniciada.setText("Iniciar Sesión");
                    } else {
                        btnSesionIniciada.setText(venPrincipal.Usuario.getApodo());
                    }
                }
            }
        };
        actualiza.start();
    }

    public void setComponentes() {
    }

}
