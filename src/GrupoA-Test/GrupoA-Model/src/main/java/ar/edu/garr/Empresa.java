package ar.edu.garr;

import java.util.ArrayList;
import java.util.List;

import ar.edu.garr.mediosdepago.MedioDePago;
import ar.edu.garr.productos.Categoria;
import ar.edu.garr.productos.Producto;
import ar.edu.garr.usuarios.Usuario;

/**
 *
 */
public class Empresa {
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    private List<Producto> productos = new ArrayList<Producto>();

    private List<MedioDePago> mediosDePago = new ArrayList<MedioDePago>();

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(final List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Producto> getProductos() {
        return this.productos;
    }

    public void setProductos(final List<Producto> productos) {
        this.productos = productos;
    }

    public List<MedioDePago> getMediosDePago() {
        return this.mediosDePago;
    }

    public void setMediosDePago(final List<MedioDePago> mediosDePago) {
        this.mediosDePago = mediosDePago;
    }

    // METODOS:

    public List<Producto> buscarProductoPorCategoria(final Categoria categoria) {
        List<Producto> productosCategoria = new ArrayList<Producto>();
        for (Producto producto : this.getProductos()) {
            if (producto.getCategoria() == categoria) {
                productosCategoria.add(producto);
            }
        }
        return productosCategoria;
    }

    public List<Producto> buscarProductoPorMarca(final String marca) {
        List<Producto> productosMarca = new ArrayList<Producto>();
        for (Producto producto : this.getProductos()) {
            if (producto.getMarca() == marca) {
                productosMarca.add(producto);
            }
        }
        return productosMarca;
    }

}
