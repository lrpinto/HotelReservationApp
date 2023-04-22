package com.hotel.app.menu.exception;

/**
 * InvalidMenuOptionException.java
 *
 * An exception to be thrown when a Menu Option selected by the user is not valid for the provided Menu.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class InvalidMenuOptionException extends Exception {

    /**
     * Constructor to create a InvalidMenuOptionException instance with the given message.
     *
     * @param message - the given message
     */
    public InvalidMenuOptionException(String message) {
        super(message);
    }
}
