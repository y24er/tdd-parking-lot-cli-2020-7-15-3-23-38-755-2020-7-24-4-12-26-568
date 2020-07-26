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
            return getParkingLotByParkingLotId(carTicket.getParkingLotId()).fetch(carTicket);
        } else
            return message;
    }

    public ParkingLot getParkingLotByParkingLotId(int parkingLotId) {
        ParkingLot parkingLot = null;
        for (ParkingLot lot : parkingLots) {
            if (lot.getId() == parkingLotId) {
                parkingLot = lot;
            }
        }
        return parkingLot;
    }

    public String verifyCarTicket(CarTicket carTicket) {
        if (carTicket == null) {
            return "Please provide your parking ticket.";
        }
        int parkingLotId = carTicket.getParkingLotId();
        ParkingLot parkingLot = getParkingLotByParkingLotId(parkingLotId);
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