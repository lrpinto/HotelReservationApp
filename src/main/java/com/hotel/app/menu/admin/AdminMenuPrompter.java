package com.hotel.app.menu.admin;

import com.hotel.app.menu.main.MainMenuPrompter;
import com.hotel.app.model.room.RoomType;

import static com.hotel.app.constant.Regex.*;

public record AdminMenuPrompter(MainMenuPrompter mainMenuPrompter) {

    public String promptAddAnotherRoom() {
        return mainMenuPrompter()
                .prompter()
                .promptString("Would you like to add another room - answer 'y' or 'n': ",
                        "Please enter y (yes) or n (no): ",
                        YES_OR_NO_REGEX);
    }

    public double promptPrice() {
        return mainMenuPrompter()
                .prompter()
                .promptDouble("Enter price per night: ",
                        "Please enter a price per night - must be zero or positive: ",
                        0d);
    }

    public String promptRoomNumber() {
        return mainMenuPrompter()
                .prompter()
                .promptString("Please enter a room number - must be alphanumeric, e.g. 1A: ",
                        "Please enter a room number - must be alphanumeric, e.g. 1A: ",
                        ALPHANUMERIC_STRING_REGEX);
    }

    public RoomType promptRoomType() {
        int roomType = mainMenuPrompter()
                .prompter()
                .promptInt("Enter room type - 1 single, or 2 double: ",
                        "Please enter a valid room type - 1 for single room, or 2 for double room: ",
                        1, 2);

        return roomType == 1 ?  RoomType.SINGLE : RoomType.DOUBLE;
    }
}
