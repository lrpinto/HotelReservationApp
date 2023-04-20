package com.hotel.app.model.room;

public class RoomFactory {

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
