package com.eVida.Componentes;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.FutureTask;


public class menuSuperior extends JMenuBar{

    /**
     *Pet Project
     */
    private static final long serialVersionUID = 1L;
    private java.awt.Font fuenteMenu;
    private java.awt.Font fuenteMenu2;

    public menuSuperior() {
        fuenteMenu = new java.awt.Font("Times New Roman ", java.awt.Font.PLAIN, 17);
        fuenteMenu2 = new java.awt.Font("Times New Roman ", java.awt.Font.PLAIN, 14);
        JMenu inicio = new JMenu("Inicio"); inicio.setFont(fuenteMenu); this.add(inicio);
        JMenuItem salir = new JMenuItem("Salir");salir.setFont(fuenteMenu2); inicio.add(salir);
        /* ************************* */


        JMenu lecturas = new JMenu("Lecturas"); lecturas.setFont(fuenteMenu); this.add(lecturas);
        JMenuItem Lsensor = new JMenuItem("Lectura del sensor"); Lsensor.setFont(fuenteMenu2); lecturas.add(Lsensor);
        JMenuItem Lpulso = new JMenuItem("Lectura del pulso"); Lpulso.setFont(fuenteMenu2); lecturas.add(Lpulso);
        JMenuItem Laceleraciones = new JMenuItem("Lectura de las aceleraciones"); Laceleraciones.setFont(fuenteMenu2); lecturas.add(Laceleraciones);
        JMenuItem Lmovimiento = new JMenuItem("Lectura del movimiento"); Lmovimiento.setFont(fuenteMenu2); lecturas.add(Lmovimiento);
        /* ************************* */


        JMenu animales = new JMenu("Animales"); animales.setFont(fuenteMenu); this.add(animales);
        JMenuItem Aagregar = new JMenuItem("Agregar animal"); Aagregar.setFont(fuenteMenu2); animales.add(Aagregar);
        JMenuItem Aver = new JMenuItem("Ver animal"); Aver.setFont(fuenteMenu2); animales.add(Aver);
        JMenuItem Aeliminar = new JMenuItem("Eliminar animal"); Aeliminar.setFont(fuenteMenu2); animales.add(Aeliminar);
        /* ************************* */


        JMenu quienesSomos = new JMenu("Quienes somos"); quienesSomos.setFont(fuenteMenu); this.add(quienesSomos);
        /* ************************* */


        ActionListener salirL = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        salir.addActionListener(salirL);

        
    }
    
}
