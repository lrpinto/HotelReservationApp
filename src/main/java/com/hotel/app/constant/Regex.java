package com.hotel.app.constant;

public class Regex {
    public static final String ALPHANUMERIC_STRING_REGEX = "^[a-zA-Z0-9]*$";
    public static final String AT_LEAST_ONE_NON_EMPTY_CHAR_REGEX = "^(?=\\s*\\S).*$";
    public static final String DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";
    public static final String EMAIL_REGEX = "^(.+)@(\\S+)$";
    public static final String YES_OR_NO_REGEX = "^(yes|y|no|n)$";
}
