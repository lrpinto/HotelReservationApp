package com.hotel.app.model.room;

/**
 * RoomFactory.java
 *
 * A class that knows which type of rooms should be created for the specified parameters.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class RoomFactory {

    /**
     * Create a room with the given room number, room type, and price.
     * The actual type of room created is determined by the input parameters.
     *
     * @param roomNumber the given room number.
     * @param roomType the given room type.
     * @param price the given price per night.
     * @return an instance of IRoom which represents a room as specified.
     */
    public static IRoom create(String roomNumber, RoomType roomType, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        } else if (price == 0d) {
            return new FreeRoom(roomNumber, roomType);
        } else {
            return new Room(roomNumber, roomType, price);
        }
    }
}
