/**
 * 
 */
package ar.edu.unq;

// CHECKSTYLE:OFF
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import junit.framework.TestCase;

/**
 * Prueba usando mockito.
 * 
 * @author Cristian
 * 
 */
public class PersonPersisterUsingMockitoTest extends TestCase {

    public void testPersonPersister() throws Exception {
        Repository repositoryMock = mock(Repository.class);

        Person aPerson = new Person("Cristian", "Gomez", new Date());

        PersonPersister persister = new PersonPersisterImpl(repositoryMock);

        persister.save(aPerson);

        verify(repositoryMock, atLeastOnce()).persists(aPerson);
    }

    public void testPersonPersisterFails() throws Exception {
        Repository repositoryMock = mock(Repository.class);

        Person aPerson = new Person("Cristian", "Gomez", new Date());

        PersonPersister persister = new PersonPersisterImpl(repositoryMock);

        doThrow(new RepositoryException()).when(repositoryMock).persists(aPerson);

        try {
            persister.save(aPerson);
            fail("should thrown a PersistenceException");
        } catch (PersistenceException e) {
            verify(repositoryMock).rollback();
        }
    }

    public void testPersonIsAStub() throws Exception {
        Person aPerson = mock(Person.class);

        when(aPerson.getName()).thenReturn("Cristian");

        when(aPerson.getBirthday()).thenThrow(new RuntimeException("Exploto"));

        assertEquals("Cristian", aPerson.getName());

        try {
            aPerson.getBirthday();
            fail("Should thown a RuntimeException");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("Exploto"));
        }
    }

    public void testLlamadasSucesivas() {
        Person aPerson = mock(Person.class);

        when(aPerson.getName()).thenReturn("Cristian1", "Cristian2", "Cristian3");

        assertEquals("Cristian1", aPerson.getName());
        assertEquals("Cristian2", aPerson.getName());
        assertEquals("Cristian3", aPerson.getName());
    }

}
