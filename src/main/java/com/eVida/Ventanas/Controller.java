package main.java.com.eVida.Ventanas;

import java.awt.BorderLayout;

import com.eVida.App;
import com.eVida.Ventanas.venPrincipal;

import main.java.com.eVida.Ventanas.Lecturas.venPulso;

public class Controller {

        public static void panelSwitch(String panelName){
            if(panelName.equals("venPulso")){
                venPulso vPl = new venPulso();
                venGenerica vG = new venGenerica();
                App.vP.getPanelCentral().removeAll();
                App.vP.getPanelCentral().add(vG , BorderLayout.CENTER);
                App.vP.getVp().repaint();
                App.vP.getPanelCentral().repaint();


                System.out.println(App.vP.getPanelCentral().getComponent(0).getName());
                System.out.println("Ventana pulso  " + App.vP.getPanelCentral().getComponentCount());
            }
        }
}
