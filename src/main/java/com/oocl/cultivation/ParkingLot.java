package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<CarTicket, Car> packingRooms = new HashMap<>();
    private int capacity;
    private TicketSystem ticketSystem;

    public ParkingLot() {
        this.capacity = 10;
        ticketSystem = new TicketSystem();
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot(int capacity, TicketSystem ticketSystem) {
        this.capacity = capacity;
        this.ticketSystem = ticketSystem;
    }

    public CarTicket park(Car car) {
        if (car != null && !isParkIn(car) && isFullCapacity() == null) {
            CarTicket carTicket = ticketSystem.createCarTicket(car.getLicensePlateNumber());
//            CarTicket carTicket = new CarTicket(car.getLicensePlateNumber());
            packingRooms.put(carTicket, car);
            return carTicket;
        } else {
            return null;
        }
    }

    public Car fetch(CarTicket carTicket) {
        Car fetchCar = packingRooms.get(carTicket);
        packingRooms.remove(carTicket);
        ticketSystem.updateCarTicket(carTicket);
        return fetchCar;
    }

    public String verifyCarTicket(CarTicket carTicket) {
        return ticketSystem.verifyCarTicket(carTicket);
        /*String message = null;
        if (carTicket == null) {
            message = "Please provide your parking ticket.";
        }
        if (carTicket != null && !packingRooms.containsKey(carTicket)) {
            message = "Unrecognized parking ticket.";
        }
        return message;*/
    }

    public String isFullCapacity() {
        String message = null;
        if (capacity == packingRooms.size())
            message = "Not enough position.";
        return message;
    }

    public boolean isParkIn(Car car) {
        return packingRooms.containsValue(car);
    }
}
