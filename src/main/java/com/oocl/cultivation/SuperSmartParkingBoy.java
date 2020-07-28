package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(ParkingLot... parkingLot1) {
        super(parkingLot1);
    }

    @Override
    public CarTicket park(Car car) {
        ParkingLot parkingLot = getLargerAvailablePositionRateParkingLot();
        if (parkingLot != null)
            return parkingLot.park(car);
        else
            throw new RuntimeException("Not enough position.");
    }

    public ParkingLot getLargerAvailablePositionRateParkingLot() {
        double largerAvailablePositionRate = 0;
        ParkingLot parkingLot = null;
        for (ParkingLot lot : parkingLots) {
            double availablePositionRate = (double) lot.getEmptyPositionNumber() / lot.getCapacity();
            if (availablePositionRate > largerAvailablePositionRate) {
                largerAvailablePositionRate = availablePositionRate;
                parkingLot = lot;
            }
        }
        return parkingLot;
    }
}
