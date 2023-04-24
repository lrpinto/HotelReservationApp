package com.hotel.app.menu.main;

import com.hotel.app.api.HotelResource;
import com.hotel.app.menu.AbstractMenu;
import com.hotel.app.menu.IMenu;
import com.hotel.app.menu.admin.AdminMenu;
import com.hotel.app.menu.admin.AdminMenuPrompter;
import com.hotel.app.menu.exception.InvalidMenuOptionException;
import com.hotel.app.model.Customer;
import com.hotel.app.model.Reservation;
import com.hotel.app.model.room.IRoom;
import com.hotel.app.validator.PatternValidator;

import java.time.LocalDate;
import java.util.Collection;

/**
 * MainMenu.java
 *
 * A class that provides main functionality to interact with a user via the console.
 *
 * @author Luisa Pinto | luisa.rebelopinto@gmail.com
 */
public class MainMenu extends AbstractMenu {

    public static final int DAYS_TO_ADD = 7;
    private final MainMenuPrompter mainMenuPrompter;

    /**
     * Construct a new instance of MainMenu with the given main menu prompter.
     *
     * @param mainMenuPrompter - the main given prompter
     */
    public MainMenu(MainMenuPrompter mainMenuPrompter) {
        super(mainMenuPrompter.prompter());
        this.mainMenuPrompter = mainMenuPrompter;
    }

    /**
     * @see IMenu#execute(int)
     */
    @Override
    public boolean execute(int selectedOption) throws InvalidMenuOptionException {
        switch (selectedOption) {
            case 1 -> // Find and reserve a room
                    findAndReserveARoom();
            case 2 ->  // See my reservations
                    seeMyReservations();
            case 3 -> // Create an account
                    createAnAccount();
            case 4 -> // Admin
                    displayAdmin();
            case 5 -> // Exit
                    exit();
            default -> throw new InvalidMenuOptionException("Please enter an option number between 1 and 5.");
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
                |           Main  Menu              |
                =====================================
                | Options:                          |
                | 1. Find and reserve a room        |
                | 2. See my reservations            |
                | 3. Create an account              |
                | 4. Admin                          |
                | 5. Exit                           |
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

    // Auxiliary method to handle the execution of Option 1 - Find and reserve a room (this method handles finding a room)
    private void findAndReserveARoom() {

        String findAndReserveARoom = """

                =====================================
                | Option 1: Find and Reserve a Room  |
                =====================================""";

        System.out.println(findAndReserveARoom);

        LocalDate checkInDate = mainMenuPrompter.promptCheckInDate();
        LocalDate checkOutDate = mainMenuPrompter.promptCheckOutDate();

        if (checkInDate.equals(checkOutDate) || checkInDate.isAfter(checkOutDate)) {
            throw new IllegalArgumentException("Check-in date must be before check-out date.");
        }

        LocalDate now = LocalDate.now();
        if (checkInDate.isBefore(now) || checkOutDate.isBefore(now)) {
            throw new IllegalArgumentException("Check-in date and check-out dates must be in the future.");
        }

        Collection<IRoom> availableRooms = HotelResource.getInstance().findARoom(checkInDate, checkOutDate);

        if (availableRooms == null || availableRooms.isEmpty()) {
            System.out.println("No rooms available for the date range provided.");

            LocalDate recommendedCheckIn = checkInDate.plusDays(DAYS_TO_ADD);
            LocalDate recommendedCheckOut = checkOutDate.plusDays(DAYS_TO_ADD);

            availableRooms = HotelResource.getInstance().findARoom(recommendedCheckIn, recommendedCheckOut);

            if (availableRooms != null && !availableRooms.isEmpty()) {
                System.out.printf("\nShowing recommended rooms for %d days later - from '%s' to '%s':\n",
                        DAYS_TO_ADD, recommendedCheckIn, recommendedCheckOut);

                checkInDate = recommendedCheckIn;
                checkOutDate = recommendedCheckOut;
            }
        }

        if (availableRooms != null && !availableRooms.isEmpty()) {
            availableRooms.forEach(System.out::println);

            String answer = mainMenuPrompter.promptReserveRoom();
            PatternValidator yesValidator = new PatternValidator("^(yes|y)$");
            if (yesValidator.validate(answer)) {
                reserveRoom(checkInDate, checkOutDate, availableRooms);
            }
        }

        mainMenuPrompter.prompter().promptEnterKey();

        displayMenu();

    }

    // Auxiliary method to handle the execution of Option 1 - Find and Reserve a Room (this method handle reserving a room)
    private void reserveRoom(LocalDate checkIn, LocalDate checkOut, Collection<IRoom> availableRooms) {
        String email = mainMenuPrompter.promptEmail();
        String roomNumber = mainMenuPrompter.promptRoomNumber();

        IRoom room = HotelResource.getInstance().getRoom(roomNumber);

        if (!availableRooms.contains(room)) {
            throw new IllegalArgumentException("Room is not available.");
        }

        HotelResource.getInstance().bookARoom(email, room, checkIn, checkOut);

        System.out.println("Reservation created successfully!");
    }

    // Auxiliary method to handle the execution of Option 2 - See my reservations
    private void seeMyReservations() {

        String seeMyReservations = """

                =====================================
                | Option 2: See My Reservations     |
                =====================================""";

        System.out.println(seeMyReservations);

        String email = mainMenuPrompter.promptEmail();
        Customer customer = HotelResource.getInstance().getCustomer(email);
        if (customer == null) {
            System.out.println("Customer with the provided email does not exist.");
        } else {
            Collection<Reservation> reservations = HotelResource.getInstance().getCustomersReservations(email);
            if (reservations == null || reservations.isEmpty()) {
                System.out.println("Looks like you have no reservations.");
            } else {
                reservations.forEach(reservation -> {
                    System.out.println("================================================================");
                    System.out.println(reservation);
                    System.out.println("================================================================");
                });
            }
        }

        mainMenuPrompter.prompter().promptEnterKey();

        displayMenu();
    }

    // Auxiliary method to handle the execution of Option 3 - Create an Account
    private void createAnAccount() {

        String createAnAccount = """

                =====================================
                | Option 3: Create an Account       |
                =====================================""";

        System.out.println(createAnAccount);

        String email = mainMenuPrompter.promptEmail();
        String firstname = mainMenuPrompter.promptFirstName();
        String lastname = mainMenuPrompter.promptLastName();

        try {
            HotelResource.getInstance().createACustomer(email, firstname, lastname);
            System.out.println("Customer created successfully!");
        } catch (Exception ex) {
            System.out.printf("Unable to create customer. [Reason=%s].\n", ex.getLocalizedMessage());
        } finally {
            String answer = mainMenuPrompter.promptCreateAnotherCustomer();
            PatternValidator yesValidator = new PatternValidator("^(yes|y)$");
            if (yesValidator.validate(answer)) {
                createAnAccount();
            } else {
                mainMenuPrompter.prompter().promptEnterKey();

                displayMenu();
            }
        }
    }

    // Auxiliary method to handle the execution of Option 4 - Display Admin Menu
    private void displayAdmin() {
        AdminMenuPrompter adminMenuPrompter = new AdminMenuPrompter(mainMenuPrompter);
        IMenu admin = new AdminMenu(adminMenuPrompter, this);
        admin.displayMenu();
    }

    // Auxiliary method to handle the execution of Option 5 - Exit
    private void exit() {
        prompter.scanner().close();
        System.exit(0);
    }
}
