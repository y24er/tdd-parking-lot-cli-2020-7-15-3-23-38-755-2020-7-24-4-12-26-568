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

    public Car fetch(CarTicket carTicket) {
        if (carTicket == null) {
            throw new RuntimeException(ErrorMessage.Message.NULL_TICKET.toString());
        }
        ParkingLot parkingLot = getParkingLotFromCarTicker(carTicket);
        if (parkingLot == null) {
            throw new RuntimeException(ErrorMessage.Message.UNRECOGNIZED_TICKET.toString());
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

    public CarTicket park(Car car) {
        CarTicket carTicket = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                carTicket = parkingLot.park(car);
                return carTicket;
            }
        }
        if (carTicket == null) {
            throw new RuntimeException(ErrorMessage.Message.NON_POSITION.toString());
        }
        return carTicket;
    }
}