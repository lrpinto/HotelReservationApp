package com.hotel.app.service;

import com.hotel.app.model.Customer;
import com.hotel.app.model.Reservation;
import com.hotel.app.model.room.IRoom;

import java.time.LocalDate;
import java.util.*;

/**
 * ReservationService.java
 * <p>
 * A class which provides Reservation services.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class ReservationService {

    // The singleton instance of ReservationService
    private static ReservationService instance;

    // A map storing reservations indexed by customer emails.
    private final HashMap<String, Collection<Reservation>> reservationsByCustomer;

    // The set of rooms that can be either reserved or not.
    private final HashSet<IRoom> rooms;

    // Hide the ReservationService constructor since this class is a singleton.
    private ReservationService() {
        this.reservationsByCustomer = new HashMap<>();
        this.rooms = new HashSet<>();
    }

    /**
     * Get the singleton ReservationService instance.
     *
     * @return the ReservationService instance.
     */
    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

    /**
     * Add the given to the rooms held by this ReservationService.
     * @param room - the given room to add
     */
    public void addIRoom(IRoom room) {
        this.rooms.add(room);
    }

    /**
     * Searching for rooms.
     * Allow the user to search for available rooms based on provided checkin and checkout dates.
     * If the application has available rooms for the specified date range,
     * a list of the corresponding rooms will be displayed to the user for choosing.
     */
    public Collection<IRoom> findRooms(LocalDate checkInDate, LocalDate checkOutDate) {
        Set<IRoom> availableRooms = new HashSet<>(rooms);
        this.reservationsByCustomer.values().forEach(reservations -> reservations.forEach(reservation -> {
            /*
             * Avoid conflicting reservations. A single room may only be reserved by a single customer
             * per check-in and check-out date range.
             */
            if (reservation.isOverlap(checkInDate, checkOutDate)) {
                availableRooms.remove(reservation.getRoom());
            }
        }));

        return availableRooms;
    }

    /**
     * Get the room with given room number.
     *
     * @param roomNumber - the given room number
     * @return the IRoom instance representing a room with the given room number.
     */
    public IRoom getARoom(String roomNumber) {
        return this.rooms.stream()
                .filter(room -> room.getRoomNumber().equals(roomNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to find room with the provided room number."));
    }

    /**
     * Get all rooms held by this ReservationService.
     *
     * @return a collection of IRoom instances.
     */
    public Collection<IRoom> getAllRooms() {
        return this.rooms;
    }

    public void printAllReservations() {
        if (reservationsByCustomer.isEmpty()) {
            System.out.println("There are no reservations yet.");
            return;
        }

        this.reservationsByCustomer.values().forEach(System.out::println);
    }

    /**
     * Reserve the given room, for the given customer,
     * and for the period determined by the provided check=in and check-out dates.
     *
     * @param customer - the given customer
     * @param room - the given room
     * @param checkInDate - the given check-in date
     * @param checkOutDate - the given check-out date
     * @return a Reservation instance representing the created reservation.
     */
    public Reservation reserveARoom(Customer customer, IRoom room, LocalDate checkInDate, LocalDate checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        Collection<Reservation> reservations = getCustomersReservation(customer);
        if (reservations == null) {
            reservations = new LinkedList<>();
        }
        reservations.add(reservation);
        this.reservationsByCustomer.put(customer.getEmail(), reservations);
        return reservation;
    }

    /**
     * Get the reservations for the given Customer.
     *
     * @param customer - the given Customer instance
     * @return a collection of Reservation instances made by the given Customer.
     */
    public Collection<Reservation> getCustomersReservation(Customer customer) {
        return this.reservationsByCustomer.get(customer.getEmail());
    }

}
