package com.eVida.Ventanas;

import java.awt.*;
import javax.swing.*;

public class venMascotas extends venGenerica {

    protected JPanel contenedor;
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
        hilo = new Thread() {
            @Override
            public void run() {
                setTitulo("Mascotas");
                UIManager.put("ToolTip.background", Color.white);
                UIManager.put("ToolTip.font", fuenteTT);

                contenedor = new JPanel();
                contenedor.setBounds(0, titulo.getHeight() + btnAdelante.getHeight(),
                        venPrincipal.getPanelCentral().getWidth(),
                        (venPrincipal.getPanelCentral().getHeight() - titulo.getHeight() - btnAdelante.getHeight()));
                contenedor.setLayout(new GridLayout(2, 2, 20, 20));
                contenedor.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                contenedor.setBackground(Color.red);

                Icon iconAddPet = new ImageIcon("src/main/java/com/eVida/Recursos/img/addPet.png");
                btnAgregarMascotas = new JButton(iconAddPet);
                btnAgregarMascotas.setToolTipText("Añadir mascota");
                btnAgregarMascotas.setFocusable(false);
                contenedor.add(btnAgregarMascotas);

                Icon iconPet = new ImageIcon("src/main/java/com/eVida/Recursos/img/petIcon.png");
                btnVerMascotas = new JButton(iconPet);
                btnVerMascotas.setToolTipText("Mis mascotas");
                btnVerMascotas.setFocusable(false);
                contenedor.add(btnVerMascotas);

                lbl1 = new JLabel();
                // contenedor.add(lbl1);

                lbl2 = new JLabel();
                // contenedor.add(lbl2);

                add(contenedor);
                contenedor.repaint();
                repaint();
            }
        };
        hilo.start();
    }

}
