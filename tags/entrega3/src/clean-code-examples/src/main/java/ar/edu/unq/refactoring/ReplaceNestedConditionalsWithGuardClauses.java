package ar.edu.unq.refactoring;

/**
 * Cuando queremos diferenciar bien las condiciones inusuales del camino feliz.
 * Los nested son mas dificiles de seguir y entender que cuando estamos en un
 * solo nivel.
 * 
 * Usando guard clauses, queda claro cuales el camino feliz y culaes las
 * condiciones inusuales
 */
public class ReplaceNestedConditionalsWithGuardClauses {

    private static final double ADJ_FACTOR = 0;

    private boolean isDead;

    private boolean isSeparated;

    private boolean isRetired;

    private double capital;

    private double intRate;

    private double duration;

    private double income;

    double getPayAmount_v1() {
        double result;
        if (isDead) {
            result = this.deadAmount();
        } else {
            if (isSeparated) {
                result = this.separatedAmount();
            } else {
                if (isRetired) {
                    result = this.retiredAmount();
                } else {
                    result = this.normalAmount();
                }
            }
        }
        return result;
    }

    double getPayAmount_v2() {
        if (isDead) {
            return this.deadAmount();
        }
        if (isSeparated) {
            return this.separatedAmount();
        }
        if (isRetired) {
            return this.retiredAmount();
        }
        return this.normalAmount();
    }

    double getAdjustedCapital_v1() {
        double result = 0.0;
        if (capital > 0.0) {
            if (intRate > 0.0 && duration > 0.0) {
                result = income / duration * ADJ_FACTOR;
            }
        }
        return result;
    }

    double getAdjustedCapital_v2() {
        if (capital <= 0.0) {
            return 0.0;
        }
        if (intRate <= 0.0 || duration <= 0.0) {
            return 0.0;
        }
        return income / duration * ADJ_FACTOR;
    }

    double getAdjustedCapital_v3() {
        if (capital <= 0.0 || intRate <= 0.0 || duration <= 0.0) {
            return 0.0;
        }
        return income / duration * ADJ_FACTOR;
    }

    private double normalAmount() {
        throw new UnsupportedOperationException();
    }

    private double retiredAmount() {
        throw new UnsupportedOperationException();
    }

    private double separatedAmount() {
        throw new UnsupportedOperationException();
    }

    private double deadAmount() {
        throw new UnsupportedOperationException();
    }

}
