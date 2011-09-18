package ar.edu.unq;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTestCaseJunit4Style {

    private static final List<String> calls = new ArrayList<String>();

    static boolean setUpWasCalledOnce = false;

    static boolean tearDownWasCalledOnce = false;

    @BeforeClass
    public static void method_before_class() throws Exception {
        calls.add("method_before_class");
    }

    @Before
    public void method1() throws Exception {
        if (!setUpWasCalledOnce) {
            calls.add("method1");
            setUpWasCalledOnce = true;
        }
    }

    @After
    public void method2() throws Exception {
        if (!tearDownWasCalledOnce) {
            calls.add("method2");
            tearDownWasCalledOnce = true;
        }
    }

    @Test
    public void testMethodExample() throws Exception {
        calls.add("testMethod");
    }

    @Test
    public void aftersAndBeforesShouldWrapTheTestMethod() throws Exception {
        assertThat(this.callAt(0), is("method_before_class"));
        assertThat(this.callAt(1), is("method1"));
        assertThat(this.callAt(2), is("testMethod"));
        assertThat(this.callAt(3), is("method2"));
    }

    public String callAt(final int index) {
        return calls.get(index);
    }

}
