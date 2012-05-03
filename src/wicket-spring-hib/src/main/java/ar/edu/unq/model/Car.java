package ar.edu.unq.model;

import java.util.Date;

public class Car extends Entity {

	private static final long serialVersionUID = -3495963190665047369L;
	private String brand;
	private int occupeds;
	private Person owner;
	private Date since;

	public Car() {
		super();
	}

	public Car(final String brand, final int occupeds, final Date since) {
		super();
		this.brand = brand;
		this.occupeds = occupeds;
		this.since = since;
	}

	public String getBrand() {
		return this.brand;
	}

	public int getOccupeds() {
		return this.occupeds;
	}

	public Person getOwner() {
		return this.owner;
	}

	public Date getSince() {
		return this.since;
	}

	public void setBrand(final String brand) {
		this.brand = brand;
	}

	public void setOccupeds(final int occupeds) {
		this.occupeds = occupeds;
	}

	public void setOwner(final Person owner) {
		if (owner != null) {
			owner.addCar(this);
		}
		this.owner = owner;
	}

	public void setSince(final Date since) {
		this.since = since;
	}

}
