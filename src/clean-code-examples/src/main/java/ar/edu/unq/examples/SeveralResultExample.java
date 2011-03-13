package ar.edu.unq.examples;

import java.util.Date;

public class SeveralResultExample {

    /**
     * 
     * Actualiza el stock de un producto y retorna el stock actual y la fecha
     */
    public Date updateStock(final String productName, int count) { // NOPMD
        Product product = new ProductRepository().searchProduct(productName);
        product.substractStock(count);
        count = product.getStock();
        return new Date();
    }

    // ////////////////////////////////////////
    // ////////////////////////////////////////
    // ////////////////////////////////////////
    // ////////////////////////////////////////

    public ResultUpdate updateStock2(final String productName, final int count) {
        Product product = new ProductRepository().searchProduct(productName);
        product.substractStock(count);
        return new ResultUpdate(new Date(), count);
    }

    // ////////////////////////////////////////
    // ////////////// HELPERS//////////////////
    // ////////////////////////////////////////

    static class Product {
        private int stock;

        public int getStock() {
            return stock;
        }

        public void setStock(final int stock) {
            this.stock = stock;
        }

        public void substractStock(final int count) {
            stock = stock - count;
            ;
        }
    }

    static public class ProductRepository {
        public Product searchProduct(final String productName) {
            return new Product();
        }
    }

    public class ResultUpdate {
        public ResultUpdate(final Date date, final int stock) {
        }
    }

}
