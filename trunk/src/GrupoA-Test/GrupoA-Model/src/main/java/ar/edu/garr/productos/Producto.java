package ar.edu.garr.productos;

/**
 * 
 */
public class Producto {

    private String marca;

    private String modelo;

    private int anioFabricacion;

    private String descripcion;

    private String especificacion;

    private int stock;

    private double precio;

    private Categoria categoria;

    public Categoria getCategoria() {
        return this.categoria;
    }

    public Producto(final String marca, final String modelo, final double precio, final Categoria categoria,
            final int stock) {
        super();
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    public void setCategoria(final Categoria categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(final String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(final String modelo) {
        this.modelo = modelo;
    }

    public int getAnioFabricacion() {
        return this.anioFabricacion;
    }

    public void setAnioFabricacion(final int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEspecificacion() {
        return this.especificacion;
    }

    public void setEspecificacion(final String especificacion) {
        this.especificacion = especificacion;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(final int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(final double precio) {
        this.precio = precio;
    }

    public void aplicaPromocion() {
    }

    @Override
    public String toString() {
        return this.getMarca() + " - " + this.getModelo();
    }

    public boolean hayStock() {
        return this.getStock() > 0;
    }
}
