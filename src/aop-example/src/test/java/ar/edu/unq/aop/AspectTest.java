package ar.edu.unq.aop;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class AspectTest extends AbstractDependencyInjectionSpringContextTests {

    private Persona persona;

    public void setPersona(final Persona unaPersona) {
        persona = unaPersona;
    }

    public void testAspects() {
        persona.comprar();
    }

    @Override
    protected String[] getConfigLocations() {
        return new String[] { "aspects-context.xml" };
    }

}
