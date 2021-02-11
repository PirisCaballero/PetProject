package main.java.com.eVida.Ventanas;
import java.awt.BorderLayout;
import javax.swing.*;

public class venGenerica extends JPanel{

    /**
     * Pet Project
     */
    private static final long serialVersionUID = 1L;
    public JPanel panelPrincipal = new JPanel();

    public venGenerica(){
        setName("venGenerica");
        setLayout(new BorderLayout());
        panelPrincipal.setLayout(new BorderLayout());
        add(panelPrincipal , BorderLayout.CENTER);
    }

    public void addComp(JComponent comp , String pos){
        this.panelPrincipal.add(comp , pos);
    }
    
}
