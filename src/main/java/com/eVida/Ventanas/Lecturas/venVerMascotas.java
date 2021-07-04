package com.eVida.Ventanas.Lecturas;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.animal;
import com.conexion.Recursos.persona;
import com.eVida.Ventanas.venGenerica;
import com.eVida.Ventanas.venPrincipal;
import com.eVida.Ventanas.venSeleccionDatos;
import com.eVida.Ventanas.ventanaEmergente1;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class venVerMascotas extends venGenerica {

    protected persona user;
    protected DefaultTableModel modelo;
    protected JTable tabla;
    protected JScrollPane scroll;
    protected JButton btnVerAnimal;

    public venVerMascotas() {
    }

    public venVerMascotas(persona u) {
        super();
        user = u;
        init();
    }

    private void init() {
        setName("venVerMascotas");
        setComponentes();
    }

    @Override
    public void setComponentes() {
        actualiza = new Thread() {
            @Override
            public void run() {
                setTitulo("Ver Mascotas");
                UIManager.put("ToolTip.background", Color.white);
                UIManager.put("ToolTip.font", fuenteTT);

                modelo = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                String[] nombres = { "ID", "Apodo", "Tipo", "Raza", "Peso", "Sangre", "Fecha Nacimiento",
                        "Agregación" };
                modelo.setColumnCount(8);
                modelo.setColumnIdentifiers(nombres);
                tabla = new JTable(modelo);
                tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                tabla.getTableHeader().setFont(fuenteLabels);
                tabla.setFont(fuenteLabels2);
                tabla.setRowHeight(30);
                tabla.setEnabled(true);
                tabla.setSelectionBackground(Color.GRAY);
                scroll = new JScrollPane(tabla);

                scroll.setBounds(230, 100, venPrincipal.getPanelCentral().getWidth() - 400,
                        venPrincipal.getPanelCentral().getHeight() - 507);

                scroll.setOpaque(false);
                rellenarTabla(Integer.parseInt(venPrincipal.Usuario.getId()));

                btnVerAnimal = new JButton("Ver");
                btnVerAnimal.setFont(fuenteBtn);
                btnVerAnimal.setBackground(Color.white);
                btnVerAnimal.setFocusable(false);
                btnVerAnimal.setFocusPainted(false);
                btnVerAnimal.setBounds(scroll.getLocation().x + (scroll.getWidth() / 2) - 75, 500, 150, 50);
                contenedor2.add(btnVerAnimal);

                ActionListener btnVerAnimalL = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Thread ventana = new Thread() {
                            @Override
                            public void run() {
                                if (!tabla.getSelectionModel().isSelectionEmpty()) {
                                    animal a = new animal();
                                    a.setIdAnimal((String) tabla.getValueAt(tabla.getSelectedRow(), 0));
                                    try {
                                        Cliente cl = new Cliente("1010");
                                        if(tabla.getValueAt(tabla.getSelectedRow(), 0) == null ){
                                            JOptionPane.showMessageDialog(null, "Antes debes seleccionar una fila", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                                        }else{
                                            animal mascota = cl.getAnimal(a.getIdAnimal());
                                            venSeleccionDatos vSD = new venSeleccionDatos(mascota);
                                        }
                                    } catch (IOException e) {
                                        System.out.println(e);
                                        e.printStackTrace();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Antes debes seleccionar una fila", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        };
                        ventana.start();
                    }
                };
                btnVerAnimal.addActionListener(btnVerAnimalL);

                contenedor2.add(scroll);
                add(contenedor2);
                contenedor2.repaint();

            }
        };
        actualiza.start();
    }

    private void rellenarTabla(int IdUsuario) {
        List<String> animales;
        try {
            Cliente cl = new Cliente("1009");
            animales = Arrays.asList(cl.getAnimales(IdUsuario).split("-"));
            for (String s : animales) {
                ArrayList<String> animal = new ArrayList<String>();
                List<String> ss = Arrays.asList(s.split(","));
                int l = ss.size();
                for (int i = 0; i < l; i++) {
                    animal.add(ss.get(i));
                }
                modelo.addRow(animal.toArray());
            }
            int restantes = 9-modelo.getRowCount();
            ArrayList<String> vacio = new ArrayList<String>();
            for(int i = 0; i<restantes ; i++){
                modelo.addRow(vacio.toArray());
            }
            contenedor2.repaint();
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }

    @Override
    public void reSet() {
        int rowCount = modelo.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    @Override
    public void setData() {
        rellenarTabla(Integer.parseInt(venPrincipal.Usuario.getId()));
    }

}
