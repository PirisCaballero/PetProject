package com.eVida.Ventanas;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class venRegistro extends venGenerica {

    private JLabel apodo, nombre, apellidos, correo, dni, contrasenia;
    private JTextField apodoT, nombreT, apellidosT, correoT, dniT;
    private JPasswordField contraseniaT;
    private JPanel contenedor = new JPanel();
    private JButton btnRegistro;

    public venRegistro() {
        super();
        init();
    }

    private void init() {
        setName("venRegistro");
        setComponentes();
    }

    @Override
    public void setComponentes() {
        // TODO
        Thread venRegis = new Thread() {
            @Override
            public void run() {
                setTitulo("Registro de usuario");
                contenedor = new JPanel();
                contenedor.setBounds(0, titulo.getHeight(), venPrincipal.getPanelCentral().getWidth(),
                        (venPrincipal.getPanelCentral().getHeight() - titulo.getHeight()));

                contenedor.setLayout(null);

                apodo = new JLabel("Apodo");
                apodo.setBounds((contenedor.getWidth() / 2) - 300, 200, 250, 50);
                apodo.setFont(fuenteLabels);
                // apodo.setBorder(BorderFactory.createLineBorder(Color.green));
                contenedor.add(apodo);
                apodoT = new JTextField();
                apodoT.setBounds((contenedor.getWidth() / 2) + 50, 200, 350, 50);
                apodoT.setFont(fuenteLabels);
                contenedor.add(apodoT);

                nombre = new JLabel("Nombre");
                nombre.setBounds((contenedor.getWidth() / 2) - 300, 270, 250, 50);
                nombre.setFont(fuenteLabels);
                // nombre.setBorder(BorderFactory.createLineBorder(Color.green));
                contenedor.add(nombre);
                nombreT = new JTextField();
                nombreT.setBounds((contenedor.getWidth() / 2) + 50, 270, 350, 50);
                nombreT.setFont(fuenteLabels);
                contenedor.add(nombreT);

                apellidos = new JLabel("Apellidos");
                apellidos.setBounds((contenedor.getWidth() / 2) - 300, 340, 250, 50);
                apellidos.setFont(fuenteLabels);
                // apellidos.setBorder(BorderFactory.createLineBorder(Color.green));
                contenedor.add(apellidos);
                apellidosT = new JTextField();
                apellidosT.setBounds((contenedor.getWidth() / 2) + 50, 340, 350, 50);
                apellidosT.setFont(fuenteLabels);
                contenedor.add(apellidosT);

                correo = new JLabel("Correo");
                correo.setBounds((contenedor.getWidth() / 2) - 300, 410, 250, 50);
                correo.setFont(fuenteLabels);
                // correo.setBorder(BorderFactory.createLineBorder(Color.green));
                contenedor.add(correo);
                correoT = new JTextField();
                correoT.setBounds((contenedor.getWidth() / 2) + 50, 410, 350, 50);
                correoT.setFont(fuenteLabels);
                contenedor.add(correoT);

                dni = new JLabel("DNI");
                dni.setBounds((contenedor.getWidth() / 2) - 300, 480, 250, 50);
                dni.setFont(fuenteLabels);
                // dni.setBorder(BorderFactory.createLineBorder(Color.green));
                contenedor.add(dni);
                dniT = new JTextField();
                dniT.setBounds((contenedor.getWidth() / 2) + 50, 480, 350, 50);
                dniT.setFont(fuenteLabels);
                contenedor.add(dniT);

                contrasenia = new JLabel("Contraseña");
                contrasenia.setBounds((contenedor.getWidth() / 2) - 300, 550, 250, 50);
                contrasenia.setFont(fuenteLabels);
                // contrasenia.setBorder(BorderFactory.createLineBorder(Color.green));
                contenedor.add(contrasenia);
                contraseniaT = new JPasswordField();
                contraseniaT.setBounds((contenedor.getWidth() / 2) + 50, 550, 350, 50);
                contraseniaT.setFont(fuenteLabels);
                contenedor.add(contraseniaT);

                btnRegistro = new JButton("Registrar");
                btnRegistro.setBounds((venPrincipal.getPanelCentral().getWidth() / 2) - 175, 640, 250, 50);
                btnRegistro.setBackground(Color.white);
                btnRegistro.setFocusable(false);
                btnRegistro.setFocusPainted(false);
                btnRegistro.setFont(fuenteBtn);
                contenedor.add(btnRegistro);

                ActionListener registroL = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!apodoT.getText().equals("") && !nombreT.getText().equals("")
                                && !apellidosT.getText().equals("") && !correoT.getText().equals("")
                                && !dniT.getText().equals("") && !contrasenia.getText().equals("")) {
                            persona p = new persona(nombreT.getText(), apellidosT.getText(), dniT.getText(),
                                    correoT.getText(), apodoT.getText(), contraseniaT.getText());
                            try {
                                Cliente cl = new Cliente("1002");
                                boolean regs = cl.registrarUsuario(p);
                                Cliente cl2 = new Cliente("1001");
                                boolean pV = cl2.verificarUsuario(apodoT.getText(), contraseniaT.getText());
                                if (regs && pV) {
                                    Cliente cl3 = new Cliente("1003");
                                    persona p2 = cl3.getPersona(apodoT.getText(), contraseniaT.getText());
                                    venGenerica.inicio = true;
                                    venPrincipal.Usuario = p2;
                                    JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                                    Controller.guardarSesion(p2.getApodo(), p2.getContrasenia());
                                    Controller.panelSwitch("venSesionIniciada");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error al registrar usuario");
                                }

                            } catch (IOException e1) {
                                e1.printStackTrace();
                                JOptionPane.showMessageDialog(null, "not ok");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "not ok");
                        }
                    }
                };
                btnRegistro.addActionListener(registroL);

                add(contenedor);
                repaint();
            }
        };
        venRegis.start();
    }

}
