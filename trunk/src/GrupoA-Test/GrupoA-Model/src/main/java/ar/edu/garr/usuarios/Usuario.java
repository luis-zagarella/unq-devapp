package ar.edu.garr.usuarios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.garr.Carrito;
import ar.edu.garr.Voucher;
import ar.edu.garr.historial.HistorialDeCompras;
import ar.edu.garr.mediosdepago.MedioDePago;
import ar.edu.garr.productos.Producto;

public class Usuario {

    private String nombre;

    private String apellido;

    private String mail;

    private String direccion;

    private int dni;

    private Carrito carrito = new Carrito();

    private List<Voucher> vouchers = new ArrayList<Voucher>();

    private HistorialDeCompras historial = new HistorialDeCompras();

    public Usuario(final String nombre, final String apellido, final String mail, final String direccion, final int dni) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.direccion = direccion;
        this.dni = dni;
    }

    // Getters & Setters //

    public HistorialDeCompras getHistorial() {
        return this.historial;
    }

    public void setHistorial(final HistorialDeCompras historial) {
        this.historial = historial;
    }

    public List<Voucher> getVouchers() {
        return this.vouchers;
    }

    public void setVouchers(final List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    public Usuario(final String nombre) {
        super();
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(final String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(final String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(final String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {
        return this.dni;
    }

    public void setDni(final int dni) {
        this.dni = dni;
    }

    public Carrito getCarrito() {
        return this.carrito;
    }

    public void setCarrito(final Carrito carrito) {
        this.carrito = carrito;
    }

    // /////

    /* Métodos */

    public void agregarProductoAlCarrito(final Producto producto, final int cantidad) {
        this.getCarrito().agregarProducto(producto, cantidad);
    }

    public void agregarMedioDePagoAlCarrito(final MedioDePago mediodepago) {
        this.getCarrito().agregarMedioDePago(mediodepago);
    }

    public void facturar() {
        this.getCarrito().facturar();
    }

    public void agregarVoucherACarrito(final Voucher voucher) {
        if (voucher.estaVigente()) {
            this.getCarrito().agregarVoucher(voucher);
        }
        this.getVouchers().remove(voucher);
    }

    public boolean seSaldoLaCompra(final double totalAFacturar, final int plataDeVouchers) {
        return totalAFacturar >= plataDeVouchers;
    }

    public boolean tengoVouchersDisponibles(final List<Voucher> listvouchers) {
        return listvouchers.isEmpty();
    }

}
