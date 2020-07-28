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

    public Map<CarTicket, Car> getPackingRooms() {
        return packingRooms;
    }

    public CarTicket park(Car car) {
        if (isParkIn(car) || isFull())
            return null;
        CarTicket carTicket = new CarTicket();
        packingRooms.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        Car fetchCar = packingRooms.get(carTicket);
        packingRooms.remove(carTicket);
        return fetchCar;
    }

    public boolean isFull() {
        return packingRooms.size() == capacity;
    }

    public int getEmptyPositionNumber() {
        return capacity - packingRooms.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isParkIn(Car car) {
        return packingRooms.containsValue(car);
    }
}
