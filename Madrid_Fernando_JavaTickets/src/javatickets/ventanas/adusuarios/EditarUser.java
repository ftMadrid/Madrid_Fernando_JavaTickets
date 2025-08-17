package javatickets.ventanas.adusuarios;

import javatickets.usuarios.UserManager;
import javatickets.utilidades.Enums;
import javatickets.utilidades.Fondos;
import javatickets.ventanas.AdUsuarios;
import javax.swing.*;
import java.awt.*;
import javatickets.ventanas.Principal;

public class EditarUser extends JFrame {

    public EditarUser() {
        initVentana();
        initComponentes();
    }

    private void initVentana() {

        setSize(700, 700);
        setTitle("JAVA TICKETS | EDITAR USUARIO");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(700, 700);
        panel.setLayout(null);

        titulo.setBounds(-10, 50, 600, 128);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/editarusuario.png")));

        buscarLabel.setBounds(50, 175, 280, 40);
        buscarLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        buscarLabel.setForeground(Color.WHITE);

        buscar.setBounds(50, 210, 280, 40);
        buscar.setFont(new Font("Kefa", Font.PLAIN, 18));

        buscarboton.setBounds(340, 210, 150, 40);
        buscarboton.setFont(new Font("Kefa", Font.BOLD, 18));
        buscarboton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buscarboton.setForeground(Color.BLUE);
        buscarboton.addActionListener(e -> buscarAction());

        nombreLabel.setBounds(50, 290, 280, 40);
        nombreLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        nombreLabel.setForeground(Color.WHITE);

        nombre.setBounds(50, 325, 280, 40);
        nombre.setFont(new Font("Kefa", Font.PLAIN, 18));
        nombre.setEnabled(false);

        usuarioLabel.setBounds(50, 370, 280, 40);
        usuarioLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        usuarioLabel.setForeground(Color.WHITE);

        usuario.setBounds(50, 405, 280, 40);
        usuario.setFont(new Font("Kefa", Font.PLAIN, 18));
        usuario.setEnabled(false);

        passwordLabel.setBounds(50, 455, 280, 40);
        passwordLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        passwordLabel.setForeground(Color.WHITE);

        password.setBounds(50, 490, 280, 40);
        password.setFont(new Font("Kefa", Font.PLAIN, 18));
        password.setEnabled(false);

        edadLabel.setBounds(50, 540, 280, 40);
        edadLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        edadLabel.setForeground(Color.WHITE);

        edad.setBounds(50, 575, 280, 40);
        edad.setFont(new Font("Kefa", Font.PLAIN, 18));
        edad.setEnabled(false);

        tipoLabel.setBounds(380, 355, 280, 40);
        tipoLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        tipoLabel.setForeground(Color.WHITE);

        tipo.setBounds(377, 385, 280, 50);
        tipo.setFont(new Font("Kefa", Font.BOLD, 20));
        tipo.setEnabled(false);

        editar.setBounds(380, 480, 150, 50);
        editar.setFont(new Font("Kefa", Font.BOLD, 18));
        editar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editar.setForeground(new Color(0, 153, 0));
        editar.addActionListener(e -> editarAction());
        editar.setEnabled(false);

        salir.setBounds(530, 480, 150, 50);
        salir.setFont(new Font("Kefa", Font.BOLD, 18));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        panel.add(titulo);
        panel.add(buscarLabel);
        panel.add(buscar);
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
        panel.add(editar);
        panel.add(buscarboton);
        add(panel);

    }

    private UserManager original;

    private void buscarAction() {

        UserManager target = UserManager.buscar(buscar.getText());
        original = target;

        if (buscar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tienes que ingresar un usuario para buscarlo!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (target != null) {
            if (buscar.getText().equals(UserManager.usuarios.get(0).getUsuario())) {
                JOptionPane.showMessageDialog(null, "No puedes editar a este usuario!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            } else {
                nombre.setText(target.getNombre());
                nombre.setEnabled(true);
                usuario.setText(target.getUsuario());
                usuario.setEnabled(true);
                password.setText(target.getPassword());
                password.setEnabled(true);
                edad.setText(String.valueOf(target.getEdad()));
                edad.setEnabled(true);

                switch (target.getTipo()) {
                    case ADMINISTRADOR:
                        tipo.setSelectedItem(Enums.TipoUsuarios.ADMINISTRADOR);
                        break;
                    case CONTENIDO:
                        tipo.setSelectedItem(Enums.TipoUsuarios.CONTENIDO);
                        break;
                    case LIMITADO:
                        tipo.setSelectedItem(Enums.TipoUsuarios.LIMITADO);
                        break;
                }
                tipo.setEnabled(true);
                editar.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Ahora estas editando al usuario " + buscar.getText(), "MODO EDICION", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario " + buscar.getText() + " no existe!", "ERROR", JOptionPane.ERROR_MESSAGE);
            nombre.setText("");
            nombre.setEnabled(false);
            usuario.setText("");
            usuario.setEnabled(false);
            password.setText("");
            password.setEnabled(false);
            edad.setText("");
            edad.setEnabled(false);
            tipo.setSelectedItem(null);
            tipo.setEnabled(false);
            editar.setEnabled(false);
        }

    }

    private void editarAction() {

        int iedad;

        UserManager existente = UserManager.buscar(usuario.getText());

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

        if (existente != null && existente != original) {
            JOptionPane.showMessageDialog(null, "Ya existe un miembro con ese usuario!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (iedad <= 0 || iedad >= 100) {
            JOptionPane.showMessageDialog(null, "Ingresa una edad valida!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Enums.TipoUsuarios seleccion = (Enums.TipoUsuarios) tipo.getSelectedItem();

        UserManager.editar(original, nombre.getText(), usuario.getText(), password.getText(), iedad, seleccion);
        JOptionPane.showMessageDialog(null, "Usuario editado exitosamente!\n"
                + "\nNombre: " + nombre.getText()
                + "\nUsuario: " + usuario.getText()
                + "\nEdad: " + iedad + " años"
                + "\nTipo: " + seleccion, "PROCESO EXITOSO", JOptionPane.INFORMATION_MESSAGE);

        if (original == UserManager.usuarioLogged) {

            UserManager.usuarioLogged = null;
            UserManager.logged = false;
            
            JOptionPane.showMessageDialog(null, "Se ha cerrado sesion por cambios hechos en tu cuenta!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            
            dispose();
            new Principal().setVisible(true);
            
        } else {
            dispose();
            new AdUsuarios().setVisible(true);
        }

    }

    private void salirAction() {
        dispose();
        new AdUsuarios().setVisible(true);
    }

    private final JLabel titulo = new JLabel();
    private final JTextField buscar = new JTextField();
    private final JTextField nombre = new JTextField();
    private final JTextField usuario = new JTextField();
    private final JTextField password = new JTextField();
    private final JTextField edad = new JTextField();
    private final JLabel buscarLabel = new JLabel("Buscar Usuario:");
    private final JLabel nombreLabel = new JLabel("Nombre:");
    private final JLabel usuarioLabel = new JLabel("Usuario:");
    private final JLabel passwordLabel = new JLabel("Contraseña:");
    private final JLabel edadLabel = new JLabel("Edad:");
    private final JLabel tipoLabel = new JLabel("Tipo de Usuario:");
    private final JComboBox<Enums.TipoUsuarios> tipo = new JComboBox<>(Enums.TipoUsuarios.values());
    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JButton salir = new JButton("REGRESAR");
    private final JButton editar = new JButton("EDITAR");
    private final JButton buscarboton = new JButton("BUSCAR");

    public static void main(String[] args) {
        new EditarUser().setVisible(true);
    }

}
