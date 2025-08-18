package javatickets.ventanas.adeventos;

import javatickets.eventos.EventsManager;
import javatickets.utilidades.Calculos;
import javatickets.utilidades.Fondos;
import javatickets.ventanas.AdEventos;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import javatickets.usuarios.UserManager;

public class EliminarEvento extends JFrame {

    public EliminarEvento() {
        initVentana();
        initComponentes();

    }

    private void initVentana() {

        setSize(600, 500);
        setTitle("JAVA TICKETS | ELIMINAR EVENTO");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(600, 500);
        panel.setLayout(null);

        titulo.setBounds(-10, 50, 580, 118);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/eliminarevento.png")));

        codigoLabel.setBounds(50, 200, 280, 40);
        codigoLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        codigoLabel.setForeground(Color.WHITE);

        codigo.setBounds(50, 240, 255, 40);
        codigo.setFont(new Font("Kefa", Font.PLAIN, 18));

        borrar.setBounds(50, 310, 125, 50);
        borrar.setFont(new Font("Kefa", Font.BOLD, 18));
        borrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        borrar.setForeground(new Color(0, 153, 0));
        borrar.addActionListener(e -> borrarAction());

        salir.setBounds(180, 310, 125, 50);
        salir.setFont(new Font("Kefa", Font.BOLD, 18));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        panel.add(titulo);
        panel.add(codigo);
        panel.add(codigoLabel);
        panel.add(salir);
        panel.add(borrar);
        add(panel);

    }

    private void borrarAction() {

        Calendar hoy = Calendar.getInstance();

        int icodigo;
        double indemnizacion;

        if (codigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tienes que llenar todos los campos!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            icodigo = Integer.parseInt(codigo.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan numeros enteros para el codigo!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EventsManager target = EventsManager.buscar(icodigo);

        if (target != null) {
            if (target.getEstado()) {
                if (target.getCreador() == UserManager.usuarioLogged || UserManager.usuarioLogged == UserManager.usuarios.get(0)) {
                    if (target.getFechaEvento().after(hoy)) {

                        int opcion = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar el evento " + target.getTitulo() + "?", "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION);
                        if (opcion == JOptionPane.YES_OPTION) {
                            indemnizacion = Calculos.cobrarIndemnizacion(icodigo);
                            Calculos.agregarSaldo(indemnizacion);
                            target.setIndemnizacion(indemnizacion);
                            dispose();
                            new AdEventos().setVisible(true);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No puedes cancelar este evento porque ya se realizo!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No puedes cancelar este evento porque no eres el creador!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El evento con codigo [" + icodigo + "] ya esta cancelado!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El evento con codigo [" + icodigo + "] no existe!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void salirAction() {
        dispose();
        new AdEventos().setVisible(true);
    }

    private final JLabel titulo = new JLabel();
    private final JTextField codigo = new JTextField();
    private final JLabel codigoLabel = new JLabel("Codigo del Evento:");
    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JButton salir = new JButton("REGRESAR");
    private final JButton borrar = new JButton("BORRAR");

    public static void main(String[] args) {
        new EliminarEvento().setVisible(true);
    }

}
