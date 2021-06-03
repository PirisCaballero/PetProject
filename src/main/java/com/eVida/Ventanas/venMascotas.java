package com.eVida.Ventanas;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.conexion.Conexion.conexion;

import java.awt.GridLayout;

public class venMascotas extends venGenerica {

    protected static JPanel contenedor = new JPanel();
    protected JButton btnVerMascotas, btnAgregarMascotas;
    protected JLabel lbl1, lbl2;
    protected Thread hilo;

    public venMascotas() {
        super();
        init();
    }

    private void init() {
        setName("venMascotas");
        setComponentes();
    }

    @Override
    public void setComponentes() {
        actualiza = new Thread() {
            @Override
            public void run() {
                setTitulo("Mascotas");
                UIManager.put("ToolTip.background", Color.white);
                UIManager.put("ToolTip.font", fuenteTT);

                contenedor = new JPanel();
                contenedor.setBounds(0, titulo.getHeight() + btnAdelante.getHeight(),
                        venPrincipal.getPanelCentral().getWidth(),
                        (venPrincipal.getPanelCentral().getHeight() - titulo.getHeight() - btnAdelante.getHeight()));
                // contenedor.setLayout(new GridLayout(2, 2, 20, 20));
                contenedor.setLayout(null);
                contenedor.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                // contenedor.setBackground(Color.white);

                Icon iconAddPet = new ImageIcon("src/main/java/com/eVida/Recursos/img/addPet.png");
                btnAgregarMascotas = new JButton(iconAddPet);
                btnAgregarMascotas.setBackground(Color.white);
                btnAgregarMascotas.setBounds((venPrincipal.getPanelCentral().getWidth() / 2) - 350, 150, 200, 200);
                btnAgregarMascotas.setToolTipText("Añadir mascota");
                btnAgregarMascotas.setFocusable(false);

                Icon iconPet = new ImageIcon("src/main/java/com/eVida/Recursos/img/petIcon.png");
                btnVerMascotas = new JButton(iconPet);
                btnVerMascotas.setBounds((venPrincipal.getPanelCentral().getWidth() / 2) + 150, 150, 200, 200);
                btnVerMascotas.setBackground(Color.white);
                btnVerMascotas.setToolTipText("Mis mascotas");
                btnVerMascotas.setFocusable(false);

                ActionListener btnAgregarMascotasL = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Controller.panelSwitch("venAgregarMascota");
                    }

                };
                btnAgregarMascotas.addActionListener(btnAgregarMascotasL);

                ActionListener btnVerMascotasL = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Controller.panelSwitch("venVerMascotas");
                    }

                };
                btnVerMascotas.addActionListener(btnVerMascotasL);

                contenedor.add(btnAgregarMascotas);
                contenedor.add(btnVerMascotas);
                add(contenedor);
                contenedor.repaint();
            }
        };
        actualiza.start();
    }

}
