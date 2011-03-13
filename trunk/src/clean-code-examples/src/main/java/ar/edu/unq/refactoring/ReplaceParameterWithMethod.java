package ar.edu.unq.refactoring;

/**
 * La motivacion de este refactor es eliminar la mayor cantidad de parametros
 * posibles de un metodo. Cuantos menos parametros, mejor, mas facil de
 * entender.
 */
public class ReplaceParameterWithMethod {

	double getPrice_v1(int quantity, double itemPrice) {
		double basePrice = quantity * itemPrice;

		int discountLevel = getDiscountLevel();
		return discountedPrice_v1(basePrice, discountLevel);
	}

	double getPrice_v2(int quantity, double itemPrice) {
		double basePrice = quantity * itemPrice;
		return discountedPrice_v2(basePrice);
	}

	private double discountedPrice_v1(double basePrice, int discountLevel) {
		if (discountLevel == 2) {
			return basePrice * 0.1;
		}
		return basePrice * 0.05;
	}

	private double discountedPrice_v2(double basePrice) {
		if (getDiscountLevel() == 2) {
			return basePrice * 0.1;
		}
		return basePrice * 0.05;
	}

	private int getDiscountLevel() {
		throw new UnsupportedOperationException();
	}

}
