package ar.edu.unq.refactoring;

/**
 * Una variable temporal debera tener una sola responsabilidad. mas de una
 * confunde al lector. Deben ser seteadas una sola vez. (Con excepcion de las
 * que participan en loops o las usadas en collecting parameters)
 */
public class SplitTemporaryVariable {

    private int primaryForce;

    private int mass;

    private int delay;

    private int secondaryForce;

    public double getDistanceTravelled_before(final int time) {
        double result;
        double acc = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * acc * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            double primaryVel = acc * delay;
            acc = (primaryForce + secondaryForce) / mass; // se reasigna!!
            result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
        }
        return result;
    }

    public double getDistanceTravelled_after(final int time) {
        double result;
        double primaryAcc = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * primaryAcc * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            double primaryVel = primaryAcc * delay;
            double secondaryAcc = (primaryForce + secondaryForce) / mass;
            result += primaryVel * secondaryTime + 0.5 * secondaryAcc * secondaryTime * secondaryTime;
        }
        return result;
    }

    public double getDistanceTravelled_after2(final int time) {
        if (this.secondaryTime(time) > 0) {
            return this.primaryDistanceTravelled(time) + this.secondaryDistanceTravelled(time);
        }
        return this.primaryDistanceTravelled(time);
    }

    private double secondaryDistanceTravelled(final int time) {
        return this.primaryVelocity() * this.secondaryTime(time) + 0.5 * this.secondaryAcceleration()
                * this.secondaryTime(time) * this.secondaryTime(time);
    }

    private double primaryDistanceTravelled(final int time) {
        return 0.5 * this.primaryAcceleration() * this.primaryTime(time) * this.primaryTime(time);
    }

    private int secondaryAcceleration() {
        return (primaryForce + secondaryForce) / mass;
    }

    private double primaryVelocity() {
        return (double) this.primaryAcceleration() * delay;
    }

    private int secondaryTime(final int time) {
        return time - delay;
    }

    private int primaryTime(final int time) {
        return Math.min(time, delay);
    }

    private int primaryAcceleration() {
        return primaryForce / mass;
    }

}
