package ar.edu.garr;

import junit.framework.TestCase;
import ar.edu.garr.historial.Compra;
import ar.edu.garr.productos.Categoria;
import ar.edu.garr.productos.Producto;
import ar.edu.garr.productos.ProductoEnCarrito;
import ar.edu.garr.usuarios.Usuario;

public class CompraTest extends TestCase {

    public void testTotalDeCompra() {
        Producto prd = new Producto("Patrik", "ABC123", 4000, Categoria.HELADERA, 2);
        Producto prd2 = new Producto("Patrik", "JFF22", 1500, Categoria.HELADERA, 2);
        ProductoEnCarrito prodCarrito = new ProductoEnCarrito(prd, 1);
        ProductoEnCarrito prodCarrito2 = new ProductoEnCarrito(prd2, 2);
        prodCarrito2.setAhorro(100);
        Usuario usuario = new Usuario("Carlos", "Perez", "cPerez@gmail.com", "Urquiza 23", 123123);
        usuario.getCarrito().getProductos().add(prodCarrito);
        usuario.getCarrito().getProductos().add(prodCarrito2);
        Compra compra = new Compra(usuario);

        assertTrue(6800 == compra.totalDeCompra());

    }

    public void testTotalDeAhorro() {
        Producto prd = new Producto("Patrik", "ABC123", 4000, Categoria.HELADERA, 2);
        Producto prd2 = new Producto("Patrik", "JFF22", 1500, Categoria.HELADERA, 2);
        ProductoEnCarrito prodCarrito = new ProductoEnCarrito(prd, 1);
        prodCarrito.setAhorro(500);
        ProductoEnCarrito prodCarrito2 = new ProductoEnCarrito(prd2, 2);
        prodCarrito2.setAhorro(200);
        Usuario usuario = new Usuario("Carlos", "Perez", "cPerez@gmail.com", "Urquiza 23", 123123);
        usuario.getCarrito().getProductos().add(prodCarrito);
        usuario.getCarrito().getProductos().add(prodCarrito2);
        Compra compra = new Compra(usuario);

        assertTrue(900 == compra.totalDeAhorro());
    }
}
