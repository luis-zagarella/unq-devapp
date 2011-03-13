/**
 * 
 */
package com.hexacta.hat.mockingexamples;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author diego
 * 
 */
public class Person {

    private final String name;

    private final String lastName;

    private final Date birthday;

    public Person(final String name, final String lastName, final Date birthday) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this).append(this.getName()).append(this.getLastName()).toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Person) {
            Person otherPerson = (Person) obj;
            return new EqualsBuilder().append(this.getName(), otherPerson.getName())
                    .append(this.getLastName(), otherPerson.getLastName())
                    .append(this.getBirthday(), otherPerson.getBirthday()).isEquals();
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getName()).append(this.getLastName()).append(this.getBirthday())
                .toHashCode();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }
}
