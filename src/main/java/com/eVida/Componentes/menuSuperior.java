package com.eVida.Componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import com.eVida.Ventanas.venPrincipal;
import com.eVida.Ventanas.Controller;
import com.eVida.Ventanas.venGenerica;
import com.eVida.Ventanas.Lecturas.venGraficas;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class menuSuperior extends JMenuBar {

    /**
     * Pet Project
     */
    private static final long serialVersionUID = 1L;
    private Font fuenteMenu;
    private Font fuenteMenu2;
    public static JMenuItem inicio2;

    public menuSuperior() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension((int)screenSize.getWidth(),50));
        setBorder(BorderFactory.createEmptyBorder());

        fuenteMenu = new Font("Times New Roman", Font.PLAIN, 17);
        fuenteMenu2 = new Font("Times New Roman ", Font.PLAIN, 14);
        JMenu inicio = new JMenu("Inicio");
        inicio.setFont(fuenteMenu);
        inicio.setBackground(Color.white);
        this.add(inicio);
        JMenuItem salir = new JMenuItem("Salir");
        salir.setFont(fuenteMenu2);
        inicio2 = new JMenuItem("Inicio");
        inicio2.setFont(fuenteMenu2);
        inicio.setForeground(Color.white);
        JMenuItem cerrarSesion = new JMenuItem("Cerrar Sesion");
        cerrarSesion.setFont(fuenteMenu2);

        inicio.add(inicio2);
        inicio.add(cerrarSesion);
        inicio.add(salir);
        /* ************************* */

        JMenu lecturas = new JMenu("Lecturas");
        lecturas.setBackground(Color.white);
        lecturas.setForeground(Color.white);
        lecturas.setFont(fuenteMenu);
        this.add(lecturas);
        JMenuItem Lsensor = new JMenuItem("Lectura del sensor");
        Lsensor.setFont(fuenteMenu2);
        lecturas.add(Lsensor);
        JMenuItem Lpulso = new JMenuItem("Lectura del pulso");
        Lpulso.setFont(fuenteMenu2);
        lecturas.add(Lpulso);
        JMenuItem Laceleraciones = new JMenuItem("Lectura de las aceleraciones");
        Laceleraciones.setFont(fuenteMenu2);
        lecturas.add(Laceleraciones);
        JMenuItem Lmovimiento = new JMenuItem("Lectura del movimiento");
        Lmovimiento.setFont(fuenteMenu2);
        lecturas.add(Lmovimiento);

        ///////////////

        ActionListener pulsoL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller.panelSwitch("venPulso");
            }
        };
        Lpulso.addActionListener(pulsoL);

        /* ************************* */

        JMenu animales = new JMenu("Animales");
        animales.setBackground(Color.white);
        animales.setFont(fuenteMenu);
        animales.setForeground(Color.white);
        this.add(animales);
        JMenuItem Aagregar = new JMenuItem("Agregar animal");
        Aagregar.setFont(fuenteMenu2);
        animales.add(Aagregar);
        JMenuItem Aver = new JMenuItem("Ver animal");
        Aver.setFont(fuenteMenu2);
        animales.add(Aver);
        JMenuItem Aeliminar = new JMenuItem("Eliminar animal");
        Aeliminar.setFont(fuenteMenu2);
        animales.add(Aeliminar);
        /* ************************* */

        JMenu quienesSomos = new JMenu("Quienes somos");
        quienesSomos.setFont(fuenteMenu);
        quienesSomos.setForeground(Color.white);
        this.add(quienesSomos);
        /* ************************* */

        ActionListener salirL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        salir.addActionListener(salirL);

        ActionListener inicioL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!venGenerica.inicio) {
                    Controller.panelSwitch("venInicio");
                } else {
                    Controller.panelSwitch("venSesionIniciada");
                }

            }
        };
        inicio2.addActionListener(inicioL);

        ActionListener cerrarSesionL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller.cerrarSesion();
            }
        };
        cerrarSesion.addActionListener(cerrarSesionL);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Image img = ImageIO.read(new File("src/main/java/com/eVida/Recursos/img/bgiNav2.png"));
            g.drawImage(img , 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }

}

