package ar.edu.unq.examples.statements;

public class Nesting {

    double discountFor(final int quantity) {
        Double discount = null;

        if (quantity > 10) {
            if (quantity > 100) {
                if (quantity > 1000) {
                    discount = 0.10;
                } else {
                    discount = 0.05;
                }
            } else {
                discount = 0.025;
            }
        } else {
            discount = 0.0;
        }

        return discount;
    }

    double discountFor_v2(final int quantity) {
        if (quantity > 1000) {
            return 0.10;
        }
        if (quantity > 100) {
            return 0.05;
        }
        if (quantity > 10) {
            return 0.025;
        }

        return 0.0;
    }

}
