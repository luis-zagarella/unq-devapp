package ar.edu.garr;

import junit.framework.TestCase;

import org.joda.time.DateTime;

import ar.edu.garr.mediosdepago.MedioDePago;
import ar.edu.garr.productos.Categoria;
import ar.edu.garr.productos.Producto;
import ar.edu.garr.usuarios.Usuario;

/**
 * 
 */
public class UsuarioTest extends TestCase {
    public void testAgregarProductosAlCarrito() {
        Usuario usuario = new Usuario("Martin");
        Producto heladera = new Producto("Patrick", "Hpk 35b", 2799, Categoria.HELADERA, 2);

        usuario.agregarProductoAlCarrito(heladera, 1);

        assertTrue(usuario.getCarrito().getProductos().get(0).getProducto() == heladera);
        assertTrue(usuario.getCarrito().getProductos().size() > 0);
        assertFalse(usuario.getCarrito().getProductos().size() > 2);
    }

    public void testAgregarMedioDePagoAlCarrito() {
        Usuario usuario = new Usuario("Martin");
        MedioDePago visa = new MedioDePago();

        usuario.agregarMedioDePagoAlCarrito(visa);

        assertTrue(usuario.getCarrito().getMedioDePago() == visa);
        assertFalse(usuario.getCarrito().getMedioDePago() == null);

    }

    public void testAgregarVoucherACarrito() {
        Usuario usuario = new Usuario("Martin");
        Voucher voucher = new Voucher(new DateTime("2012-09-30"), 30);
        Voucher voucherVencido = new Voucher(new DateTime("2012-08-20"), 30);

        usuario.agregarVoucherACarrito(voucher);
        usuario.agregarVoucherACarrito(voucherVencido);

        assertTrue(usuario.getCarrito().getVouchers().size() == 1);
    }
}
