package com.eVida.Ventanas;

import java.awt.Color;
import javax.swing.*;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.persona;

import java.awt.event.*;
import java.io.IOException;

public class venInicio extends venGenerica {

    /**
     * PetProject 2021
     */
    private static final long serialVersionUID = 1L;
    public JLabel apodo, contrasenia;
    public JTextField apodoInput;
    public JPasswordField contraseniaInput;
    public JButton btnInicio, btnRegistro;
    public JScrollPane contenedor = new JScrollPane();

    public venInicio() {
        super();
        init();
    }

    private void init() {
        setName("venInicio");
        setComponentes();
        System.out.println(contenedor.getName());
    }

    @Override
    public void setComponentes() {
        setTitulo("Bienvenido a Pet Project");
        contenedor.setBounds(0, this.titulo.getHeight(), venPrincipal.getPanelCentral().getWidth(),
                (venPrincipal.getPanelCentral().getHeight() - this.titulo.getHeight()));

        contenedor.setLayout(null);

        apodo = new JLabel("Apodo");
        // apodo.setBounds(400, 200, 250, 50);
        apodo.setBounds((contenedor.getWidth() / 2) - 300, 200, 250, 50);
        apodo.setFont(fuenteLabels);
        // apodo.setBorder(BorderFactory.createLineBorder(Color.green));
        contenedor.add(apodo);

        contrasenia = new JLabel("Contraseña");
        // contrasenia.setBounds(400, 300, 250, 50);
        contrasenia.setBounds((contenedor.getWidth() / 2) - 300, 300, 250, 50);
        contrasenia.setFont(fuenteLabels);
        // contrasenia.setBorder(BorderFactory.createLineBorder(Color.green));
        contenedor.add(contrasenia);

        apodoInput = new JTextField();
        apodoInput.setBounds((contenedor.getWidth() / 2) + 50, 200, 350, 50);
        apodoInput.setFont(fuenteLabels);
        // apodoInput.setBorder(BorderFactory.createLineBorder(Color.blue));
        contenedor.add(apodoInput);

        contraseniaInput = new JPasswordField();
        contraseniaInput.setBounds((contenedor.getWidth() / 2) + 50, 300, 350, 50);
        // contraseniaInput.setBorder(BorderFactory.createLineBorder(Color.blue));
        contenedor.add(contraseniaInput);

        btnInicio = new JButton("Inicio de Sesión");
        btnInicio.setFont(fuenteBtn);
        btnInicio.setBounds((contenedor.getWidth() / 2) - 450, 450, 400, 30);
        btnInicio.setBackground(Color.white);
        btnInicio.setFocusable(false);
        contenedor.add(btnInicio);

        btnRegistro = new JButton("Registro de Usuario");
        btnRegistro.setFont(fuenteBtn);
        btnRegistro.setBounds((contenedor.getWidth() / 2) + 50, 450, 400, 30);
        btnRegistro.setBackground(Color.white);
        btnRegistro.setFocusable(false);
        contenedor.add(btnRegistro);

        Thread escuchadores = new Thread() {
            @Override
            public void run() {
                ActionListener btnInicioL = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // TODO
                        System.out.println("Escuchar");
                        try {
                            // TODO
                            Cliente inicioSesion = new Cliente("1001");
                            boolean inic = inicioSesion.verificarUsuario(apodoInput.getText(),
                                    contraseniaInput.getText());
                            System.out.println(inic);
                            if (!inic) {
                                JOptionPane.showMessageDialog(null, "Usuario no registrado", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Bienvenido " + apodoInput.getText(), "Bienvenido",
                                        JOptionPane.INFORMATION_MESSAGE);
                                Cliente cl = new Cliente("1003");
                                persona p = cl.getPersona(apodoInput.getText(), contraseniaInput.getText());
                                Controller.guardarSesion(p.getApodo(), p.getContrasenia());
                                venPrincipal.Usuario = p;
                                venGenerica.inicio = true;
                                Controller.panelSwitch("venSesionIniciada");
                                Controller.setData();
                            }
                        } catch (IOException io) {
                            System.out.println(io);
                            io.printStackTrace();
                        }
                    }
                };
                btnInicio.addActionListener(btnInicioL);

                ActionListener btnRegistroL = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Controller.panelSwitch("venRegistro");
                    }
                };
                btnRegistro.addActionListener(btnRegistroL);
            }
        };
        escuchadores.start();

        add(contenedor);
        repaint();
    }

    @Override
    public void reSet() {
        apodoInput.setText("");
        contraseniaInput.setText("");
    }

}
