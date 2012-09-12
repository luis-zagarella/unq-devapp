package ar.edu.garr;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.garr.productos.Categoria;
import ar.edu.garr.productos.Combo;
import ar.edu.garr.productos.Producto;

public class ComboTest extends TestCase {

    public void testAplicarPromocion() {
        Producto prod1 = new Producto("LG", "asd", 1000, Categoria.AIREACONDICIONADO, 2);
        Producto prod2 = new Producto("LG", "asd", 1000, Categoria.AIREACONDICIONADO, 2);
        Producto prod3 = new Producto("LG", "asd", 1000, Categoria.AIREACONDICIONADO, 2);
        Producto prod4 = new Producto("LG", "asd", 1000, Categoria.AIREACONDICIONADO, 2);
        Combo combo = new Combo("LG", "asd", 2000, Categoria.AIREACONDICIONADO, 2);
        List<Producto> productos = new ArrayList<Producto>();
        productos.add(prod1);
        productos.add(prod2);
        productos.add(prod3);
        productos.add(prod4);
        combo.setProductos(productos);

        combo.aplicaPromocion();
        assertTrue(combo.getPrecio() == 4000);
    }
}
