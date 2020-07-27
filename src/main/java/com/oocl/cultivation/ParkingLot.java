package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<CarTicket, Car> packingRooms = new HashMap<>();
    private int capacity;

    public ParkingLot() {
        this.capacity = 10;
    }

    public ParkingLot(int id, int capacity) {
        this.capacity = capacity;
    }

    public Map<CarTicket, Car> getPackingRooms() {
        return packingRooms;
    }

    public CarTicket park(Car car) {
        if (car != null && !isParkIn(car) && isFullCapacity() == null) {
            CarTicket carTicket = new CarTicket();
            packingRooms.put(carTicket, car);
            return carTicket;
        } else {
            return null;
        }
    }

    public Car fetch(CarTicket carTicket) {
        Car fetchCar = packingRooms.get(carTicket);
        packingRooms.remove(carTicket);
        return fetchCar;
    }

    public String isFullCapacity() {
        String message = null;
        if (capacity == packingRooms.size()) {
            message = "Not enough position.";
        }
        return message;
    }

    public boolean isParkIn(Car car) {
        return packingRooms.containsValue(car);
    }

    public int getEmptyPositionNumber() {
        return capacity - packingRooms.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public String verifyCarTicket(CarTicket carTicket) {
        String message = null;
        if (carTicket == null) {
            message = "Please provide your parking ticket.";
        }
        if (carTicket != null && !packingRooms.containsKey(carTicket)) {
            message = "Unrecognized parking ticket.";
        }
        return message;
    }
}
