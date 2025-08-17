package javatickets.ventanas.adeventos;

import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import java.util.Date;
import javatickets.eventos.Deportivo;
import javatickets.eventos.EventsManager;
import javatickets.eventos.Musical;
import javatickets.eventos.Religioso;
import javatickets.utilidades.Enums;
import javatickets.utilidades.Fondos;
import javatickets.ventanas.AdEventos;
import javax.swing.*;
import java.awt.*;

public class CrearEvento extends JFrame {

    public CrearEvento() {
        initVentana();
        initComponentes();
    }

    private void initVentana() {

        setSize(1100, 700);
        setTitle("JAVA TICKETS | CREAR EVENTO");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(1100, 700);
        panel.setLayout(null);

        titulo.setBounds(-10, 50, 600, 128);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/crearevento.png")));

        tipoLabel.setBounds(50, 175, 280, 40);
        tipoLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        tipoLabel.setForeground(Color.WHITE);

        tipo.setBounds(50, 210, 280, 40);
        tipo.setFont(new Font("Kefa", Font.BOLD, 20));
        tipo.setSelectedItem(null);
        tipo.addActionListener(e -> actualizarTipo());

        codigoLabel.setBounds(50, 290, 280, 40);
        codigoLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        codigoLabel.setForeground(Color.WHITE);

        codigo.setBounds(50, 325, 280, 40);
        codigo.setFont(new Font("Kefa", Font.PLAIN, 18));

        fechaLabel.setBounds(380, 290, 280, 40);
        fechaLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        fechaLabel.setForeground(Color.WHITE);

        fecha.setBounds(380, 327, 280, 35);
        fecha.setFont(new Font("Kefa", Font.PLAIN, 18));

        nombreLabel.setBounds(50, 375, 280, 40);
        nombreLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        nombreLabel.setForeground(Color.WHITE);

        nombre.setBounds(50, 410, 280, 40);
        nombre.setFont(new Font("Kefa", Font.PLAIN, 18));

        descripcionLabel.setBounds(50, 455, 280, 40);
        descripcionLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        descripcionLabel.setForeground(Color.WHITE);

        descripcion.setBounds(50, 490, 280, 40);
        descripcion.setFont(new Font("Kefa", Font.PLAIN, 18));

        lpsLabel.setBounds(50, 575, 280, 40);
        lpsLabel.setFont(new Font("Kefa", Font.PLAIN, 22));
        lpsLabel.setForeground(Color.WHITE);

        rentaLabel.setBounds(50, 540, 280, 40);
        rentaLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        rentaLabel.setForeground(Color.WHITE);

        renta.setBounds(100, 575, 230, 40);
        renta.setFont(new Font("Kefa", Font.PLAIN, 18));

        cantidadGenteLabel.setBounds(380, 375, 280, 40);
        cantidadGenteLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        cantidadGenteLabel.setForeground(Color.WHITE);

        cantidadGente.setBounds(380, 410, 280, 40);
        cantidadGente.setFont(new Font("Kefa", Font.PLAIN, 18));

        subtipoLabel.setBounds(380, 455, 280, 40);
        subtipoLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        subtipoLabel.setForeground(Color.WHITE);

        subtipo.setBounds(377, 490, 280, 50);
        subtipo.setFont(new Font("Kefa", Font.BOLD, 20));
        subtipo.setEnabled(false);
        subtipo.setSelectedItem(null);

        //DEPORTIVO
        equipo1Label.setBounds(710, 290, 280, 40);
        equipo1Label.setFont(new Font("Kefa", Font.BOLD, 22));
        equipo1Label.setForeground(Color.WHITE);
        equipo1Label.setVisible(false);

        equipo1.setBounds(710, 327, 280, 40);
        equipo1.setFont(new Font("Kefa", Font.PLAIN, 18));
        equipo1.setVisible(false);

        equipo2Label.setBounds(710, 375, 280, 40);
        equipo2Label.setFont(new Font("Kefa", Font.BOLD, 22));
        equipo2Label.setForeground(Color.WHITE);
        equipo2Label.setVisible(false);

        equipo2.setBounds(710, 410, 280, 40);
        equipo2.setFont(new Font("Kefa", Font.PLAIN, 18));
        equipo2.setVisible(false);

        crear.setBounds(710, 565, 150, 50);
        crear.setFont(new Font("Kefa", Font.BOLD, 18));
        crear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        crear.setForeground(new Color(0, 153, 0));
        crear.addActionListener(e -> crearAction());

        salir.setBounds(860, 565, 150, 50);
        salir.setFont(new Font("Kefa", Font.BOLD, 18));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        panel.add(titulo);
        panel.add(fecha);
        panel.add(nombre);
        panel.add(codigo);
        panel.add(descripcion);
        panel.add(renta);
        panel.add(cantidadGente);
        panel.add(tipo);
        panel.add(subtipo);
        panel.add(fechaLabel);
        panel.add(nombreLabel);
        panel.add(codigoLabel);
        panel.add(descripcionLabel);
        panel.add(rentaLabel);
        panel.add(lpsLabel);
        panel.add(cantidadGenteLabel);
        panel.add(tipoLabel);
        panel.add(subtipoLabel);
        panel.add(salir);
        panel.add(crear);
        panel.add(equipo1Label);
        panel.add(equipo1);
        panel.add(equipo2Label);
        panel.add(equipo2);
        add(panel);

    }

