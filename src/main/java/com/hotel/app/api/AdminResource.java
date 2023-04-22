package com.hotel.app.api;

import com.hotel.app.model.Customer;
import com.hotel.app.model.room.IRoom;
import com.hotel.app.service.CustomerService;
import com.hotel.app.service.ReservationService;

import java.util.Collection;

/**
 * AdminResource.java
 *
 * A class resource which delegates admin operations to the respective services.
 *
 * The AdminResource has little to no behavior contained inside the class
 * and should make use of the Service classes to implement its methods.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class AdminResource {

    private static AdminResource instance;

    // This constructor his hidden because this class is a Singleton.
    private AdminResource() {}

    /**
     * Get the AdminResource instance.
     *
     * @return the AdminResource singleton object.
     */
    public static AdminResource getInstance() {
        if (instance == null) {
            instance = new AdminResource();
        }
        return instance;
    }

    /**
     * Get customer with the specified email.
     *
     * @param email - the specified email.
     * @return the Customer with the given email, or null if such Customer does not exist.
     */
    public Customer getCustomer(String email) {
        return CustomerService.getInstance().getCustomer(email);
    }

    /**
     * Add the given IRoom object which represents a room.
     *
     * @param room - the given room.
     */
    public void addRoom(IRoom room) {
        ReservationService.getInstance().addIRoom(room);
    }

    /**
     * Get all rooms.
     *
     * @return a collection of IRoom instances containing all rooms.
     */
    public Collection<IRoom> getAllRooms() {
        return ReservationService.getInstance().getAllRooms();
    }

    /**
     * Get all customers.
     *
     * @return a collection of Customer instances containing all customers.
     */
    public Collection<Customer> getAllCustomers(){
        return CustomerService.getInstance().getAllCustomers();
    }

    /**
     * Prints all reservations.
     */
    public void displayAllReservations() {
        ReservationService.getInstance().printAllReservations();
    }
}
