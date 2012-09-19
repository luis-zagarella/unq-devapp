package ar.edu.unq;

public class Person {

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
