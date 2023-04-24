package com.hotel.app.constant;

/**
 * Regex.java
 *
 * A class representing Regex patterns used by this application.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class Regex {

    /**
     * A regex that matches alphanumeric Strings.
     */
    public static final String ALPHANUMERIC_STRING_REGEX = "^[a-zA-Z0-9]*$";

    /**
     * A regex that matches alphanumeric Strings.
     */
    public static final String AT_LEAST_ONE_NON_EMPTY_CHAR_REGEX = "^(?=\\s*\\S).*$";

    /**
     * A regex that matches a date String in format 'yyyy-mm-dd'.
     */
    public static final String DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";

    /**
     * A regex that matches an email String - this is simplified version, not the full RFC compliance match.
     */
    public static final String EMAIL_REGEX = "^(.+)@(\\S+)$";

    /**
     * A regex that matches 'yes', 'no', 'y' e 'n' Strings.
     */
    public static final String YES_OR_NO_REGEX = "^(yes|y|no|n)$";

    public static String NUMBER_REGEX = "^[0-9]*$";
}
