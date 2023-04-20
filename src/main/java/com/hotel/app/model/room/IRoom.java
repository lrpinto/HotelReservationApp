package com.hotel.app.model.room;

public interface IRoom {

    String getRoomNumber();

    Double getRoomPrice(double roomPrice);

    RoomType getRoomType();

    boolean isFree();
}
