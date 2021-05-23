package com.eVida.Ventanas;

import javax.swing.UIManager;

import com.conexion.Recursos.persona;

import javax.swing.*;
import java.awt.*;

public class venUsuario extends venGenerica {
    private persona user;
    protected JPanel contenedor;
    private JLabel apodo, nombre, apellidos, correo, dni, contrasenia;
    private JTextField apodoT, nombreT, apellidosT, correoT, dniT;
    private JPasswordField contraseniaT;

    public venUsuario(persona u) {
        super();
        init();
        user = u;
    }

    private void init() {
        setName("venUsuario");
        setComponentes();
    }

    @Override
    public void setComponentes() {
        actualiza = new Thread() {
            @Override
            public void run() {
                setTitulo(user.getApodo());
                UIManager.put("ToolTip.background", Color.white);
                UIManager.put("ToolTip.font", fuenteTT);

                contenedor = new JPanel();
                contenedor.setBounds(0, titulo.getHeight() + btnAdelante.getHeight(),
                        venPrincipal.getPanelCentral().getWidth(),
                        (venPrincipal.getPanelCentral().getHeight() - titulo.getHeight() - btnAdelante.getHeight()));
                // contenedor.setLayout(new GridLayout(2, 2, 20, 20));
                contenedor.setLayout(null);
                contenedor.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                // contenedor.setBackground(Color.pink);

                apodo = new JLabel("Apodo");
                apodo.setBounds((contenedor.getWidth() / 2) - 300, 100, 250, 50);
                apodo.setFont(fuenteLabels);
                // apodo.setBorder(BorderFactory.createLineBorder(Color.green));
                contenedor.add(apodo);
                apodoT = new JTextField(user.getApodo());
                apodoT.setBounds((contenedor.getWidth() / 2) + 50, 100, 350, 50);
                apodoT.setFont(fuenteLabels);
                apodoT.setEnabled(false);
                contenedor.add(apodoT);

                nombre = new JLabel("Nombre");
                nombre.setBounds((contenedor.getWidth() / 2) - 300, 170, 250, 50);
                nombre.setFont(fuenteLabels);
                // nombre.setBorder(BorderFactory.createLineBorder(Color.green));
                contenedor.add(nombre);
                nombreT = new JTextField(user.getNombre());
                nombreT.setBounds((contenedor.getWidth() / 2) + 50, 170, 350, 50);
                nombreT.setFont(fuenteLabels);
                nombreT.setEnabled(false);
                contenedor.add(nombreT);

                apellidos = new JLabel("Apellidos");
                apellidos.setBounds((contenedor.getWidth() / 2) - 300, 240, 250, 50);
                apellidos.setFont(fuenteLabels);
                // apellidos.setBorder(BorderFactory.createLineBorder(Color.green));
                contenedor.add(apellidos);
                apellidosT = new JTextField(user.getApellidos());
                apellidosT.setBounds((contenedor.getWidth() / 2) + 50, 240, 350, 50);
                apellidosT.setFont(fuenteLabels);
                apellidosT.setEnabled(false);
                contenedor.add(apellidosT);

                correo = new JLabel("Correo");
                correo.setBounds((contenedor.getWidth() / 2) - 300, 310, 250, 50);
                correo.setFont(fuenteLabels);
                // correo.setBorder(BorderFactory.createLineBorder(Color.green));
                contenedor.add(correo);
                correoT = new JTextField(user.getCorreo());
                correoT.setBounds((contenedor.getWidth() / 2) + 50, 310, 350, 50);
                correoT.setFont(fuenteLabels);
                correoT.setEnabled(false);
                contenedor.add(correoT);

                dni = new JLabel("DNI");
                dni.setBounds((contenedor.getWidth() / 2) - 300, 380, 250, 50);
                dni.setFont(fuenteLabels);
                // dni.setBorder(BorderFactory.createLineBorder(Color.green));
                contenedor.add(dni);
                dniT = new JTextField(user.getDni());
                dniT.setBounds((contenedor.getWidth() / 2) + 50, 380, 350, 50);
                dniT.setFont(fuenteLabels);
                dniT.setEnabled(false);
                contenedor.add(dniT);

                contrasenia = new JLabel("Contraseña");
                contrasenia.setBounds((contenedor.getWidth() / 2) - 300, 450, 250, 50);
                contrasenia.setFont(fuenteLabels);
                // contrasenia.setBorder(BorderFactory.createLineBorder(Color.green));
                contenedor.add(contrasenia);
                contraseniaT = new JPasswordField(user.getContrasenia());
                contraseniaT.setBounds((contenedor.getWidth() / 2) + 50, 450, 350, 50);
                contraseniaT.setFont(fuenteLabels);
                contraseniaT.setEnabled(false);
                contenedor.add(contraseniaT);

                add(contenedor);
                contenedor.repaint();
                repaint();
            }
        };
        actualiza.start();
    }

    public void setUsuario(persona u) {
        this.user = u;
    }

}
