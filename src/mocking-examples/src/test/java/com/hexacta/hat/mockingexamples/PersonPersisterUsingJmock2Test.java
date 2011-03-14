/**
 * 
 */
package com.hexacta.hat.mockingexamples;

import java.util.Date;

import junit.framework.TestCase;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

/**
 * Prueba de jmock2.
 * 
 * @author diego
 */
public class PersonPersisterUsingJmock2Test extends TestCase {

    public void testPersonPersister() {
        Mockery context = new Mockery();

        final Repository repositoryMock = context.mock(Repository.class);

        final Person aPerson = new Person("Diego", "Gomez", new Date());

        PersonPersister persister = new PersonPersisterImpl(repositoryMock);

        try {
            context.checking(new Expectations() {
                {
                    this.oneOf(repositoryMock).persists(aPerson);
                }
            });
        } catch (RepositoryException e) {
            throw new UnsupportedOperationException();
        }

        persister.save(aPerson);

        context.assertIsSatisfied();
    }

    public void testPersonPersisterFails() throws Exception {
        Mockery context = new Mockery();

        final Repository repositoryMock = context.mock(Repository.class);

        final Person aPerson = new Person("Diego", "Gomez", new Date());

        PersonPersister persister = new PersonPersisterImpl(repositoryMock);

        context.checking(new Expectations() {
            {
                this.oneOf(repositoryMock).persists(aPerson);
                this.will(throwException(new RepositoryException()));
                this.oneOf(repositoryMock).rollback();
            }
        });

        try {
            persister.save(aPerson);
            fail("should thrown a PersistenceException");
        } catch (PersistenceException e) {
            // Test success
        }

        context.assertIsSatisfied();
    }

    public void testPersonIsAStub() throws Exception {
        Mockery context = new Mockery() {
            {
                this.setImposteriser(ClassImposteriser.INSTANCE);
            }
        };

        final Person aPerson = context.mock(Person.class, "aPersonMock");

        context.checking(new Expectations() {
            {
                this.allowing(aPerson).getName();
                this.will(returnValue("diego"));
                this.allowing(aPerson).getBirthday();
                this.will(throwException(new RuntimeException("Exploto")));
            }
        });

        assertEquals("diego", aPerson.getName());

        try {
            aPerson.getBirthday();
            fail("Should thrown a RuntimeException");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("Exploto"));
        }

        context.assertIsSatisfied();
    }

}
