package ar.edu.garr;

import junit.framework.TestCase;

import org.joda.time.DateTime;

import ar.edu.garr.mediosdepago.Promocion;

/**
 * 
 */
public class PromocionTest extends TestCase {
    public void testEstaVigente() {
        Promocion promo = new Promocion(30, new DateTime("2012-09-30"));
        Promocion promo2 = new Promocion(30, new DateTime("2012-08-20"));

        Boolean vigente = promo.estaVigente();
        Boolean noVigente = promo2.estaVigente();

        assertTrue(vigente);
        assertFalse(noVigente);
    }

}
