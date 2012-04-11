package ar.edu.unq.refactoring;

/**
 * Tal vez por algun refactoring previo o algun descuido, nos queda el mismo
 * coidgo ejecutandose siempre en 2 branchs distintos.
 */
public class ConsolidateDuplicateConditionalFragments {

    public double finalPrice_v1(final double price) {
        double total = 0;
        if (this.isSpecialDeal()) {
            total = price * 0.95;
            this.changed();
        } else {
            total = price;
            this.changed();
        }
        return total;
    }

    public double finalPrice_v2(final double price) {
        double total = 0;
        if (this.isSpecialDeal()) {
            total = price * 0.95;
        } else {
            total = price;
        }
        this.changed();
        return total;
    }

    public double finalPrice_v3(final double price) {
        double total = this.isSpecialDeal() ? price * 0.95 : price;
        this.changed();
        return total;
    }

    private void changed() {
        throw new UnsupportedOperationException();
    }

    private boolean isSpecialDeal() {
        throw new UnsupportedOperationException();
    }

}
