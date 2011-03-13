package ar.edu.unq.refactoring;

import java.util.Arrays;

/**
 * Las expresiones logicas se pueden volver complicadas de leer y entender. Con
 * este refactoring, ayudamos al lector a entender cual es la razon del branch.
 * 
 * La variante a este es introduce explaining variable (si es temp solo sirve en
 * ese metodo, si es inst, mete ruido), mejor usar explaining method.
 */
public class IntroduceExplainingMethod {

	private final String platform = "IE";
	private final int resize = 1;

	//@formatter:off
	public void before() {
		if ((platform.toUpperCase().indexOf("MAC") > -1) 
				&& (platform.toUpperCase().indexOf("IE") > -1)
				&& wasInitialized() 
				&& resize > 0) {

			someCode();
		} 
		otherCode();
	}

	// @formatter:on
	public void after() {
		if (isMacOs() && isIEBrowser() && wasInitialized() && wasResized()) {
			someCode();
		}
		otherCode();
	}

	// @formatter:on
	public void after2() {
		if (isPlatformSupported() && wasInitialized() && wasResized()) {
			someCode();
		}
		otherCode();
	}

	// @formatter:off
	public void after3() {
		if (satisfiesAll(
				isPlatformSupported(), 
				wasInitialized(), 
				wasResized())) {
			
			someCode();
		}
		otherCode();
	}

	private boolean satisfiesAll(boolean... exp) {
		return !Arrays.asList(exp).contains(false);
	}

	private boolean wasResized() {
		return resize > 0;
	}

	private boolean isPlatformSupported() {
		return isMacOs() && isIEBrowser();
	}
	
	private boolean isIEBrowser() {
		return platform.toUpperCase().indexOf("IE") > -1;
	}

	private boolean isMacOs() {
		return platform.toUpperCase().indexOf("MAC") > -1;
	}

	// support code.
	private void otherCode() {
	}

	private boolean wasInitialized() {
		return true;
	}

	private void someCode() {
	}

}
