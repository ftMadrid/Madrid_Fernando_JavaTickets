package javatickets.ventanas.adeventos;

import com.toedter.calendar.JDateChooser;
import javatickets.eventos.EventsManager;
import javatickets.usuarios.UserManager;
import javatickets.utilidades.Fondos;
import javatickets.ventanas.AdUsuarios;
import javax.swing.*;
import java.awt.*;

public class EditarEvento extends JFrame {

    public EditarEvento() {
        initVentana();
        initComponentes();
    }

    private void initVentana() {

        setSize(1200, 700);
        setTitle("JAVA TICKETS | EDITAR EVENTO");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(1200, 700);
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

        codigoLabel.setBounds(650, 100, 280, 40);
        codigoLabel.setFont(new Font("Kefa", Font.BOLD, 28));
        codigoLabel.setForeground(Color.WHITE);

        eventoLabel.setBounds(650, 150, 280, 40);
        eventoLabel.setFont(new Font("Kefa", Font.BOLD, 28));
        eventoLabel.setForeground(Color.WHITE);

        tipoLabel.setBounds(650, 200, 280, 40);
        tipoLabel.setFont(new Font("Kefa", Font.BOLD, 28));
        tipoLabel.setForeground(Color.WHITE);

        nombreLabel.setBounds(50, 300, 280, 40);
        nombreLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        nombreLabel.setForeground(Color.WHITE);

        nombre.setBounds(50, 335, 280, 40);
        nombre.setFont(new Font("Kefa", Font.PLAIN, 18));
        nombre.setText("N/A");
        nombre.setEnabled(false);

        descripcionLabel.setBounds(50, 390, 280, 40);
        descripcionLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        descripcionLabel.setForeground(Color.WHITE);

        descripcion.setBounds(50, 425, 280, 40);
        descripcion.setFont(new Font("Kefa", Font.PLAIN, 18));
        descripcion.setText("N/A");
        descripcion.setEnabled(false);

        lpsLabel.setBounds(50, 510, 280, 40);
        lpsLabel.setFont(new Font("Kefa", Font.PLAIN, 22));
        lpsLabel.setForeground(Color.WHITE);

        rentaLabel.setBounds(50, 475, 280, 40);
        rentaLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        rentaLabel.setForeground(Color.WHITE);

        renta.setBounds(100, 510, 230, 40);
        renta.setFont(new Font("Kefa", Font.PLAIN, 18));
        renta.setText("N/A");
        renta.setEnabled(false);

        cantidadGenteLabel.setBounds(50, 560, 280, 40);
        cantidadGenteLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        cantidadGenteLabel.setForeground(Color.WHITE);

        cantidadGente.setBounds(50, 595, 280, 40);
        cantidadGente.setFont(new Font("Kefa", Font.PLAIN, 18));
        cantidadGente.setText("N/A");
        cantidadGente.setEnabled(false);

        fechaLabel.setBounds(380, 390, 280, 40);
        fechaLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        fechaLabel.setForeground(Color.WHITE);

        fecha.setBounds(380, 425, 280, 35);
        fecha.setFont(new Font("Kefa", Font.PLAIN, 18));
        fecha.setEnabled(false);

        editar.setBounds(375, 480, 140, 50);
        editar.setFont(new Font("Kefa", Font.BOLD, 18));
        editar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editar.setForeground(new Color(0, 153, 0));
        editar.addActionListener(e -> editarAction());
        editar.setEnabled(false);

        salir.setBounds(522, 480, 140, 50);
        salir.setFont(new Font("Kefa", Font.BOLD, 18));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        panel.add(titulo);
        panel.add(buscarLabel);
        panel.add(buscar);
        panel.add(codigoLabel);
        panel.add(eventoLabel);
        panel.add(tipoLabel);
        panel.add(nombreLabel);
        panel.add(descripcionLabel);
        panel.add(rentaLabel);
        panel.add(lpsLabel);
        panel.add(cantidadGenteLabel);
        panel.add(fechaLabel);
        panel.add(nombre);
        panel.add(descripcion);
        panel.add(renta);
        panel.add(cantidadGente);
        panel.add(fecha);
        panel.add(salir);
        panel.add(editar);
        panel.add(buscarboton);
        add(panel);

    }

    private EventsManager original;

