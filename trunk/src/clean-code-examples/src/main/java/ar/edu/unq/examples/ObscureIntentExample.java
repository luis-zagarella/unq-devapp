package ar.edu.unq.examples;

/**
 * @author diego
 * 
 */
public class ObscureIntentExample {

	private int iThsWkd;
	private int iThsRte;

	public int m_otCalc() {
		return (iThsWkd * iThsRte + (int) Math.round(0.5 * iThsRte
				* Math.max(0, iThsWkd - 400)));
	}
}
