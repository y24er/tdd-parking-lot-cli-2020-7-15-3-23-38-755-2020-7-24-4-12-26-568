package com.oocl.cultivation;

public class ParkingBoy {
    ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Object park(Car car) {
        String message = checkParkingLotLeftCapacity();
        if (message == null)
            return parkingLot.park(car);
        else
            return message;
    }

    public Object fetch(CarTicket carTicket) {
        String message = verifyCarTicket(carTicket);
        if (message == null)
            return parkingLot.fetch(carTicket);
        else
            return message;
    }

    public String verifyCarTicket(CarTicket carTicket) {
        return parkingLot.verifyCarTicket(carTicket);
    }

    public String checkParkingLotLeftCapacity() {
        return parkingLot.isFullCapacity();
    }
}