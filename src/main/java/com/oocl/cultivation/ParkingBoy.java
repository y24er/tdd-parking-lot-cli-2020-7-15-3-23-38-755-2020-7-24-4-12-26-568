package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingBoy(ParkingLot... parkingLot) {
        for (ParkingLot lot : parkingLot) {
            parkingLots.add(lot);
        }
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Car fetch(CarTicket carTicket) {
        if (carTicket == null) {
            throw new RuntimeException("Please provide your parking ticket.");
        }
        ParkingLot parkingLot = getParkingLotFromCarTicker(carTicket);
        if (parkingLot == null) {
            throw new RuntimeException("Unrecognized parking ticket.");
        }
        return parkingLot.fetch(carTicket);
    }

    public ParkingLot getParkingLotFromCarTicker(CarTicket carTicket) {
        ParkingLot parkingLot = null;
        for (ParkingLot lot : parkingLots) {
            if (lot.packingRooms.containsKey(carTicket)) {
                parkingLot = lot;
                break;
            }
        }
        return parkingLot;
    }

    public Object park(Car car) {
        String message = null;
        for (ParkingLot parkingLot : parkingLots) {
            message = checkParkingLotLeftCapacity(parkingLot);
            if (message == null) {
                return parkingLot.park(car);
            }
        }
        return message;
    }

    public String checkParkingLotLeftCapacity(ParkingLot parkingLot) {
        return parkingLot.isFullCapacity();
    }
}