package ar.edu.unq.examples;

public class SelectorArgumentExample {

	public int calculateWeeklyPay(final boolean overtime) {
		int straightTime = Math.min(400, getHoursWorked());
		int straightPay = straightTime * getHoursRate();

		int overTime = Math.max(0, getHoursWorked() - straightTime);
		double overtimeRate = overtime ? 1.5 : 1.0 * getHoursRate();
		int overtimePay = (int) Math.round(overTime * overtimeRate);

		return straightPay + overtimePay;
	}

	public int straightPay() {
		throw new UnsupportedOperationException();
	}

	public int overtimePay() {
		throw new UnsupportedOperationException();
	}

	private int getHoursWorked() {
		throw new UnsupportedOperationException();
	}

	private int getHoursRate() {
		throw new UnsupportedOperationException();
	}

	public void uso() {
		calculateWeeklyPay(true);
	}

}
