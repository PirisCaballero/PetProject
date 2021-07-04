package com.eVida.Ventanas.Lecturas;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import com.conexion.Recursos.animal;
import com.eVida.Ventanas.Controller;
import com.conexion.Conexion.Cliente;
import java.awt.event.*;

public class venSeleccionReg extends JFrame {

    protected animal animal;
    protected JLabel lbl_registro;
    protected JComboBox combo_registros;
    protected Font fuenteLabels2 = new Font("Times New Roman", Font.ROMAN_BASELINE, 19);
    protected JButton aceptar , salir;

    public venSeleccionReg (animal a){
        animal = a;
        setTitle("Seleccion de registro");
        setSize(new Dimension(400 , 250));
        getContentPane().setBackground(Color.white);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setOpacity(1.0f);
        setVisible(true);
        getContentPane().setLayout(null);

        lbl_registro = new JLabel("Registro: ");
        lbl_registro.setBounds(20 , 50 , 150 , 50);
        lbl_registro.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_registro.setBackground(Color.white);
        lbl_registro.setFont(fuenteLabels2);
        getContentPane().add(lbl_registro);

        combo_registros = new JComboBox();
        combo_registros.setBounds(200 , 50 , 150 , 30);
        combo_registros.setFont(fuenteLabels2);
        combo_registros.setBackground(Color.white);
        getContentPane().add(combo_registros);
        setComboData();

        aceptar = new JButton("aceptar");
        aceptar.setBounds(250 , 170 , 100 , 30);
        aceptar.setBackground(Color.white);
        aceptar.setFocusable(false);
        getContentPane().add(aceptar);



        ActionListener aceptarL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(combo_registros.getSelectedIndex() > 0){
                    JOptionPane.showMessageDialog(null, "Seleccionado el registro de: "  + combo_registros.getSelectedItem(), "Cambio de ventana" , JOptionPane.INFORMATION_MESSAGE);
                Controller.panelSwitch("venGraficas");
                dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Debe de selecionar un registro valido" , "Cambio de ventana" , JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        aceptar.addActionListener(aceptarL);

    }

    private void setComboData(){
        try {
            Cliente cl = new Cliente("1011");
            ArrayList<String> regs = cl.getMediciones(animal.getIdAnimal(), animal.getIdUsuario()+"");
            if(regs.size()==0){
                JOptionPane.showMessageDialog(null, "No hay mediciones para: " + animal.getApodo(), "Error",
                JOptionPane.ERROR_MESSAGE);
               }else{
                   combo_registros.addItem("--------");
                for(String s : regs){
                    String[] tmp = s.split(",");
                    combo_registros.addItem(tmp[3]);
                }
               }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
}
