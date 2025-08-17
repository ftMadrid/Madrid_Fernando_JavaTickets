package javatickets.ventanas;

import javax.swing.*;
import java.awt.*;
import javatickets.utilidades.Fondos;
import javatickets.ventanas.reportes.EventosCancelados;
import javatickets.ventanas.reportes.EventosFuturos;
import javatickets.ventanas.reportes.EventosRealizados;
import javatickets.ventanas.reportes.VerPerfil;

public class Reportes extends JFrame {

    public Reportes() {
        initVentana();
        initComponentes();
    }

    private void initVentana() {

        setSize(700, 700);
        setTitle("JAVA TICKETS | REPORTES");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(700, 700);
        panel.setLayout(null);

        titulo.setBounds(-10, 60, 540, 150);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/tituloreportes.png")));

        eventosrealizados.setBounds(50, 200, 320, 60);
        eventosrealizados.setFont(new Font("Kefa", Font.BOLD, 18));
        eventosrealizados.setCursor(new Cursor(Cursor.HAND_CURSOR));
        eventosrealizados.setForeground(Color.red);
        eventosrealizados.addActionListener(e -> eventosRealizadosAction());

        eventosfuturos.setBounds(50, 275, 320, 60);
        eventosfuturos.setFont(new Font("Kefa", Font.BOLD, 18));
        eventosfuturos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        eventosfuturos.setForeground(Color.red);
        eventosfuturos.addActionListener(e -> eventosFuturosAction());

        eventoscancelados.setBounds(50, 350, 320, 60);
        eventoscancelados.setFont(new Font("Kefa", Font.BOLD, 18));
        eventoscancelados.setCursor(new Cursor(Cursor.HAND_CURSOR));
        eventoscancelados.setForeground(Color.red);
        eventoscancelados.addActionListener(e -> eventosCanceladosAction());
        
        ingeneradosfecha.setBounds(50, 425, 320, 60);
        ingeneradosfecha.setFont(new Font("Kefa", Font.BOLD, 17));
        ingeneradosfecha.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ingeneradosfecha.setForeground(Color.red);
        
        perfiluser.setBounds(50, 500, 320, 60);
        perfiluser.setFont(new Font("Kefa", Font.BOLD, 18));
        perfiluser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        perfiluser.setForeground(Color.red);
        perfiluser.addActionListener(e -> verPerfilAction());

        salir.setBounds(50, 575, 320, 60);
        salir.setFont(new Font("Kefa", Font.BOLD, 18));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        panel.add(titulo);
        panel.add(eventosrealizados);
        panel.add(eventosfuturos);
        panel.add(eventoscancelados);
        panel.add(ingeneradosfecha);
        panel.add(perfiluser);
        panel.add(salir);
        add(panel);

    }

    private void eventosRealizadosAction() {
        dispose();
        new EventosRealizados().setVisible(true);

    }

    private void eventosFuturosAction() {
        dispose();
        new EventosFuturos().setVisible(true);
    }
    
    private void eventosCanceladosAction() {
        dispose();
        new EventosCancelados().setVisible(true);
    }
    
    private void verPerfilAction(){
        dispose();
        new VerPerfil().setVisible(true);
    }

    private void salirAction() {

        dispose();
        new Sistema().setVisible(true);

    }

    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JLabel titulo = new JLabel();
    private final JButton eventosrealizados = new JButton("EVENTOS REALIZADOS");
    private final JButton eventosfuturos = new JButton("EVENTOS FUTUROS");
    private final JButton eventoscancelados = new JButton("EVENTOS CANCELADOS");
    private final JButton ingeneradosfecha = new JButton("INGRESOS GENERADOS POR FECHA");
    private final JButton perfiluser = new JButton("VER PERFIL");
    private final JButton salir = new JButton("REGRESAR");

    public static void main(String[] args) {
        new Reportes().setVisible(true);
    }

}
