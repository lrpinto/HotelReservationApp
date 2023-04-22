package com.hotel.app.model;

import com.hotel.app.model.room.IRoom;

import java.time.LocalDate;
import java.util.Objects;

public class Reservation {

    private final Customer customer;

    public IRoom getRoom() {
        return room;
    }

    private final IRoom room;

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;

    public Reservation(Customer customer, IRoom room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(room, that.room) && Objects.equals(checkInDate,
                that.checkInDate) && Objects.equals(checkOutDate, that.checkOutDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, checkInDate, checkOutDate);
    }

    @Override
    public String toString() {
        return "Customer:\n\t" + customer + "\n" +
                "Room:\n\t" + room + "\n" +
                "Check-in date:\n\t" + checkInDate + "\n" +
                "Check-out date\n\t:" + checkOutDate;
    }
}
