package ar.edu.unq.refactoring;

/**
 * La motivacion de este refactor es eliminar la mayor cantidad de parametros
 * posibles de un metodo. Cuantos menos parametros, mejor, mas facil de
 * entender.
 */
public class ReplaceParameterWithMethod {

    double getPrice_v1(final int quantity, final double itemPrice) {
        double basePrice = quantity * itemPrice;

        int discountLevel = this.getDiscountLevel();
        return this.discountedPrice_v1(basePrice, discountLevel);
    }

    double getPrice_v2(final int quantity, final double itemPrice) {
        double basePrice = quantity * itemPrice;
        return this.discountedPrice_v2(basePrice);
    }

    private double discountedPrice_v1(final double basePrice, final int discountLevel) {
        if (discountLevel == 2) {
            return basePrice * 0.1;
        }
        return basePrice * 0.05;
    }

    private double discountedPrice_v2(final double basePrice) {
        if (this.getDiscountLevel() == 2) {
            return basePrice * 0.1;
        }
        return basePrice * 0.05;
    }

    private int getDiscountLevel() {
        throw new UnsupportedOperationException();
    }

}
