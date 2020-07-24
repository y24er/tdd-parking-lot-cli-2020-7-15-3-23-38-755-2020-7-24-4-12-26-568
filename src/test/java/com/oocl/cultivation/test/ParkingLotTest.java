package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_car_ticket_then_park_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        CarTicket carTicket = parkingLot.park(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_fetch_car_when_fetch_car_from_parking_lot_given_car_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket = parkingLot.park(car);
        //when
        Car fetchCar = parkingLot.fetch(carTicket);
        //then
        assertEquals(car, fetchCar);
    }

    @Test
    void should_return_multiple_car_ticket_when_park_multiple_car_given_multiple_car() {
        //given
        Car oneCar = new Car();
        Car anotherCar = new Car();

        ParkingLot parkingLot = new ParkingLot();

        //when

        CarTicket oneCarTicket = parkingLot.park(oneCar);
        CarTicket antherCarTicket = parkingLot.park(anotherCar);

        //then
        assertNotNull(oneCar);
        assertNotNull(anotherCar);

    }
}
