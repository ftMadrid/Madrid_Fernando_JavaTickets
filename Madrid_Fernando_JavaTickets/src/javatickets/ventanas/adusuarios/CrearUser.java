package javatickets.ventanas.adusuarios;

import java.awt.*;
import javatickets.usuarios.Administrador;
import javatickets.usuarios.Contenidos;
import javatickets.usuarios.Limitado;
import javatickets.usuarios.UserManager;
import javatickets.utilidades.Enums;
import javatickets.utilidades.Fondos;
import javatickets.ventanas.AdUsuarios;
import javax.swing.*;

public class CrearUser extends JFrame {

    public CrearUser() {
        initVentana();
        initComponentes();

    }

    private void initVentana() {

        setSize(700, 600);
        setTitle("JAVA TICKETS | CREAR USUARIO");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(700, 600);
        panel.setLayout(null);

        titulo.setBounds(-10, 50, 600, 128);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/crearusuario.png")));

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

        tipoLabel.setBounds(380, 260, 280, 40);
        tipoLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        tipoLabel.setForeground(Color.WHITE);

        tipo.setBounds(380, 290, 280, 50);
        tipo.setFont(new Font("Kefa", Font.BOLD, 20));

        crear.setBounds(380, 380, 150, 50);
        crear.setFont(new Font("Kefa", Font.BOLD, 18));
        crear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        crear.setForeground(new Color(0, 153, 0));
        crear.addActionListener(e -> crearAction());

        salir.setBounds(530, 380, 150, 50);
        salir.setFont(new Font("Kefa", Font.BOLD, 18));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        panel.add(titulo);
        panel.add(nombre);
        panel.add(usuario);
        panel.add(password);
        panel.add(edad);
        panel.add(nombreLabel);
        panel.add(usuarioLabel);
        panel.add(passwordLabel);
        panel.add(edadLabel);
        panel.add(tipoLabel);
        panel.add(tipo);
        panel.add(salir);
        panel.add(crear);
        add(panel);

    }

    private void crearAction() {

        int iedad;
        String nomb = nombre.getText().trim();
        String user = usuario.getText().trim();
        String pass = password.getText();
        Enums.TipoUsuarios seleccion = (Enums.TipoUsuarios) tipo.getSelectedItem();

        if (nombre.getText().equals("") || usuario.getText().equals("") || password.getText().equals("") || edad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tienes que llenar todos los campos!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            iedad = Integer.parseInt(edad.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan numeros enteros para la edad!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (iedad <= 0 || iedad >= 100) {
            JOptionPane.showMessageDialog(null, "Ingresa una edad valida!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UserManager target = UserManager.buscar(usuario.getText());

        if (target == null) {

            UserManager nuevoUsuario = null;

            switch (seleccion) {
                case ADMINISTRADOR:
                    nuevoUsuario = new Administrador(nomb, user, pass, iedad);
                    break;
                case CONTENIDO:
                    nuevoUsuario = new Contenidos(nomb, user, pass, iedad);
                    break;
                case LIMITADO:
                    nuevoUsuario = new Limitado(nomb, user, pass, iedad);
                    break;
            }

            if (nuevoUsuario != null) {

                JOptionPane.showMessageDialog(null, "Usuario creado exitosamente!\n"
                        + "\nNombre: " + nombre.getText()
                        + "\nUsuario: " + usuario.getText()
                        + "\nEdad: " + iedad + " años"
                        + "\nTipo: " + seleccion, "PROCESO EXITOSO", JOptionPane.INFORMATION_MESSAGE);

                UserManager.agregar(nuevoUsuario);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un miembro con ese usuario!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        dispose();
        new AdUsuarios().setVisible(true);

    }

    private void salirAction() {
        dispose();
        new AdUsuarios().setVisible(true);
    }

    private final JLabel titulo = new JLabel();
    private final JTextField nombre = new JTextField();
    private final JTextField usuario = new JTextField();
    private final JTextField password = new JTextField();
    private final JTextField edad = new JTextField();
    private final JLabel nombreLabel = new JLabel("Nombre:");
    private final JLabel usuarioLabel = new JLabel("Usuario:");
    private final JLabel passwordLabel = new JLabel("Contraseña:");
    private final JLabel edadLabel = new JLabel("Edad:");
    private final JLabel tipoLabel = new JLabel("Tipo de Usuario:");
    private final JComboBox<Enums.TipoUsuarios> tipo = new JComboBox<>(Enums.TipoUsuarios.values());
    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JButton salir = new JButton("REGRESAR");
    private final JButton crear = new JButton("CREAR");

    public static void main(String[] args) {
        new CrearUser().setVisible(true);
    }

}
