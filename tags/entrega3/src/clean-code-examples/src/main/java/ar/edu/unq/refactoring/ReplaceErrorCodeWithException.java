package ar.edu.unq.refactoring;

/**
 * Usemos exceptions. En gral reduce la cantidad y complejidad del codigo en el
 * metodo que las lanza.
 */
public class ReplaceErrorCodeWithException {

    private double balance;

    int withdraw_v1(final double amount) {
        if (amount > balance) {
            return -1;
        }

        balance -= amount;
        return 0;
    }

    public void uso_v1() {
        if (this.withdraw_v1(200) < 0) {
            this.handleError();
        }
        this.moreCode();
    }

    void withdraw_v2(final double amount) {
        if (amount > balance) {
            throw new BalanceException(balance, amount);
        }

        balance -= amount;
    }

    public void uso_v2() {
        try {
            this.withdraw_v2(200);
        } catch (BalanceException e) {
            this.handleError();
        }
        this.moreCode();
    }

    private void moreCode() {
        throw new UnsupportedOperationException();
    }

    private void handleError() {
        throw new UnsupportedOperationException();
    }

    static class BalanceException extends RuntimeException {

        public BalanceException(final double balance, final double amount) {
            throw new UnsupportedOperationException();
        }

        private static final long serialVersionUID = 9137570078131393654L;

    }

}
