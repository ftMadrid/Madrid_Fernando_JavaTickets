package javatickets.ventanas.reportes;

import javatickets.eventos.EventsManager;
import javatickets.utilidades.Fondos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static javatickets.utilidades.Enums.TipoEventos.DEPORTIVO;
import static javatickets.utilidades.Enums.TipoEventos.MUSICAL;
import static javatickets.utilidades.Enums.TipoEventos.RELIGIOSO;
import javatickets.ventanas.Reportes;

public class EventosCancelados extends JFrame {

    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JLabel titulo = new JLabel();
    private final JButton regresar = new JButton("REGRESAR");

    public EventosCancelados() {
        initVentana();
        initComponentes();
    }

    private void initVentana() {
        setSize(800, 650);
        setTitle("JAVA TICKETS | EVENTOS CANCELADOS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
    }

    private void initComponentes() {
        panel.setSize(800, 650);
        panel.setLayout(null);

        titulo.setBounds(80, 30, 650, 117);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/tituloec.png")));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        regresar.setBounds(300, 550, 200, 50);
        regresar.setFont(new Font("Kefa", Font.BOLD, 18));
        regresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        regresar.setForeground(Color.RED);
        regresar.addActionListener(e -> regresarAction());

        String[] columnas = {"CODIGO", "TIPO", "TITULO", "FECHA", "MULTA"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(50, 150, 700, 250);

        JPanel panelStats = new JPanel();
        panelStats.setLayout(new GridLayout(4, 1));
        panelStats.setBounds(190, 420, 700, 120);
        panelStats.setOpaque(false);

        ArrayList<EventsManager> cancelados = new ArrayList<>(EventsManager.eventosCancelados);

        for (int i = 1; i < cancelados.size(); i++) {
            EventsManager key = cancelados.get(i);
            int j = i - 1;
            while (j >= 0 && cancelados.get(j).getFechaEvento().compareTo(key.getFechaEvento()) > 0) {
                cancelados.set(j + 1, cancelados.get(j));
                j--;
            }
            cancelados.set(j + 1, key);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int countDeportivos = 0, countReligiosos = 0, countMusicales = 0;
        double montoDeportivos = 0, montoReligiosos = 0, montoMusicales = 0;

        for (EventsManager e : cancelados) {
            model.addRow(new Object[]{
                e.getCodigo(),
                e.getTipo(),
                e.getTitulo(),
                sdf.format(e.getFechaEvento().getTime()),
                String.format("%.2f", e.getIndemnizacion())
            });

            switch (e.getTipo()) {
                case DEPORTIVO:
                    countDeportivos++;
                    montoDeportivos += e.getIndemnizacion();
                    break;
                case RELIGIOSO:
                    countReligiosos++;
                    montoReligiosos += e.getIndemnizacion();
                    break;
                case MUSICAL:
                    countMusicales++;
                    montoMusicales += e.getIndemnizacion();
                    break;
            }
        }

        JLabel lblDeportivos = new JLabel("<html><b>Deportivos:</b> " + countDeportivos + " eventos | <b>Total Indemnizaciones:</b> Lps.<span style='font-weight:normal;'>" + String.format("%.2f", montoDeportivos) + "</span></html>");
        lblDeportivos.setFont(new Font("Kefa", Font.PLAIN, 16));
        lblDeportivos.setForeground(Color.WHITE);
        panelStats.add(lblDeportivos);

        JLabel lblReligiosos = new JLabel("<html><b>Religiosos:</b> " + countReligiosos + " eventos | <b>Total Indemnizaciones:</b> Lps.<span style='font-weight:normal;'>" + String.format("%.2f", montoReligiosos) + "</span></html>");
        lblReligiosos.setFont(new Font("Kefa", Font.PLAIN, 16));
        lblReligiosos.setForeground(Color.WHITE);
        panelStats.add(lblReligiosos);

        JLabel lblMusicales = new JLabel("<html><b>Musicales:</b> " + countMusicales + " eventos | <b>Total Indemnizaciones:</b> Lps.<span style='font-weight:normal;'>" + String.format("%.2f", montoMusicales) + "</span></html>");
        lblMusicales.setFont(new Font("Kefa", Font.PLAIN, 16));
        lblMusicales.setForeground(Color.WHITE);
        panelStats.add(lblMusicales);

        panel.add(titulo);
        panel.add(regresar);
        panel.add(scroll);
        panel.add(panelStats);

        add(panel);
    }

    private void regresarAction() {
        dispose();
        new Reportes().setVisible(true);
    }

    public static void main(String[] args) {
        new EventosCancelados().setVisible(true);
    }
}

