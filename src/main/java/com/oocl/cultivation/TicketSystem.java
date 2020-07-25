package com.oocl.cultivation;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TicketSystem {
    Set<CarTicket> carTickets = new HashSet<>();

    public CarTicket createCarTicket(String licensePlateNumber) {
        int ticketId = new Random().nextInt(10000);
        CarTicket carTicket = new CarTicket(ticketId, licensePlateNumber);
        carTickets.add(carTicket);
        return carTicket;
    }

    public void updateCarTicket(CarTicket carTicket) {
        carTicket.setFetch(true);
    }

    public String verifyCarTicket(CarTicket carTicket) {
        String message = null;
        if (carTicket == null) {
            message = "Please provide your parking ticket.";
        }
        if (carTicket != null && (!carTickets.contains(carTicket) || carTicket.isFetch() == true)) {
            message = "Unrecognized parking ticket.";
        }
        return message;
    }

}
