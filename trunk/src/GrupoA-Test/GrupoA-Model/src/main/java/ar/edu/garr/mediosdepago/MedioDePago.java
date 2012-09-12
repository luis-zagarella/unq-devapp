package ar.edu.garr.mediosdepago;

import ar.edu.garr.productos.ProductoEnCarrito;

/**
 * 
 */
public class MedioDePago {

    private Promocion promocion = null;

    public Promocion getPromocion() {
        return this.promocion;
    }

    public void setPromocion(final Promocion promocion) {
        this.promocion = promocion;
    }

    public void facturar(final ProductoEnCarrito producto) {
        if (!(this.getPromocion() == null) && this.getPromocion().estaVigente()
                && this.getPromocion().getProductos().contains(producto.getProducto())) {
            producto.getProducto().aplicaPromocion();
            producto.setPrecio(producto.getPrecio() - producto.getPrecio() * producto.getCantidad()
                    * this.getPromocion().getDescuento() / 100);
        } else {
            producto.setPrecio(producto.getPrecio() * producto.getCantidad());
        }
    }
}
