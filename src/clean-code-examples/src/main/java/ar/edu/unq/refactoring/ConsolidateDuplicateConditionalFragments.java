package ar.edu.unq.refactoring;

/**
 * Tal vez por algun refactoring previo o algun descuido, nos queda el mismo
 * coidgo ejecutandose siempre en 2 branchs distintos.
 */
public class ConsolidateDuplicateConditionalFragments {

	public double finalPrice_v1(double price) {
		double total = 0;
		if (isSpecialDeal()) {
			total = price * 0.95;
			changed();
		} else {
			total = price;
			changed();
		}
		return total;
	}

	public double finalPrice_v2(double price) {
		double total = 0;
		if (isSpecialDeal()) {
			total = price * 0.95;
		} else {
			total = price;
		}
		changed();
		return total;
	}

	public double finalPrice_v3(double price) {
		double total = isSpecialDeal() ? price * 0.95 : price;
		changed();
		return total;
	}

	private void changed() {
		throw new UnsupportedOperationException();
	}

	private boolean isSpecialDeal() {
		throw new UnsupportedOperationException();
	}

}
