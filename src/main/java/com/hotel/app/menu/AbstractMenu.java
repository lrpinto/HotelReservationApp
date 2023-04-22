package com.hotel.app.menu;

import com.hotel.app.menu.exception.InvalidMenuOptionException;
import com.hotel.app.menu.prompter.IPrompter;

/**
 * AbstractMenu.java
 *
 * An abstract implementation of a IMenu providing common IMenu functionality.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public abstract class AbstractMenu implements IMenu {

    protected final IPrompter prompter;
    protected final String menu;

    /**
     * Create an instance of this AbstractMenu with the given IPrompter prompter instance.
     *
     * @param prompter the given IPrompter instance.
     */
    public AbstractMenu(IPrompter prompter) {
        menu = initMenu();
        this.prompter = prompter;
    }

    /**
     * Display this menu on the console, whilst prompting for a valid option.
     * Keeps asking for an option until the inserted option is valid.
     * Then will call this instance's execute(int option) with the option inserted by the user.
     *
     * @see IMenu#displayMenu()
     */
    @Override
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

    /**
     * (non-javadoc)
     * @see IMenu#execute(int)
     */
    public abstract boolean execute(int selectedOption) throws InvalidMenuOptionException;

    /**
     * (non-javadoc)
     * @see IMenu#initMenu() (int)
     */
    public abstract String initMenu();

    /**
     * (non-javadoc)
     * @see IMenu#isValidOption(int) (int)
     */
    public abstract boolean isValidOption(int option);

}
