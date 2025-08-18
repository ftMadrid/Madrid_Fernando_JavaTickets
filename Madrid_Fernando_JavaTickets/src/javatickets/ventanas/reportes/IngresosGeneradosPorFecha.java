package javatickets.ventanas.reportes;

import com.toedter.calendar.JDateChooser;
import javatickets.utilidades.Fondos;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import javatickets.utilidades.Calculos;
import javatickets.ventanas.Reportes;

public class IngresosGeneradosPorFecha extends JFrame {

    private boolean generado = false;
    private Calendar inicioReporte;
    private Calendar finReporte;

    public IngresosGeneradosPorFecha() {
        initVentana();
        initComponentes();

    }

    private void initVentana() {

        setSize(750, 600);
        setTitle("JAVA TICKETS | INGRESOS GENERADOS POR FECHA");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(750, 600);
        panel.setLayout(null);

        titulo.setBounds(-10, 50, 700, 126);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/ingresos.png")));

        titulo2.setBounds(-2, 120, 470, 124);
        titulo2.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/xfecha.png")));

        fechainicialLabel.setBounds(50, 250, 280, 40);
        fechainicialLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        fechainicialLabel.setForeground(Color.WHITE);

        fechainicial.setBounds(50, 290, 255, 40);
        fechainicial.setFont(new Font("Kefa", Font.PLAIN, 18));

        fechafinalLabel.setBounds(50, 340, 280, 40);
        fechafinalLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        fechafinalLabel.setForeground(Color.WHITE);

        fechafinal.setBounds(50, 380, 255, 40);
        fechafinal.setFont(new Font("Kefa", Font.PLAIN, 18));

        crearreporte.setBounds(380, 260, 250, 50);
        crearreporte.setFont(new Font("Kefa", Font.BOLD, 18));
        crearreporte.setCursor(new Cursor(Cursor.HAND_CURSOR));
        crearreporte.setForeground(new Color(0, 153, 0));
        crearreporte.addActionListener(e -> generarReporteAction());

        verreporte.setBounds(380, 330, 250, 50);
        verreporte.setFont(new Font("Kefa", Font.BOLD, 18));
        verreporte.setCursor(new Cursor(Cursor.HAND_CURSOR));
        verreporte.setForeground(new Color(104, 87, 250));
        verreporte.addActionListener(e -> verReporteAction());
        verreporte.setEnabled(true);

        salir.setBounds(380, 400, 250, 50);
        salir.setFont(new Font("Kefa", Font.BOLD, 18));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        panel.add(titulo);
        panel.add(titulo2);
        panel.add(fechainicialLabel);
        panel.add(fechainicial);
        panel.add(fechafinalLabel);
        panel.add(fechafinal);
        panel.add(salir);
        panel.add(crearreporte);
        panel.add(verreporte);
        add(panel);

    }

    private void generarReporteAction() {
        if (fechainicial.getDate() == null || fechafinal.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Tienes que llenar todos los campos!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            generado = false;
            return;
        }

        if (fechainicial.getDate().after(fechafinal.getDate())) {
            JOptionPane.showMessageDialog(null, "La fecha inicial tiene que ser antes que la final!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            generado = false;
            return;
        }

        inicioReporte = Calendar.getInstance();
        inicioReporte.setTime(fechainicial.getDate());

        finReporte = Calendar.getInstance();
        finReporte.setTime(fechafinal.getDate());

        generado = true;
        JOptionPane.showMessageDialog(null, "Reporte del "
                + inicioReporte.get(Calendar.DAY_OF_MONTH) + "/" + (inicioReporte.get(Calendar.MONTH) + 1) + "/" + inicioReporte.get(Calendar.YEAR)
                + " al "
                + finReporte.get(Calendar.DAY_OF_MONTH) + "/" + (finReporte.get(Calendar.MONTH) + 1) + "/" + finReporte.get(Calendar.YEAR)
                + "\nGenerado con éxito!",
                "PROCESO EXITOSO", JOptionPane.INFORMATION_MESSAGE);
    }

    private void verReporteAction() {

        if (!generado) {
            JOptionPane.showMessageDialog(null,
                    "No has generado ningun reporte para poder ver!",
                    "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } else {
            JTextArea area = new JTextArea(Calculos.generarReporteIngresos(inicioReporte, finReporte));
            area.setEditable(false);
            area.setFont(new Font("Kefa", Font.PLAIN, 14));
            area.setLineWrap(true);
            area.setWrapStyleWord(true);

            JScrollPane scroll = new JScrollPane(area);
            scroll.setPreferredSize(new Dimension(320, 250));

            JOptionPane.showMessageDialog(null, scroll,
                    "REPORTE DE INGRESOS POR FECHA", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void salirAction() {
        dispose();
        new Reportes().setVisible(true);
    }

    private final JLabel titulo = new JLabel();
    private final JLabel titulo2 = new JLabel();
    private final JLabel fechainicialLabel = new JLabel("Fecha Inicial:");
    private final JDateChooser fechainicial = new JDateChooser();
    private final JLabel fechafinalLabel = new JLabel("Fecha Final:");
    private final JDateChooser fechafinal = new JDateChooser();
    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JButton salir = new JButton("REGRESAR");
    private final JButton crearreporte = new JButton("GENERAR REPORTE");
    private final JButton verreporte = new JButton("VER REPORTE");

    public static void main(String[] args) {
        new IngresosGeneradosPorFecha().setVisible(true);
    }

}
