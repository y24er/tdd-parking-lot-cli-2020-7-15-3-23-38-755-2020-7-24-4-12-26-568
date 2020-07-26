package com.oocl.cultivation;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(ParkingLot... parkingLot) {
        super(parkingLot);
    }

    @Override
    public Object park(Car car) {
        ParkingLot parkingLot = getMoreEmptyPositionParkingLot();
        if (parkingLot != null) {
            return parkingLot.park(car);
        } else {
            return "Not enough position.";
        }
    }

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
