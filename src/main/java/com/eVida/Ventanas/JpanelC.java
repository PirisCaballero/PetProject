package com.eVida.Ventanas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class JpanelC extends JPanel {


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Image img = ImageIO.read(new File("src/main/java/com/eVida/Recursos/img/bgi2.png"));
            Image img2 = ImageIO.read(new File("src/main/java/com/eVida/Recursos/img/bgi2-2.png"));
            g.drawImage(img , 0, 0, null);
            repaint();
            g.drawImage(img2 , 1750, 0, null);
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
