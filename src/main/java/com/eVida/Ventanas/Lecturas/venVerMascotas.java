package com.eVida.Ventanas.Lecturas;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.animal;
import com.conexion.Recursos.persona;
import com.eVida.Ventanas.venGenerica;
import com.eVida.Ventanas.venPrincipal;
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
    protected JPanel contenedor = new JPanel();
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

                contenedor = new JPanel();
                contenedor.setBounds(0, titulo.getHeight() + btnAdelante.getHeight(),
                        venPrincipal.getPanelCentral().getWidth(),
                        (venPrincipal.getPanelCentral().getHeight() - titulo.getHeight() - btnAdelante.getHeight()));
                // contenedor.setLayout(new GridLayout(2, 2, 20, 20));
                contenedor.setLayout(null);
                // contenedor.setBorder(BorderFactory.createLineBorder(Color.red));
                contenedor.setBackground(Color.white);

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

                scroll.setBounds(50, 20, venPrincipal.getPanelCentral().getWidth() - 200,
                        venPrincipal.getPanelCentral().getHeight() - 500);

                rellenarTabla(Integer.parseInt(venPrincipal.Usuario.getId()));

                btnVerAnimal = new JButton("Ver");
                btnVerAnimal.setFont(fuenteBtn);
                btnVerAnimal.setBackground(Color.white);
                btnVerAnimal.setFocusable(false);
                btnVerAnimal.setFocusPainted(false);
                btnVerAnimal.setBounds(scroll.getLocation().x + (scroll.getWidth() / 2) - 75, 500, 150, 50);
                contenedor.add(btnVerAnimal);

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
                                        animal mascota = cl.getAnimal(a.getIdAnimal());
                                        ventanaEmergente1 venVer = new ventanaEmergente1(mascota);
                                    } catch (IOException e) {
                                        System.out.println(e);
                                        e.printStackTrace();
                                    }
                                } else {
                                    JOptionPane.showConfirmDialog(null, "Antes debes de seleccionar una fila");
                                }
                            }
                        };
                        ventana.start();
                    }
                };
                btnVerAnimal.addActionListener(btnVerAnimalL);

                contenedor.add(scroll);
                add(contenedor);
                contenedor.repaint();

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
            contenedor.repaint();
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
