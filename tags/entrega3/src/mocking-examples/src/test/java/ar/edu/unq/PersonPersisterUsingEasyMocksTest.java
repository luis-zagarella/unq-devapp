/**
 * 
 */
package ar.edu.unq;

// CHECKSTYLE:OFF
import static org.easymock.EasyMock.*;
import static org.easymock.classextension.EasyMock.*;

import java.util.Date;

import ar.edu.unq.PersistenceException;
import ar.edu.unq.Person;
import ar.edu.unq.PersonPersister;
import ar.edu.unq.PersonPersisterImpl;
import ar.edu.unq.Repository;
import ar.edu.unq.RepositoryException;

import junit.framework.TestCase;

/**
 * Usando EasyMocks.
 * 
 * @author diego
 * 
 */
public class PersonPersisterUsingEasyMocksTest extends TestCase {

    public void testPersonPersister() throws Exception {
        Person aPerson = new Person("Diego", "Gomez", new Date());

        Repository repositoryMock = createMock(Repository.class);
        repositoryMock.persists(aPerson);
        replay(repositoryMock);

        PersonPersister persister = new PersonPersisterImpl(repositoryMock);

        persister.save(aPerson);

        verify(repositoryMock);
    }

    public void testPersonPersisterFails() throws Exception {
        Person aPerson = new Person("Diego", "Gomez", new Date());

        Repository repositoryMock = createMock(Repository.class);
        repositoryMock.persists(aPerson);
        expectLastCall().andThrow(new RepositoryException());
        repositoryMock.rollback();
        replay(repositoryMock);

        PersonPersister persister = new PersonPersisterImpl(repositoryMock);

        try {
            persister.save(aPerson);
            fail("should thrown a PersistenceException");
        } catch (PersistenceException e) {
            verify(repositoryMock);
        }
    }

    public void testPersonIsAStub() throws Exception {
        Person aPerson = createMock(Person.class);
        expect(aPerson.getName()).andStubReturn("diego");
        expect(aPerson.getBirthday()).andStubThrow(new RuntimeException("Exploto"));
        replay(aPerson);

        assertEquals("diego", aPerson.getName());

        try {
            aPerson.getBirthday();
            fail("Should thown a RuntimeException");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("Exploto"));
        }
    }

}
