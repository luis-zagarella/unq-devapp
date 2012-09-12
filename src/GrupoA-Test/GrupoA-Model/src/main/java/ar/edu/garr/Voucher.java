package ar.edu.garr;

import org.joda.time.DateTime;

public class Voucher {

    private DateTime fechaInicio;

    private DateTime fechaVencimiento;

    private int monto;

    public Voucher(final DateTime fechaVencimiento, final int monto) {
        this.setFechaInicio(DateTime.now());
        this.setFechaVencimiento(fechaVencimiento);
        this.setMonto(monto);
    }

    public DateTime getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(final DateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public DateTime getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(final DateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getMonto() {
        return this.monto;
    }

    public void setMonto(final int monto) {
        this.monto = monto;
    }

    public boolean estaVigente() {
        return this.getFechaInicio().isBefore(this.getFechaVencimiento());
    }
}
