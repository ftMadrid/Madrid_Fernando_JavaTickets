package javatickets.ventanas;

import java.awt.*;
import javatickets.utilidades.Fondos;
import javatickets.ventanas.adusuarios.Borrar;
import javatickets.ventanas.adusuarios.Crear;
import javatickets.ventanas.adusuarios.Editar;
import javax.swing.*;

public class AdUsuarios extends JFrame {

    public AdUsuarios() {
        initVentana();
        initComponentes();
    }

    private void initVentana() {

        setSize(700, 600);
        setTitle("JAVA TICKETS | ADMINISTRACIÓN DE USUARIOS");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(700, 600);
        panel.setLayout(null);

        titulo.setBounds(-10, 60, 650, 125);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/adusuarios.png")));
        titulo2.setBounds(5, 150, 380, 107);
        titulo2.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/adusuarios2.png")));

        crear.setBounds(50, 250, 320, 60);
        crear.setFont(new Font("Kefa", Font.BOLD, 18));
        crear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        crear.setForeground(Color.red);
        crear.addActionListener(e -> crearAction());

        editar.setBounds(50, 325, 320, 60);
        editar.setFont(new Font("Kefa", Font.BOLD, 18));
        editar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editar.setForeground(Color.red);
        editar.addActionListener(e -> editarAction());

        borrar.setBounds(50, 400, 320, 60);
        borrar.setFont(new Font("Kefa", Font.BOLD, 18));
        borrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        borrar.setForeground(Color.red);
        borrar.addActionListener(e -> borrarAction());

        salir.setBounds(50, 475, 320, 60);
        salir.setFont(new Font("Kefa", Font.BOLD, 18));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        panel.add(titulo);
        panel.add(titulo2);
        panel.add(crear);
        panel.add(editar);
        panel.add(borrar);
        panel.add(salir);
        add(panel);

    }

    private void crearAction() {
        dispose();
        new Crear().setVisible(true);
    }

    private void editarAction() {
        dispose();
        new Editar().setVisible(true);
    }

    private void borrarAction() {
        dispose();
        new Borrar().setVisible(true);
    }

    private void salirAction() {

        dispose();
        new Sistema().setVisible(true);

    }

    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JLabel titulo = new JLabel();
    private final JLabel titulo2 = new JLabel();
    private final JButton crear = new JButton("CREAR USUARIO");
    private final JButton editar = new JButton("EDITAR USUARIO");
    private final JButton borrar = new JButton("BORRAR USUARIO");
    private final JButton salir = new JButton("REGRESAR");

    public static void main(String[] args) {
        new AdUsuarios().setVisible(true);
    }

}
