package com.oocl.cultivation;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(ParkingLot... parkingLot) {
        super(parkingLot);
    }

    @Override
    public CarTicket park(Car car) {
        ParkingLot parkingLot = getMoreEmptyPositionParkingLot();
        if (parkingLot == null) {
            throw new RuntimeException("Not enough position.");
        }
        return parkingLot.park(car);
    }

    //todo
    public ParkingLot getMoreEmptyPositionParkingLot() {
        ParkingLot parkingLot = null;
        int maxNumber = 0;
        for (ParkingLot lot : parkingLots) {
            int emptyPositionNumber = lot.getEmptyPositionNumber();
            if (emptyPositionNumber > maxNumber) {
                maxNumber = emptyPositionNumber;
                parkingLot = lot;
            }
        }
        return parkingLot;
    }
}
