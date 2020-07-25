package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<CarTicket, Car> packingRooms = new HashMap<>();

    private int capacity;

    public ParkingLot() {
        this.capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public CarTicket park(Car car) {
        if (car != null && !isParkIn(car) && packingRooms.size() < capacity) {
            CarTicket carTicket = new CarTicket(car.getLicensePlateNumber());
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

    public String verifyCarTicket(CarTicket carTicket) {
        String result = null;
        if (!packingRooms.containsValue(carTicket)) {
            result = "Unrecognized parking ticket.";
        }
        return result;
    }

    public boolean isParkIn(Car car) {
        return packingRooms.containsValue(car);
    }
}
