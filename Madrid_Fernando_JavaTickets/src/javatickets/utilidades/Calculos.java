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

        hoy.set(Calendar.HOUR_OF_DAY, 0);
        hoy.set(Calendar.MINUTE, 0);
        hoy.set(Calendar.SECOND, 0);
        hoy.set(Calendar.MILLISECOND, 0);

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
                "Se ha cancelado el evento " + target.getTitulo() + ".\n"
                + "\nEstado: Cancelado"
                + String.format("\nIndemnización cobrada: Lps.%.2f", indemnizacion), "PROCESO EXITOSO", JOptionPane.INFORMATION_MESSAGE);

        EventsManager.eliminarEvento(target);
        return indemnizacion;
    }

    public final static String generarReporteIngresos(Calendar inicio, Calendar fin) {
        
        double total = 0, totalRentas = 0, totalMultas = 0;
        int deportivos = 0, religiosos = 0, musicales = 0;

        for (EventsManager evento : EventsManager.eventos) {
            if (evento != null) {
                Calendar fechaEvento = evento.getFechaEvento();

                if (!fechaEvento.before(inicio) && !fechaEvento.after(fin)) {
                    if (evento.getEstado()) {
                        total += evento.getRenta();
                        totalRentas += evento.getRenta();
                    } else {
                        total += evento.getIndemnizacion();
                        totalMultas += evento.getIndemnizacion();
                    }

                    switch (evento.getTipo()) {
                        case DEPORTIVO:
                            deportivos++;
                            break;
                        case RELIGIOSO:
                            religiosos++;
                            break;
                        case MUSICAL:
                            musicales++;
                            break;
                    }
                }
            }
        }

        return "Ingresos generados del "
                + inicio.get(Calendar.DAY_OF_MONTH) + "/" + (inicio.get(Calendar.MONTH) + 1) + "/" + inicio.get(Calendar.YEAR)
                + " al "
                + fin.get(Calendar.DAY_OF_MONTH) + "/" + (fin.get(Calendar.MONTH) + 1) + "/" + fin.get(Calendar.YEAR)
                + String.format("\n\nTotal generado: L.%.2f", total)
                + String.format("\n   - Rentas: L.%.2f", totalRentas)
                + String.format("\n   - Multas por cancelación: L.%.2f", totalMultas)
                + "\n\nEventos Realizados:"
                + "\n   - Deportivos: " + deportivos
                + "\n   - Religiosos: " + religiosos
                + "\n   - Musicales: " + musicales;
    }

}
