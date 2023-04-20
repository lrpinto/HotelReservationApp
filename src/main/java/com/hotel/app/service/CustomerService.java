package com.hotel.app.service;

import com.hotel.app.model.Customer;

import java.util.Collection;
import java.util.HashMap;

public class CustomerService {

    private static CustomerService instance;

    private final HashMap<String, Customer> customers;

    private CustomerService() {
        this.customers = new HashMap<>();
    }

    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }
        return instance;
    }

    public void addCustomer(String email, String firstName, String lastName) {
        if (this.customers.containsKey(email)) {
            throw new IllegalArgumentException("A customer with this email already exists");
        }

        Customer customer = new Customer(email, firstName, lastName);
        this.customers.put(email, customer);
    }

    public Customer getCustomer(String email) {
        return this.customers.get(email);
    }

    public Collection<Customer> getAllCustomers() {
        return this.customers.values();
    }
}
