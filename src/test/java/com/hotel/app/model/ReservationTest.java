package com.hotel.app.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    Reservation reservationUnderTest;

    @BeforeEach
    void setup() {
        LocalDate checkInDate = LocalDate.parse("2024-04-01");
        LocalDate checkOutDate = LocalDate.parse("2024-04-10");

        reservationUnderTest = new Reservation(null, null, checkInDate, checkOutDate);

    }

    @Test
    void isAfter() {

        String[][] inputs = {
                {"2024-03-24", "2024-03-31", "true"},
                {"2024-03-31", "2024-04-01", "true"},
                {"2024-03-31", "2024-04-02", "false"},
                {"2024-04-01", "2024-04-05", "false"},
                {"2024-04-01", "2024-04-10", "false"},
                {"2024-04-10", "2024-04-12", "false"},
                {"2024-04-11", "2024-04-15", "false"},
                {"2024-02-01", "2024-05-01", "false"},
                {"2024-04-08", "2024-04-17", "false"},
        };

        Arrays.stream(inputs).forEach(input -> {
            LocalDate checkInDate = LocalDate.parse(input[0]);
            LocalDate checkOutDate = LocalDate.parse(input[1]);
            boolean expectedTestResult = Boolean.parseBoolean(input[2]);

            assertEquals(reservationUnderTest.isAfter(checkInDate, checkOutDate),
                    expectedTestResult,
                    String.format("Test failed for check-in=%s and check-out=%s", checkInDate, checkOutDate));
        });

    }

    @Test
    void isBefore() {

        String[][] inputs = {
//                {"2024-03-24", "2024-03-31", "false"},
//                {"2024-03-31", "2024-04-01", "false"},
//                {"2024-03-31", "2024-04-02", "false"},
//                {"2024-04-01", "2024-04-05", "false"},
//                {"2024-04-01", "2024-04-10", "false"},
//                {"2024-04-10", "2024-04-12", "true"},
//                {"2024-04-11", "2024-04-15", "true"},
//                {"2024-02-01", "2024-05-01", "false"},
                {"2024-04-08", "2024-04-17", "false"},
        };

        Arrays.stream(inputs).forEach(input -> {
            LocalDate checkInDate = LocalDate.parse(input[0]);
            LocalDate checkOutDate = LocalDate.parse(input[1]);
            boolean expectedTestResult = Boolean.parseBoolean(input[2]);

            assertEquals(reservationUnderTest.isBefore(checkInDate, checkOutDate),
                    expectedTestResult,
                    String.format("Test failed for check-in=%s and check-out=%s", checkInDate, checkOutDate));
        });

    }

    @Test
    void isOverlap() {

        String[][] inputs = {
                {"2024-03-24", "2024-03-31", "false"},
                {"2024-03-31", "2024-04-01", "false"},
                {"2024-03-31", "2024-04-02", "true"},
                {"2024-04-01", "2024-04-05", "true"},
                {"2024-04-01", "2024-04-10", "true"},
                {"2024-04-10", "2024-04-12", "false"},
                {"2024-04-11", "2024-04-15", "false"},
                {"2024-02-01", "2024-05-01", "true"},
                {"2024-04-08", "2024-04-17", "true"},
        };

        Arrays.stream(inputs).forEach(input -> {
            LocalDate checkInDate = LocalDate.parse(input[0]);
            LocalDate checkOutDate = LocalDate.parse(input[1]);
            boolean expectedTestResult = Boolean.parseBoolean(input[2]);

            assertEquals(reservationUnderTest.isOverlap(checkInDate, checkOutDate),
                    expectedTestResult,
                    String.format("Test failed for check-in=%s and check-out=%s", checkInDate, checkOutDate));
        });
    }
}