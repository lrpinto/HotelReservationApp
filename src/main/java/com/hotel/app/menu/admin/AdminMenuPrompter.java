package com.hotel.app.menu.admin;

import com.hotel.app.menu.main.MainMenuPrompter;
import com.hotel.app.model.room.RoomType;

import static com.hotel.app.constant.Regex.*;
import static com.hotel.app.menu.admin.AdminMenuPrompt.*;

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
                .promptString(ADD_ANOTHER_ROOM_ANSWER_Y_OR_N, ENTER_Y_YES_OR_N_NO, YES_OR_NO_REGEX);
    }

    /**
     * Prompt a user whether for the price of a room.
     *
     * @return a double representing a zero or positive price.
     */
    public double promptPrice() {
        return mainMenuPrompter()
                .prompter()
                .promptDouble(ENTER_PRICE_PER_NIGHT, PRICE_PER_NIGHT_MUST_BE_ZERO_OR_POSITIVE, 0d);
    }

    /**
     * Prompt a user for the number for a room.
     *
     * @return a String representing an alphanumeric room number.
     */
    public String promptRoomNumber() {
        return mainMenuPrompter()
                .prompter()
                .promptString(ENTER_A_ROOM_NUMBER, ROOM_NUMBER_MUST_BE_NUMBER, NUMBER_REGEX);
    }

    /**
     * Prompt a user whether for the type of room.
     *
     * @return a RoomType representing a room type.
     */
    public RoomType promptRoomType() {
        int roomType = mainMenuPrompter()
                .prompter()
                .promptInt(ENTER_ROOM_TYPE, ENTER_A_VALID_ROOM_TYPE, MIN_ROOM_TYPE, MAX_ROOM_TYPE);

        return roomType == MIN_ROOM_TYPE ?  RoomType.SINGLE : RoomType.DOUBLE;
    }
}
