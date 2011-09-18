/**
 * 
 */
package ar.edu.unq;

// CHECKSTYLE:OFF
import static org.mockito.Mockito.*;

import java.util.Date;

import ar.edu.unq.PersistenceException;
import ar.edu.unq.Person;
import ar.edu.unq.PersonPersister;
import ar.edu.unq.PersonPersisterImpl;
import ar.edu.unq.Repository;
import ar.edu.unq.RepositoryException;

import junit.framework.TestCase;

/**
 * Prueba usando mockito.
 * 
 * @author diego
 * 
 */
public class PersonPersisterUsingMockitoTest extends TestCase {

    public void testPersonPersister() throws Exception {
        Repository repositoryMock = mock(Repository.class);

        Person aPerson = new Person("Diego", "Gomez", new Date());

        PersonPersister persister = new PersonPersisterImpl(repositoryMock);

        persister.save(aPerson);

        verify(repositoryMock, atLeastOnce()).persists(aPerson);
    }

    public void testPersonPersisterFails() throws Exception {
        Repository repositoryMock = mock(Repository.class);

        Person aPerson = new Person("Diego", "Gomez", new Date());

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

        when(aPerson.getName()).thenReturn("diego");

        when(aPerson.getBirthday()).thenThrow(new RuntimeException("Exploto"));

        assertEquals("diego", aPerson.getName());

        try {
            aPerson.getBirthday();
            fail("Should thown a RuntimeException");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("Exploto"));
        }
    }

    public void testLlamadasSucesivas() {
        Person aPerson = mock(Person.class);

        when(aPerson.getName()).thenReturn("diego1", "diego2", "diego3");

        assertEquals("diego1", aPerson.getName());
        assertEquals("diego2", aPerson.getName());
        assertEquals("diego3", aPerson.getName());
    }

}
