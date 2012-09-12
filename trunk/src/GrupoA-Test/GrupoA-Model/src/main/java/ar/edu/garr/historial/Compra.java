package ar.edu.garr.historial;

import org.joda.time.DateTime;

import ar.edu.garr.Carrito;
import ar.edu.garr.productos.ProductoEnCarrito;
import ar.edu.garr.usuarios.Usuario;

/**
 * 
 */
public class Compra {
    private Carrito carrito;

    private DateTime fecha;

    private Usuario usuario;

    public Carrito getCarrito() {
        return this.carrito;
    }

    public void setCarrito(final Carrito carrito) {
        this.carrito = carrito;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(final Usuario usuario) {
        this.usuario = usuario;
    }

    public DateTime getFecha() {
        return this.fecha;
    }

    public void setFecha(final DateTime fecha) {
        this.fecha = fecha;
    }

    public Compra(final Usuario usuario) {
        this.setFecha(DateTime.now());
        this.setCarrito(usuario.getCarrito());
        this.setUsuario(usuario);
        usuario.setCarrito(new Carrito());

    }

    public double totalDeCompra() {
        double total = 0;
        for (ProductoEnCarrito producto : this.getCarrito().getProductos()) {
            total = total + producto.getPrecio() * producto.getCantidad() - producto.getAhorro()
                    * producto.getCantidad();
        }
        return total;
    }

    public double totalDeAhorro() {
        double total = 0;
        for (ProductoEnCarrito producto : this.getCarrito().getProductos()) {
            total = total + producto.getAhorro() * producto.getCantidad();
        }
        return total;
    }

}
