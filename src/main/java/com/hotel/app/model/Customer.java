package com.hotel.app.model;

import com.hotel.app.validator.PatternValidator;

import java.util.Objects;

import static com.hotel.app.constant.Regex.EMAIL_REGEX;

/**
 * Customer.java
 * <p>
 * A class which represents a customer.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class Customer {

    // The customer's email
    private final String email;

    // The customer's first name
    private final String firstName;

    // The customer's last name
    private final String lastName;

    /**
     * Create a new Customer with the given email, first name, and last name
     *
     * @param firstName the first name for this customer
     * @param lastName  the last name for this customer
     * @param email     the given email for this customer
     */
    public Customer(String email, String firstName, String lastName) {
        super();

        PatternValidator emailValidator = new PatternValidator(EMAIL_REGEX);
        if (!emailValidator.validate(email)) {
            throw new IllegalArgumentException("Email must be a valid email address");
        }

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Return the first name
     *
     * @return a String representing the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Return the last name
     *
     * @return a String representing the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * (non-javadoc)
     *
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }

    /**
     * (non-javadoc)
     *
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getEmail(), customer.getEmail());
    }

    /**
     * Return the customer email
     *
     * @return a String representing the customer email
     */
    public String getEmail() {
        return email;
    }

    /**
     * A String representing a Customer instance.
     *
     * @return this Customer instance represented as String.
     */
    @Override
    public String toString() {
        return "Email: " + email + ", First Name: " + firstName + ", Last Name: " + lastName;
    }
}