    private void buscarAction() {

        int icod;

        try {
            icod = Integer.parseInt(buscar.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan numeros enteros para el codigo", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (icod <= 0) {
            JOptionPane.showMessageDialog(null, "Ingresa un codigo valido!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EventsManager target = EventsManager.buscar(icod);
        original = target;

        if (buscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tienes que ingresar el codigo de un evento para buscarlo!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (target != null) {
            if (buscar.getText().equals(UserManager.usuarios.get(0).getUsuario())) {
                JOptionPane.showMessageDialog(null, "No puedes editar a este usuario!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            } else {
                codigoLabel.setText("Codigo: " + target.getCodigo());
                eventoLabel.setText(("Evento: " + target.getTipo()));
                tipoLabel.setText(("Tipo: " + target.getSubTipo()));
                nombre.setText(target.getTitulo());
                nombre.setEnabled(true);
                descripcion.setText(target.getDescripcion());
                descripcion.setEnabled(true);
                renta.setText(String.valueOf(target.getRenta()));
                renta.setEnabled(true);
                cantidadGente.setText(String.valueOf(target.getCantidadGente()));
                cantidadGente.setEnabled(true);
                fecha.setCalendar(target.getFechaEvento());
                fecha.setEnabled(true);

                switch (target.getTipo()) {
                    case DEPORTIVO:
                        //tipo.setSelectedItem(Enums.TipoUsuarios.ADMINISTRADOR);
                        break;
                    case MUSICAL:
                        //tipo.setSelectedItem(Enums.TipoUsuarios.CONTENIDO);
                        break;
                    case RELIGIOSO:
                        //tipo.setSelectedItem(Enums.TipoUsuarios.LIMITADO);
                        break;
                }
                editar.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Ahora estas editando el evento " + target.getTitulo(), "MODO EDICION", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El evento con codigo " + icod + " no existe!", "ERROR", JOptionPane.ERROR_MESSAGE);
            codigoLabel.setText("Codigo: N/A");
            eventoLabel.setText("Evento: N/A");
            tipoLabel.setText("Tipo: N/A");
            nombre.setText("N/A");
            nombre.setEnabled(false);
            descripcion.setText("N/A");
            descripcion.setEnabled(false);
            renta.setText("N/A");
            renta.setEnabled(false);
            cantidadGente.setText("N/A");
            cantidadGente.setEnabled(false);
            fecha.setCalendar(null);
            fecha.setEnabled(false);
            editar.setEnabled(false);
        }

    }

    private void editarAction() {

        double irenta;
        double icantidadGente;

        if (nombre.getText().isEmpty() || descripcion.getText().isEmpty() || renta.getText().isEmpty() || cantidadGente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tienes que llenar todos los campos!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (fecha == null) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fecha para el evento", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            irenta = Double.parseDouble(renta.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un monto de renta válido", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (irenta <= 0) {
            JOptionPane.showMessageDialog(null, "Ingresa un monto de renta valido", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            icantidadGente = Integer.parseInt(cantidadGente.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa una cantidad de personas válida", "ERROR", JOptionPane.ERROR_MESSAGE);
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
    private final JTextField buscar = new JTextField();
    private final JLabel buscarLabel = new JLabel("Buscar por codigo:");
    private final JLabel codigoLabel = new JLabel("Codigo: N/A");
    private final JLabel eventoLabel = new JLabel("Evento: N/A");
    private final JLabel tipoLabel = new JLabel("Tipo: N/A");
    private final JLabel nombreLabel = new JLabel("Titulo del Evento: ");
    private final JLabel descripcionLabel = new JLabel("Descripción:");
    private final JLabel cantidadGenteLabel = new JLabel("Cantidad de Personas:");
    private final JLabel rentaLabel = new JLabel("Monto de la Renta:");
    private final JLabel lpsLabel = new JLabel("Lps.");
    private final JLabel fechaLabel = new JLabel("Fecha del Evento:");
    private final JTextField nombre = new JTextField();
    private final JTextField descripcion = new JTextField();
    private final JTextField cantidadGente = new JTextField();
    private final JTextField renta = new JTextField();
    private final JDateChooser fecha = new JDateChooser();
    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JButton salir = new JButton("REGRESAR");
    private final JButton editar = new JButton("EDITAR");
    private final JButton buscarboton = new JButton("BUSCAR");

    public static void main(String[] args) {
        new EditarEvento().setVisible(true);
    }

}
