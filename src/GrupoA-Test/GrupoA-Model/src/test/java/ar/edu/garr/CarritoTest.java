package ar.edu.garr;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.joda.time.DateTime;

import ar.edu.garr.mediosdepago.MedioDePago;
import ar.edu.garr.productos.Categoria;
import ar.edu.garr.productos.Producto;
import ar.edu.garr.productos.ProductoEnCarrito;

/**
 * Prueba
 */
public class CarritoTest extends TestCase {
    public void testAgregarProducto() {
        Carrito carrito = new Carrito();
        Producto prd = new Producto("Patrik", "ABC123", 4000, Categoria.HELADERA, 2);

        carrito.agregarProducto(prd, 2);

        assertTrue(carrito.getProductos().size() == 1);
        assertTrue(carrito.getProductos().get(0).getProducto().equals(prd));
    }

    public void testAgregarMedioDePago() {
        Carrito carrito = new Carrito();
        MedioDePago visa = new MedioDePago();

        carrito.agregarMedioDePago(visa);

        assertTrue(carrito.getMedioDePago() == visa);
    }

    public void testFacturar() {
        Producto prd = new Producto("Patrik", "ABC123", 1000, Categoria.HELADERA, 2);
        Producto prd2 = new Producto("Patrik", "JFF22", 1100, Categoria.HELADERA, 2);
        ProductoEnCarrito prodCarrito = new ProductoEnCarrito(prd, 1);
        ProductoEnCarrito prodCarrito2 = new ProductoEnCarrito(prd2, 2);

        MedioDePago mdp = new MedioDePago();
        Carrito carrito = new Carrito();
        carrito.setMedioDePago(mdp);
        List<ProductoEnCarrito> productos = new ArrayList<ProductoEnCarrito>();
        productos.add(prodCarrito);
        productos.add(prodCarrito2);
        carrito.setProductos(productos);

        carrito.facturar();

        assertTrue(carrito.getTotal() == 3200);
    }

    public void testAgregarVoucher() {
        Voucher voucher1 = new Voucher(new DateTime(2020, 3, 26, 12, 0, 0, 0), 500);
        Voucher voucher2 = new Voucher(new DateTime(2020, 3, 26, 12, 0, 0, 0), 1000);
        Carrito carrito = new Carrito();
        carrito.agregarVoucher(voucher1);
        carrito.agregarVoucher(voucher2);

        assertTrue(carrito.getVouchers().size() == 2);
    }

    public void testTotalVouchers() {
        Voucher voucher1 = new Voucher(new DateTime(2020, 3, 26, 12, 0, 0, 0), 500);
        Voucher voucher2 = new Voucher(new DateTime(2020, 3, 26, 12, 0, 0, 0), 1000);
        Carrito carrito = new Carrito();
        List<Voucher> vouchers = new ArrayList<Voucher>();
        vouchers.add(voucher1);
        vouchers.add(voucher2);
        carrito.setVouchers(vouchers);
        assertTrue(carrito.totalVouchers() == 1500);
    }
}
