package com.hotel.app.menu;

import com.hotel.app.menu.exception.InvalidMenuOptionException;
import com.hotel.app.menu.prompter.IPrompter;

public abstract class AbstractMenu implements IMenu {

    protected final IPrompter prompter;
    protected final String menu;

    public AbstractMenu(IPrompter prompter) {
        menu = initMenu();
        this.prompter = prompter;
    }

    public void displayMenu() {
        // Display the admin menu options
        int selectedOption = 0;
        System.out.print(menu);
        do {
            try {
                selectedOption = prompter.scanner().nextInt();
            }   catch (Exception exception) {
                System.out.print("Please enter a valid option number: ");
            }
        } while(!isValidOption(selectedOption));

        boolean executed = false;
        do {
            try {
                executed = execute(selectedOption);
            } catch (InvalidMenuOptionException | IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            } catch (Exception exception) {
                System.out.println(exception.getLocalizedMessage());
            }
        } while(!executed);
    }

    public abstract boolean execute(int selectedOption) throws InvalidMenuOptionException;

    public abstract String initMenu();

    public abstract boolean isValidOption(int option);

}
