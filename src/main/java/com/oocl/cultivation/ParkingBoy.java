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

    public Object fetch(CarTicket carTicket) {
        String message = verifyCarTicket(carTicket);
        if (message == null) {
            ParkingLot parkingLot = getParkingLotFromCarTicker(carTicket);
            return parkingLot.fetch(carTicket);
        } else
            return message;
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

    public String verifyCarTicket(CarTicket carTicket) {
        ParkingLot parkingLot = getParkingLotFromCarTicker(carTicket);
        if (carTicket == null) {
            return "Please provide your parking ticket.";
        }
        if (parkingLot == null) {
            return "Unrecognized parking ticket.";
        }
        return parkingLot.verifyCarTicket(carTicket);
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