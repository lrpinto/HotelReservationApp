package com.hotel.app.menu.main;

import com.hotel.app.menu.prompter.Prompter;

import java.time.LocalDate;

import static com.hotel.app.constant.Regex.*;
import static com.hotel.app.menu.main.MainMenuPrompt.*;

/**
 * MainMenuPrompter.java
 *
 * This record is solely responsible for displaying main menu prompts to the user,
 * and collecting the respective user inputs.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public record MainMenuPrompter(Prompter prompter) {

    /**
     * Prompt a user for the check-in date.
     *
     * @return a String represents the check-in date in format 'yyyy-mm-dd'.
     */
    public LocalDate promptCheckInDate() {
        return prompter().promptDate(TYPE_THE_CHECK_IN_DATE, TYPE_A_VALID_DATE_USING_THE_FORMAT_YYYY_MM_DD, DATE_REGEX);
    }

    /**
     * Prompt a user for the check-out date.
     *
     * @return a String represents the check-out date in format 'yyyy-mm-dd'.
     */
    public LocalDate promptCheckOutDate() {
        return prompter().promptDate(TYPE_THE_CHECK_OUT_DATE,
                MainMenuPrompt.TYPE_A_VALID_DATE_USING_THE_FORMAT_YYYY_MM_DD, DATE_REGEX);
    }

    /**
     * Prompt whether they want to create another customer.
     *
     * @return a String which can be y (yes) or n (no).
     */
    public String promptCreateAnotherCustomer() {
        return prompter().promptString(WOULD_YOU_LIKE_TO_ADD_ANOTHER_CUSTOMER, ENTER_Y_YES_OR_N_NO, YES_OR_NO_REGEX);
    }

    /**
     * Prompt the user for their email.
     *
     * @return a String representing a valid email.
     */
    public String promptEmail() {
        return prompter().promptString(TYPE_YOUR_EMAIL_AND_PRESS_ENTER, ENTER_A_VALID_EMAIL_ADDRESS, EMAIL_REGEX);
    }

    /**
     * Prompt the user for their first name.
     *
     * @return a String representing the first name.
     */
    public String promptFirstName() {
        return prompter().promptString(TYPE_YOUR_FIRST_NAME_AND_PRESS_ENTER, ENTER_A_VALID_FIRST_NAME, AT_LEAST_ONE_NON_EMPTY_CHAR_REGEX);
    }

    /**
     * Prompt the user for their last name.
     *
     * @return a String representing the last name.
     */
    public String promptLastName() {
        return prompter().promptString(TYPE_YOUR_LAST_NAME_AND_PRESS_ENTER, ENTER_A_VALID_LAST_NAME, AT_LEAST_ONE_NON_EMPTY_CHAR_REGEX);
    }

    /**
     * Prompt the user whether they want to reserve the room.
     *
     * @return a String which can be y (yes) or n (no).
     */
    public String promptReserveRoom() {
        return prompter().promptString(WOULD_YOU_LIKE_TO_RESERVE_A_ROOM, ENTER_Y_YES_OR_N_NO, YES_OR_NO_REGEX);
    }

    /**
     * Prompt a user to type the room number.
     *
     * @return a String representing an alphanumeric room number.
     */
    public String promptRoomNumber() {
        return prompter().promptString(TYPE_THE_ROOM_NUMBER_AND_PRESS_ENTER, TYPE_A_VALID_ROOM_NUMBER, AT_LEAST_ONE_NON_EMPTY_CHAR_REGEX);
    }

}
