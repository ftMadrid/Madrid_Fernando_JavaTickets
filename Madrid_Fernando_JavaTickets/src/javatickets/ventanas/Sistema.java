package javatickets.ventanas;

import java.awt.*;
import javatickets.utilidades.Fondos;
import javatickets.usuarios.UserManager;
import javatickets.utilidades.Enums;
import javax.swing.*;

public class Sistema extends JFrame {

    public Sistema() {
        initVentana();
        initComponentes();
    }

    private void initVentana() {

        setSize(700, 600);
        setTitle("JAVA TICKETS | SISTEMA");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(700, 600);
        panel.setLayout(null);

        titulo.setBounds(-10, 60, 580, 178);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/titulosistema.png")));

        adeventos.setBounds(50, 250, 320, 60);
        adeventos.setFont(new Font("Kefa", Font.BOLD, 18));
        adeventos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adeventos.setForeground(Color.red);
        adeventos.addActionListener(e -> adEventosAction());

        adusuarios.setBounds(50, 325, 320, 60);
        adusuarios.setFont(new Font("Kefa", Font.BOLD, 18));
        adusuarios.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adusuarios.setForeground(Color.red);
        adusuarios.addActionListener(e -> adUsuariosAction());

        reportes.setBounds(50, 400, 320, 60);
        reportes.setFont(new Font("Kefa", Font.BOLD, 20));
        reportes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reportes.setForeground(Color.red);

        salir.setBounds(50, 475, 320, 60);
        salir.setFont(new Font("Kefa", Font.BOLD, 20));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        panel.add(titulo);
        panel.add(adeventos);
        panel.add(adusuarios);
        panel.add(reportes);
        panel.add(salir);
        add(panel);

    }

    private void adEventosAction() {
        dispose();
        new AdEventos().setVisible(true);

    }

    private void adUsuariosAction() {

        if (UserManager.usuarioLogged.getTipo() == Enums.TipoUsuarios.ADMINISTRADOR) {
            dispose();
            new AdUsuarios().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Solo los Administradores pueden ingresar aqui!", "ADMINISTRAR USUARIOS", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void salirAction() {

        dispose();
        UserManager.logged = false;
        new Principal().setVisible(true);
        /*System.out.println("[CONSOLE LOG] Cerrando el programa...");
        System.exit(0);*/

    }

    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JLabel titulo = new JLabel();
    private final JButton adeventos = new JButton("ADMINISTRACIÓN DE EVENTOS");
    private final JButton adusuarios = new JButton("ADMINISTRACIÓN DE USUARIOS");
    private final JButton reportes = new JButton("REPORTES");
    private final JButton salir = new JButton("SALIR");

    public static void main(String[] args) {
        new Sistema().setVisible(true);
    }

}
