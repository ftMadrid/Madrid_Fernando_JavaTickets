package javatickets.ventanas;

import java.awt.*;
import javatickets.usuarios.UserManager;
import javatickets.utilidades.Enums;
import javatickets.utilidades.Fondos;
import javatickets.ventanas.adeventos.CrearEvento;
import javatickets.ventanas.adeventos.EditarEvento;
import javatickets.ventanas.adeventos.EliminarEvento;
import javatickets.ventanas.adeventos.VerEvento;
import javax.swing.*;

public class AdEventos extends JFrame {

    public AdEventos() {
        initVentana();
        initComponentes();
    }

    private void initVentana() {
        setSize(700, 700);
        setTitle("JAVA TICKETS | ADMINISTRACIÓN DE EVENTOS");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(700, 700);
        panel.setLayout(null);

        titulo.setBounds(-10, 60, 650, 125);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/adusuarios.png")));
        titulo2.setBounds(0, 150, 390, 116);
        titulo2.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/adeventos.png")));

        crear.setBounds(50, 260, 320, 60);
        crear.setFont(new Font("Kefa", Font.BOLD, 18));
        crear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        crear.setForeground(Color.red);
        crear.addActionListener(e -> crearAction());
        
        borrar.setBounds(50, 335, 320, 60);
        borrar.setFont(new Font("Kefa", Font.BOLD, 18));
        borrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        borrar.setForeground(Color.red);
        borrar.addActionListener(e -> borrarAction());

        editar.setBounds(50, 410, 320, 60);
        editar.setFont(new Font("Kefa", Font.BOLD, 18));
        editar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editar.setForeground(Color.red);
        editar.addActionListener(e -> editarAction());
        
        ver.setBounds(50, 485, 320, 60);
        ver.setFont(new Font("Kefa", Font.BOLD, 18));
        ver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ver.setForeground(Color.red);
        ver.addActionListener(e -> verAction());

        salir.setBounds(50, 560, 320, 60);
        salir.setFont(new Font("Kefa", Font.BOLD, 18));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        panel.add(titulo);
        panel.add(titulo2);
        panel.add(crear);
        panel.add(editar);
        panel.add(borrar);
        panel.add(ver);
        panel.add(salir);
        add(panel);

    }

    private void crearAction() {
        if(UserManager.usuarioLogged.getTipo() == Enums.TipoUsuarios.LIMITADO){
            JOptionPane.showMessageDialog(null, "Los usuarios Limitados no pueden acceder aqui!", "ADMINISTRAR EVENTOS", JOptionPane.WARNING_MESSAGE);
        }else{
            dispose();
            new CrearEvento().setVisible(true);
        }
    }

    private void editarAction() {
        if(UserManager.usuarioLogged.getTipo() == Enums.TipoUsuarios.LIMITADO){
            JOptionPane.showMessageDialog(null, "Los usuarios Limitados no pueden acceder aqui!", "ADMINISTRAR EVENTOS", JOptionPane.WARNING_MESSAGE);
        }else{
            dispose();
            new EditarEvento().setVisible(true);
        }
    }

    private void borrarAction() {
        dispose();
        new EliminarEvento().setVisible(true);
    }
    
    private void verAction(){
        dispose();
        new VerEvento().setVisible(true);
    }

    private void salirAction() {
        dispose();
        new Sistema().setVisible(true);

    }

    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JLabel titulo = new JLabel();
    private final JLabel titulo2 = new JLabel();
    private final JButton crear = new JButton("CREAR EVENTO");
    private final JButton editar = new JButton("EDITAR EVENTO");
    private final JButton borrar = new JButton("ELIMINAR EVENTO");
    private final JButton ver = new JButton("VER EVENTO");
    private final JButton salir = new JButton("REGRESAR");

    public static void main(String[] args) {
        new AdEventos().setVisible(true);
    }

}
