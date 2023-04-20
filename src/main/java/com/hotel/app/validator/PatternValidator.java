package com.hotel.app.validator;

import java.util.regex.Pattern;

public class PatternValidator {

    private final Pattern pattern;

    public PatternValidator(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public boolean validate(String input) {
        return input != null && this.pattern.matcher(input.toLowerCase()).matches();
    }
}
