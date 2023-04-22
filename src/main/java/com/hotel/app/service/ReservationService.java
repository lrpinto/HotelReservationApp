package com.hotel.app.service;

import com.hotel.app.model.Customer;
import com.hotel.app.model.Reservation;
import com.hotel.app.model.room.IRoom;

import java.time.LocalDate;
import java.util.*;

/**
 * ReservationService.java
 *
 * A class which provides Reservation services.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class ReservationService {

    private static ReservationService instance;

    private final HashMap<String, Collection<Reservation>> reservationsByCustomer;
    private final HashSet<IRoom> rooms;

    private ReservationService() {
        this.reservationsByCustomer = new HashMap<>();
        this.rooms = new HashSet<>();
    }

    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

    public void addIRoom(IRoom room) {
        this.rooms.add(room);
    }

    /**
     * Searching for rooms.
     * Allow the user to search for available rooms based on provided checkin and checkout dates.
     * If the application has available rooms for the specified date range,
     * a list of the corresponding rooms will be displayed to the user for choosing.
     *
     */
    public Collection<IRoom> findRooms(LocalDate checkInDate, LocalDate checkOutDate) {
        Set<IRoom> availableRooms = new HashSet<>(rooms);
        this.reservationsByCustomer.values().forEach(reservations -> reservations.forEach(reservation -> {
            LocalDate reservationCheckInDate = reservation.getCheckInDate();
            LocalDate reservationCheckOutDate = reservation.getCheckOutDate();
            if (!reservationCheckInDate.isAfter(checkOutDate) || !reservationCheckOutDate.isBefore(checkInDate)) {
                availableRooms.remove(reservation.getRoom());
            }
        }));

        return availableRooms;
    }

    public IRoom getARoom(String roomId) {
        return this.rooms.stream()
                .filter(room -> room.getRoomNumber().equals(roomId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to find room with the provided room number."));
    }

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

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        return this.reservationsByCustomer.get(customer.getEmail());
    }

}
