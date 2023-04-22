package com.hotel.app;

import com.hotel.app.menu.IMenu;
import com.hotel.app.menu.prompter.Prompter;
import com.hotel.app.menu.main.MainMenu;
import com.hotel.app.menu.main.MainMenuPrompter;

import java.util.Scanner;

/**
 * HotelApplication.java
 * <p>
 * A class which is the entry point for this application.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class HotelApplication {

    /**
     * Entry point method that starts this application.
     *
     * @param args - the arguments for this application to run with
     */
    public static void main(String[] args) {

        System.out.println("Welcome to the Hotel Reservation Application");

        Scanner scanner = new Scanner(System.in);
        Prompter prompter = new Prompter(scanner);
        MainMenuPrompter mainMenuPrompter = new MainMenuPrompter(prompter);
        IMenu mainMenu = new MainMenu(mainMenuPrompter);
        mainMenu.displayMenu();
        scanner.close();

    }
}
