package ar.edu.unq.examples;

import junit.framework.TestCase;

public class GetEmailArrayTest extends TestCase {

    public void testGetEmailArray() {
        String[] results = GetEmailArrayExample
                .getEmailArray("carlos@gmail.com,pedro@gmail.com;Lucas@gmail.com Mariano@gmail.com:pepe@gmail.com,Leandro@gmail.com");
        assertEquals(6, results.length);
    }

    public void testGetEmailArray2() {
        String[] results = GetEmailArrayExample
                .getEmailArray2("carlos@gmail.com,pedro@gmail.com;Lucas@gmail.com Mariano@gmail.com:pepe@gmail.com,Leandro@gmail.com");
        assertEquals(6, results.length);
    }

}
