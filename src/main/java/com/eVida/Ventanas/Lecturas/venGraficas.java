package com.eVida.Ventanas.Lecturas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import com.conexion.Conexion.Cliente;
import com.conexion.Recursos.animal;
import com.eVida.Recursos.buffer;
import com.eVida.Ventanas.venGenerica;
import com.eVida.Ventanas.venPrincipal;
import org.jfree.*;
import org.jfree.data.category.DefaultCategoryDataset;

public class venGraficas extends venGenerica {

    /**
     * Pet Project
     */
    private static final long serialVersionUID = 1L;
    protected JLabel idL, apodoL , tipoL, razaL, pesoL , sangreL , fechaNacL , fechaAgregL;
    protected animal animal;
    protected JLabel titulo , otrosPaneles , registros;
    protected String tituloS;
    protected JPanel panelGrafico;
    protected JComboBox elegirPanel , elegirRegistro;
    protected JButton recargar;
    protected venSeleccionReg vSR;

    public venGraficas(animal a) {
        super();
        animal = a;
        init();
    }

    private void init() {
        setTitulo("Ventana Pulso");
        setName("venGraficas");
        setComponentes();
    }

    @Override
    public void setComponentes(){
        Thread actualiza = new Thread(){
            @Override
            public void run(){

                if(buffer.seleccionComnbo.equals("Pulso")){
                    tituloS = "Pulsometro de: " + animal.getApodo();
                }else if(buffer.seleccionComnbo.equals("Oxigenacion")){
                    tituloS = "Oxigenacion de: " + animal.getApodo();
                }else if(buffer.seleccionComnbo.equals("Temperatura")){
                    tituloS = "Temperatura de: " + animal.getApodo();
                }else if(buffer.seleccionComnbo.equals("Aceleracion")){
                    tituloS = "Aceleracion de: " + animal.getApodo();
                }

                int ancho = venPrincipal.getPanelCentral().getWidth()-100;
                int anchoLabel = ancho/8;
                int var = 50;

                String id = "ID: "+animal.getIdAnimal();
                idL = new JLabel(id + animal.getIdAnimal());
                idL.setBounds(var , 0 , anchoLabel*1 , 50);
                idL.setBorder(BorderFactory.createLineBorder(Color.black));
                contenedor2.add(idL);
                var += anchoLabel;

                String apodo = "APODO: "+animal.getApodo();
                apodoL = new JLabel(apodo);
                apodoL.setBounds(var , 0 , anchoLabel , 50);
                apodoL.setBorder(BorderFactory.createLineBorder(Color.black));
                contenedor2.add(apodoL);
                var += anchoLabel;

                String tipo = "TIPO: " + animal.getTipo();
                tipoL = new JLabel(tipo);
                tipoL.setBounds(var , 0 , anchoLabel , 50);
                tipoL.setBorder(BorderFactory.createLineBorder(Color.black));
                contenedor2.add(tipoL);
                var += anchoLabel;

                String raza = "RAZA: " + animal.getRaza();
                razaL = new JLabel(raza);
                razaL.setBounds(var , 0 , anchoLabel , 50);
                razaL.setBorder(BorderFactory.createLineBorder(Color.black));
                contenedor2.add(razaL);
                var += anchoLabel;

                String peso = "PESO: " + animal.getPeso();
                pesoL = new JLabel(peso);
                pesoL.setBounds(var , 0 , anchoLabel , 50);
                pesoL.setBorder(BorderFactory.createLineBorder(Color.black));
                contenedor2.add(pesoL);
                var += anchoLabel;

                String sangre = "SANGRE: " + animal.getTipoSangre();
                sangreL = new JLabel(sangre);
                sangreL.setBounds(var , 0 , anchoLabel , 50);
                sangreL.setBorder(BorderFactory.createLineBorder(Color.black));
                contenedor2.add(sangreL);
                var += anchoLabel;

                String fechaNac = "FECHA DE NACIMIENTO: " + animal.getFechaNacimiento();
                fechaNacL = new JLabel(fechaNac);
                fechaNacL.setBounds(var , 0 , anchoLabel , 50);
                fechaNacL.setBorder(BorderFactory.createLineBorder(Color.black));
                contenedor2.add(fechaNacL);
                var += anchoLabel;

                String fechaAgreg = "FECHA DE AGREGACION: " + animal.getFechaFueAgregado();
                fechaAgregL = new JLabel(fechaAgreg);
                fechaAgregL.setBounds(var , 0 , anchoLabel , 50);
                fechaAgregL.setBorder(BorderFactory.createLineBorder(Color.black));
                contenedor2.add(fechaAgregL);
                var += anchoLabel;

                
                titulo = new JLabel(tituloS);
                titulo.setBounds((venPrincipal.getPanelCentral().getWidth()/2)-250 , 70 , 500 , 75);
                titulo.setFont(fuenteLabels);
                titulo.setHorizontalAlignment(SwingConstants.CENTER);
                //titulo.setBorder(BorderFactory.createLineBorder(Color.black));
                contenedor2.add(titulo);

                panelGrafico = new JPanel();
                panelGrafico.setBounds(200 , 130 , (venPrincipal.getPanelCentral().getWidth()-400) , 500);
                contenedor2.add(panelGrafico);

                String[] paneles = {"---------", "Oxigenación", "Pulso", "Temperatura", "Aceleración"};
                elegirPanel = new JComboBox<String>(paneles);
                elegirPanel.setBounds(50 , 170 , 120 , 50);
                elegirPanel.setBackground(Color.white);
                elegirPanel.setFocusable(false);
                elegirPanel.setFont(fuenteTT);
                contenedor2.add(elegirPanel);

                otrosPaneles = new JLabel("Otros paneles");
                otrosPaneles.setBounds(50 , 130 , 120 , 50);
                otrosPaneles.setHorizontalAlignment(SwingConstants.CENTER);
                otrosPaneles.setVerticalAlignment(SwingConstants.NORTH);
                otrosPaneles.setFont(fuenteTT);
                contenedor2.add(otrosPaneles);

                registros = new JLabel("Registros");
                registros.setBounds(1760 , 130 , 120 , 50);
                registros.setHorizontalAlignment(SwingConstants.CENTER);
                registros.setFont(fuenteTT);
                contenedor2.add(registros);

                elegirRegistro = new JComboBox<String>();
                elegirRegistro.setBounds(1760 , 170 , 150 , 50);
                elegirRegistro.setBackground(Color.white);
                elegirRegistro.setFocusable(false);
                elegirRegistro.setFont(fuenteTT);
                setComboRegistros();
                contenedor2.add(elegirRegistro);

                Color col = Color.decode("#1660a9");
                recargar = new JButton("R");
                recargar.setBounds(venPrincipal.getPanelCentral().getWidth() - 550, 700, 100, 40);
                recargar.setBackground(col);
                recargar.setForeground(Color.white);
                recargar.setFocusable(false);
                recargar.setToolTipText("Recargar datos");
                contenedor2.add(recargar);

        
                //Grafico pulso

                int n1 = 20;
                int n2 = 30;
                int n3 = 40;
                int n4 = 20;

                //DefaultCategoryDataset datos = new DefaultCategoryDataset();
                //datos.setValue(value, rowKey, columnKey);

                add(contenedor2);
                contenedor2.repaint();
            }

        };
        actualiza.start();
    }

    private void setComboRegistros(){
        String registros = "---------";
        elegirRegistro.addItem(registros);
        try {
            System.out.println("ID del animal y dueño: " + animal.getIdAnimal() + "  "+ animal.getIdUsuario());
           Cliente getMetricas = new Cliente("1011");
           ArrayList<String> regs = getMetricas.getMediciones(animal.getIdAnimal(), animal.getIdUsuario()+"");
           if(regs.size()==0){
            JOptionPane.showMessageDialog(null, "No hay mediciones para: " + animal.getApodo(), "Error",
            JOptionPane.ERROR_MESSAGE);
           }else{
            for(String s : regs){
                String[] tmp = s.split(",");
                elegirRegistro.addItem(tmp[3]);
            }
           }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
