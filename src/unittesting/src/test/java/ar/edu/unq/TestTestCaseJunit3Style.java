package ar.edu.unq;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TestTestCaseJunit3Style extends TestCase {

    private static final List<String> calls = new ArrayList<String>();

    static boolean setUpWasCalledOnce = false;

    static boolean tearDownWasCalledOnce = false;

    @Override
    protected void setUp() throws Exception {
        if (!setUpWasCalledOnce) {
            calls.add("setUp");
            setUpWasCalledOnce = true;
        }
    }

    @Override
    protected void tearDown() throws Exception {

        if (!tearDownWasCalledOnce) {
            calls.add("tearDown");
            tearDownWasCalledOnce = true;
        }
    }

    public void testTestMethodExample() throws Exception {
        calls.add("testMethod");
    }

    public void testSetUpAndTearDownShouldWrapTheTestMethod() throws Exception {
        assertTrue(calls.get(0).equals("setUp"));
        assertTrue(calls.get(1).equals("testMethod"));
        assertTrue(calls.get(2).equals("tearDown"));
    }

}
