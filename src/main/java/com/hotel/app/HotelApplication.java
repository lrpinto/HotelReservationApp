package com.hotel.app;

import com.hotel.app.menu.IMenu;
import com.hotel.app.menu.prompter.Prompter;
import com.hotel.app.menu.main.MainMenu;
import com.hotel.app.menu.main.MainMenuPrompter;

import java.util.Scanner;

public class HotelApplication {

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
