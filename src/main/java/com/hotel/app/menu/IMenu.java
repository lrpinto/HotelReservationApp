package com.hotel.app.menu;

import com.hotel.app.menu.exception.InvalidMenuOptionException;

public interface IMenu {

    void displayMenu();

    String initMenu();

    default boolean execute(int selectedOption) throws InvalidMenuOptionException {
        return false;
    }

    boolean isValidOption(int option);
}
