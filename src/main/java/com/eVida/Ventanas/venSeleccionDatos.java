package com.eVida.Ventanas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import com.conexion.Recursos.animal;
import com.eVida.Recursos.buffer;
import com.eVida.Ventanas.Lecturas.venSeleccionReg;

public class venSeleccionDatos extends JFrame {
    protected String titulo;
    protected JLabel seleccionL , apodoL , razaL;
    protected JComboBox seleccion;
    protected JButton enviar;
    protected Font fuenteLabels2 = new Font("Times New Roman", Font.ROMAN_BASELINE, 19);
    protected animal anim;

    public venSeleccionDatos(animal a) {
        anim = a;
        titulo = "Selección de gráfica";
        setSize(550, 350);
        setTitle(titulo);
        setVisible(true);
        setOpacity(1.0f);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        getContentPane().setLayout(null);
        init();
    }

    private void init() {
        Thread actualiza = new Thread() {
            @Override
            public void run() {
                seleccionL = new JLabel("Tipo de gráfica: ");
                seleccionL.setBounds(20, 20, 200, 50);
                seleccionL.setBackground(Color.white);
                seleccionL.setForeground(Color.black);
                seleccionL.setFont(fuenteLabels2);
                getContentPane().add(seleccionL);

                String[] opciones = { "---------", "Oxigenacion", "Pulso", "Temperatura", "Aceleracion" };
                seleccion = new JComboBox<String>(opciones);
                seleccion.setBounds(250, 20, 200, 50);
                seleccion.setBackground(Color.white);
                seleccion.setForeground(Color.black);
                seleccion.setFocusable(false);
                getContentPane().add(seleccion);

                enviar = new JButton("Enviar");
                enviar.setBounds(225 , 250 , 100 , 50);
                enviar.setFocusable(false);
                enviar.setBackground(Color.white);
                enviar.setForeground(Color.black);
                enviar.setFont(fuenteLabels2);
                getContentPane().add(enviar);

                apodoL = new JLabel("Apodo: "+anim.getApodo());
                apodoL.setBounds(20 , 100 , 250 , 50);
                apodoL.setBackground(Color.white);
                apodoL.setForeground(Color.black);
                apodoL.setFocusable(false);
                apodoL.setFont(fuenteLabels2);
                getContentPane().add(apodoL);

                razaL = new JLabel("Raza: " + anim.getRaza());
                razaL.setBounds(20 , 150 , 250 , 50);
                razaL.setBackground(Color.white);
                razaL.setForeground(Color.black);
                razaL.setFont(fuenteLabels2);
                razaL.setFocusable(false);
                getContentPane().add(razaL);


                ActionListener btnEnviar = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(seleccion.getSelectedIndex()>0){
                            JOptionPane.showMessageDialog(null, "Datos de "+ seleccion.getSelectedItem()+" : " +anim.getApodo() , "Bienvenido",
                                        JOptionPane.INFORMATION_MESSAGE);
                                        if(seleccion.getSelectedIndex()>0){
                                            buffer.anim = anim;
                                            buffer.seleccionComnbo = seleccion.getSelectedItem().toString();
                                            System.out.println(buffer.seleccionComnbo);
                                            dispose();
                                            venSeleccionReg vSR = new venSeleccionReg(anim);
                                            System.out.println("activo: "+vSR.isActive());
                                        }

                        }else{
                            JOptionPane.showMessageDialog(null, "Antes debes seleccionar una opción", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                        }
                    }
                };
                enviar.addActionListener(btnEnviar);

                getContentPane().repaint();
            }
        };
        actualiza.start();
    }
}
