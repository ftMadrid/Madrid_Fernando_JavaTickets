package javatickets.utilidades;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondos extends JPanel {

    private Image imagen;

    public Fondos(String ruta) {
        imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setOpaque(false);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}
