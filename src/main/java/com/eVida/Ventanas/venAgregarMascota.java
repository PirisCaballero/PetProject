package com.eVida.Ventanas;

import java.awt.event.*;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.animal;
import com.conexion.Recursos.persona;

public class venAgregarMascota extends venGenerica {

    persona user;
    protected JPanel contenedor;
    protected JLabel tipoAnimal, razaAnimal, apodo, peso, tipoSangre, fechaNacimiento;
    protected JTextField apodoT, pesoT;
    protected JTextField DD, MM, YYYY;
    protected JComboBox tipoAnimalC, tipoSangreC;
    protected JComboBox razaAnimalC = new JComboBox<String>();
    protected JButton enviar;

    public venAgregarMascota(persona u) {
        super();
        init();
    }

    private void init() {
        setName("venAgregarMascota");
        setComponentes();
    }

    @Override
    public void setComponentes() {
        actualiza = new Thread() {
            @Override
            public void run() {
                setTitulo("Agregar Mascota");
                UIManager.put("ToolTip.background", Color.white);
                UIManager.put("ToolTip.font", fuenteTT);

                contenedor = new JPanel();
                contenedor.setBounds(0, titulo.getHeight() + btnAdelante.getHeight(),
                        venPrincipal.getPanelCentral().getWidth(),
                        (venPrincipal.getPanelCentral().getHeight() - titulo.getHeight() - btnAdelante.getHeight()));
                // contenedor.setLayout(new GridLayout(2, 2, 20, 20));
                contenedor.setLayout(null);
                contenedor.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                // contenedor.setBackground(Color.green);

                tipoAnimal = new JLabel("Tipo de Animal");
                tipoAnimal.setBounds(100, 100, 250, 50);
                tipoAnimal.setFont(fuenteLabels);
                contenedor.add(tipoAnimal);

                try {
                    Cliente cl3 = new Cliente("1005");
                    Object[] tipos = cl3.getTiposDeAnimales().toArray();
                    tipoAnimalC = new JComboBox<String>();
                    tipoAnimalC.setFont(fuenteLabels);
                    tipoAnimalC.addItem("-----");
                    tipoAnimalC.setBackground(Color.white);
                    tipoAnimalC.setFocusable(false);
                    for (Object o : tipos) {
                        tipoAnimalC.addItem(o.toString());
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
                tipoAnimalC.setBounds(400, 100, 250, 50);
                contenedor.add(tipoAnimalC);

                ///////////////////////
                razaAnimal = new JLabel("Raza del Animal");
                razaAnimal.setBounds(100, 200, 250, 50);
                razaAnimal.setFont(fuenteLabels);
                contenedor.add(razaAnimal);

                if (tipoAnimalC.getSelectedItem().equals("Perro")) {
                    try {
                        Cliente cl = new Cliente("1004");
                        Object[] razas = cl.getRazasPerros().toArray();
                        razaAnimalC.setFont(fuenteLabels);
                        razaAnimalC.setBackground(Color.white);
                        razaAnimalC.addItem("-----");
                        razaAnimalC.setFocusable(false);
                        for (Object o : razas) {
                            razaAnimalC.addItem(o.toString());
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    razaAnimalC.setBounds(400, 200, 250, 50);
                    contenedor.add(razaAnimalC);
                } else {
                    razaAnimalC.setFont(fuenteLabels);
                    razaAnimalC.setBackground(Color.white);
                    razaAnimalC.addItem("-----");
                    razaAnimalC.setFocusable(false);
                    razaAnimalC.setBounds(400, 200, 250, 50);
                    contenedor.add(razaAnimalC);
                }

                apodo = new JLabel("Apodo");
                apodo.setBounds(100, 300, 150, 50);
                apodo.setFont(fuenteLabels);
                contenedor.add(apodo);
                apodoT = new JTextField();
                apodoT.setBounds(400, 300, 250, 50);
                apodoT.setFont(fuenteLabels);
                contenedor.add(apodoT);

                peso = new JLabel("Peso");
                peso.setBounds(100, 400, 250, 50);
                peso.setFont(fuenteLabels);
                contenedor.add(peso);
                pesoT = new JTextField();
                pesoT.setBounds(400, 400, 250, 50);
                pesoT.setFont(fuenteLabels);
                contenedor.add(pesoT);

                tipoSangre = new JLabel("Tipo de Samgre");
                tipoSangre.setBounds(100, 500, 250, 50);
                tipoSangre.setFont(fuenteLabels);
                contenedor.add(tipoSangre);
                tipoSangreC = new JComboBox<String>();
                try {
                    Cliente cl2 = new Cliente("1006");
                    Object[] tipos = cl2.getTiposDeSangreAnimales().toArray();
                    tipoSangreC.addItem("-----");
                    for (Object o : tipos) {
                        tipoSangreC.addItem(o.toString());
                    }
                    tipoSangreC.setFocusable(false);
                    tipoSangreC.setBackground(Color.white);
                    tipoSangreC.setBounds(400, 500, 250, 50);
                    contenedor.add(tipoSangreC);
                } catch (Exception e) {
                    // TODO: handle exception
                }

                fechaNacimiento = new JLabel("Fecha de nacimiento");
                fechaNacimiento.setBounds(1000, 100, 250, 50);
                fechaNacimiento.setFont(fuenteLabels);
                contenedor.add(fechaNacimiento);

                DD = new JTextField();
                DD.setBounds(1000, 200, 50, 50);
                DD.setFont(fuenteLabels);
                JLabel barra1 = new JLabel("/");
                barra1.setFont(fuenteLabels);
                barra1.setBounds(1075, 212, 25, 25);
                contenedor.add(barra1);
                contenedor.add(DD);
                MM = new JTextField();
                MM.setBounds(1100, 200, 50, 50);
                MM.setFont(fuenteLabels);
                JLabel barra2 = new JLabel("/");
                barra2.setFont(fuenteLabels);
                barra2.setBounds(1175, 212, 25, 25);
                contenedor.add(barra2);
                contenedor.add(MM);
                YYYY = new JTextField();
                YYYY.setBounds(1200, 200, 100, 50);
                YYYY.setFont(fuenteLabels);
                JLabel barra3 = new JLabel("/");
                barra3.setFont(fuenteLabels);
                barra3.setBounds(1275, 212, 25, 25);
                contenedor.add(barra3);
                contenedor.add(YYYY);

                enviar = new JButton("Agregar");
                enviar.setFont(fuenteBtn);
                enviar.setBounds(1000, 300, 250, 50);
                enviar.setFocusable(false);
                enviar.setBackground(Color.white);
                contenedor.add(enviar);

                ActionListener razasL = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (tipoAnimalC.getSelectedItem().equals("Perro")) {
                            try {
                                Cliente cl = new Cliente("1004");
                                Object[] razas = cl.getRazasPerros().toArray();
                                razaAnimalC.removeAllItems();
                                razaAnimalC.setFont(fuenteLabels);
                                razaAnimalC.setBackground(Color.white);
                                razaAnimalC.addItem("-----");
                                razaAnimalC.setFocusable(false);
                                for (Object o : razas) {
                                    razaAnimalC.addItem(o.toString());
                                }

                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                            razaAnimalC.setBounds(400, 200, 250, 50);
                            contenedor.add(razaAnimalC);
                        } else {
                            razaAnimalC.removeAllItems();
                            razaAnimalC.setFont(fuenteLabels);
                            razaAnimalC.setBackground(Color.white);
                            razaAnimalC.addItem("-----");
                            razaAnimalC.setFocusable(false);
                            razaAnimalC.setBounds(400, 200, 250, 50);
                            contenedor.add(razaAnimalC);
                        }
                    }

                };
                tipoAnimalC.addActionListener(razasL);

                ActionListener enviarL = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (agregarMascota()) {
                            JOptionPane.showMessageDialog(null, "Agregado!", "informacion",
                                    JOptionPane.INFORMATION_MESSAGE);
                            apodoT.setText("");
                            pesoT.setText("");
                            DD.setText("");
                            MM.setText("");
                            YYYY.setText("");
                            tipoAnimalC.setSelectedIndex(0);
                            tipoSangreC.setSelectedIndex(0);
                            razaAnimalC.setSelectedIndex(0);
                            Controller.panelSwitch("venSesionIniciada");
                        } else {
                            JOptionPane.showMessageDialog(null, "Mascota no agregada", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                };
                enviar.addActionListener(enviarL);

                add(contenedor);
                contenedor.repaint();
            }
        };
        actualiza.start();
    }

    public boolean agregarMascota() {
        animal a = new animal();
        if (!apodoT.getText().isEmpty() && !pesoT.getText().isEmpty() && !DD.getText().isEmpty()
                && !MM.getText().isEmpty() && !YYYY.getText().isEmpty()) {
            if (razaAnimalC.getSelectedIndex() > 0 && tipoAnimalC.getSelectedIndex() > 0
                    && tipoSangreC.getSelectedIndex() > 0) {
                a.setApodo(apodoT.getText());
                a.setTipo(tipoAnimalC.getSelectedItem() + "");
                a.setRaza(razaAnimalC.getSelectedItem() + "");
                a.setPeso(pesoT.getText());
                a.setTipoSangre(tipoSangreC.getSelectedItem() + "");
                a.setFechaNacimiento(DD.getText() + "/" + MM.getText() + "/" + YYYY.getText());
                a.setIdUsuario(Integer.parseInt(venPrincipal.Usuario.getId()));
                try {
                    Cliente cl = new Cliente("1008");
                    cl.agregarAnimal(a);
                    return true;
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(e);
                    e.printStackTrace();
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
