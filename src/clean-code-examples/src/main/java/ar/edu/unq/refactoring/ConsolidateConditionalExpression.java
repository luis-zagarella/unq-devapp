package ar.edu.unq.refactoring;

import java.util.Arrays;

/**
 * Muchos branches terminan en la misma accion. Usar ands o ors, segun
 * corresponda.
 */
public class ConsolidateConditionalExpression {

	public double getRate_v1() {
		if (onVacation()) {
			if (lengthOfService() > 10) {
				return 1;
			}
		}
		return 0.5;
	}

	public double getRate_v2() {
		if (onVacation() && lengthOfService() > 10) {
			return 1;
		}
		return 0.5;
	}

	public double getRate_v3() {
		return (onVacation() && lengthOfService() > 10) ? 1 : 0.5;
	}

	private int lengthOfService() {
		throw new UnsupportedOperationException();
	}

	private boolean onVacation() {
		throw new UnsupportedOperationException();
	}

	static class TicTacToeGame {

		boolean isGameOver_v1() {
			if (allPositionsAreFilled()) {
				return true;
			}
			if (oneRowIsFilledByOnePlayer()) {
				return true;
			}
			if (oneColumnIsFilledByOnePlayer()) {
				return true;
			}
			if (oneDiagonalIsFilledByOnePlayer()) {
				return true;
			}
			return false;
		}

		//@formatter:off
		boolean isGameOver_v2() {
			if (allPositionsAreFilled() 
					|| oneRowIsFilledByOnePlayer() 
					|| oneColumnIsFilledByOnePlayer()
					|| oneDiagonalIsFilledByOnePlayer()) {
				return true;
			}
			return false;
		}

		boolean isGameOver_v3() {
			return allPositionsAreFilled() 
					|| oneRowIsFilledByOnePlayer() 
					|| oneColumnIsFilledByOnePlayer()
					|| oneDiagonalIsFilledByOnePlayer();
		}
		
		boolean isGameOver_v4() {
			return satisfiesAnyOf(
					allPositionsAreFilled(), 
					oneRowIsFilledByOnePlayer(), 
					oneColumnIsFilledByOnePlayer(),
					oneDiagonalIsFilledByOnePlayer());
		}

		private boolean satisfiesAnyOf(boolean... exp) {
			return Arrays.asList(exp).contains(true);
		}

		private boolean oneDiagonalIsFilledByOnePlayer() {
			throw new UnsupportedOperationException();
		}

		private boolean oneColumnIsFilledByOnePlayer() {
			throw new UnsupportedOperationException();
		}

		private boolean oneRowIsFilledByOnePlayer() {
			throw new UnsupportedOperationException();
		}

		private boolean allPositionsAreFilled() {
			throw new UnsupportedOperationException();
		}
	}
}
