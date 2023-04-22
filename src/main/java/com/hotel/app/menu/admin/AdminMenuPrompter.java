package com.hotel.app.menu.admin;

import com.hotel.app.menu.main.MainMenuPrompter;
import com.hotel.app.model.room.RoomType;

import static com.hotel.app.constant.Regex.*;

/**
 * AdminMenuPrompter.java
 *
 * This record is solely responsible for displaying administrative prompts to the user,
 * and collecting the respective user inputs.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public record AdminMenuPrompter(MainMenuPrompter mainMenuPrompter) {

    /**
     * Prompt a user whether they want to add another room.
     *
     * @return a String which can be y (yes) or n (no).
     */
    public String promptAddAnotherRoom() {
        return mainMenuPrompter()
                .prompter()
                .promptString("Would you like to add another room - answer 'y' or 'n': ",
                        "Please enter y (yes) or n (no): ",
                        YES_OR_NO_REGEX);
    }

    /**
     * Prompt a user whether for the price of a room.
     *
     * @return a double representing a zero or positive price.
     */
    public double promptPrice() {
        return mainMenuPrompter()
                .prompter()
                .promptDouble("Enter price per night: ",
                        "Please enter a price per night - must be zero or positive: ",
                        0d);
    }

    /**
     * Prompt a user whether for the number for a room.
     *
     * @return a String representing an alphanumeric room number.
     */
    public String promptRoomNumber() {
        return mainMenuPrompter()
                .prompter()
                .promptString("Please enter a room number - must be alphanumeric, e.g. 1A: ",
                        "Please enter a room number - must be alphanumeric, e.g. 1A: ",
                        ALPHANUMERIC_STRING_REGEX);
    }

    /**
     * Prompt a user whether for the type of room.
     *
     * @return a RoomType representing a room type.
     */
    public RoomType promptRoomType() {
        int roomType = mainMenuPrompter()
                .prompter()
                .promptInt("Enter room type - 1 single, or 2 double: ",
                        "Please enter a valid room type - 1 for single room, or 2 for double room: ",
                        1, 2);

        return roomType == 1 ?  RoomType.SINGLE : RoomType.DOUBLE;
    }
}
