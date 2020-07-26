package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(ParkingLot... parkingLot) {
        super(parkingLot);
    }

    @Override
    public Object park(Car car) {
        ParkingLot parkingLot = getMoreEmptyPositionParingLot();
        if (parkingLot != null)
            return parkingLot.park(car);
        else
            return "Not enough position.";
    }

    public ParkingLot getMoreEmptyPositionParingLot() {
        Map<ParkingLot, Integer> emptyPositionNumberFromAllParkingLot = new HashMap<>();

        for (ParkingLot parkingLot : parkingLots) {
            emptyPositionNumberFromAllParkingLot.put(parkingLot, parkingLot.getEmptyPositionNumber());
        }
        int maxNumber = 0;
        ParkingLot parkingLot = null;
        for (ParkingLot lot : emptyPositionNumberFromAllParkingLot.keySet()) {
            int emptyPositionNumber = lot.getEmptyPositionNumber();
            if (emptyPositionNumber >= maxNumber) {
                maxNumber = emptyPositionNumber;
                parkingLot = lot;
            }
        }
        return parkingLot;
    }
}
