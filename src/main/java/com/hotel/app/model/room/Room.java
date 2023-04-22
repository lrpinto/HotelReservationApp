package com.hotel.app.model.room;

import java.util.Objects;

/**
 * Room.java
 *
 * A class which represents a room.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class Room implements IRoom {

    // The room number
    protected final String roomNumber;

    // The room type
    protected final RoomType roomType;

    // The room's price per night
    protected final Double price;

    /**
     * Create a Room instance with the given room number, room type, and price per night.
     *
     * @param roomNumber - the given room number
     * @param roomType - the given room type
     * @param price - the given price
     */
    public Room(String roomNumber, RoomType roomType, Double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
    }

    /**
     * (non-javadoc)
     * @see IRoom#getRoomNumber()
     */
    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * (non-javadoc)
     * @see IRoom#getRoomPrice()
     */
    @Override
    public Double getRoomPrice() {
        return price;
    }

    /**
     * (non-javadoc)
     * @see IRoom#getRoomType()
     */
    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    /**
     * (non-javadoc)
     * @see IRoom#isFree()
     */
    @Override
    public boolean isFree() {
        return price == 0d;
    }

    /**
     * (non-javadoc)
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(getRoomNumber(), room.getRoomNumber());
    }

    /**
     * (non-javadoc)
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(getRoomNumber());
    }

    /**
     * A String representing a Room instance.
     *
     * @return this Room instance represented as String.
     */
    @Override
    public String toString() {
        return "Room number: " + roomNumber +
                ", Room type: " + roomType +
                ", Room price: " + price;
    }
}
