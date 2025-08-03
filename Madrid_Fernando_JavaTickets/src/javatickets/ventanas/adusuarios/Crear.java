package javatickets.ventanas.adusuarios;

import java.awt.*;
import javatickets.usuarios.Administrador;
import javatickets.usuarios.Contenidos;
import javatickets.usuarios.Limitado;
import javatickets.usuarios.Usuarios;
import javatickets.utilidades.Fondos;
import javatickets.ventanas.AdUsuarios;
import javax.swing.*;

public class Crear extends JFrame {

    public Crear() {
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
        
        if(nombre.getText().equals("") || usuario.getText().equals("") || password.getText().equals("") || edad.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tienes que llenar todos los campos!", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            iedad = Integer.parseInt(edad.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan numeros enteros para la edad!", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (Usuarios.buscar(usuario.getText()) == null) {

            String seleccion = (String) tipo.getSelectedItem();
            String tipouser = "";
            Usuarios nuevoUsuario = null;

            switch (seleccion) {
                case "Administrador":
                    nuevoUsuario = new Administrador(nombre.getText(), usuario.getText(), password.getText(), iedad);
                    tipouser = "Administrador";
                    break;
                case "Contenido":
                    nuevoUsuario = new Contenidos(nombre.getText(), usuario.getText(), password.getText(), iedad);
                    tipouser = "Contenidos";
                    break;
                case "Limitado":
                    nuevoUsuario = new Limitado(nombre.getText(), usuario.getText(), password.getText(), iedad);
                    tipouser = "Limitado";
                    break;
            }

            if (nuevoUsuario != null) {
                
                JOptionPane.showMessageDialog(null, "Usuario creado exitosamente!\n"
                            +"\nNombre: "+nombre.getText()
                            +"\nUsuario: "+usuario.getText()
                            +"\nEdad: "+iedad+" años"
                            +"\nTipo: "+tipouser, "PROCESO EXITOSO", JOptionPane.INFORMATION_MESSAGE);
                
                Usuarios.agregar(nuevoUsuario);
                Usuarios.cantidadUsuarios++;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un miembro con ese usuario!", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        dispose();
        new AdUsuarios().setVisible(true);

    }

    private void salirAction() {
        dispose();
        new AdUsuarios().setVisible(true);
    }

    private JLabel titulo = new JLabel();
    private JTextField nombre = new JTextField();
    private JTextField usuario = new JTextField();
    private JTextField password = new JTextField();
    private JTextField edad = new JTextField();
    private JLabel nombreLabel = new JLabel("Nombre:");
    private JLabel usuarioLabel = new JLabel("Usuario:");
    private JLabel passwordLabel = new JLabel("Contraseña:");
    private JLabel edadLabel = new JLabel("Edad:");
    private JLabel tipoLabel = new JLabel("Tipo de Usuario:");
    private JComboBox<String> tipo = new JComboBox<>(new String[]{"Administrador", "Contenido", "Limitado"});
    private JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private JButton salir = new JButton("REGRESAR");
    private JButton crear = new JButton("CREAR");

    public static void main(String[] args) {
        new Crear().setVisible(true);
    }

}
