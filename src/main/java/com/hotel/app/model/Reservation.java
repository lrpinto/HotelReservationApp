package com.hotel.app.model;

import com.hotel.app.model.room.IRoom;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Reservation.java
 * <p>
 * A class which represents a reservation.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class Reservation {

    // The check-in date for this reservation
    private final LocalDate checkInDate;

    // The check-out date for this reservation
    private final LocalDate checkOutDate;

    // The customer holding the reservation
    private final Customer customer;

    // The room instance in this Reservation
    private final IRoom room;

    /**
     * Create a new Reservation instance with the given customer, room, check-in and check-out dates.
     *
     * @param customer     - the given customer
     * @param room         - the given room
     * @param checkInDate  - the given check-in date
     * @param checkOutDate - the given check-out date
     */
    public Reservation(Customer customer, IRoom room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    /**
     * Get the check-in date for this Reservation.
     *
     * @return a LocalDate representing the check-in date.
     */
    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    /**
     * Get the check-out date for this Reservation.
     *
     * @return a LocalDate representing the check-out date.
     */
    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Get the room in this Reservation.
     *
     * @return the Room instance for this Reservation.
     */
    public IRoom getRoom() {
        return room;
    }

    /**
     * (non-javadoc)
     *
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(room, checkInDate, checkOutDate);
    }

    /**
     * (non-javadoc)
     *
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(room, that.room) && Objects.equals(checkInDate,
                that.checkInDate) && Objects.equals(checkOutDate, that.checkOutDate);
    }

    /**
     * A String representing a Reservation instance.
     *
     * @return this Reservation instance represented as String.
     */
    @Override
    public String toString() {
        return customer + "\n" +
                room + "\n" +
                "Check-in date: " + checkInDate + "\n" +
                "Check-out date: " + checkOutDate;
    }

    /**
     * Return whether this reservation overlaps the period determined by the given check-in and checkout dates.
     *
     * @param checkInDate  - the given check-in date
     * @param checkOutDate - the given check-out date
     * @return true if there is an overlap, false otherwise.
     */
    public boolean isOverlap(LocalDate checkInDate, LocalDate checkOutDate) {
        return !(isAfter(checkInDate, checkOutDate) || isBefore(checkInDate, checkOutDate));
    }

    /**
     * Return whether this Reservation is after the given check-in and check-out dates.
     *
     * @param checkInDate  - the given check-in date
     * @param checkOutDate - the given check-out date
     * @return true if this Reservation starts and ends after the period determined by the given dates, false otherwise.
     */
    public boolean isAfter(LocalDate checkInDate, LocalDate checkOutDate) {
        return checkInDate.isBefore(this.checkInDate) &&
                (checkOutDate.isBefore(this.checkInDate) || checkOutDate.isEqual(this.checkInDate));
    }

    /**
     * Return whether this Reservation is before the given check-in and check-out dates.
     *
     * @param checkInDate  - the given check-in date
     * @param checkOutDate - the given check-out date
     * @return true if this Reservation starts and ends before the period determined by the given dates, false otherwise.
     */
    public boolean isBefore(LocalDate checkInDate, LocalDate checkOutDate) {
        return this.checkInDate.isBefore(checkInDate) &&
                (this.checkOutDate.isBefore(checkInDate) || this.checkOutDate.equals(checkInDate));
    }

}
