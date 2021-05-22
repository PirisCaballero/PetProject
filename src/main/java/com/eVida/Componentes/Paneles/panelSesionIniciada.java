package com.eVida.Componentes.Paneles;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolTip;
import javax.swing.UIManager;
import java.awt.event.*;
import java.awt.Color;
import java.awt.GridLayout;

import com.eVida.Ventanas.Controller;
import com.eVida.Ventanas.venGenerica;
import com.eVida.Ventanas.venPrincipal;

public class panelSesionIniciada extends venGenerica {

    protected Thread componentes;
    protected JButton btnConfiguracion, btnAnimales, btnEstadisticas, btnSalir;
    protected JPanel contenedor;

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
                contenedor = new JPanel();
                contenedor.setBounds(0, titulo.getHeight() + btnAdelante.getHeight(),
                        venPrincipal.getPanelCentral().getWidth(),
                        (venPrincipal.getPanelCentral().getHeight() - titulo.getHeight() - btnAdelante.getHeight()));
                contenedor.setLayout(new GridLayout(2, 2, 20, 20));
                contenedor.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                Icon iconConfig = new ImageIcon("src/main/java/com/eVida/Recursos/img/configIcon.png");
                btnConfiguracion = new JButton(iconConfig);
                btnConfiguracion.setBackground(Color.white);
                btnConfiguracion.setFocusable(false);
                btnConfiguracion.setToolTipText("Configuracion");
                contenedor.add(btnConfiguracion);

                Icon iconPet = new ImageIcon("src/main/java/com/eVida/Recursos/img/petIcon.png");
                btnAnimales = new JButton(iconPet);
                btnAnimales.setBackground(Color.white);
                btnAnimales.setFocusable(false);
                btnAnimales.setToolTipText("Mascotas");
                contenedor.add(btnAnimales);

                Icon iconUser = new ImageIcon("src/main/java/com/eVida/Recursos/img/userIcon.png");
                btnEstadisticas = new JButton(iconUser);
                btnEstadisticas.setBackground(Color.white);
                btnEstadisticas.setFocusable(false);
                btnEstadisticas.setToolTipText("Usuario");
                contenedor.add(btnEstadisticas);

                Icon iconExit = new ImageIcon("src/main/java/com/eVida/Recursos/img/exitIcon.png");
                btnSalir = new JButton(iconExit);
                btnSalir.setBackground(Color.white);
                btnSalir.setFocusable(false);
                btnSalir.setToolTipText("Salir");
                contenedor.add(btnSalir);

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

                add(contenedor);
                contenedor.repaint();
                repaint();
            }
        };
        actualiza.start();
    }

}
