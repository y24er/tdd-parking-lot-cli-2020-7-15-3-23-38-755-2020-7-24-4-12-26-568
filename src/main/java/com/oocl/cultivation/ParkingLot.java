package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<CarTicket, Car> packingRooms = new HashMap<>();
    private int id;
    private int capacity;
    private TicketSystem ticketSystem = new TicketSystem();

    public ParkingLot() {
        this.capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public CarTicket park(Car car) {
        if (car != null && !isParkIn(car) && isFullCapacity() == null) {
            CarTicket carTicket = ticketSystem.createCarTicket(car.getLicensePlateNumber(), this.getId());
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
