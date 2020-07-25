package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void should_return_null_when_park_given_passing_parked_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        CarTicket carTicket = parkingLot.park(car);

        //when
        CarTicket anotherCarTicket = parkingLot.park(car);

        //then
        assertNotNull(carTicket);
        assertNull(anotherCarTicket);
    }

    @Test
    void should_return_null_when_park_given_null() {
        //given
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket carTicket = parkingLot.park(null);

        //then
        assertNull(carTicket);
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
        assertNotNull(oneCarTicket);
        assertNotNull(antherCarTicket);
    }

    @Test
    void should_fetch_multiple_right_car_when_fetch_car_from_parking_lot_given_multiple_correspond_car_ticket() {
        //given
        Car oneCar = new Car();
        Car anotherCar = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket oneCarTicket = parkingLot.park(oneCar);
        CarTicket anotherCarTicket = parkingLot.park(anotherCar);

        //when
        Car fetchOneCar = parkingLot.fetch(oneCarTicket);
        Car fetchAnotherCar = parkingLot.fetch(anotherCarTicket);

        //then
        assertEquals(oneCar, fetchOneCar);
        assertEquals(anotherCar, fetchAnotherCar);
    }

    @Test
    void should_return_no_car_when_fetch_car_from_parking_lot_given_wrong_car_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket = parkingLot.park(car);

        //when
        CarTicket wrongCarTicket = new CarTicket();
        Car fetchCar = parkingLot.fetch(wrongCarTicket);

        //then
        assertNotNull(carTicket);
        assertNotEquals(carTicket, wrongCarTicket);
        assertNull(fetchCar);
    }

    @Test
    void should_return_no_car_when_fetch_car_from_parking_lot_given_no_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();

        //when
        Car fetchCar = parkingLot.fetch(null);

        //then
        assertNull(fetchCar);
    }

    @Test
    void should_return_no_car_when_fetch_car_from_parking_lot_given_already_been_used_car_ticket() {
        //given
        Car oneCar = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket oneCarTicket = parkingLot.park(oneCar);
        Car fetchOneCar = parkingLot.fetch(oneCarTicket);

        //when
        Car fetchCar = parkingLot.fetch(oneCarTicket);

        //then
        assertNotNull(fetchOneCar);
        assertNull(fetchCar);
    }

    @Test
    void should_return_no_car_ticket_and_not_park_in_when_park_from_full_capacity_parking_lot_given_car() {
        //given
        Car oneCar = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        for (int i = 0; i < 10; i++) {
            parkingLot.park(new Car());
        }
        CarTicket oneCarTicket = parkingLot.park(oneCar);

        //then
        assertNull(oneCarTicket);
    }

    @Test
    void should_return_car_ticket_and_park_in_when_park_from_one_capacity_left_parking_lot_given_car() {
        //given
        Car oneCar = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        for (int i = 0; i < 9; i++) {
            parkingLot.park(new Car());
        }
        CarTicket oneCarTicket = parkingLot.park(oneCar);

        //then
        assertNotNull(oneCarTicket);
    }
}
