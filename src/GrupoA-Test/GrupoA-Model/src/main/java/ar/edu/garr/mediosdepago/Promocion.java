package ar.edu.garr.mediosdepago;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import ar.edu.garr.productos.Producto;

/**
 * 
 */
public class Promocion {
    private double descuento;

    private DateTime fechaLimite;

    private List<Producto> productos = new ArrayList<Producto>();

    public Promocion(final double descuento, final DateTime fechaLimite, final List<Producto> productos) {
        super();
        this.descuento = descuento;
        this.fechaLimite = fechaLimite;
        this.productos = productos;
    }

    public Promocion(final double descuento, final DateTime fechaLimite) {
        super();
        this.descuento = descuento;
        this.fechaLimite = fechaLimite;
    }

    public List<Producto> getProductos() {
        return this.productos;
    }

    public void setProductos(final List<Producto> producto) {
        this.productos = producto;
    }

    public DateTime getFechaLimite() {
        return this.fechaLimite;
    }

    public void setFechaLimite(final DateTime fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public double getDescuento() {
        return this.descuento;
    }

    public void setDescuento(final double descuento) {
        this.descuento = descuento;
    }

    public Boolean estaVigente() {
        return this.getFechaLimite().isAfterNow();
    }
}
