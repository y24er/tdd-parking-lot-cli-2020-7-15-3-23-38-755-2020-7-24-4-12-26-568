package com.oocl.cultivation.test;

import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.TicketSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TicketSystemTest {
    @Test
    void should_return_car_ticket_when_create_car_ticket_given_license_plate_number() {
        //given
        String licensePlateNumber = "粤B 8723A";
        TicketSystem ticketSystem = new TicketSystem();

        //when
        CarTicket carTicket = ticketSystem.createCarTicket(licensePlateNumber);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_ticket_fetch_is_true_when_update_car_ticket_given_car_ticket() {
        //given
        String licensePlateNumber = "粤B 8723A";
        TicketSystem ticketSystem = new TicketSystem();
        CarTicket carTicket = ticketSystem.createCarTicket(licensePlateNumber);

        //when
        ticketSystem.updateCarTicket(carTicket);
        boolean isFetch = carTicket.isFetch();

        //then
        assertEquals(true, isFetch);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_verify_car_ticket_given_null_car_ticket() {
        //given
        TicketSystem ticketSystem = new TicketSystem();

        //when
        String message = ticketSystem.verifyCarTicket(null);

        //then
        assertEquals("Please provide your parking ticket.", message);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_verify_car_ticket_given_wrong_ticket() {
        //given
        String licensePlateNumber = "粤B 8723A";
        TicketSystem ticketSystem = new TicketSystem();
        CarTicket carTicket = ticketSystem.createCarTicket(licensePlateNumber);
        CarTicket wrongCarTicket = new CarTicket(6, "粤A 12245");

        //when
        String message = ticketSystem.verifyCarTicket(wrongCarTicket);

        //then
        assertNotNull(carTicket);
        assertNotEquals(carTicket, wrongCarTicket);
        assertEquals("Unrecognized parking ticket.", message);
    }

    @Test
    void should_not_fetch_car_and_return_unrecognized_parking_ticket_when_fetch_car_given_has_been_used_ticket() {
        //given
        String licensePlateNumber = "粤B 8723A";
        TicketSystem ticketSystem = new TicketSystem();
        CarTicket carTicket = ticketSystem.createCarTicket(licensePlateNumber);

        ticketSystem.updateCarTicket(carTicket);

        //when
        String message = ticketSystem.verifyCarTicket(carTicket);

        //then
        assertNotNull(carTicket);
        assertEquals("Unrecognized parking ticket.", message);
    }

}
