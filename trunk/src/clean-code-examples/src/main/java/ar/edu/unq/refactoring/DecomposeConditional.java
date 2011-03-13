package ar.edu.unq.refactoring;

import java.util.Date;

/**
 * Gran parte de la complejidad de un metodo es culpa de expresiones
 * condiocionales complejas.
 * 
 * Basicamente aplicamos Extract method en le condiocinal y en las partes.
 */
public class DecomposeConditional {

    private static final Date WINTER_START = null;

    private static final Date WINTER_END = null;

    private static final int WINTER_RATE = 100;

    private static final int NORMAL_RATE = 10;

    private static final int WINTER_SERVICE_CHARGE = 55;

    double chargeFor_v1(final Date date, final int quantity) {
        double totalCharge = 0;
        if (date.after(WINTER_START) || date.before(WINTER_END)) {
            totalCharge = quantity * WINTER_RATE + WINTER_SERVICE_CHARGE;
        } else {
            totalCharge = quantity * NORMAL_RATE;
        }
        return totalCharge;
    }

    double chargeFor_v2(final Date date, final int quantity) {
        if (this.isAWinter(date)) {
            return this.winterCharge(quantity);
        }
        return this.normalCharge(quantity);
    }

    double chargeFor_v3(final Date date, final int quantity) {
        return this.isAWinter(date) ? this.winterCharge(quantity) : this.normalCharge(quantity);
    }

    private double normalCharge(final int quantity) {
        return quantity * NORMAL_RATE;
    }

    private double winterCharge(final int quantity) {
        return quantity * WINTER_RATE + WINTER_SERVICE_CHARGE;
    }

    private boolean isAWinter(final Date date) {
        return date.after(WINTER_START) || date.before(WINTER_END);
    }

}
