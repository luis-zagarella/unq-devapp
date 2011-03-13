package ar.edu.unq.refactoring;

import java.util.Arrays;

/**
 * Muchos branches terminan en la misma accion. Usar ands o ors, segun
 * corresponda.
 */
public class ConsolidateConditionalExpression {

    public double getRate_v1() {
        if (this.onVacation()) {
            if (this.lengthOfService() > 10) {
                return 1;
            }
        }
        return 0.5;
    }

    public double getRate_v2() {
        if (this.onVacation() && this.lengthOfService() > 10) {
            return 1;
        }
        return 0.5;
    }

    public double getRate_v3() {
        return this.onVacation() && this.lengthOfService() > 10 ? 1 : 0.5;
    }

    private int lengthOfService() {
        throw new UnsupportedOperationException();
    }

    private boolean onVacation() {
        throw new UnsupportedOperationException();
    }

    static class TicTacToeGame {

        boolean isGameOver_v1() {
            if (this.allPositionsAreFilled()) {
                return true;
            }
            if (this.oneRowIsFilledByOnePlayer()) {
                return true;
            }
            if (this.oneColumnIsFilledByOnePlayer()) {
                return true;
            }
            if (this.oneDiagonalIsFilledByOnePlayer()) {
                return true;
            }
            return false;
        }

        //@formatter:off
		boolean isGameOver_v2() {
			if (this.allPositionsAreFilled() 
					|| this.oneRowIsFilledByOnePlayer() 
					|| this.oneColumnIsFilledByOnePlayer()
					|| this.oneDiagonalIsFilledByOnePlayer()) {
				return true;
			}
			return false;
		}

		boolean isGameOver_v3() {
			return this.allPositionsAreFilled() 
					|| this.oneRowIsFilledByOnePlayer() 
					|| this.oneColumnIsFilledByOnePlayer()
					|| this.oneDiagonalIsFilledByOnePlayer();
		}
		
		boolean isGameOver_v4() {
			return this.satisfiesAnyOf(
					this.allPositionsAreFilled(), 
					this.oneRowIsFilledByOnePlayer(), 
					this.oneColumnIsFilledByOnePlayer(),
					this.oneDiagonalIsFilledByOnePlayer());
		}

		private boolean satisfiesAnyOf(final boolean... exp) {
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
