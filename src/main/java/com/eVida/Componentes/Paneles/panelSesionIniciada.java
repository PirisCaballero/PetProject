package com.eVida.Componentes.Paneles;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolTip;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Image.*;
import java.awt.GridLayout;
import java.awt.Graphics;
import com.eVida.Ventanas.Controller;
import com.eVida.Ventanas.JpanelC;
import com.eVida.Ventanas.venGenerica;
import com.eVida.Ventanas.venPrincipal;

import javax.swing.border.Border;
import javax.swing.border.Border.*;

public class panelSesionIniciada extends venGenerica {

    protected Thread componentes;
    protected JButton btnConfiguracion, btnAnimales, btnEstadisticas, btnSalir;
    protected JLabel opcionesUsuario;

    public panelSesionIniciada() {
        super();
        init();
    }

    private void init() {
        setName("venSesionIniciada");
        setComponentes();
    }

    @Override
    public void setComponentes() {
        actualiza = new Thread() {
            @Override
            public void run() {
                UIManager.put("ToolTip.background", Color.white);
                UIManager.put("ToolTip.font", fuenteTT);

                setTitulo("Pet Project");

                opcionesUsuario = new JLabel("Opciones de usuario");
                opcionesUsuario.setBounds((venPrincipal.getPanelCentral().getWidth()/2) -100 , 100 , 200 , 50);
                opcionesUsuario.setFont(fuenteLabels);
                opcionesUsuario.setHorizontalAlignment(SwingConstants.CENTER);
                contenedor2.add(opcionesUsuario);

                Icon iconConfig = new ImageIcon("src/main/java/com/eVida/Recursos/img/configIcon.png");
                btnConfiguracion = new JButton(iconConfig);
                btnConfiguracion.setBounds(475 , 200 , 250 , 250);
                btnConfiguracion.setBackground(new Color(0,0,0,0));
                btnConfiguracion.setFocusable(false);
                btnConfiguracion.setToolTipText("Configuracion");
                contenedor2.add(btnConfiguracion);

                Icon iconPet = new ImageIcon("src/main/java/com/eVida/Recursos/img/petIcon.png");
                btnAnimales = new JButton(iconPet);
                btnAnimales.setBounds(750 , 200 , 250 , 250);
                btnAnimales.setBackground(Color.white);
                btnAnimales.setFocusable(false);
                btnAnimales.setToolTipText("Mascotas");
                contenedor2.add(btnAnimales);

                Icon iconUser = new ImageIcon("src/main/java/com/eVida/Recursos/img/userIcon.png");
                btnEstadisticas = new JButton(iconUser);
                btnEstadisticas.setBounds(1025 , 200 , 250 , 250);
                btnEstadisticas.setBackground(Color.white);
                btnEstadisticas.setFocusable(false);
                btnEstadisticas.setToolTipText("Usuario");
                contenedor2.add(btnEstadisticas);

                //Icon iconExit = new ImageIcon("src/main/java/com/eVida/Recursos/img/exitIcon.png");
                Color col = Color.decode("#1660a9");
                btnSalir = new JButton("Salir");
                btnSalir.setBackground(col);
                btnSalir.setForeground(Color.white);
                btnSalir.setBounds(venPrincipal.getPanelCentral().getWidth()-400 , 700 , 100 , 40);
                btnSalir.setFocusable(false);
                btnSalir.setToolTipText("Salir");
                //btnSalir.setBorder(new Border(10));
                contenedor2.add(btnSalir);

                ActionListener btnSalirL = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String[] opciones = { "Cerra sesion y salir", "Salir sin cerrar sesion", "Cancelar" };
                        UIManager.put("Button.background", Color.white);
                        int i = JOptionPane.showOptionDialog(null, "¿Como desea salir?", "Salir",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                        if (i == 0) {
                            Controller.cerrarSesion();
                            System.exit(0);
                        } else if (i == 1) {
                            System.exit(0);
                        }
                    }
                };
                btnSalir.addActionListener(btnSalirL);
                ActionListener btnAnimalesL = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Controller.panelSwitch("venMascotas");
                    }
                };
                btnAnimales.addActionListener(btnAnimalesL);
                ActionListener btnEstadisticasL = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Controller.panelSwitch("venUsuario");
                    }
                };
                btnEstadisticas.addActionListener(btnEstadisticasL);

                contenedor2.repaint();
                add(contenedor2);
                repaint();
            }
        };
        actualiza.start();
    }

}
