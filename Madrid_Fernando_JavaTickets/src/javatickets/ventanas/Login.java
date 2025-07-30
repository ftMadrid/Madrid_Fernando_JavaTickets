package javatickets.ventanas;

import java.awt.*;
import javatickets.usuarios.Administrador;
import javatickets.usuarios.Usuarios;
import javatickets.utilidades.Fondos;
import javax.swing.*;

public class Login extends JFrame {

    Administrador admin = new Administrador();

    public Login() {
        initVentana();
        initComponentes();

        Usuarios.usuarios[1] = new Usuarios("Fernando Madrid", "Fernando", "12345", 18);
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

        titulo.setBounds(155, 50, 400, 150);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/login.png")));

        usuario.setBounds(210, 250, 280, 45);
        usuario.setFont(new Font("Kefa", Font.PLAIN, 18));

        password.setBounds(210, 340, 280, 45);
        password.setFont(new Font("Kefa", Font.PLAIN, 18));

        userText.setBounds(210, 180, 200, 100);
        userText.setFont(new Font("Kefa", Font.BOLD, 24));
        userText.setForeground(Color.white);

        passText.setBounds(210, 270, 200, 100);
        passText.setFont(new Font("Kefa", Font.BOLD, 24));
        passText.setForeground(Color.white);

        aceptar.setBounds(370, 420, 120, 50);
        aceptar.setFont(new Font("Kefa", Font.BOLD, 20));
        aceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        aceptar.setForeground(new Color(0, 153, 0));
        aceptar.addActionListener(e -> loginAction());

        regresar.setBounds(210, 420, 120, 50);
        regresar.setFont(new Font("Kefa", Font.BOLD, 20));
        regresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        regresar.setForeground(Color.red);
        regresar.addActionListener(e -> regresarAction());

        panel.add(aceptar);
        panel.add(regresar);
        panel.add(titulo);
        panel.add(usuario);
        panel.add(password);
        panel.add(userText);
        panel.add(passText);
        add(panel);

    }

    private void loginAction() {

        boolean encontrado = false;

        if (usuario.getText().equals("") || password.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tienes que llenar todos los campos!", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (usuario.getText().equals(admin.getUsuario())) {
            if (password.getText().equals(admin.getPassword())) {
                Usuarios.logged = true;
                Usuarios.usuarioLogged = admin;
                JOptionPane.showMessageDialog(null, "Logueado como Administrador", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
                new Sistema().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña es incorrecta!", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
            }
            return;
        }

        for (int i = 0; i < Usuarios.cantidadUsuarios; i++) {
            if (Usuarios.usuarios[i] != null && usuario.getText().equals(Usuarios.usuarios[i].getUsuario())) {
                encontrado = true;
                if (password.getText().equals(Usuarios.usuarios[i].getPassword())) {
                    Usuarios.logged = true;
                    Usuarios.usuarioLogged = Usuarios.usuarios[i];
                    JOptionPane.showMessageDialog(null, "Logueado como " + Usuarios.usuarios[i].getUsuario(), "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
                    new Sistema().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta!", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
                }
                return;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Este usuario no existe!", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void regresarAction() {
        Principal principal = new Principal();
        principal.setVisible(true);
        dispose();
    }

    private JTextField usuario = new JTextField();
    private JTextField password = new JTextField();
    private JLabel userText = new JLabel("Usuario:");
    private JLabel passText = new JLabel("Contraseña:");
    private JLabel titulo = new JLabel();
    private JButton aceptar = new JButton("ACEPTAR");
    private JButton regresar = new JButton("REGRESAR");
    JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
