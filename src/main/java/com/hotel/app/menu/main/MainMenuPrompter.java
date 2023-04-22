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
        return prompter().promptDate(CHECK_IN_DATE_PRIMARY_PROMPT, CHECK_IN_DATE_SECONDARY_PROMPT, DATE_REGEX);
    }

    /**
     * Prompt a user for the check-out date.
     *
     * @return a String represents the check-out date in format 'yyyy-mm-dd'.
     */
    public LocalDate promptCheckOutDate() {
        return prompter().promptDate(CHECK_OUT_DATE_PRIMARY_PROMPT, CHECK_OUT_DATE_SECONDARY_PROMPT, DATE_REGEX);
    }

    /**
     * Prompt whether they want to create another customer.
     *
     * @return a String which can be y (yes) or n (no).
     */
    public String promptCreateAnotherCustomer() {
        return prompter().promptString(CREATE_ANOTHER_CUSTOMER_PRIMARY_PROMPT, YES_OR_NO_SECONDARY_PROMPT, YES_OR_NO_REGEX);
    }

    /**
     * Prompt the user for their email.
     *
     * @return a String representing a valid email.
     */
    public String promptEmail() {
        return prompter().promptString(EMAIL_PRIMARY_PROMPT, EMAIL_SECONDARY_PROMPT, EMAIL_REGEX);
    }

    /**
     * Prompt the user for their first name.
     *
     * @return a String representing the first name.
     */
    public String promptFirstName() {
        return prompter().promptString(FIRST_NAME_PRIMARY_PROMPT, FIRST_NAME_SECONDARY_PROMPT, AT_LEAST_ONE_NON_EMPTY_CHAR_REGEX);
    }

    /**
     * Prompt the user for their last name.
     *
     * @return a String representing the last name.
     */
    public String promptLastName() {
        return prompter().promptString(LAST_NAME_PRIMARY_PROMPT, LAST_NAME_SECONDARY_PROMPT, AT_LEAST_ONE_NON_EMPTY_CHAR_REGEX);
    }

    /**
     * Prompt the user whether they want to reserve the room.
     *
     * @return a String which can be y (yes) or n (no).
     */
    public String promptReserveRoom() {
        return prompter().promptString(RESERVE_ROOM_PRIMARY_PROMPT, YES_OR_NO_SECONDARY_PROMPT, YES_OR_NO_REGEX);
    }

    /**
     * Prompt a user to type the room number.
     *
     * @return a String representing an alphanumeric room number.
     */
    public String promptRoomNumber() {
        return prompter().promptString(ROOM_NUMBER_PRIMARY_PROMPT, ROOM_NUMBER_SECONDARY_PROMPT, AT_LEAST_ONE_NON_EMPTY_CHAR_REGEX);
    }

}