    private void actualizarTipo() {
        Enums.TipoEventos ttipo = (Enums.TipoEventos) tipo.getSelectedItem();

        if (subtipo.isPopupVisible()) {
            subtipo.hidePopup();
        }

        SwingUtilities.invokeLater(() -> {
            switch (ttipo) {
                case DEPORTIVO:
                    equipo1Label.setVisible(true);
                    equipo1.setVisible(true);
                    equipo2Label.setVisible(true);
                    equipo2.setVisible(true);

                    subtipo.setEnabled(true);
                    subtipo.setModel(new DefaultComboBoxModel<>(Enums.TipoDeportes.values()));
                    if (subtipo.getItemCount() > 0) {
                        subtipo.setSelectedIndex(0);
                    }
                    break;

                case MUSICAL:
                    equipo1Label.setVisible(false);
                    equipo1.setVisible(false);
                    equipo2Label.setVisible(false);
                    equipo2.setVisible(false);

                    subtipo.setEnabled(true);
                    subtipo.setModel(new DefaultComboBoxModel<>(Enums.TipoMusica.values()));
                    if (subtipo.getItemCount() > 0) {
                        subtipo.setSelectedIndex(0);
                    }
                    break;

                case RELIGIOSO:
                    equipo1Label.setVisible(false);
                    equipo1.setVisible(false);
                    equipo2Label.setVisible(false);
                    equipo2.setVisible(false);

                    subtipo.setEnabled(false);
                    subtipo.setModel(new DefaultComboBoxModel<>());
                    break;
            }
        });
    }

