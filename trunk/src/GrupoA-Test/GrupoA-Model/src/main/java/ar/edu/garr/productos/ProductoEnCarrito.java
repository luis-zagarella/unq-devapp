package ar.edu.garr.productos;

/**
 */
public class ProductoEnCarrito {
    private Producto producto;

    private int cantidad;

    private double precio;

    private double ahorro;

    public ProductoEnCarrito(final Producto producto, final int cantidad) {
        this.setCantidad(cantidad);
        this.setProducto(producto);
        this.setPrecio(producto.getPrecio());
    }

    // Getters && Setters //

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(final Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(final int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(final double precio) {
        this.precio = precio;
        this.setAhorro(this.getProducto().getPrecio() - this.getPrecio());
    }

    public double getAhorro() {
        return this.ahorro;
    }

    public void setAhorro(final double ahorro) {
        this.ahorro = ahorro;
    }

    // //////////////////////////

}
