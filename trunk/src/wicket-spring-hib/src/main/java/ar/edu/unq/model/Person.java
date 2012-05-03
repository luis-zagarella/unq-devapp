package ar.edu.unq.model;

import java.util.ArrayList;
import java.util.List;

public class Person extends Entity {

	private static final long serialVersionUID = 6716714837006810519L;
	private int age;
	private List<Car> cars = new ArrayList<Car>();
	private String name;

	public Person() {
		super();
	}

	public Person(final String name, final int age) {
		super();
		this.name = name;
		this.age = age;

	}

	public void addCar(final Car car) {
		this.getCars().add(car);
	}

	public int getAge() {
		return this.age;
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public String getName() {
		return this.name;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	public void setCars(final List<Car> cars) {
		this.cars = cars;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