    private void crearAction() {

        int icodigo;
        String nom = nombre.getText();
        String desc = descripcion.getText();
        double irenta;
        int icantidadGente;
        Date fechaEvento = fecha.getDate();
        Enums.TipoEventos tipoevento = (Enums.TipoEventos) tipo.getSelectedItem();
        String stringsubtipos = "";
        String ep1 = equipo1.getText();
        String ep2 = equipo2.getText();

        if (codigo.getText().isEmpty() || nom.isEmpty() || desc.isEmpty() || cantidadGente.getText().isEmpty() || tipoevento == null) {
            JOptionPane.showMessageDialog(null, "Tienes que llenar todos los campos!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (fechaEvento == null) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fecha para el evento", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            irenta = Double.parseDouble(renta.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un monto de renta valido!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (irenta <= 0) {
            JOptionPane.showMessageDialog(null, "Ingresa un monto de renta valido!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            icantidadGente = Integer.parseInt(cantidadGente.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa una cantidad de personas valida!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(icantidadGente <= 0 ){
            JOptionPane.showMessageDialog(null, "Ingresa una cantidad de personas valida!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            icodigo = Integer.parseInt(codigo.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan numeros enteros para el codigo!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (icodigo <= 0) {
            JOptionPane.showMessageDialog(null, "Ingresa un codigo valido!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EventsManager target = EventsManager.buscar(icodigo);

        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaEvento);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        if (target == null) {
            if (!EventsManager.buscarFecha(day, month, year)) {

                EventsManager nuevoEvento = null;

                switch (tipoevento) {
                    case DEPORTIVO:
                        if (icantidadGente <= 0 || icantidadGente > 20000) {
                            JOptionPane.showMessageDialog(null, "Esa cantidad de personas no esta permitida para este evento!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        Enums.TipoDeportes tipodeportes = (Enums.TipoDeportes) subtipo.getSelectedItem();
                        nuevoEvento = new Deportivo(icodigo, nom, desc, irenta, icantidadGente, day, month, year, tipodeportes, ep1, ep2);
                        stringsubtipos = "\n| Tipo: " + tipodeportes.toString();
                        break;
                    case MUSICAL:
                        if (icantidadGente <= 0 || icantidadGente > 25000) {
                            JOptionPane.showMessageDialog(null, "Esa cantidad de personas no esta permitida para este evento!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        Enums.TipoMusica tipomusica = (Enums.TipoMusica) subtipo.getSelectedItem();
                        nuevoEvento = new Musical(icodigo, nom, desc, irenta, icantidadGente, day, month, year, tipomusica);
                        stringsubtipos = "\n| Tipo: " + tipomusica.toString();
                        break;
                    case RELIGIOSO:
                        if (icantidadGente <= 0 || icantidadGente > 30000) {
                            JOptionPane.showMessageDialog(null, "Esa cantidad de personas no esta permitida para este evento!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        nuevoEvento = new Religioso(icodigo, nom, desc, irenta, icantidadGente, day, month, year);
                        break;
                }

                if (nuevoEvento != null) {
                    JOptionPane.showMessageDialog(null, "Evento creado exitosamente!\n"
                            + "\n| Evento: " + tipoevento
                            + stringsubtipos
                            + "\n| Codigo: " + icodigo
                            + "\n| Titulo: " + nom
                            + "\n| Descripción: " + desc
                            + String.format("\n| Monto de Renta: Lps.%.2f", irenta)
                            + "\n| Cantidad de Personas: " + icantidadGente
                            + "\n| Fecha del Evento: " + day + "/" + (month + 1) + "/" + year, "PROCESO EXITOSO", JOptionPane.INFORMATION_MESSAGE);

                    EventsManager.agregarEvento(nuevoEvento);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ya esta agendado un evento para esta fecha!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un evento con este codigo!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        dispose();

        new AdEventos()
                .setVisible(true);

    }

    private void salirAction() {
        dispose();
        new AdEventos().setVisible(true);
    }

    private final JLabel titulo = new JLabel();
    private final JLabel tipoLabel = new JLabel("Tipo de Evento:");
    private final JLabel subtipoLabel = new JLabel("Opciones:");
    private final JComboBox<Enums.TipoEventos> tipo = new JComboBox<>(Enums.TipoEventos.values());
    private final JComboBox<Object> subtipo = new JComboBox<>(Enums.TipoDeportes.values());
    private final JDateChooser fecha = new JDateChooser();
    private final JTextField codigo = new JTextField();
    private final JTextField nombre = new JTextField();
    private final JTextField descripcion = new JTextField();
    private final JTextField cantidadGente = new JTextField();
    private final JTextField renta = new JTextField();
    private final JLabel fechaLabel = new JLabel("Fecha del Evento:");
    private final JLabel codigoLabel = new JLabel("Codigo:");
    private final JLabel nombreLabel = new JLabel("Titulo del Evento:");
    private final JLabel descripcionLabel = new JLabel("Descripción:");
    private final JLabel cantidadGenteLabel = new JLabel("Cantidad de Personas:");
    private final JLabel rentaLabel = new JLabel("Monto de la Renta:");
    private final JLabel lpsLabel = new JLabel("Lps.");
    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JButton salir = new JButton("REGRESAR");
    private final JButton crear = new JButton("CREAR");

    //Extras
    private final JLabel equipo1Label = new JLabel("Nombre del Equipo 1:");
    private final JLabel equipo2Label = new JLabel("Nombre del Equipo 2:");
    private final JTextField equipo1 = new JTextField();
    private final JTextField equipo2 = new JTextField();

    public static void main(String[] args) {
        new CrearEvento().setVisible(true);
    }

}
