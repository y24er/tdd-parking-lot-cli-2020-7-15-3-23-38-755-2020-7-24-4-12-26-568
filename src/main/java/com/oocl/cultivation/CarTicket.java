package com.oocl.cultivation;

public class CarTicket {
    private int id;
    private String licensePlateNumber;
    private boolean isFetch;
    private int parkingLotId;

    public CarTicket() {
    }

    public CarTicket(int id, String licensePlateNumber) {
        this.id = id;
        this.licensePlateNumber = licensePlateNumber;
    }

    public CarTicket(int id, String licensePlateNumber, int parkingLotId) {
        this.id = id;
        this.licensePlateNumber = licensePlateNumber;
        this.parkingLotId = parkingLotId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarTicket carTicket = (CarTicket) o;
        return id == carTicket.id;
    }

    public boolean isFetch() {
        return isFetch;
    }

    public void setFetch(boolean fetch) {
        isFetch = fetch;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }
}