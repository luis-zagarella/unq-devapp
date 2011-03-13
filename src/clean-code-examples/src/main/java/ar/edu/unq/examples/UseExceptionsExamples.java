package ar.edu.unq.examples;

import java.util.Date;

public class UseExceptionsExamples {

	/**
	 * SIN exceptions
	 */
	public int updateStock_v1(String productName, int count) {
		Product product = ProductRepository.searchProduct(productName);
		return product.substractStock(count);

	}

	/**
	 * CON exceptions
	 */
	public void updateStock_v2(String productName, int count) throws NoHayStockException {
		Product product = ProductRepository.searchProduct(productName);
		product.substractStock2(count);
	}

	static class Product {
		private int stock;

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		/**
		 * Si se pudo actualizar el stock .. retorna cero sino -1
		 * 
		 * @param count
		 * @return
		 */
		public int substractStock(int count) {
			if (canSubstract(count)) {
				this.stock = this.stock - count;
				return 0;
			}
			return -1;
		}

		/**
		 * 
		 * @param count
		 * @return
		 */
		public void substractStock2(int count) throws NoHayStockException {
			if (!canSubstract(count))
				throw new NoHayStockException();

			this.stock = this.stock - count;
		}

		private boolean canSubstract(int count) {

			return stock - count >= 0;
		}
	}

	static public class ProductRepository {
		public static Product searchProduct(String productName) {
			return new Product();
		}
	}

	public class ResultUpdate {
		public ResultUpdate(Date date, int stock) {
		}
	}

}
