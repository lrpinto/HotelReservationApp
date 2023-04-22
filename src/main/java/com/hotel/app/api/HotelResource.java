package com.hotel.app.api;

import com.hotel.app.model.Customer;
import com.hotel.app.model.Reservation;
import com.hotel.app.model.room.IRoom;
import com.hotel.app.service.CustomerService;
import com.hotel.app.service.ReservationService;

import java.time.LocalDate;
import java.util.Collection;

/**
 * HotelResource.java
 *
 * A class resource which delegates hotel operations to the respective services.
 *
 * The HotelResource has little to no behavior contained inside the class
 * and should make use of the Service classes to implement its methods.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class HotelResource {

    private static HotelResource instance;

    // This constructor is hidden because this class is a Singleton.
    private HotelResource() {
    }

    /**
     * Get the HotelResource instance.
     *
     * @return the HotelResource singleton object.
     */
    public static HotelResource getInstance() {
        if (instance == null) {
            instance = new HotelResource();
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
     * Create a Customer instance with the given email, first name, and last name.
     *
     * @param email - the given email
     * @param firstName - the given first name
     * @param lastName - the given last name
     */
    public void createACustomer (String email, String firstName, String lastName) {
        CustomerService.getInstance().addCustomer(email, firstName, lastName);
    }

    /**
     * Get the IRoom instance with the given room number.
     *
     * @param roomNumber - the given room number.
     * @return the IRoom instance with the given room number.
     */
    public IRoom getRoom (String roomNumber) {
        return ReservationService.getInstance().getARoom(roomNumber);
    }

    /**
     * Book the given room for the Customer with the given email, for the provided check-in and check-out dates.
     *
     * @param customerEmail - the given email for the customer making the booking.
     * @param room - the given room to book.
     * @param checkInDate - the given check-in date.
     * @param checkOutDate - the given check-out date.
     * @return a Reservation instance which represents the booking.
     */
    public Reservation bookARoom(String customerEmail, IRoom room, LocalDate checkInDate, LocalDate checkOutDate) {
        Customer customer = getCustomer(customerEmail);
        if (customer == null) {
            throw new IllegalArgumentException("Customer with the provided email does not exist.");
        }
        return ReservationService.getInstance().reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    /**
     * Get the reservations for the Customer with the given email.
     *
     * @param email - the given email.
     * @return a Collection for Reservation instances containing only reservations for the target Customer.
     */
    public Collection<Reservation> getCustomersReservations(String email) {
        Customer customer = getCustomer(email);
        return ReservationService.getInstance().getCustomersReservation(customer);
    }

    /**
     * Find a room which is available between the check-in and check-out dates (both inclusive).
     *
     * @param checkIn - the given check-in date.
     * @param checkout - the given check-out date.
     * @return a Collection of IRoom instances representing room available during the specified dates period.
     */
    public Collection<IRoom> findARoom (LocalDate checkIn, LocalDate checkout) {
        return ReservationService.getInstance().findRooms(checkIn, checkout);
    }
}
