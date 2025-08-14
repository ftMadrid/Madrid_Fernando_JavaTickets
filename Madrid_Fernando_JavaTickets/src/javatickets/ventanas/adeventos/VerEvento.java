package javatickets.ventanas.adeventos;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javatickets.eventos.Deportivo;
import javatickets.eventos.EventsManager;
import javatickets.eventos.Musical;
import javatickets.eventos.Religioso;
import javatickets.usuarios.UserManager;
import javatickets.utilidades.Enums;
import static javatickets.utilidades.Enums.TipoEventos.DEPORTIVO;
import static javatickets.utilidades.Enums.TipoEventos.MUSICAL;
import static javatickets.utilidades.Enums.TipoEventos.RELIGIOSO;
import javatickets.utilidades.Fondos;
import javatickets.ventanas.AdEventos;
import javatickets.ventanas.AdUsuarios;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VerEvento extends JFrame {

    public VerEvento() {
        initVentana();
        initComponentes();
    }

    private void initVentana() {

        setSize(1000, 700);
        setTitle("JAVA TICKETS | VER EVENTO");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    private void initComponentes() {

        panel.setSize(1000, 700);
        panel.setLayout(null);

        titulo.setBounds(-10, 50, 560, 137);
        titulo.setIcon(new ImageIcon(getClass().getResource("/javatickets/imagenes/verevento.png")));

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

        eventoLabel.setBounds(50, 290, 280, 40);
        eventoLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        eventoLabel.setForeground(Color.WHITE);

        evento.setBounds(50, 325, 280, 40);
        evento.setFont(new Font("Kefa", Font.PLAIN, 18));
        evento.setEditable(false);
        evento.setText("N/A");

        fechaLabel.setBounds(380, 290, 280, 40);
        fechaLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        fechaLabel.setForeground(Color.WHITE);

        fecha.setBounds(380, 325, 280, 40);
        fecha.setFont(new Font("Kefa", Font.PLAIN, 18));
        fecha.setEditable(false);
        fecha.setText("N/A");

        nombreLabel.setBounds(50, 375, 280, 40);
        nombreLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        nombreLabel.setForeground(Color.WHITE);

        nombre.setBounds(50, 410, 280, 40);
        nombre.setFont(new Font("Kefa", Font.PLAIN, 18));
        nombre.setEditable(false);
        nombre.setText("N/A");

        descripcionLabel.setBounds(50, 455, 280, 40);
        descripcionLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        descripcionLabel.setForeground(Color.WHITE);

        descripcion.setBounds(50, 490, 280, 40);
        descripcion.setFont(new Font("Kefa", Font.PLAIN, 18));
        descripcion.setEditable(false);
        descripcion.setText("N/A");

        lpsLabel.setBounds(50, 575, 280, 40);
        lpsLabel.setFont(new Font("Kefa", Font.PLAIN, 22));
        lpsLabel.setForeground(Color.WHITE);

        rentaLabel.setBounds(50, 540, 280, 40);
        rentaLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        rentaLabel.setForeground(Color.WHITE);

        renta.setBounds(100, 575, 230, 40);
        renta.setFont(new Font("Kefa", Font.PLAIN, 18));
        renta.setEditable(false);
        renta.setText("N/A");

        cantidadGenteLabel.setBounds(380, 375, 280, 40);
        cantidadGenteLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        cantidadGenteLabel.setForeground(Color.WHITE);

        cantidadGente.setBounds(380, 410, 280, 40);
        cantidadGente.setFont(new Font("Kefa", Font.PLAIN, 18));
        cantidadGente.setEditable(false);
        cantidadGente.setText("N/A");

        categoriaLabel.setBounds(380, 455, 280, 40);
        categoriaLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        categoriaLabel.setForeground(Color.WHITE);

        categoria.setBounds(380, 490, 280, 40);
        categoria.setFont(new Font("Kefa", Font.PLAIN, 18));
        categoria.setEditable(false);
        categoria.setText("N/A");
        
        estadoLabel.setBounds(380, 540, 280, 40);
        estadoLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        estadoLabel.setForeground(Color.WHITE);
        
        estado.setBounds(380, 575, 280, 40);
        estado.setFont(new Font("Kefa", Font.PLAIN, 18));
        estado.setEditable(false);
        estado.setText("N/A");
        
        multaLabel.setBounds(710, 540, 280, 40);
        multaLabel.setFont(new Font("Kefa", Font.BOLD, 22));
        multaLabel.setForeground(Color.WHITE);
        multaLabel.setVisible(false);
        
        lps2Label.setBounds(710, 575, 280, 40);
        lps2Label.setFont(new Font("Kefa", Font.PLAIN, 22));
        lps2Label.setForeground(Color.WHITE);
        lps2Label.setVisible(false);
        
        multa.setBounds(760, 575, 230, 40);
        multa.setFont(new Font("Kefa", Font.PLAIN, 18));
        multa.setEditable(false);
        multa.setVisible(false);

        salir.setBounds(750, 450, 150, 50);
        salir.setFont(new Font("Kefa", Font.BOLD, 18));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(Color.red);
        salir.addActionListener(e -> salirAction());

        panel.add(titulo);
        panel.add(fecha);
        panel.add(buscar);
        panel.add(nombre);
        panel.add(evento);
        panel.add(descripcion);
        panel.add(renta);
        panel.add(cantidadGente);
        panel.add(categoria);
        panel.add(estado);
        panel.add(multa);
        panel.add(fechaLabel);
        panel.add(buscarLabel);
        panel.add(nombreLabel);
        panel.add(eventoLabel);
        panel.add(descripcionLabel);
        panel.add(rentaLabel);
        panel.add(lpsLabel);
        panel.add(lps2Label);
        panel.add(cantidadGenteLabel);
        panel.add(categoriaLabel);
        panel.add(estadoLabel);
        panel.add(multaLabel);
        panel.add(salir);
        panel.add(buscarboton);
        add(panel);

    }

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
        
        Calendar fechaEvento = target.getFechaEvento();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormat = formato.format(fechaEvento.getTime());

        if (buscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tienes que ingresar el codigo de un evento para buscarlo!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (target != null) {
            evento.setText(String.valueOf(target.getTipo()));
            nombre.setText(target.getTitulo());
            descripcion.setText(target.getDescripcion());
            renta.setText(String.format("%.2f", target.getRenta()));
            cantidadGente.setText(String.valueOf(target.getCantidadGente()));
            fecha.setText(fechaFormat);
            categoria.setText(String.valueOf(target.getSubTipo()));
            
            if(target.getEstado()){
                estado.setText("Vigente");
            }else{
                estado.setText("Cancelado");
                multaLabel.setVisible(true);
                lps2Label.setVisible(true);
                multa.setText(String.format("%.2f", target.getIndemnizacion()));
                multa.setVisible(true);
            }

            JOptionPane.showMessageDialog(null, "Viendo el evento " + target.getTitulo(), "MODO INSPECCIÓN", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El evento con codigo " + icod + " no existe!", "ERROR", JOptionPane.ERROR_MESSAGE);
            evento.setText("N/A");
            nombre.setText("N/A");
            descripcion.setText("N/A");
            renta.setText("N/A");
            cantidadGente.setText("N/A");
            fecha.setText("N/A");
            categoria.setText("N/A");
            estado.setText("N/A");
        }

    }

    private void salirAction() {
        dispose();
        new AdEventos().setVisible(true);
    }

    private final JLabel titulo = new JLabel();
    private final JTextField buscar = new JTextField();
    private final JLabel buscarLabel = new JLabel("Buscar por codigo:");
    private final JLabel categoriaLabel = new JLabel("Categoria:");
    private final JTextField categoria = new JTextField();
    private final JTextField fecha = new JTextField();
    private final JTextField evento = new JTextField();
    private final JTextField nombre = new JTextField();
    private final JTextField descripcion = new JTextField();
    private final JTextField cantidadGente = new JTextField();
    private final JTextField renta = new JTextField();
    private final JTextField estado = new JTextField();
    private final JTextField multa = new JTextField();
    private final JLabel fechaLabel = new JLabel("Fecha del Evento:");
    private final JLabel eventoLabel = new JLabel("Tipo de Evento:");
    private final JLabel nombreLabel = new JLabel("Titulo del Evento:");
    private final JLabel descripcionLabel = new JLabel("Descripción:");
    private final JLabel cantidadGenteLabel = new JLabel("Cantidad de Personas:");
    private final JLabel rentaLabel = new JLabel("Monto de la Renta:");
    private final JLabel lpsLabel = new JLabel("Lps.");
    private final JLabel lps2Label = new JLabel("Lps.");
    private final JLabel estadoLabel = new JLabel("Estado:");
    private final JLabel multaLabel = new JLabel("Multa Pagada:");
    private final JPanel panel = new Fondos("/javatickets/imagenes/fondo.png");
    private final JButton salir = new JButton("REGRESAR");
    private final JButton buscarboton = new JButton("BUSCAR");

    public static void main(String[] args) {
        new VerEvento().setVisible(true);
    }

}
