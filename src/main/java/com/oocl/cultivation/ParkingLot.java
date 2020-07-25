package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity = 10;
    Map<CarTicket, Car> packingRooms = new HashMap<>();

    public CarTicket park(Car car) {
        if (car != null && !packingRooms.containsValue(car) && packingRooms.size() < capacity) {
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
}
