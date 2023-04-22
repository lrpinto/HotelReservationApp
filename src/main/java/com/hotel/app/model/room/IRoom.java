package com.hotel.app.model.room;

/**
 * IRoom.java
 *
 * A class that represents a IRoom instance.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public interface IRoom {

    /**
     * Get the room number.
     *
     * @return a String representing the room number.
     */
    String getRoomNumber();

    /**
     * Get the room price.
     *
     * @return a Double value representing the room price.
     */
    Double getRoomPrice();

    /**
     * Get the room price.
     *
     * @return a RoomType enum representing the room type.
     */
    RoomType getRoomType();

    /**
     * Return whether this is a FreeRoom.
     *
     * @return true if the room is free, false otherwise..
     */
    boolean isFree();
}
