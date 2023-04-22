package com.hotel.app.menu.prompter;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * IPrompter.java
 *
 * An interface that declares the contract for a prompter.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public interface IPrompter {

    /**
     * Prompt the user for a date matching the given regex.
     *
     * @param primaryPrompt - the initial prompt to display
     * @param secondaryPrompt - the prompt to display in case of an invalid input
     * @param regex - the regex to match the date against
     * @return a LocalDate matching the given regex.
     */
    @NotNull LocalDate promptDate(String primaryPrompt, String secondaryPrompt, String regex);

    /**
     * Prompt the user for a double greater than the given minimum value.
     *
     * @param primaryPrompt - the initial prompt to display
     * @param secondaryPrompt - the prompt to display in case of an invalid input
     * @param minValue - the given minimum value
     * @return a Double value matching the given regex.
     */
    double promptDouble(String primaryPrompt, String secondaryPrompt, double minValue);

    /**
     * Prompt the user for the enter key.
     */
    void promptEnterKey();

    /**
     * Prompt the user for an integer value between the given minimum and maximum values.
     *
     * @param primaryPrompt - the initial prompt to display
     * @param secondaryPrompt - the prompt to display in case of an invalid input
     * @param min - the given minimum value
     * @param max - the given maximum value
     * @return an Integer value between the minimum and maximum value.
     */
    int promptInt(String primaryPrompt, String secondaryPrompt, int min, int max);

    /**
     * Prompt the user for a String matching the given regex.
     *
     * @param primaryPrompt - the initial prompt to display
     * @param secondaryPrompt - the prompt to display in case of an invalid input
     * @param regex - the given regex to match the string against.
     * @return a String matching the given regex.
     */
    @NotNull String promptString(String primaryPrompt, String secondaryPrompt, String regex);

    /**
     * Return the scanner used by this prompter to interact with the user.
     *
     * @return a Scanner object.
     */
    @NotNull Scanner scanner();
}
