package com.hotel.app.api;

import com.hotel.app.model.Customer;
import com.hotel.app.model.room.IRoom;
import com.hotel.app.service.CustomerService;
import com.hotel.app.service.ReservationService;

import java.util.Collection;

public class AdminResource {

    private static AdminResource instance;

    private AdminResource() {
    }

    public static AdminResource getInstance() {
        if (instance == null) {
            instance = new AdminResource();
        }
        return instance;
    }

    public Customer getCustomer(String email) {
        return CustomerService.getInstance().getCustomer(email);
    }

    public void addRoom(IRoom room) {
        ReservationService.getInstance().addIRoom(room);
    }

    public Collection<IRoom> getAllRooms() {
        return ReservationService.getInstance().getAllRooms();
    }

    public Collection<Customer> getAllCustomers(){
        return CustomerService.getInstance().getAllCustomers();
    }

    public void displayAllReservations() {
        ReservationService.getInstance().printAllReservations();
    }
}
