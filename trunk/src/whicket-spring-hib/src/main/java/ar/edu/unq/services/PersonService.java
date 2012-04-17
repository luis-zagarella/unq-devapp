package ar.edu.unq.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.Person;
import ar.edu.unq.repositories.PersonRepository;

/**
 * TODO: description
 */
public class PersonService {

	static Logger logger = Logger.getLogger(PersonService.class);
	
    private PersonRepository personRepository;

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    public void setPersonRepository(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Transactional
    public void addPerson(final Person person) {
        personRepository.save(person);
        logger.warn("Log del person service");
    }

    @Transactional(readOnly = true)
    public List<Person> filterPeople(final String pattern) {
        return personRepository.filterPeople(pattern);
    }
}
