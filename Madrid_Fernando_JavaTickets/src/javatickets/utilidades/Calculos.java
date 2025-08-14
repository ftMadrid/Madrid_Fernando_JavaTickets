package javatickets.utilidades;

import java.util.Calendar;
import javatickets.eventos.EventsManager;
import javax.swing.JOptionPane;

public final class Calculos {

    private int saldo = 0;
    private final Calendar hoy = Calendar.getInstance();

    public final double getSaldo() {
        return saldo;
    }

    public final void agregarSaldo(double monto) {
        saldo += monto;
    }

    public final double cobrarIndemnizacion(int codigo) {

        EventsManager target = EventsManager.buscar(codigo);

        // Calendario de hoy sin horas
        hoy.set(Calendar.HOUR_OF_DAY, 0);
        hoy.set(Calendar.MINUTE, 0);
        hoy.set(Calendar.SECOND, 0);
        hoy.set(Calendar.MILLISECOND, 0);

        // Fecha del evento sin horas
        Calendar fechaEvento = (Calendar) target.getFechaEvento().clone();
        fechaEvento.set(Calendar.HOUR_OF_DAY, 0);
        fechaEvento.set(Calendar.MINUTE, 0);
        fechaEvento.set(Calendar.SECOND, 0);
        fechaEvento.set(Calendar.MILLISECOND, 0);

        double indemnizacion = 0.0;

        if (target.getTipo() != Enums.TipoEventos.RELIGIOSO) {
            long diffMillis = fechaEvento.getTimeInMillis() - hoy.getTimeInMillis();
            long diasFaltantes = (long) Math.ceil(diffMillis / (1000.0 * 60 * 60 * 24));

            if (diasFaltantes == 1) {
                indemnizacion = target.getRenta() * 0.5;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Se ha cancelado el evento " + target.getTitulo() + "\n"
                        + ".\nEstado: Cancelado" 
                        +String.format("\nIndemnización cobrada: Lps.%.2f", indemnizacion), "PROCESO EXITOSO", JOptionPane.INFORMATION_MESSAGE);

        EventsManager.eliminarEvento(target);
        return indemnizacion;
    }

}
