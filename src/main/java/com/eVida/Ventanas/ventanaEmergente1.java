package com.eVida.Ventanas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.conexion.Recursos.animal;

public class ventanaEmergente1 extends JFrame {

    protected animal mascota;
    protected JPanel contenedor;
    protected JLabel titulo;
    protected JLabel dueñoL, IdPerroL, apodoL, pesoL, tipoL, razaL, tipoDeSangreL, fechaNacimientoL, fechaAgregacionL,
            veterinarioL;
    protected JTextField dueño, IdPerro, apodo, peso, tipo, raza, tipoDeSangre, fechaNacimiento, fechaAgregacion,
            veterinario;
    protected Font fuenteTitulo = new Font("Times New Roman", Font.ROMAN_BASELINE, 50);
    protected Font fuenteLabels = new Font("Times New Roman", Font.ROMAN_BASELINE, 22);

    public ventanaEmergente1(animal a) {
        this.mascota = a;
        setSize(720, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setOpacity(1.0f);
        setTitle(mascota.getApodo());
        setLayout(null);
        setResizable(false);
        contenedor = new JPanel();
        contenedor.setBounds(0, 0, 720, 480);
        contenedor.setBackground(Color.WHITE);
        contenedor.setLayout(null);

        Thread ventana = new Thread() {
            @Override
            public void run() {
                titulo = new JLabel(mascota.getApodo());
                titulo.setBounds(0, 0, 720, 75);
                titulo.setBorder(BorderFactory.createLineBorder(Color.green));
                titulo.setFont(fuenteTitulo);
                titulo.setHorizontalAlignment(SwingConstants.CENTER);
                titulo.setVerticalAlignment(SwingConstants.CENTER);
                contenedor.add(titulo);

                dueñoL = new JLabel("Dueño");
                dueñoL.setBounds(20, 100, 150, 50);
                dueñoL.setFont(fuenteLabels);
                contenedor.add(dueñoL);
                // dueño = new JTextField(venPrincipal.Usuario.getApodo());
                dueño = new JTextField("aitoooor98");
                dueño.setDisabledTextColor(Color.black);
                dueño.setBounds(170, 100, 200, 50);
                dueño.setEnabled(false);
                dueño.setBackground(Color.white);
                dueño.setFont(fuenteLabels);
                contenedor.add(dueño);

                IdPerroL = new JLabel("Identificacion");
                IdPerroL.setBounds(20, 150, 150, 50);
                IdPerroL.setFont(fuenteLabels);
                contenedor.add(IdPerroL);
                IdPerro = new JTextField(mascota.getIdAnimal());
                IdPerro.setBounds(170, 150, 200, 50);
                IdPerro.setDisabledTextColor(Color.black);
                IdPerro.setEnabled(false);
                IdPerro.setBackground(Color.white);
                IdPerro.setFont(fuenteLabels);
                contenedor.add(IdPerro);

                apodoL = new JLabel("Apodo");
                apodoL.setBounds(20, 200, 150, 50);
                apodoL.setFont(fuenteLabels);
                contenedor.add(apodoL);
                apodo = new JTextField(mascota.getApodo());
                apodo.setBounds(170, 200, 200, 50);
                apodo.setDisabledTextColor(Color.black);
                apodo.setEnabled(false);
                apodo.setBackground(Color.white);
                apodo.setFont(fuenteLabels);
                contenedor.add(apodo);

                pesoL = new JLabel("Peso");
                pesoL.setBounds(20, 250, 150, 50);
                pesoL.setFont(fuenteLabels);
                contenedor.add(pesoL);
                peso = new JTextField(mascota.getPeso());
                peso.setBounds(170, 250, 200, 50);
                peso.setDisabledTextColor(Color.black);
                peso.setEnabled(false);
                peso.setBackground(Color.white);
                peso.setFont(fuenteLabels);
                contenedor.add(peso);

                tipoL = new JLabel("Tipo de animal");
                tipoL.setBounds(20, 300, 150, 50);
                tipoL.setFont(fuenteLabels);
                contenedor.add(tipoL);
                tipo = new JTextField(mascota.getTipo());
                tipo.setBounds(170, 300, 200, 50);
                tipo.setEnabled(false);
                tipo.setBackground(Color.white);
                tipo.setDisabledTextColor(Color.BLACK);
                tipo.setFont(fuenteLabels);
                contenedor.add(tipo);

                razaL = new JLabel("Raza");
                razaL.setBounds(20, 350, 150, 50);
                razaL.setFont(fuenteLabels);
                contenedor.add(razaL);
                raza = new JTextField(mascota.getRaza());
                raza.setBounds(170, 350, 200, 50);
                raza.setEnabled(false);
                raza.setDisabledTextColor(Color.black);
                raza.setBackground(Color.white);
                raza.setFont(fuenteLabels);
                contenedor.add(raza);

                contenedor.repaint();

            }
        };
        ventana.start();
        contenedor.repaint();
        add(contenedor);
    }

    public static void main(String[] args) {
        animal a = new animal("Perrete 1", "Perro", "Doberman", "20", "DEA1neg", "25/0/2020", 18);
        a.setIdAnimal("13");
        ventanaEmergente1 v = new ventanaEmergente1(a);
    }

}
