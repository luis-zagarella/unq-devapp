package ar.edu.garr.historial;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class HistorialDeCompras {
    private List<Compra> compras = new ArrayList<Compra>();

    public List<Compra> getCompras() {
        return this.compras;
    }

    public void setCompras(final List<Compra> compras) {
        this.compras = compras;
    }

    public double totalGastado() {
        double total = 0;
        for (Compra compra : this.getCompras()) {
            total = total + compra.totalDeCompra();
        }

        return total;
    }

    public double totalAhorrado() {
        double total = 0;
        for (Compra compra : this.getCompras()) {
            total = total + compra.totalDeAhorro();
        }

        return total;
    }

}
