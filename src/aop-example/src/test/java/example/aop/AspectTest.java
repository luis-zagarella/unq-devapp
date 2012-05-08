package example.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/aspects-context.xml"})
public class AspectTest {

	@Autowired
    private Persona persona;

    public void setPersona(final Persona unaPersona) {
        persona = unaPersona;
    }

    @Test
    public void testAspects() {
        persona.comprar();
    }

    

}
