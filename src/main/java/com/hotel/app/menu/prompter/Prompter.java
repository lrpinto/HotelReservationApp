package com.hotel.app.menu.prompter;

import com.hotel.app.validator.PatternValidator;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Prompter.java
 *
 * An implementation of a IPrompter, which uses a scanner,
 * and provides general prompting operations commonly used within this application.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public record Prompter(Scanner scanner) implements IPrompter {

    /**
     * The message shown to the user when requesting them to press the 'enter' key.
     */
    public static final String PRESS_ENTER_TO_CONTINUE_PROMPT = "\nPlease press 'ENTER' to continue.";

    /**
     * (non-javadoc)
     * @see IPrompter#promptDouble(java.lang.String, java.lang.String, double)
     */
    @Override
    public double promptDouble(String primaryPrompt, String secondaryPrompt, double minValue) {
        Double aDouble = null;
        System.out.println(primaryPrompt);
        do {
            try {
                if (scanner().hasNext()) {
                    String input = scanner().next();
                    aDouble = Double.parseDouble(input);
                    if (aDouble < minValue) {
                        System.out.println(secondaryPrompt);
                        aDouble = null;
                    }
                }
            } catch (Exception ex) {
                System.out.println(secondaryPrompt);
                aDouble = null;
            }
        } while (aDouble == null);
        return aDouble;
    }

    /**
     * (non-javadoc)
     * @see IPrompter#promptInt(String, String, int, int)
     */
    @Override
    public int promptInt(String primaryPrompt, String secondaryPrompt, int min, int max) {
        Integer aInt = null;
        System.out.println(primaryPrompt);
        do {
            try {
                if (scanner().hasNext()) {
                    String input = scanner().next();
                    aInt = Integer.parseInt(input);
                    if (aInt < min || aInt > max) {
                        System.out.println(secondaryPrompt);
                    }
                }
            } catch (Exception ex) {
                System.out.println(secondaryPrompt);
                aInt = null;
            }
        } while (aInt == null);
        return aInt;
    }

    /**
     * (non-javadoc)
     * @see IPrompter#promptString(String, String, String)
     */
    @Override
    @NotNull
    public String promptString(String primaryPrompt, String secondaryPrompt, String regex) {
        String input = null;
        PatternValidator patternValidator = new PatternValidator(regex);
        System.out.print(primaryPrompt);
        do {
            try {
                if (scanner().hasNext()) {
                    input = scanner().next();
                    boolean isValidInput = patternValidator.validate(input);
                    if (!isValidInput) {
                        System.out.print(secondaryPrompt);
                        input = null;
                    }
                }
            } catch (Exception ex) {
                System.out.print(secondaryPrompt);
                input = null;
            }
        } while (input == null);
        return input;
    }

    /**
     * (non-javadoc)
     * @see IPrompter#promptDate(String, String, String)
     */
    @Override
    @NotNull
    public LocalDate promptDate(String primaryPrompt, String secondaryPrompt, String regex) {
        LocalDate date = null;
        PatternValidator patternValidator = new PatternValidator(regex);
        System.out.print(primaryPrompt);
        do {
            try {
                if (scanner().hasNext()) {
                    String input = scanner().next();
                    boolean isValidInput = patternValidator.validate(input);
                    if (!isValidInput) {
                        System.out.print(secondaryPrompt);
                    } else {
                        date = LocalDate.parse(input);
                    }
                }
            } catch (Exception ex) {
                System.out.print(secondaryPrompt);
            }
        } while (date == null);
        return date;
    }

    /**
     * (non-javadoc)
     * @see IPrompter#promptEnterKey()
     */
    @Override
    public void promptEnterKey(){
        scanner().nextLine();
        System.out.print(PRESS_ENTER_TO_CONTINUE_PROMPT);
        scanner().nextLine();
    }
}
