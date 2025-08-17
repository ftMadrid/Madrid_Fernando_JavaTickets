package javatickets.ventanas.reportes;

import javax.swing.*;
import java.awt.*;
import javatickets.usuarios.UserManager;
import javatickets.utilidades.Fondos;
import javatickets.ventanas.Reportes;

public class VerPerfil extends JFrame {

    public VerPerfil() {
        initVentana();
        initComponentes();
        initInformacion();
    }

    private void initVentana() {

        setSize(700, 600);
        setTitle("JAVA TICKETS | VER PERFIL");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(700, 600);
        panel.setLayout(null);

        titulo.setBounds(-10, 50, 400, 141);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/miperfil.png")));

        nombreLabel.setBounds(50, 195, 280, 40);
        nombreLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        nombreLabel.setForeground(Color.WHITE);

        nombre.setBounds(50, 230, 280, 40);
        nombre.setFont(new Font("Kefa", Font.PLAIN, 18));

        usuarioLabel.setBounds(50, 275, 280, 40);
        usuarioLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        usuarioLabel.setForeground(Color.WHITE);

        usuario.setBounds(50, 310, 280, 40);
        usuario.setFont(new Font("Kefa", Font.PLAIN, 18));

        passwordLabel.setBounds(50, 355, 280, 40);
        passwordLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        passwordLabel.setForeground(Color.WHITE);

        password.setBounds(50, 390, 280, 40);
        password.setFont(new Font("Kefa", Font.PLAIN, 18));

        edadLabel.setBounds(50, 435, 280, 40);
        edadLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        edadLabel.setForeground(Color.WHITE);

        edad.setBounds(50, 470, 280, 40);
        edad.setFont(new Font("Kefa", Font.PLAIN, 18));

        tipoLabel.setBounds(380, 195, 280, 40);
        tipoLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        tipoLabel.setForeground(Color.WHITE);

        tipo.setBounds(380, 230, 280, 40);
        tipo.setFont(new Font("Kefa", Font.PLAIN, 18));

        eventoscreadosLabel.setBounds(380, 275, 280, 40);
        eventoscreadosLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        eventoscreadosLabel.setForeground(Color.WHITE);

        eventoscreados.setBounds(380, 310, 280, 40);
        eventoscreados.setFont(new Font("Kefa", Font.PLAIN, 18));

        vereventos.setBounds(380, 385, 280, 50);
        vereventos.setFont(new Font("Kefa", Font.BOLD, 18));
        vereventos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        vereventos.setForeground(new Color(104, 87, 250));
        vereventos.addActionListener(e -> verEventosAction());

        salir.setBounds(380, 460, 280, 50);
        salir.setFont(new Font("Kefa", Font.BOLD, 18));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        nombre.setEditable(false);
        usuario.setEditable(false);
        password.setEditable(false);
        edad.setEditable(false);
        tipo.setEditable(false);
        eventoscreados.setEditable(false);

        panel.add(titulo);
        panel.add(nombre);
        panel.add(usuario);
        panel.add(password);
        panel.add(edad);
        panel.add(tipo);
        panel.add(eventoscreados);
        panel.add(nombreLabel);
        panel.add(usuarioLabel);
        panel.add(passwordLabel);
        panel.add(edadLabel);
        panel.add(tipoLabel);
        panel.add(eventoscreadosLabel);
        panel.add(salir);
        panel.add(vereventos);
        add(panel);

    }

    UserManager target = UserManager.usuarioLogged;

    private void initInformacion() {

        nombre.setText(target.getNombre());
        usuario.setText(target.getUsuario());
        password.setText(target.getPassword());
        edad.setText(String.valueOf(target.getEdad()));
        tipo.setText(String.valueOf(target.getTipo()));
        eventoscreados.setText(String.valueOf(target.getCantEventosCreados()));

    }

    private void verEventosAction() {

        if (target.getEventosCreados().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No has creado ningun evento para poder listarlos!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } else {
            JTextArea area = new JTextArea(target.getEventosCreados());
            area.setEditable(false);
            area.setFont(new Font("Kefa", Font.PLAIN, 14));
            JScrollPane scroll = new JScrollPane(area);
            scroll.setPreferredSize(new Dimension(500, 300));

            JOptionPane.showMessageDialog(null, scroll,
                    "Eventos Creados por " + UserManager.usuarioLogged.getUsuario(), JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void salirAction() {
        dispose();
        new Reportes().setVisible(true);
    }

    private final JLabel titulo = new JLabel();
    private final JTextField nombre = new JTextField();
    private final JTextField usuario = new JTextField();
    private final JTextField password = new JTextField();
    private final JTextField edad = new JTextField();
    private final JTextField tipo = new JTextField();
    private final JTextField eventoscreados = new JTextField();
    private final JLabel nombreLabel = new JLabel("Nombre:");
    private final JLabel usuarioLabel = new JLabel("Usuario:");
    private final JLabel passwordLabel = new JLabel("Contraseña:");
    private final JLabel edadLabel = new JLabel("Edad:");
    private final JLabel tipoLabel = new JLabel("Tipo de Usuario:");
    private final JLabel eventoscreadosLabel = new JLabel("Eventos Creados:");
    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JButton salir = new JButton("REGRESAR");
    private final JButton vereventos = new JButton("EVENTOS CREADOS");

    public static void main(String[] args) {
        new VerPerfil().setVisible(true);
    }

}
