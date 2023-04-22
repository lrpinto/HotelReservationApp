package com.hotel.app.service;

import com.hotel.app.model.Customer;

import java.util.Collection;
import java.util.HashMap;

/**
 * CustomerService.java
 * <p>
 * A class which provides Customer services.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class CustomerService {

    // The singleton instance of CustomerService
    private static CustomerService instance;

    // A hash map to store customers indexed by email address.
    private final HashMap<String, Customer> customers;

    // Hides the constructor since this class is a singleton
    private CustomerService() {
        this.customers = new HashMap<>();
    }

    /**
     * Get the singleton CustomerService instance.
     *
     * @return the CustomerService instance.
     */
    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }
        return instance;
    }

    /**
     * Add the customer with the given email, first name, and last name.
     *
     * @param email - the given email
     * @param firstName - the given first name
     * @param lastName - the given last name
     */
    public void addCustomer(String email, String firstName, String lastName) {
        if (this.customers.containsKey(email)) {
            throw new IllegalArgumentException("A customer with this email already exists");
        }

        Customer customer = new Customer(email, firstName, lastName);
        this.customers.put(email, customer);
    }

    /**
     * Get the Customer instance with the given email address.
     *
     * @param email - the given email address.
     * @return a Customer instance with the given email, or null if it does not exists.
     */
    public Customer getCustomer(String email) {
        return this.customers.get(email);
    }

    /**
     * Get the all Customer instances held by this CustomerService instance.
     *
     * @return a collection of Customer instances.
     */
    public Collection<Customer> getAllCustomers() {
        return this.customers.values();
    }
}
