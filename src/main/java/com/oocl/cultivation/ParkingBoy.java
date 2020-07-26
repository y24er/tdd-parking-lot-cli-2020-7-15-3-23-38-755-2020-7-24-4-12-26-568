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

    public void boundPackingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }


    public Object fetch(CarTicket carTicket) {
        String message = verifyCarTicket(carTicket);
        if (message == null)
            return parkingLots.get(0).fetch(carTicket);
        else
            return message;
    }

    public String verifyCarTicket(CarTicket carTicket) {
        if (carTicket == null)
            return "Please provide your parking ticket.";
        int parkingLotId = carTicket.getParkingLotId();
        ParkingLot parkingLot = null;
        for (ParkingLot lot : parkingLots) {
            if (lot.getId() == parkingLotId) {
                parkingLot = lot;
            }
        }
        return parkingLot.verifyCarTicket(carTicket);
    }

    public String checkParkingLotLeftCapacity() {
        return parkingLots.get(0).isFullCapacity();
    }

    public Object park(Car car) {
        ParkingLot parkingLot = parkingLots.get(0);
        String message1 = checkParkingLotLeftCapacity(parkingLot);
        if (message1 == null)
            return parkingLot.park(car);

        int indexOfNowParkingLot = parkingLots.indexOf(parkingLot);
        while (indexOfNowParkingLot + 1 != parkingLots.size()) {
            indexOfNowParkingLot = indexOfNowParkingLot + 1;
            ParkingLot newParkingLot = parkingLots.get(indexOfNowParkingLot);
            String message2 = checkParkingLotLeftCapacity(newParkingLot);
            if (message2 == null) {
                return newParkingLot.park(car);
            } else {
                return message2;
            }
        }
        return message1;
    }

    public String checkParkingLotLeftCapacity(ParkingLot parkingLot) {
        return parkingLot.isFullCapacity();
    }
}