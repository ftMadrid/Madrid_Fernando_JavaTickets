package javatickets.utilidades;

import com.toedter.calendar.IDateEvaluator;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FechasOcupadasEvaluator implements IDateEvaluator {
    
    private final List<Date> fechasOcupadas = new ArrayList<>();

    public FechasOcupadasEvaluator(List<Calendar> eventos) {
        for (Calendar c : eventos) {
            Calendar copia = (Calendar) c.clone();
            copia.set(Calendar.HOUR_OF_DAY, 0);
            copia.set(Calendar.MINUTE, 0);
            copia.set(Calendar.SECOND, 0);
            copia.set(Calendar.MILLISECOND, 0);
            fechasOcupadas.add(copia.getTime());
        }
    }

    @Override
    public boolean isSpecial(Date date) {
        return fechasOcupadas.contains(normalizar(date));
    }

    @Override
    public Color getSpecialForegroundColor() {
        return Color.RED;
    }

    @Override
    public Color getSpecialBackroundColor() {
        return Color.YELLOW;
    }

    @Override
    public String getSpecialTooltip() {
        return "Fecha ocupada";
    }

    @Override
    public boolean isInvalid(Date date) {
        return false; // No bloqueamos la fecha, solo la resaltamos
    }

    @Override
    public Color getInvalidForegroundColor() { return null; }

    @Override
    public Color getInvalidBackroundColor() { return null; }

    @Override
    public String getInvalidTooltip() { return null; }

    // Normaliza la fecha quitando horas/minutos/segundos
    private Date normalizar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
}

