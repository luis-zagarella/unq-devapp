package ar.edu.unq.examples;

import java.util.Date;

public class UseExceptionsExamples {

    /**
     * SIN exceptions
     */
    public int updateStock_v1(final String productName, final int count) {
        Product product = ProductRepository.searchProduct(productName);
        return product.substractStock(count);

    }

    /**
     * CON exceptions
     */
    public void updateStock_v2(final String productName, final int count) throws NoHayStockException {
        Product product = ProductRepository.searchProduct(productName);
        product.substractStock2(count);
    }

    static class Product {
        private int stock;

        public int getStock() {
            return stock;
        }

        public void setStock(final int stock) {
            this.stock = stock;
        }

        /**
         * Si se pudo actualizar el stock .. retorna cero sino -1
         * 
         * @param count
         * @return
         */
        public int substractStock(final int count) {
            if (this.canSubstract(count)) {
                stock = stock - count;
                return 0;
            }
            return -1;
        }

        /**
         * 
         * @param count
         * @return
         */
        public void substractStock2(final int count) throws NoHayStockException {
            if (!this.canSubstract(count)) {
                throw new NoHayStockException();
            }

            stock = stock - count;
        }

        private boolean canSubstract(final int count) {

            return stock - count >= 0;
        }
    }

    static public class ProductRepository {
        public static Product searchProduct(final String productName) {
            return new Product();
        }
    }

    public class ResultUpdate {
        public ResultUpdate(final Date date, final int stock) {
        }
    }

}
