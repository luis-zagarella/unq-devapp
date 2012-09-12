package ar.edu.garr;

import junit.framework.TestCase;

import org.joda.time.DateTime;

import ar.edu.garr.mediosdepago.MedioDePago;
import ar.edu.garr.mediosdepago.Promocion;
import ar.edu.garr.productos.Categoria;
import ar.edu.garr.productos.Producto;
import ar.edu.garr.productos.ProductoEnCarrito;
import ar.edu.garr.usuarios.Usuario;

public class MedioDePagoTest extends TestCase {
    public void testFacturarSinPromocion() {
        Usuario usuario = new Usuario("Martin");
        Producto heladera = new Producto("Patrick", "Hpk 35b", 2799, Categoria.HELADERA, 2);
        MedioDePago visa = new MedioDePago();
        usuario.agregarProductoAlCarrito(heladera, 1);
        usuario.getCarrito().getProductos().add(new ProductoEnCarrito(heladera, 1));
        usuario.getCarrito().setMedioDePago(visa);

        visa.facturar(usuario.getCarrito().getProductos().get(0));
        assertTrue(usuario.getCarrito().getProductos().get(0).getPrecio() == 2799);
        assertTrue(usuario.getCarrito().getProductos().get(0).getAhorro() == 0);
    }

    public void testFacturarConPromocion() {
        Usuario usuario = new Usuario("Martin");
        Producto heladera = new Producto("Patrick", "Hpk 35b", 2799, Categoria.HELADERA, 2);
        MedioDePago visa = new MedioDePago();
        Promocion promo = new Promocion(30, new DateTime("2012-09-30"));
        promo.getProductos().add(heladera);
        visa.setPromocion(promo);
        usuario.agregarProductoAlCarrito(heladera, 1);
        usuario.getCarrito().getProductos().add(new ProductoEnCarrito(heladera, 1));
        usuario.getCarrito().setMedioDePago(visa);

        visa.facturar(usuario.getCarrito().getProductos().get(0));
        assertTrue(usuario.getCarrito().getProductos().get(0).getPrecio() == 1959.30);
        assertTrue(usuario.getCarrito().getProductos().get(0).getAhorro() == 839.7);
    }

    public void testFacturarConPromocionQueNoIncluyeProducto() {
        Usuario usuario = new Usuario("Martin");
        Producto heladera = new Producto("Patrick", "Hpk 35b", 2799, Categoria.HELADERA, 2);
        Producto lavarropas = new Producto("Patrick", "Hpk 35b", 3120, Categoria.LAVARROPAS, 2);
        MedioDePago visa = new MedioDePago();
        Promocion promo = new Promocion(30, new DateTime("2012-09-30"));
        promo.getProductos().add(lavarropas);
        visa.setPromocion(promo);
        usuario.agregarProductoAlCarrito(heladera, 1);
        usuario.getCarrito().getProductos().add(new ProductoEnCarrito(heladera, 1));
        usuario.getCarrito().setMedioDePago(visa);

        visa.facturar(usuario.getCarrito().getProductos().get(0));

        assertTrue(usuario.getCarrito().getProductos().get(0).getPrecio() == 2799);
        assertTrue(usuario.getCarrito().getProductos().get(0).getAhorro() == 0);
    }

    public void testFacturarConPromocionVencida() {
        Usuario usuario = new Usuario("Martin");
        Producto heladera = new Producto("Patrick", "Hpk 35b", 2799, Categoria.HELADERA, 2);
        MedioDePago visa = new MedioDePago();
        Promocion promo = new Promocion(30, new DateTime("2012-08-25"));
        promo.getProductos().add(heladera);
        visa.setPromocion(promo);
        usuario.agregarProductoAlCarrito(heladera, 1);
        usuario.getCarrito().getProductos().add(new ProductoEnCarrito(heladera, 1));
        usuario.getCarrito().setMedioDePago(visa);

        visa.facturar(usuario.getCarrito().getProductos().get(0));
        assertTrue(usuario.getCarrito().getProductos().get(0).getPrecio() == 2799);
        assertTrue(usuario.getCarrito().getProductos().get(0).getAhorro() == 0);
    }
}
