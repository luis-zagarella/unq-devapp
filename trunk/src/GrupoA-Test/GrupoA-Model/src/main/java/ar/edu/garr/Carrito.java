package ar.edu.garr;

import java.util.ArrayList;
import java.util.List;

import ar.edu.garr.mediosdepago.MedioDePago;
import ar.edu.garr.productos.Producto;
import ar.edu.garr.productos.ProductoEnCarrito;

public class Carrito {

    private List<ProductoEnCarrito> productos = new ArrayList<ProductoEnCarrito>();

    private MedioDePago medioDePago;

    private double total;

    private double ahorro;

    private List<Voucher> vouchers = new ArrayList<Voucher>();

    public List<Voucher> getVouchers() {
        return this.vouchers;
    }

    public void setVouchers(final List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(final double tot) {
        this.total = tot;
    }

    public double getAhorro() {
        return this.ahorro;
    }

    public void setAhorro(final double ahorro) {
        this.ahorro = ahorro;
    }

    public List<ProductoEnCarrito> getProductos() {
        return this.productos;
    }

    public void setProductos(final List<ProductoEnCarrito> productos) {
        this.productos = productos;
    }

    public MedioDePago getMedioDePago() {
        return this.medioDePago;
    }

    public void setMedioDePago(final MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }

    public void agregarProducto(final Producto producto, final int cantidad) {
        // if (producto.hayStock()) {
        this.getProductos().add(new ProductoEnCarrito(producto, cantidad));
        // }
    }

    public void agregarMedioDePago(final MedioDePago mediodepago) {
        this.setMedioDePago(mediodepago);
    }

    public void facturar() {
        double to = 0;
        for (ProductoEnCarrito prd : this.getProductos()) {
            this.getMedioDePago().facturar(prd);
            to += prd.getPrecio();
        }

        this.setTotal(to - this.totalVouchers());
    }

    public double totalVouchers() {
        double totVoucher = 0;
        for (Voucher voucher : this.getVouchers()) {
            totVoucher = totVoucher + voucher.getMonto();
        }

        return totVoucher;
    }

    public void agregarVoucher(final Voucher voucher) {
        this.getVouchers().add(voucher);
    }

}
