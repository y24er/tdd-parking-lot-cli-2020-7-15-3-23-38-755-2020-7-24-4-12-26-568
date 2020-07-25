package com.oocl.cultivation;

import java.util.Random;

public class CarTicket {
    private int id;
    private String licensePlateNumber;
    private boolean isFetch;

    public CarTicket() {
    }

    public CarTicket(int id) {
        this.id = id;
    }

    public CarTicket(String licensePlateNumber) {
        this.id = new Random().nextInt(1000);
        this.licensePlateNumber = licensePlateNumber;
    }

    public CarTicket(int id, String licensePlateNumber) {
        this.id = id;
        this.licensePlateNumber = licensePlateNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarTicket carTicket = (CarTicket) o;
        return id == carTicket.id;
    }

    public int getId() {
        return id;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public boolean isFetch() {
        return isFetch;
    }
}