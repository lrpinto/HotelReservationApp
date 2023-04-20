package com.hotel.app.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customerUnderTest;

    @BeforeEach
    void setUp() {
        customerUnderTest = new Customer("firstName", "lastName", "email@nodomain.com");
    }

    @AfterEach
    void tearDown() {
        customerUnderTest = null;
    }

    @Test
    void testCustomer_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Customer("firstName", "lastName", null));
        assertThrows(IllegalArgumentException.class, () -> new Customer("firstName", "lastName", ""));
        assertThrows(IllegalArgumentException.class, () -> new Customer("firstName", "lastName", "1234"));
        assertThrows(IllegalArgumentException.class, () -> new Customer("firstName", "lastName", "abc"));
    }

    @Test
    void getEmail() {
        assertEquals(customerUnderTest.getEmail(), "email@nodomain.com");
    }

    @Test
    void getFirstName() {
        assertEquals(customerUnderTest.getFirstName(), "firstName");
    }

    @Test
    void getLastName() {
        assertEquals(customerUnderTest.getLastName(), "lastName");
    }

    @Test
    void testEquals() {
        Customer  customer = new Customer("firstName", "lastName", "email@nodomain.com");

        assertEquals(customerUnderTest, customer);

        customer = new Customer("firstName", "lastName", "email@nodomain.io");

        assertNotEquals(customerUnderTest, customer);
    }

    @Test
    void testHashCode() {
        Customer  customer = new Customer("firstName", "lastName", "email@nodomain.com");

        assertEquals(customer.hashCode(), customerUnderTest.hashCode());

        customer = new Customer("firstName", "lastName", "email@nodomain.io");

        assertNotEquals(customer.hashCode(), customerUnderTest.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Email: email@nodomain.com, First Name: firstName, Last Name: lastName", customerUnderTest.toString());
    }
}
