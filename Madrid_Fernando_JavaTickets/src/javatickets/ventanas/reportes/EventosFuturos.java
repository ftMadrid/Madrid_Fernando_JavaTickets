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
import javax.swing.table.DefaultTableCellRenderer;

public class EventosFuturos extends JFrame {

    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JLabel titulo = new JLabel();
    private final JButton regresar = new JButton("REGRESAR");

    public EventosFuturos() {
        initVentana();
        initComponentes();
    }

    private void initVentana() {
        setSize(800, 650);
        setTitle("JAVA TICKETS | EVENTOS FUTUROS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
    }

    private void initComponentes() {
        panel.setSize(800, 650);
        panel.setLayout(null);

        titulo.setBounds(80, 30, 630, 118);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/tituloef.png"))); // Cambia la imagen
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        regresar.setBounds(300, 550, 200, 50);
        regresar.setFont(new Font("Kefa", Font.BOLD, 18));
        regresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        regresar.setForeground(Color.RED);
        regresar.addActionListener(e -> regresarAction());

        String[] columnas = {"CODIGO", "TIPO", "TITULO", "FECHA", "MONTO"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tabla = new JTable(model);
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getTableHeader().setDefaultRenderer(headerRenderer);

        tabla.setFillsViewportHeight(true);
        tabla.setRowHeight(25);
        tabla.setFont(new Font("Kefa", Font.PLAIN, 14));
        tabla.setForeground(Color.BLACK);
        tabla.setGridColor(Color.DARK_GRAY);
        tabla.setShowGrid(true);
        tabla.getTableHeader().setBackground(new Color(252, 246, 126));
        tabla.getTableHeader().setForeground(Color.BLACK);
        tabla.getTableHeader().setFont(new Font("Kefa", Font.BOLD, 16));
        tabla.setSelectionBackground(new Color(135, 206, 250));
        tabla.setSelectionForeground(Color.BLACK);
        tabla.getTableHeader().setReorderingAllowed(false);

        tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? new Color(250, 250, 252) : Color.WHITE);
                }
                setHorizontalAlignment(SwingConstants.CENTER);
                return c;
            }
        });

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(50, 150, 700, 250);
        scroll.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        JPanel panelStats = new JPanel();
        panelStats.setLayout(new GridLayout(3, 1, 5, 5));
        panelStats.setBounds(230, 420, 700, 100);
        panelStats.setOpaque(false);

        ArrayList<EventsManager> futuros = new ArrayList<>();
        Calendar hoy = Calendar.getInstance();

        for (EventsManager e : EventsManager.eventos) {
            if (e.getEstado() && e.getFechaEvento().compareTo(hoy) >= 0) {
                futuros.add(e);
            }
        }

        for (int i = 1; i < futuros.size(); i++) {
            EventsManager key = futuros.get(i);
            int j = i - 1;
            while (j >= 0 && futuros.get(j).getFechaEvento().compareTo(key.getFechaEvento()) > 0) {
                futuros.set(j + 1, futuros.get(j));
                j--;
            }
            futuros.set(j + 1, key);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int countDeportivos = 0, countReligiosos = 0, countMusicales = 0;
        double montoDeportivos = 0, montoReligiosos = 0, montoMusicales = 0;

        for (EventsManager e : futuros) {
            model.addRow(new Object[]{
                e.getCodigo(),
                e.getTipo(),
                e.getTitulo(),
                sdf.format(e.getFechaEvento().getTime()),
                "Lps."+String.format("%.2f", e.getRenta())
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
        new EventosFuturos().setVisible(true);
    }
}
