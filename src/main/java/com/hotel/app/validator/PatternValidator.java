package com.hotel.app.validator;

import java.util.regex.Pattern;

/**
 * PatternValidator.java
 * <p>
 * A class which provides validation based on a compiled regex.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class PatternValidator {

    // The regex pattern for this validator
    private final Pattern pattern;

    /**
     * Create a new validator with the given regex.
     *
     * @param regex - the given regex
     */
    public PatternValidator(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    /**
     * Validate an input against the given regex (case-insensitive).
     *
     * @param input - the given input to validate
     * @return true if the given input matches the regex, false otherwise.
     */
    public boolean validate(String input) {
        return input != null && this.pattern.matcher(input.toLowerCase()).matches();
    }
}
