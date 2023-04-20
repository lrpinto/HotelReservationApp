package com.hotel.app.menu.prompter;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Scanner;

public interface IPrompter {
    @NotNull LocalDate promptDate(String primaryPrompt, String secondaryPrompt, String regex);

    double promptDouble(String primaryPrompt, String secondaryPrompt, double minValue);

    int promptInt(String primaryPrompt, String secondaryPrompt, int min, int max);

    @NotNull String promptString(String primaryPrompt, String secondaryPrompt, String regex);

    @NotNull Scanner scanner();
}
