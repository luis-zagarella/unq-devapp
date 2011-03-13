package ar.edu.unq.refactoring;

/**
 * Usemos exceptions. En gral reduce la cantidad y complejidad del codigo en el
 * metodo que las lanza.
 */
public class ReplaceErrorCodeWithException {

	private double balance;

	int withdraw_v1(double amount) {
		if (amount > balance) {
			return -1;
		}

		balance -= amount;
		return 0;
	}

	public void uso_v1() {
		if (withdraw_v1(200) < 0) {
			handleError();
		}
		moreCode();
	}

	void withdraw_v2(double amount) {
		if (amount > balance) {
			throw new BalanceException(balance, amount);
		}

		balance -= amount;
	}

	public void uso_v2() {
		try {
			withdraw_v2(200);
		} catch (BalanceException e) {
			handleError();
		}
		moreCode();
	}

	private void moreCode() {
		throw new UnsupportedOperationException();
	}

	private void handleError() {
		throw new UnsupportedOperationException();
	}

	static class BalanceException extends RuntimeException {

		public BalanceException(double balance, double amount) {
			throw new UnsupportedOperationException();
		}

		private static final long serialVersionUID = 9137570078131393654L;

	}

}
