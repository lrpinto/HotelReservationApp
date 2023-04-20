package com.hotel.app.model.room;

public class FreeRoom extends Room {

    public FreeRoom(String roomNumber, RoomType roomType) {
        super(roomNumber, roomType, 0d);
    }

    @Override
    public String toString() {
        return "Room number: " + roomNumber +
                ", Room type: " + roomType +
                ", Room price: FREE!";
    }
}
