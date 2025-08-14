package javatickets.ventanas.reportes;

import javatickets.eventos.EventsManager;
import javatickets.utilidades.Fondos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javatickets.ventanas.Reportes;

public class EventosRealizados extends JFrame {

    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JLabel titulo = new JLabel();
    private final JButton regresar = new JButton("REGRESAR");

    public EventosRealizados() {
        initVentana();
        initComponentes();
    }

    private void initVentana() {
        setSize(800, 650);
        setTitle("JAVA TICKETS | EVENTOS REALIZADOS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
    }

    private void initComponentes() {
        panel.setSize(800, 650);
        panel.setLayout(null);

        // Título con imagen
        titulo.setBounds(80, 30, 650, 118);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/tituloer.png")));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Botón regresar
        regresar.setBounds(300, 550, 200, 50);
        regresar.setFont(new Font("Kefa", Font.BOLD, 18));
        regresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        regresar.setForeground(Color.RED);
        regresar.addActionListener(e -> regresarAction());

        // Tabla
        String[] columnas = {"CODIGO", "TIPO", "TITULO", "FECHA", "MONTO"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(50, 150, 700, 250);

        // Panel de estadísticas
        JPanel panelStats = new JPanel();
        panelStats.setLayout(new GridLayout(3, 1));
        panelStats.setBounds(230, 420, 700, 100);
        panelStats.setOpaque(false);

        // Filtrar solo eventos pasados y no cancelados
        ArrayList<EventsManager> realizados = new ArrayList<>();
        Calendar hoy = Calendar.getInstance();
        hoy.set(2025, Calendar.OCTOBER, 10);
        for (EventsManager e : EventsManager.eventos) {
            if (e.getEstado() && e.getFechaEvento().compareTo(hoy) < 0) {
                realizados.add(e);
            }
        }

        // Orden manual (Insertion Sort) de más reciente a más antiguo
        for (int i = 1; i < realizados.size(); i++) {
            EventsManager key = realizados.get(i);
            int j = i - 1;
            while (j >= 0 && realizados.get(j).getFechaEvento().compareTo(key.getFechaEvento()) < 0) {
                realizados.set(j + 1, realizados.get(j));
                j--;
            }
            realizados.set(j + 1, key);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int countDeportivos = 0, countReligiosos = 0, countMusicales = 0;
        double montoDeportivos = 0, montoReligiosos = 0, montoMusicales = 0;

        for (EventsManager e : realizados) {
            model.addRow(new Object[]{
                e.getCodigo(),
                e.getTipo(),
                e.getTitulo(),
                sdf.format(e.getFechaEvento().getTime()),
                String.format("%.2f", e.getRenta())
            });

            switch (e.getTipo()) {
                case DEPORTIVO:
                    countDeportivos++;
                    montoDeportivos += e.getRenta();
                    break;
                case RELIGIOSO:
                    countReligiosos++;
                    montoReligiosos += e.getRenta();
                    break;
                case MUSICAL:
                    countMusicales++;
                    montoMusicales += e.getRenta();
                    break;
            }
        }

        // Estadísticas con números en PLAIN
        JLabel lblDeportivos = new JLabel("<html><b>Deportivos:</b> " + countDeportivos + " eventos | <b>Monto total:</b> Lps.<span style='font-weight:normal;'>" + String.format("%.2f", montoDeportivos) + "</span></html>");
        lblDeportivos.setFont(new Font("Kefa", Font.PLAIN, 16));
        lblDeportivos.setForeground(Color.WHITE);
        panelStats.add(lblDeportivos);

        JLabel lblReligiosos = new JLabel("<html><b>Religiosos:</b> " + countReligiosos + " eventos | <b>Monto total:</b> Lps.<span style='font-weight:normal;'>" + String.format("%.2f", montoReligiosos) + "</span></html>");
        lblReligiosos.setFont(new Font("Kefa", Font.PLAIN, 16));
        lblReligiosos.setForeground(Color.WHITE);
        panelStats.add(lblReligiosos);

        JLabel lblMusicales = new JLabel("<html><b>Musicales:</b> " + countMusicales + " eventos | <b>Monto total:</b> Lps.<span style='font-weight:normal;'>" + String.format("%.2f", montoMusicales) + "</span></html>");
        lblMusicales.setFont(new Font("Kefa", Font.PLAIN, 16));
        lblMusicales.setForeground(Color.WHITE);
        panelStats.add(lblMusicales);

        // Añadir componentes al panel principal
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
        new EventosRealizados().setVisible(true);
    }
}
