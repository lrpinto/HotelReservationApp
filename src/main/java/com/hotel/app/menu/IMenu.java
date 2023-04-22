package com.hotel.app.menu;

import com.hotel.app.menu.exception.InvalidMenuOptionException;

/**
 * IMenu.java
 *
 * An interface that declares the contract for a menu.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public interface IMenu {

    /**
     * Display the menu.
     */
    void displayMenu();

    /**
     * Initialise the menu.
     *
     * @return a String representing the Menu after it has been initialised.
     */
    String initMenu();

    /**
     * Execute the specified option selected by the user.
     *
     * @param selectedOption - the specified option
     * @return true if the option was executed, false otherwise.
     * @throws InvalidMenuOptionException if the specified selectedOption is invalid.
     */
    default boolean execute(int selectedOption) throws InvalidMenuOptionException {
        return false;
    }

    /**
     * Determine whether the specified option is valid for this menu.
     *
     * @param option - the specified option
     * @return true if the option is valid, false otherwise.
     */
    boolean isValidOption(int option);
}
