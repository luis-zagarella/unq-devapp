package ar.edu.unq.examples;

import ar.edu.unq.examples.ext.HourlyEmployee;
import ar.edu.unq.examples.ext.Loan;
import ar.edu.unq.examples.ext.Money;

public class FeatureEnvyExample {

	public Money calculateWeeklyPay(final HourlyEmployee employee) {
		int tenthRate = employee.getTenthRatePennies();
		int tenthsWorked = employee.getTenthWorked();

		int straightTime = Math.min(400, tenthsWorked);
		int overTime = Math.max(0, tenthsWorked - straightTime);

		int straightPay = straightTime * tenthRate;
		int overtimePay = (int) Math.round(overTime * tenthRate * 1.5);

		return new Money(straightPay + overtimePay);
	}

	public Money calculateWeeklyPay2(final HourlyEmployee employee) {
		return new Money(employee.weeklyPay());
	}

	public double capital(final Loan loan) {
		if (loan.getExpiry() == null && loan.getMaturity() != null)
			return loan.getCommitment() * loan.duration() * loan.riskFactor();
		if (loan.getExpiry() != null && loan.getMaturity() == null) {
			if (loan.getUnusedPercentage() != 1.0)
				return loan.getCommitment() * loan.getUnusedPercentage() * loan.duration() * loan.riskFactor();
			else
				return (loan.outstandingRiskAmount() * loan.duration() * loan.riskFactor())
						+ (loan.unusedRiskAmount() * loan.duration() * loan.unusedRiskFactor());
		}
		return 0.0;
	}

}
