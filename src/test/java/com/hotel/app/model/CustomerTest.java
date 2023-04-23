package com.hotel.app.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customerUnderTest;

    @BeforeEach
    void setUp() {
        customerUnderTest = new Customer("email@nodomain.com", "firstName", "lastName");
    }

    @AfterEach
    void tearDown() {
        customerUnderTest = null;
    }

    @Test
    void testCustomer_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Customer(null, "firstName", "lastName"));
        assertThrows(IllegalArgumentException.class, () -> new Customer("", "firstName", "lastName"));
        assertThrows(IllegalArgumentException.class, () -> new Customer("1234", "firstName", "lastName"));
        assertThrows(IllegalArgumentException.class, () -> new Customer("abc" , "firstName", "lastName"));
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
        Customer  customer = new Customer("email@nodomain.com", "firstName", "lastName");

        assertEquals(customerUnderTest, customer);

        customer = new Customer("email@nodomain.io", "firstName", "lastName");

        assertNotEquals(customerUnderTest, customer);
    }

    @Test
    void testHashCode() {
        Customer  customer = new Customer("email@nodomain.com", "firstName", "lastName");

        assertEquals(customer.hashCode(), customerUnderTest.hashCode());

        customer = new Customer("email@nodomain.io", "firstName", "lastName");

        assertNotEquals(customer.hashCode(), customerUnderTest.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Email: email@nodomain.com, First Name: firstName, Last Name: lastName", customerUnderTest.toString());
    }
}
