package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_Car_ticket_when_park_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        CarTicket carTicket = parkingBoy.park(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_fetch_car_when_fetch_car_from_parking_lot_given_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);

        //when
        Car fetchCar = parkingBoy.fetch(carTicket);

        //then
        assertNotNull(carTicket);
        assertNotNull(fetchCar);
    }

    @Test
    void should_not_fetch_car_return_unrecognized_parking_ticket_when_fetch_car_given_wrong_ticket() {
        //given
        Car car = new Car("粤B 12345");
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        CarTicket carTicket = parkingBoy.park(car);
        CarTicket wrongCarTicket = new CarTicket(6, "粤A 12245");

        //when
        String result = parkingBoy.verifyCarTicket(wrongCarTicket);

        //then
        assertNotNull(carTicket);
        assertNotEquals(carTicket, wrongCarTicket);
        assertEquals("Unrecognized parking ticket.", result);
    }

    @Test
    void should_not_fetch_car_and_return_unrecognized_parking_ticket_when_fetch_car_given_has_been_used_ticket() {
        //given
        Car car = new Car("粤B 12345");
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        CarTicket carTicket = parkingBoy.park(car);
        Car fetchCar = parkingBoy.fetch(carTicket);

        //when
        String result = parkingBoy.verifyCarTicket(carTicket);

        //then
        assertNotNull(carTicket);
        assertEquals(car, fetchCar);
        assertEquals("Unrecognized parking ticket.", result);
    }
}
