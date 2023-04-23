package com.hotel.app.menu.admin;

import com.hotel.app.api.AdminResource;
import com.hotel.app.menu.AbstractMenu;
import com.hotel.app.menu.IMenu;
import com.hotel.app.menu.exception.InvalidMenuOptionException;
import com.hotel.app.menu.main.MainMenu;
import com.hotel.app.model.Customer;
import com.hotel.app.model.room.IRoom;
import com.hotel.app.model.room.RoomFactory;
import com.hotel.app.model.room.RoomType;

import java.util.Collection;

/**
 * AdminMenu.java
 *
 * A class that provides administrative functionality to interact with a user via the console.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class AdminMenu extends AbstractMenu {

    private final AdminMenuPrompter adminMenuPrompter;
    private final MainMenu mainMenu;

    /**
     * Construct a new instance of AdminMenu with the given admin prompter and the given main menu.
     *
     * @param adminMenuPrompter - the admin given prompter
     * @param mainMenu - the given main menu
     */
    public AdminMenu(AdminMenuPrompter adminMenuPrompter, MainMenu mainMenu) {
        super(adminMenuPrompter.mainMenuPrompter().prompter());
        this.mainMenu = mainMenu;
        this.adminMenuPrompter = adminMenuPrompter;
    }

    /**
     * @see IMenu#execute(int)
     */
    @Override
    public boolean execute(int selectedOption) throws InvalidMenuOptionException {
        switch (selectedOption) {
            case 1 -> // See all customers
                    seeAllCustomers();
            case 2 ->  // See all rooms
                    seeAllRooms();
            case 3 -> // See all reservations
                    seeAllReservations();
            case 4 -> // Add a room
                    addARoom();
            case 5 -> // Back to Main Menu
                    backToMainMenu();
            default -> throw new InvalidMenuOptionException("Please enter an option number between 1 and 5");
        }
        return true;
    }

    /**
     * @see IMenu#initMenu()
     */
    @Override
    public String initMenu() {
        return """

                =====================================
                |           Admin Menu              |
                =====================================
                | Options:                          |
                | 1. See all customers              |
                | 2. See all rooms                  |
                | 3. See all reservations           |
                | 4. Add a room                     |
                | 5. Back to Main Menu              |
                =====================================
                Please type a number for the menu option:\s""";
    }

    /**
     * @see IMenu#isValidOption(int)
     */
    @Override
    public boolean isValidOption(int option) {
        return option > 0 && option < 6;
    }

    // Auxiliary method to handle adding a room.
    private void addARoom() {

        String addARoom = """

                =====================================
                | Option 4: Add a Room              |
                =====================================""";

        System.out.println(addARoom);

        String roomNumber = adminMenuPrompter.promptRoomNumber();
        double price = adminMenuPrompter.promptPrice();
        RoomType roomType = adminMenuPrompter.promptRoomType();

        try {
            IRoom room = RoomFactory.create(roomNumber, roomType, price);
            AdminResource.getInstance().addRoom(room);
        } catch (IllegalArgumentException ex) {
            System.out.println("Unable to add room. Reason: " + ex.getLocalizedMessage() + ".");
        }

        String answer = adminMenuPrompter.promptAddAnotherRoom();
        switch (answer) {
            case "YES", "Y", "y", "yes" -> addARoom();
            default -> {
                adminMenuPrompter.mainMenuPrompter().prompter().promptEnterKey();
                displayMenu();
            }
        }
    }

    // Auxiliary method to handle going back to the main menu.
    private void backToMainMenu() {
        mainMenu.displayMenu();
    }

    // Auxiliary method to handle displaying all customers.
    private void seeAllCustomers() {

        String seeAllCustomers = """

                =====================================
                | Option 1: See All Customers       |
                =====================================""";

        System.out.println(seeAllCustomers);

        Collection<Customer> customers = AdminResource.getInstance().getAllCustomers();
        if (customers == null || customers.isEmpty()) {
            System.out.println("There are no customers yet.");
        } else {
            customers.forEach(System.out::println);
        }

        adminMenuPrompter.mainMenuPrompter().prompter().promptEnterKey();

        displayMenu();
    }

    // Auxiliary method to handle displaying all reservations.
    private void seeAllReservations() {

        String seeAllReservations = """

                =====================================
                | Option 3: See All Reservations    |
                =====================================""";

        System.out.println(seeAllReservations);

        AdminResource.getInstance().displayAllReservations();

        adminMenuPrompter.mainMenuPrompter().prompter().promptEnterKey();

        displayMenu();
    }

    // Auxiliary method to handle displaying all rooms.
    private void seeAllRooms() {

        String seeAllRooms = """

                =====================================
                | Option 2: See All Rooms           |
                =====================================""";

        System.out.println(seeAllRooms);

        Collection<IRoom> rooms = AdminResource.getInstance().getAllRooms();
        if (rooms == null || rooms.isEmpty()) {
            System.out.println("There are no rooms yet.");
        } else {
            rooms.forEach(System.out::println);
        }

        adminMenuPrompter.mainMenuPrompter().prompter().promptEnterKey();

        displayMenu();
    }
}
