package ar.edu.garr;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.joda.time.DateTime;

import ar.edu.garr.historial.Compra;
import ar.edu.garr.historial.HistorialDeCompras;
import ar.edu.garr.mediosdepago.MedioDePago;
import ar.edu.garr.mediosdepago.Promocion;
import ar.edu.garr.productos.Categoria;
import ar.edu.garr.productos.Producto;
import ar.edu.garr.productos.ProductoEnCarrito;
import ar.edu.garr.usuarios.Usuario;

/**
 * 
 */
public class HistorialDeComprasTest extends TestCase {

    public void testTotalGastado() {
        Producto prd = new Producto("Patrik", "ABC123", 1000, Categoria.HELADERA, 2);
        Producto prd2 = new Producto("Patrik", "JFF22", 1100, Categoria.HELADERA, 2);
        ProductoEnCarrito prodCarrito = new ProductoEnCarrito(prd, 1);
        ProductoEnCarrito prodCarrito2 = new ProductoEnCarrito(prd2, 2);

        Usuario usuario = new Usuario("Carlos", "Perez", "cPerez@gmail.com", "Urquiza 23", 123123);
        usuario.getCarrito().getProductos().add(prodCarrito);
        usuario.getCarrito().getProductos().add(prodCarrito2);
        Compra compra = new Compra(usuario);
        // 1000 + 2000 = 3000
        Producto prd3 = new Producto("LG", "ABC1223", 500, Categoria.HELADERA, 2);
        Producto prd4 = new Producto("Philips", "JFF2222", 2100, Categoria.HELADERA, 2);
        ProductoEnCarrito prodCarrito3 = new ProductoEnCarrito(prd3, 1);
        ProductoEnCarrito prodCarrito4 = new ProductoEnCarrito(prd4, 2);

        Usuario usuario2 = new Usuario("Jose", "Ramirez", "cPerez@gmail.com", "Urquiza 23", 1231232);
        usuario2.getCarrito().getProductos().add(prodCarrito3);
        usuario2.getCarrito().getProductos().add(prodCarrito4);
        Compra compra2 = new Compra(usuario2);
        // 500 + 4000 = 4500
        List<Compra> compras = new ArrayList<Compra>();
        compras.add(compra);
        compras.add(compra2);

        HistorialDeCompras historial = new HistorialDeCompras();
        historial.setCompras(compras);
        assertTrue(historial.totalGastado() == 7900);

    }

    public void testTotalAhorrado() {
        Producto prd = new Producto("Patrik", "ABC123", 1000, Categoria.HELADERA, 2);
        Producto prd2 = new Producto("Patrik", "JFF22", 1100, Categoria.HELADERA, 2);
        ProductoEnCarrito prodCarrito = new ProductoEnCarrito(prd, 1);
        ProductoEnCarrito prodCarrito2 = new ProductoEnCarrito(prd2, 2);

        Usuario usuario = new Usuario("Carlos", "Perez", "cPerez@gmail.com", "Urquiza 23", 123123);
        usuario.getCarrito().getProductos().add(prodCarrito);
        usuario.getCarrito().getProductos().add(prodCarrito2);
        Compra compra = new Compra(usuario);
        // 1000 + 2000 = 3000
        Producto prd3 = new Producto("LG", "ABC1223", 500, Categoria.HELADERA, 2);
        Producto prd4 = new Producto("Philips", "JFF2222", 2100, Categoria.HELADERA, 2);
        ProductoEnCarrito prodCarrito3 = new ProductoEnCarrito(prd3, 1);
        ProductoEnCarrito prodCarrito4 = new ProductoEnCarrito(prd4, 2);

        Usuario usuario2 = new Usuario("Jose", "Ramirez", "cPerez@gmail.com", "Urquiza 23", 1231232);
        usuario2.getCarrito().getProductos().add(prodCarrito3);
        usuario2.getCarrito().getProductos().add(prodCarrito4);
        Compra compra2 = new Compra(usuario2);
        // 500 + 4000 = 4500
        List<Compra> compras = new ArrayList<Compra>();
        compras.add(compra);
        compras.add(compra2);

        MedioDePago mdp = new MedioDePago();
        List<Producto> prdsPromo = new ArrayList<Producto>();
        prdsPromo.add(prd);
        prdsPromo.add(prd2);
        mdp.setPromocion(new Promocion(20, new DateTime("2012-09-30"), prdsPromo));
        usuario.getCarrito().setMedioDePago(mdp);

        usuario.getCarrito().facturar();

        HistorialDeCompras historial = new HistorialDeCompras();
        historial.setCompras(compras);
        assertTrue(historial.totalAhorrado() == 0);

    }
}
