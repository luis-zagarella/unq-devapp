package ar.edu.unq;

import org.apache.log4j.Logger;

public class Person {

	private static final Logger LOG = Logger.getLogger(Person.class);

	private String name;

	long id;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Mugre para Hibernate
	 */

	public Person() {

	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}
}
