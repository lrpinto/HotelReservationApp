package com.hotel.app.model.room;

/**
 * FreeRoom.java
 *
 * A class that represents a free room.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class FreeRoom extends Room {

    /**
     * Constructor to create a FreeRoom instance with the given room number and the given room type.
     * @param roomNumber - the specified room number
     * @param roomType - the specified room type
     */
    public FreeRoom(String roomNumber, RoomType roomType) {
        super(roomNumber, roomType, 0d);
    }

    /**
     * Return the String representing of this FreeRoom instance.
     * @return the FreeRoom represented as a String.
     */
    @Override
    public String toString() {
        return "Room number: " + roomNumber +
                ", Room type: " + roomType +
                ", Room price: FREE!";
    }
}
