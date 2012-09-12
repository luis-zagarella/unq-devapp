package ar.edu.garr;

import junit.framework.TestCase;

import org.joda.time.DateTime;

/**
 * 
 */
public class VoucherTest extends TestCase {
    public void testEstaVigente() {
        Voucher voucherVigente = new Voucher(new DateTime("2012-09-29"), 70);
        Voucher voucherNoVigente = new Voucher(new DateTime("2012-08-29"), 70);

        Boolean vigente = voucherVigente.estaVigente();
        Boolean noVigente = voucherNoVigente.estaVigente();

        assertTrue(vigente);
        assertFalse(noVigente);
    }
}
