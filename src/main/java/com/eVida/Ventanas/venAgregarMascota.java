package com.eVida.Ventanas;

import java.awt.event.*;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

import javax.swing.*;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.animal;
import com.conexion.Recursos.persona;

public class venAgregarMascota extends venGenerica {

    persona user;
    protected JLabel tipoAnimal, razaAnimal, apodo, peso, tipoSangre, fechaNacimiento;
    protected JTextField apodoT, pesoT;
    protected JTextField DD, MM, YYYY;
    protected JComboBox tipoAnimalC, tipoSangreC;
    protected JComboBox razaAnimalC = new JComboBox<String>();
    protected JComboBox diaC , mesC , anioC;
    protected Object[] dias;
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

                tipoAnimal = new JLabel("Tipo de Animal");
                tipoAnimal.setBounds(300, 100, 250, 50);
                tipoAnimal.setFont(fuenteLabels);
                contenedor2.add(tipoAnimal);

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
                tipoAnimalC.setBounds(600, 100, 250, 50);
                contenedor2.add(tipoAnimalC);

                ///////////////////////
                razaAnimal = new JLabel("Raza del Animal");
                razaAnimal.setBounds(300, 200, 250, 50);
                razaAnimal.setFont(fuenteLabels);
                contenedor2.add(razaAnimal);

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

                    razaAnimalC.setBounds(600, 200, 250, 50);
                    contenedor2.add(razaAnimalC);
                } else {
                    razaAnimalC.setFont(fuenteLabels);
                    razaAnimalC.setBackground(Color.white);
                    razaAnimalC.addItem("-----");
                    razaAnimalC.setFocusable(false);
                    razaAnimalC.setBounds(600, 200, 250, 50);
                    contenedor2.add(razaAnimalC);
                }

                apodo = new JLabel("Apodo");
                apodo.setBounds(300, 300, 150, 50);
                apodo.setFont(fuenteLabels);
                contenedor2.add(apodo);
                apodoT = new JTextField();
                apodoT.setBounds(600, 300, 250, 50);
                apodoT.setFont(fuenteLabels);
                contenedor2.add(apodoT);

                peso = new JLabel("Peso");
                peso.setBounds(300, 400, 250, 50);
                peso.setFont(fuenteLabels);
                contenedor2.add(peso);
                pesoT = new JTextField();
                pesoT.setBounds(600, 400, 250, 50);
                pesoT.setFont(fuenteLabels);
                contenedor2.add(pesoT);

                tipoSangre = new JLabel("Tipo de Samgre");
                tipoSangre.setBounds(300, 500, 250, 50);
                tipoSangre.setFont(fuenteLabels);
                contenedor2.add(tipoSangre);
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
                    tipoSangreC.setBounds(600, 500, 250, 50);
                    contenedor2.add(tipoSangreC);
                } catch (Exception e) {
                    // TODO: handle exception
                }

                fechaNacimiento = new JLabel("Fecha de nacimiento");
                fechaNacimiento.setBounds(1000, 100, 250, 50);
                fechaNacimiento.setFont(fuenteLabels);
                contenedor2.add(fechaNacimiento);

              
                rellenarCombos();
                diaC.setBounds(1000 , 200 , 50 , 50);
                diaC.setFont(fuenteLabels);
                diaC.setFocusable(false);
                diaC.setBackground(Color.white);
                contenedor2.add(diaC);

                JLabel barra1 = new JLabel("/");
                barra1.setFont(fuenteLabels);
                barra1.setBounds(1075, 212, 25, 25);
                contenedor2.add(barra1);

                mesC.setBounds(1100 , 200 , 50 , 50);
                mesC.setFont(fuenteLabels);
                mesC.setFocusable(false);
                mesC.setBackground(Color.white);
                contenedor2.add(mesC);

                JLabel barra2 = new JLabel("/");
                barra2.setFont(fuenteLabels);
                barra2.setBounds(1175, 212, 25, 25);
                contenedor2.add(barra2);

                anioC.setBounds(1200 , 200 , 100 , 50);
                anioC.setFont(fuenteLabels);
                anioC.setFocusable(false);
                anioC.setBackground(Color.white);
                contenedor2.add(anioC);

                JLabel barra3 = new JLabel("/");
                barra3.setFont(fuenteLabels);
                barra3.setBounds(1275, 212, 25, 25);
                contenedor2.add(barra3);

                enviar = new JButton("Agregar");
                enviar.setFont(fuenteBtn);
                enviar.setBounds(1000, 300, 250, 50);
                enviar.setFocusable(false);
                enviar.setBackground(Color.white);
                contenedor2.add(enviar);

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

                            razaAnimalC.setBounds(600, 200, 250, 50);
                            contenedor2.add(razaAnimalC);
                        } else {
                            razaAnimalC.removeAllItems();
                            razaAnimalC.setFont(fuenteLabels);
                            razaAnimalC.setBackground(Color.white);
                            razaAnimalC.addItem("-----");
                            razaAnimalC.setFocusable(false);
                            razaAnimalC.setBounds(600, 200, 250, 50);
                            contenedor2.add(razaAnimalC);
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

                add(contenedor2);
                contenedor2.repaint();
            }
        };
        actualiza.start();
    }

    public boolean agregarMascota() {
        animal a = new animal();
        if (!apodoT.getText().isEmpty() && !pesoT.getText().isEmpty()) {
            if (razaAnimalC.getSelectedIndex() > 0 && tipoAnimalC.getSelectedIndex() > 0
                    && tipoSangreC.getSelectedIndex() > 0) {
                a.setApodo(apodoT.getText());
                a.setTipo(tipoAnimalC.getSelectedItem() + "");
                a.setRaza(razaAnimalC.getSelectedItem() + "");
                a.setPeso(pesoT.getText());
                a.setTipoSangre(tipoSangreC.getSelectedItem() + "");
                a.setFechaNacimiento(diaC.getSelectedItem() + "/" + mesC.getSelectedItem() + "/" + anioC.getSelectedItem());
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

    private void rellenarCombos(){
        LocalDate currentDate = LocalDate.now();
        YearMonth yearmonyhObject = YearMonth.of(currentDate.getYear() , currentDate.getMonthValue());
        int numberOfDays = yearmonyhObject.lengthOfMonth();
        ArrayList<Integer> diaas = new ArrayList<Integer>();
        for(int i = 1 ; i<=numberOfDays ; i++){
            diaas.add(i);
        }
        dias = diaas.toArray();
        diaC = new JComboBox<Object>(dias);

        Integer[] meses = {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , 11 , 12};
        mesC = new JComboBox< Integer >(meses);

        int start = 1950;
        ArrayList<Integer> anios = new ArrayList<Integer>();
        for(int i = yearmonyhObject.getYear() ; i>start ; i--){
            anios.add(i);
        }
        anioC = new JComboBox<Object>(anios.toArray());
        
    }

}
