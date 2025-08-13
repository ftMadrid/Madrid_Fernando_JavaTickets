package javatickets.utilidades;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public final class Fondos extends JPanel {

    private final Image imagen;

    public Fondos(String ruta) {
        imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
    }

    @Override
    protected final void paintComponent(Graphics g) {
        super.paintComponent(g);
        setOpaque(false);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}
