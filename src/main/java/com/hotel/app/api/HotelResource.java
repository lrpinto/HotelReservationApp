package com.hotel.app.api;

import com.hotel.app.model.Customer;
import com.hotel.app.model.Reservation;
import com.hotel.app.model.room.IRoom;
import com.hotel.app.service.CustomerService;
import com.hotel.app.service.ReservationService;

import java.time.LocalDate;
import java.util.Collection;

public class HotelResource {

    private static HotelResource instance;

    private HotelResource() {
    }

    public static HotelResource getInstance() {
        if (instance == null) {
            instance = new HotelResource();
        }
        return instance;
    }

    public Customer getCustomer(String email) {
        return CustomerService.getInstance().getCustomer(email);
    }

    public void createACustomer (String email, String firstName, String lastName) {
        CustomerService.getInstance().addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom (String roomNumber) {
        return ReservationService.getInstance().getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, LocalDate checkInDate, LocalDate checkOutDate) {
        Customer customer = getCustomer(customerEmail);
        return ReservationService.getInstance().reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String email) {
        Customer customer = getCustomer(email);
        return ReservationService.getInstance().getCustomersReservation(customer);
    }

    public Collection<IRoom> findARoom (LocalDate checkIn, LocalDate checkout) {
        return ReservationService.getInstance().findRooms(checkIn, checkout);
    }
}
