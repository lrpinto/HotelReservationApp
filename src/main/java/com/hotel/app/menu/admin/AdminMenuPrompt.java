package com.hotel.app.menu.admin;

/**
 * AdminMenuPrompt.java
 * <p>
 * A class of constants used in user prompts by the AdminMenuPrompter.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class AdminMenuPrompt {
    /**
     * The message displayed to prompt a user whether they would like to add another room.
     */
    public static final String ADD_ANOTHER_ROOM_ANSWER_Y_OR_N = "Would you like to add another room - answer 'y' or 'n': ";
    /**
     * The message displayed to prompt a user to enter a room number.
     */
    public static final String ENTER_A_ROOM_NUMBER = "Please enter a room number, e.g. 1A: ";
    /**
     * The message displayed to prompt a user to enter a valid room number.
     */
    public static final String ENTER_A_VALID_ROOM_TYPE = "Please enter a valid room type - 1 for single room, or 2 for double room: ";
    /**
     * The message displayed to prompt a user to enter a price per night.
     */
    public static final String ENTER_PRICE_PER_NIGHT = "Enter price per night: ";
    /**
     * The message displayed to prompt a user to enter a room type.
     */
    public static final String ENTER_ROOM_TYPE = "Enter room type - 1 single, or 2 double: ";
    /**
     * The message displayed to prompt a user to enter a yes or no.
     */
    public static final String ENTER_Y_YES_OR_N_NO = "Please enter y (yes) or n (no): ";
    /**
     * The max value for a room type.
     */
    public static final int MAX_ROOM_TYPE = 2;
    /**
     * The minimum value for a room type.
     */
    public static final int MIN_ROOM_TYPE = 1;
    /**
     * The message displayed to prompt the user to enter a price equal or greater than zero.
     */
    public static final String PRICE_PER_NIGHT_MUST_BE_ZERO_OR_POSITIVE = "Please enter a price per night - must be zero or positive: ";

    /**
     * The message displayed to prompt the user to type an alphanumeric room number.
     */
    public static final String ROOM_NUMBER_MUST_BE_ALPHANUMERIC = "Please enter a room number - must be alphanumeric, e.g. 1A: ";
}
