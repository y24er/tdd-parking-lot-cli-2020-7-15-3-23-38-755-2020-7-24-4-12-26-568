package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity = 10;
    Map<CarTicket, Car> packingRooms = new HashMap<>();

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        if (packingRooms.size() != capacity)
            packingRooms.put(carTicket, car);
        return packingRooms.size() != capacity ? carTicket : null;
    }

    public Car fetch(CarTicket carTicket) {
        Car fetchCar = packingRooms.get(carTicket);
        packingRooms.remove(carTicket);
        return fetchCar;
    }
}
