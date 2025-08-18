package javatickets.ventanas.adusuarios;

import javatickets.usuarios.UserManager;
import javatickets.utilidades.Fondos;
import javatickets.ventanas.AdUsuarios;
import javatickets.ventanas.Principal;
import javax.swing.*;
import java.awt.*;

public class BorrarUser extends JFrame {

    public BorrarUser() {
        initVentana();
        initComponentes();

    }

    private void initVentana() {

        setSize(600, 500);
        setTitle("JAVA TICKETS | BORRAR USUARIO");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(600, 500);
        panel.setLayout(null);

        titulo.setBounds(-10, 50, 580, 118);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/borrarusuario.png")));

        usuarioLabel.setBounds(50, 200, 280, 40);
        usuarioLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        usuarioLabel.setForeground(Color.WHITE);

        usuario.setBounds(50, 240, 280, 40);
        usuario.setFont(new Font("Kefa", Font.PLAIN, 18));

        borrar.setBounds(50, 310, 150, 50);
        borrar.setFont(new Font("Kefa", Font.BOLD, 18));
        borrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        borrar.setForeground(new Color(0, 153, 0));
        borrar.addActionListener(e -> borrarAction());

        salir.setBounds(200, 310, 150, 50);
        salir.setFont(new Font("Kefa", Font.BOLD, 18));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        panel.add(titulo);
        panel.add(usuario);
        panel.add(usuarioLabel);
        panel.add(salir);
        panel.add(borrar);
        add(panel);

    }

    private void borrarAction() {

        UserManager target = UserManager.buscar(usuario.getText());

        if (usuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tienes que llenar todos los campos!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (target != null) {
            if (usuario.getText().equals(UserManager.usuarios.get(0).getUsuario())) {
                JOptionPane.showMessageDialog(null, "No puedes borrar a este usuario!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            } else {
                int opcion = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar al usuario " + usuario.getText() + "?", "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    UserManager.borrar(target);
                    JOptionPane.showMessageDialog(null, "Se ha eliminado con exito al usuario " + usuario.getText() + "!", "PROCESO EXITOSO", JOptionPane.INFORMATION_MESSAGE);
                    if (target.equals(UserManager.usuarioLogged)) {
                        UserManager.usuarioLogged = null;
                        UserManager.logged = false;

                        JOptionPane.showMessageDialog(null, "Se ha cerrado sesion porque se ha eliminado tu cuenta!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

                        dispose();
                        new Principal().setVisible(true);
                    } else {
                        dispose();
                        new AdUsuarios().setVisible(true);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario.getText() + " no existe!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void salirAction() {
        dispose();
        new AdUsuarios().setVisible(true);
    }

    private final JLabel titulo = new JLabel();
    private final JTextField usuario = new JTextField();
    private final JLabel usuarioLabel = new JLabel("Usuario:");
    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JButton salir = new JButton("REGRESAR");
    private final JButton borrar = new JButton("BORRAR");

    public static void main(String[] args) {
        new BorrarUser().setVisible(true);
    }

}
