package com.eVida.Ventanas;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.eVida.Componentes.menuSuperior;
import javax.swing.border.Border;
import java.awt.Image.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.*;

import java.util.ResourceBundle.Control;

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
        contenedor2.setBounds(0, 0, venPrincipal.getPanelCentral().getWidth(),
                venPrincipal.getPanelCentral().getHeight() + 1000);
        contenedor2.setLayout(null);
        contenedor2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contenedor2.setBackground(Color.white);

        Color col = Color.decode("#1660a9");
        btnSalir = new JButton("Salir");
        btnSalir.setBackground(col);
        btnSalir.setForeground(Color.white);
        btnSalir.setBounds(venPrincipal.getPanelCentral().getWidth() - 400, 700, 100, 40);
        btnSalir.setFocusable(false);
        btnSalir.setToolTipText("Salir");
        //btnSalir.setBorder(new RoundedBorder(10));
        contenedor2.add(btnSalir);

        ActionListener btnSalirL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] opciones = { "Cerra sesion y salir", "Salir sin cerrar sesion", "Cancelar" };
                UIManager.put("Button.background", Color.white);
                int i = JOptionPane.showOptionDialog(null, "¿Como desea salir?", "Salir", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                if (i == 0) {
                    Controller.cerrarSesion();
                    System.exit(0);
                } else if (i == 1) {
                    System.exit(0);
                }
            }
        };
        btnSalir.addActionListener(btnSalirL);


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

        btnAdelante = new JButton("--- >");
        btnAdelante.setBounds(550, 700, 100, 40);
        btnAdelante.setBackground(col);
        btnAdelante.setForeground(Color.white);
        btnAdelante.setFocusable(false);
        btnAdelante.setToolTipText("Avanzar");
        contenedor2.add(btnAdelante);

        btnAtras = new JButton("< ---");
        btnAtras.setBounds(400, 700, 100, 40);
        btnAtras.setBackground(col);
        btnAtras.setForeground(Color.white);
        btnAtras.setFocusable(false);
        btnAtras.setToolTipText("Atras");
        contenedor2.add(btnAtras);

        ActionListener btnAtrasL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller.atras();
            }
        };
        btnAtras.addActionListener(btnAtrasL);

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
