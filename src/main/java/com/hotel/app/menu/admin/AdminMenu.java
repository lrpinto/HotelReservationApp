package com.hotel.app.menu.admin;

import com.hotel.app.api.AdminResource;
import com.hotel.app.menu.AbstractMenu;
import com.hotel.app.menu.exception.InvalidMenuOptionException;
import com.hotel.app.menu.main.MainMenu;
import com.hotel.app.model.Customer;
import com.hotel.app.model.room.IRoom;
import com.hotel.app.model.room.RoomFactory;
import com.hotel.app.model.room.RoomType;

import java.util.Collection;

/**
 * An admin main.java.main.java.menu for administrative functions
 */
public class AdminMenu extends AbstractMenu {

    private final AdminMenuPrompter adminMenuPrompter;
    private final MainMenu mainMenu;

    public AdminMenu(AdminMenuPrompter adminMenuPrompter, MainMenu mainMenu) {
        super(adminMenuPrompter.mainMenuPrompter().prompter());
        this.mainMenu = mainMenu;
        this.adminMenuPrompter = adminMenuPrompter;
    }

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

    @Override
    public boolean isValidOption(int option) {
        return option > 0 && option < 6;
    }

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
        } catch (Exception ex) {
            System.out.println(
                    "Oops! Something did no go to plan. Room was not added. Reason: " + ex.getLocalizedMessage());
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

    private void backToMainMenu() {
        mainMenu.displayMenu();
    }

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
            System.out.println(customers);
        }

        adminMenuPrompter.mainMenuPrompter().prompter().promptEnterKey();

        displayMenu();
    }

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
            System.out.println(rooms);
        }

        adminMenuPrompter.mainMenuPrompter().prompter().promptEnterKey();

        displayMenu();
    }
}
