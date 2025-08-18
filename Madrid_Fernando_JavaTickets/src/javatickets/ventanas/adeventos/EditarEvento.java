package javatickets.ventanas.adeventos;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javatickets.eventos.EventsManager;
import javatickets.usuarios.UserManager;
import javatickets.utilidades.Fondos;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javatickets.eventos.Deportivo;
import javatickets.eventos.Musical;
import javatickets.eventos.Religioso;
import javatickets.utilidades.Enums;
import javatickets.utilidades.FechasOcupadas;
import javatickets.ventanas.AdEventos;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class EditarEvento extends JFrame {

    public EditarEvento() {
        initVentana();
        initComponentes();

    }

    private void initVentana() {

        setSize(700, 700);
        setTitle("JAVA TICKETS | EDITAR EVENTO");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(700, 700);
        panel.setLayout(null);

        titulo.setBounds(-10, 50, 600, 129);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/editarevento.png")));

        titulo1.setBounds(735, 250, 400, 79);
        titulo1.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/editarjugadores.png")));
        titulo1.setVisible(false);

        titulo2.setBounds(726, 250, 419, 77);
        titulo2.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/editarintegrantes.png")));
        titulo2.setVisible(false);

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

        codigoLabel.setBounds(380, 395, 280, 40);
        codigoLabel.setFont(new Font("Kefa", Font.BOLD, 28));
        codigoLabel.setForeground(Color.WHITE);

        eventoLabel.setBounds(380, 447, 280, 40);
        eventoLabel.setFont(new Font("Kefa", Font.BOLD, 28));
        eventoLabel.setForeground(Color.WHITE);

        tipoLabel.setBounds(380, 500, 300, 40);
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

        fechaLabel.setBounds(380, 300, 280, 40);
        fechaLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        fechaLabel.setForeground(Color.WHITE);

        fecha.setBounds(380, 336, 280, 35);
        fecha.setFont(new Font("Kefa", Font.PLAIN, 18));
        fecha.setEnabled(false);

        JCalendar calendario = fecha.getJCalendar();

        java.util.List<Calendar> fechasEventos = new ArrayList<>();
        for (EventsManager ev : EventsManager.eventos) {
            if (ev.getEstado()) {
                fechasEventos.add(ev.getFechaEvento());
            }
        }

        FechasOcupadas evaluador = new FechasOcupadas(fechasEventos);
        calendario.getDayChooser().addDateEvaluator(evaluador);

        pconvertidasLabel.setBounds(380, 390, 280, 40);
        pconvertidasLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        pconvertidasLabel.setForeground(Color.WHITE);
        pconvertidasLabel.setVisible(false);

        pconvertidas.setBounds(380, 425, 280, 40);
        pconvertidas.setFont(new Font("Kefa", Font.PLAIN, 18));
        pconvertidas.setVisible(false);
        pconvertidas.setText(String.valueOf(0));

        editar.setBounds(375, 560, 140, 50);
        editar.setFont(new Font("Kefa", Font.BOLD, 18));
        editar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editar.setForeground(new Color(0, 153, 0));
        editar.addActionListener(e -> editarAction());
        editar.setEnabled(false);

        salir.setBounds(522, 560, 140, 50);
        salir.setFont(new Font("Kefa", Font.BOLD, 18));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        panelTabla.setBounds(710, 330, 450, 300);
        panelTabla.setBackground(Color.WHITE);
        panelTabla.setVisible(false);

        btnAgregarFila.setBackground(new Color(34, 167, 132));
        btnAgregarFila.setForeground(new Color(0, 153, 0));
        btnAgregarFila.setFont(new Font("Kefa", Font.BOLD, 14));
        btnAgregarFila.setFocusPainted(false);

        btnAgregarFila.addActionListener(e -> {
            if (modeloTabla != null) {
                switch (original.getTipo()) {
                    case DEPORTIVO ->
                        modeloTabla.addRow(new Object[]{"", ""});
                    case MUSICAL ->
                        modeloTabla.addRow(new Object[]{""});
                }
            }
        });

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
        panel.add(pconvertidasLabel);
        panel.add(pconvertidas);
        panel.add(panelTabla);
        panel.add(titulo1);
        panel.add(titulo2);
        add(panel);

    }

    private EventsManager original;
    private String stringsubtipos = "";

    private void buscarAction() {

        int icod;

        if (buscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tienes que ingresar el codigo de un evento para buscarlo!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            actualizarPorError();
            return;
        }
        try {
            icod = Integer.parseInt(buscar.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan numeros enteros para el codigo!", "ERROR", JOptionPane.ERROR_MESSAGE);
            actualizarPorError();
            return;
        }

        if (icod <= 0) {
            JOptionPane.showMessageDialog(null, "Ingresa un codigo valido!", "ERROR", JOptionPane.ERROR_MESSAGE);
            actualizarPorError();
            return;
        }

        EventsManager target = EventsManager.buscar(icod);
        original = target;

        if (target != null) {
            if (target.getEstado()) {
                codigoLabel.setText("Codigo: " + target.getCodigo());
                eventoLabel.setText(("Evento: " + target.getTipo()));
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

                editar.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Ahora estas editando el evento " + target.getTitulo()+"!", "MODO EDICION", JOptionPane.INFORMATION_MESSAGE);
                panelTabla.setVisible(true);
                cargarTablaIntegrantes();

                switch (target.getTipo()) {
                    case DEPORTIVO, MUSICAL:
                        pconvertidasLabel.setVisible(false);
                        pconvertidas.setVisible(false);
                        editar.setBounds(375, 560, 140, 50);
                        salir.setBounds(522, 560, 140, 50);
                        codigoLabel.setBounds(380, 395, 280, 40);
                        eventoLabel.setBounds(380, 447, 280, 40);
                        setSize(1200, 700);
                        panel.setSize(1200, 700);
                        setLocationRelativeTo(null);

                        if (original.getTipo() == Enums.TipoEventos.DEPORTIVO) {
                            titulo2.setVisible(false);
                            titulo1.setVisible(true);
                        } else if (original.getTipo() == Enums.TipoEventos.MUSICAL) {
                            titulo1.setVisible(false);
                            titulo2.setVisible(true);
                        }
                        tipoLabel.setVisible(true);
                        tipoLabel.setText(("Categoria: " + target.getSubTipo()));
                        stringsubtipos = "\n| Tipo: " + target.getSubTipo();
                        break;
                    case RELIGIOSO:
                        Religioso rtarget = (Religioso) original;
                        codigoLabel.setBounds(380, 480, 280, 40);
                        eventoLabel.setBounds(380, 520, 280, 40);
                        editar.setBounds(375, 570, 140, 50);
                        salir.setBounds(522, 570, 140, 50);
                        tipoLabel.setVisible(false);
                        titulo1.setVisible(false);
                        titulo2.setVisible(false);
                        pconvertidasLabel.setVisible(true);
                        pconvertidas.setVisible(true);
                        pconvertidas.setText(String.valueOf(rtarget.getConvertidos()));
                        break;

                }
            } else {
                JOptionPane.showMessageDialog(null, "No puedes editar este evento porque esta cancelado!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                actualizarPorError();
            }
        } else {
            JOptionPane.showMessageDialog(null, "El evento con codigo [" + icod + "] no existe!", "ERROR", JOptionPane.ERROR_MESSAGE);
            actualizarPorError();
        }

    }

    private void actualizarPorError() {
        codigoLabel.setText("Codigo: N/A");
        eventoLabel.setText("Evento: N/A");
        tipoLabel.setText("Tipo: N/A");
        tipoLabel.setVisible(true);
        nombre.setText("N/A");
        nombre.setEnabled(false);
        descripcion.setText("N/A");
        descripcion.setEnabled(false);
        renta.setText("N/A");
        renta.setEnabled(false);
        cantidadGente.setText("N/A");
        cantidadGente.setEnabled(false);
        titulo1.setVisible(false);
        titulo2.setVisible(false);
        fecha.setCalendar(null);
        fecha.setEnabled(false);
        editar.setEnabled(false);
        panelTabla.setVisible(false);
        pconvertidasLabel.setVisible(false);
        pconvertidas.setVisible(false);
        editar.setBounds(375, 560, 140, 50);
        salir.setBounds(522, 560, 140, 50);
        codigoLabel.setBounds(380, 395, 280, 40);
        eventoLabel.setBounds(380, 447, 280, 40);
        setSize(700, 700);
        panel.setSize(700, 700);
        setLocationRelativeTo(null);

    }

    private void editarAction() {

        String titu = nombre.getText().trim();
        String descrip = descripcion.getText();
        double irenta;
        int icantidadGente;
        int ipconvertidas;

        Date fechaEvento = fecha.getDate();
        Calendar fechaOriginal = original.getFechaEvento();

        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaEvento);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        boolean fechaCambio = fechaOriginal.get(Calendar.DAY_OF_MONTH) != day
                || fechaOriginal.get(Calendar.MONTH) != month
                || fechaOriginal.get(Calendar.YEAR) != year;

        if (nombre.getText().isEmpty() || descripcion.getText().isEmpty() || renta.getText().isEmpty() || cantidadGente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tienes que llenar todos los campos!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (fecha == null) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fecha para el evento!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (fechaCambio && EventsManager.buscarFecha(day, month, year)) {
            JOptionPane.showMessageDialog(null, "Ya esta agendado un evento para esta fecha!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
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

        if (icantidadGente <= 0) {
            JOptionPane.showMessageDialog(null, "Ingresa una cantidad de personas valida!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            ipconvertidas = Integer.parseInt(pconvertidas.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa una cantidad de personas convertidas valida!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (ipconvertidas < 0 || pconvertidas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa una cantidad de personas convertidas valida!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        switch (original.getTipo()) {
            case DEPORTIVO:
                if (icantidadGente <= 0 || icantidadGente > 20000) {
                    JOptionPane.showMessageDialog(null, "Esa cantidad de personas no esta permitida para este evento!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            case MUSICAL:
                if (icantidadGente <= 0 || icantidadGente > 25000) {
                    JOptionPane.showMessageDialog(null, "Esa cantidad de personas no esta permitida para este evento!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            case RELIGIOSO:
                if (icantidadGente <= 0 || icantidadGente > 30000) {
                    JOptionPane.showMessageDialog(null, "Esa cantidad de personas no esta permitida para este evento!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
        }

        if (modeloTabla != null) {
            switch (original.getTipo()) {
                case DEPORTIVO -> {
                    Deportivo depEvento = (Deportivo) original;
                    ArrayList<String> jugadoresEquipo1 = new ArrayList<>();
                    ArrayList<String> jugadoresEquipo2 = new ArrayList<>();

                    for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                        Object valor1 = modeloTabla.getValueAt(i, 0);
                        Object valor2 = modeloTabla.getValueAt(i, 1);
                        if (valor1 != null && !valor1.toString().trim().isEmpty()) {
                            jugadoresEquipo1.add(valor1.toString().trim());
                        }
                        if (valor2 != null && !valor2.toString().trim().isEmpty()) {
                            jugadoresEquipo2.add(valor2.toString().trim());
                        }
                    }

                    depEvento.setJugadores1(jugadoresEquipo1);
                    depEvento.setJugadores2(jugadoresEquipo2);
                }

                case MUSICAL -> {
                    Musical musEvento = (Musical) original;
                    ArrayList<String> integrantes = new ArrayList<>();
                    for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                        Object valor = modeloTabla.getValueAt(i, 0);
                        if (valor != null && !valor.toString().trim().isEmpty()) {
                            integrantes.add(valor.toString().trim());
                        }
                    }
                    musEvento.setIntegrantes(integrantes);
                }
            }
        }

        if (original.getTipo() == Enums.TipoEventos.RELIGIOSO) {
            Religioso rtarget = (Religioso) original;
            rtarget.setConvertidos(ipconvertidas);
        }

        EventsManager.editarEvento(original, titu, descrip, irenta, icantidadGente, day, month, year);
        JOptionPane.showMessageDialog(null, "El evento ["+original.getCodigo()+"] "+titu+" se ha editado con exito!", "PROCESO EXITOSO", JOptionPane.INFORMATION_MESSAGE);

        dispose();
        new AdEventos().setVisible(true);

    }

    private void cargarTablaIntegrantes() {

        if (original.getTipo() == Enums.TipoEventos.RELIGIOSO) {
            setSize(700, 700);
            panel.setSize(700, 700);
            setLocationRelativeTo(null);
            panelTabla.setVisible(false);
        }

        if (panelTabla != null) {
            panelTabla.removeAll();
        }

        JTableHeader header;
        JScrollPane scroll;

        if (original.getTipo() == Enums.TipoEventos.DEPORTIVO) {
            Deportivo depEvento = (Deportivo) original;
            modeloTabla = new DefaultTableModel(
                    new Object[]{depEvento.getEquipo1(), depEvento.getEquipo2()}, 0);
            tablaIntegrantes = new JTable(modeloTabla);

            tablaIntegrantes.setRowHeight(28);
            tablaIntegrantes.setGridColor(new Color(220, 220, 220));
            tablaIntegrantes.setShowHorizontalLines(true);
            tablaIntegrantes.setFont(new Font("SansSerif", Font.PLAIN, 14));
            tablaIntegrantes.setSelectionBackground(new Color(200, 230, 255));
            tablaIntegrantes.setSelectionForeground(Color.BLACK);
            tablaIntegrantes.setCellSelectionEnabled(true);

            header = tablaIntegrantes.getTableHeader();
            header.setFont(new Font("Kefa", Font.BOLD, 20));
            ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

            int filas = filasPorDeporte(depEvento.getSubTipo());
            for (int i = 0; i < filas; i++) {
                modeloTabla.addRow(new Object[]{"", ""});
            }

            ArrayList<String> equipo1 = depEvento.getJugadores1();
            ArrayList<String> equipo2 = depEvento.getJugadores2();
            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                if (i < equipo1.size()) {
                    modeloTabla.setValueAt(equipo1.get(i), i, 0);
                }
                if (i < equipo2.size()) {
                    modeloTabla.setValueAt(equipo2.get(i), i, 1);
                }
            }

            scroll = new JScrollPane(tablaIntegrantes);
            scroll.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
            panelTabla.add(scroll, BorderLayout.CENTER);

        } else if (original.getTipo() == Enums.TipoEventos.MUSICAL) {
            Musical musEvento = (Musical) original;
            modeloTabla = new DefaultTableModel(new Object[]{"Integrantes"}, 0);
            tablaIntegrantes = new JTable(modeloTabla);

            tablaIntegrantes.setRowHeight(26);
            tablaIntegrantes.setGridColor(new Color(220, 220, 220));
            tablaIntegrantes.setShowHorizontalLines(true);
            tablaIntegrantes.setFont(new Font("SansSerif", Font.PLAIN, 14));
            tablaIntegrantes.setSelectionBackground(new Color(200, 230, 255));
            tablaIntegrantes.setSelectionForeground(Color.BLACK);
            tablaIntegrantes.setCellSelectionEnabled(true);

            header = tablaIntegrantes.getTableHeader();
            header.setFont(new Font("Kefa", Font.BOLD, 20));
            ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

            for (String miembro : musEvento.getIntegrantes()) {
                modeloTabla.addRow(new Object[]{miembro});
            }
            btnAgregarFila.setText("Agregar Integrante");

            scroll = new JScrollPane(tablaIntegrantes);
            scroll.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
            panelTabla.add(scroll, BorderLayout.CENTER);

            JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER));
            botones.setBackground(Color.WHITE);
            botones.add(btnAgregarFila);
            panelTabla.add(botones, BorderLayout.SOUTH);

        } else {
            tablaIntegrantes = null;
            modeloTabla = null;
        }

        panelTabla.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 2, true),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        panelTabla.revalidate();
        panelTabla.repaint();
    }

    private int filasPorDeporte(Enums.TipoDeportes deporte) {

        switch (deporte) {
            case FUTBOL:
                return 11;
            case TENIS:
                return 2;
            case BASEBALL:
                return 9;
            case RUGBY:
                return 15;
            default:
                return 5;
        }
    }

    private void salirAction() {
        dispose();
        new AdEventos().setVisible(true);
    }

    private final JLabel titulo = new JLabel();
    private final JLabel titulo1 = new JLabel();
    private final JLabel titulo2 = new JLabel();
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
    private final JLabel pconvertidasLabel = new JLabel("Personas Convertidas:");
    private final JTextField nombre = new JTextField();
    private final JTextField descripcion = new JTextField();
    private final JTextField cantidadGente = new JTextField();
    private final JTextField renta = new JTextField();
    private final JDateChooser fecha = new JDateChooser();
    private final JTextField pconvertidas = new JTextField();
    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JButton salir = new JButton("REGRESAR");
    private final JButton editar = new JButton("EDITAR");
    private final JButton buscarboton = new JButton("BUSCAR");

    private JTable tablaIntegrantes;
    private DefaultTableModel modeloTabla;
    private final JPanel panelTabla = new JPanel(new BorderLayout());
    private final JButton btnAgregarFila = new JButton();

    public static void main(String[] args) {
        new EditarEvento().setVisible(true);
    }

}
