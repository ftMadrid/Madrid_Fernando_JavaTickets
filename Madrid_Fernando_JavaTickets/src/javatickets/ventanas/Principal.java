package javatickets.ventanas;

import java.awt.*;
import javatickets.utilidades.Fondos;
import javax.swing.*;

public class Principal extends JFrame {

    public Principal() {
        initVentana();
        initComponentes();
    }

    private void initVentana() {

        setSize(700, 600);
        setTitle("JAVA TICKETS");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(700, 600);
        panel.setLayout(null);

        titulo.setBounds(-10, 110, 600, 150);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/titulo.png")));
        
        permisos.setBounds(280, 300, 500, 100);
        permisos.setFont(new Font("Kefa", Font.BOLD, 24));
        permisos.setForeground(Color.WHITE);

        login.setBounds(50, 250, 200, 60);
        login.setFont(new Font("Kefa", Font.BOLD, 24));
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.setForeground(Color.red);
        login.addActionListener(e -> botonAction());

        salir.setBounds(50, 330, 200, 60);
        salir.setFont(new Font("Kefa", Font.BOLD, 24));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        panel.add(titulo);
        panel.add(permisos);
        panel.add(login);
        panel.add(salir);
        add(panel);

    }

    private void botonAction() {
        new Login().setVisible(true);
        dispose();
    }

    private void salirAction() {
        dispose();
        System.out.println("[CONSOLE LOG] Cerrando el programa...");
        System.exit(0);
    }

    private JLabel titulo = new JLabel();
    private JLabel permisos = new JLabel();
    private JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private JButton login = new JButton("LOGIN");
    private JButton salir = new JButton("SALIR");

    public static void main(String[] args) {
        new Principal().setVisible(true);
    }

}
