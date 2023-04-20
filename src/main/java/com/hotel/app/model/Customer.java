package com.hotel.app.model;

import com.hotel.app.validator.PatternValidator;

import java.util.Objects;

import static com.hotel.app.constant.Regex.EMAIL_REGEX;

/**
 * Customer.java
 * A class which represents a customer
 *
 * @author luisapinto
 */
public class Customer {

    private final String email;

    private final String firstName;

    private final String lastName;

    /**
     * Create a new Customer with the given email, first name, and last name
     *  @param firstName the first name for this customer
     * @param lastName the last name for this customer
     * @param email the given email for this customer
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
     * Return the customer email
     *
     * @return a String representing the customer email
     */
    public String getEmail() {
        return email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getEmail(), customer.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }

    @Override
    public String toString() {
        return "Email: " + email + ", First Name: " + firstName + ", Last Name: " + lastName;
    }
}
