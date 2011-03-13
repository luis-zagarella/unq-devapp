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

	public double getDistanceTravelled_before(int time) {
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

	public double getDistanceTravelled_after(int time) {
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

	public double getDistanceTravelled_after2(int time) {
		if (secondaryTime(time) > 0) {
			return primaryDistanceTravelled(time) + secondaryDistanceTravelled(time);
		}
		return primaryDistanceTravelled(time);
	}

	private double secondaryDistanceTravelled(int time) {
		return primaryVelocity() * secondaryTime(time) + 0.5 * secondaryAcceleration() * secondaryTime(time)
				* secondaryTime(time);
	}

	private double primaryDistanceTravelled(int time) {
		return 0.5 * primaryAcceleration() * primaryTime(time) * primaryTime(time);
	}

	private int secondaryAcceleration() {
		return (primaryForce + secondaryForce) / mass;
	}

	private double primaryVelocity() {
		return (double) primaryAcceleration() * delay;
	}

	private int secondaryTime(int time) {
		return time - delay;
	}

	private int primaryTime(int time) {
		return Math.min(time, delay);
	}

	private int primaryAcceleration() {
		return primaryForce / mass;
	}

}
