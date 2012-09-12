package ar.edu.garr;

import java.util.List;

import junit.framework.TestCase;
import ar.edu.garr.productos.Categoria;
import ar.edu.garr.productos.Producto;

/**
 * 
 */
public class EmpresaTest extends TestCase {
    public void testProductosPorCategoria() {
        Empresa empresa = new Empresa();

        Producto heladera = new Producto("Patrick", "Hp220", 2850, Categoria.HELADERA, 2);
        Producto lavarropa = new Producto("Aurora", "Hp220", 3200, Categoria.LAVARROPAS, 2);
        Producto microondas = new Producto("Noven", "Hp220", 2850, Categoria.MICROONDAS, 2);
        Producto heladera2 = new Producto("Patrick", "fagor", 2200, Categoria.HELADERA, 2);
        Producto aa = new Producto("Sigma", "Hp220", 2000, Categoria.AIREACONDICIONADO, 2);

        empresa.getProductos().add(heladera);
        empresa.getProductos().add(heladera2);
        empresa.getProductos().add(lavarropa);
        empresa.getProductos().add(microondas);
        empresa.getProductos().add(aa);

        List<Producto> productos = empresa.buscarProductoPorCategoria(Categoria.HELADERA);

        assertTrue(productos.contains(heladera));
        assertTrue(productos.contains(heladera2));
        assertFalse(productos.contains(lavarropa));
        assertFalse(productos.contains(microondas));

    }

    public void testProductosPorMarca() {
        Empresa empresa = new Empresa();

        Producto heladera = new Producto("Patrick", "Hp220", 2850, Categoria.HELADERA, 2);
        Producto lavarropa = new Producto("Aurora", "Hp220", 3200, Categoria.LAVARROPAS, 2);
        Producto microondas = new Producto("Noven", "Hp220", 2850, Categoria.MICROONDAS, 2);
        Producto heladera2 = new Producto("Patrick", "fagor", 2200, Categoria.HELADERA, 2);
        Producto aa = new Producto("Sigma", "Hp220", 2000, Categoria.AIREACONDICIONADO, 2);

        empresa.getProductos().add(heladera);
        empresa.getProductos().add(heladera2);
        empresa.getProductos().add(lavarropa);
        empresa.getProductos().add(microondas);
        empresa.getProductos().add(aa);

        List<Producto> productos = empresa.buscarProductoPorMarca("Patrick");

        assertTrue(productos.contains(heladera));
        assertTrue(productos.contains(heladera2));
        assertFalse(productos.contains(lavarropa));
        assertFalse(productos.contains(microondas));

    }

}
