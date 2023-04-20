package com.hotel.app.driver;

import com.hotel.app.model.Customer;

public class CustomerDriver {

    public static void main(String[] args) {
        Customer customer = new Customer("user@nodomain.com", "firstname", "lastname");

        System.out.println(customer);

        customer = new Customer("no-email", "firstname", "lastname");

        System.out.println(customer);
    }
}
