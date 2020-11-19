package com.eVida.Ventanas;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.eVida.Componentes.menuSuperior;

public class venPrincipal {

    /**
     *PetProject
     */
    private JFrame vP;
    private Thread hiloPrincipal;

    public venPrincipal(){
        vP = new JFrame();
        vP.setTitle("Pet Project");
        vP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vP.setResizable(false);
        vP.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        vP.setUndecorated(true);
        //vP.setSize(720 , 480);
        vP.setLayout(null);
        vP.setLocationRelativeTo(null);

        hiloPrincipal = new Thread(){
            @Override
            public void run(){
                System.out.println("El hilo funciona");
                menuSuperior menu = new menuSuperior();

                vP.setJMenuBar(menu);
                vP.setVisible(true);
            }

        };
        hiloPrincipal.start();
        
        
    }
    
}
