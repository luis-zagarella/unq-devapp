package ar.edu.garr.productos;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Combo extends Producto {

    public Combo(final String marca, final String modelo, final double precio, final Categoria categoria,
            final int stock) {
        super(marca, modelo, precio, categoria, stock);
    }

    private List<Producto> productos = new ArrayList<Producto>();

    private double precio;

    public List<Producto> getProductos() {
        return this.productos;
    }

    public void setProductos(final List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public double getPrecio() {
        return this.precio;
    }

    @Override
    public void setPrecio(final double precio) {
        this.precio = precio;
    }

    @Override
    public void aplicaPromocion() {
        double totprod = 0;
        for (Producto producto : this.getProductos()) {
            totprod += producto.getPrecio();
        }
        this.setPrecio(totprod);
    }

}
