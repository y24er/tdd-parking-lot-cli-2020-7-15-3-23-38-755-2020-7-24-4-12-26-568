package com.oocl.cultivation;

public class ParkingBoy {
    ParkingLot parkingLot = new ParkingLot();

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public CarTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(CarTicket carTicket) {
        return parkingLot.fetch(carTicket);
    }

    public String verifyCarTicket(CarTicket carTicket) {
        return parkingLot.verifyCarTicket(carTicket);
    }
}