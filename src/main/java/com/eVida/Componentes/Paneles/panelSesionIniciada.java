package com.eVida.Componentes.Paneles;

import com.eVida.Ventanas.venGenerica;

public class panelSesionIniciada extends venGenerica {

    protected Thread componentes;

    public panelSesionIniciada() {
        super();
        init();
    }

    private void init() {
        setName("venSesionIniciada");
        setComponentes();
    }

    @Override
    public void setComponentes() {
        componentes = new Thread() {
            @Override
            public void run() {
                setTitulo("Sesion Iniciada");
                repaint();
            }
        };
        componentes.start();
    }

}
