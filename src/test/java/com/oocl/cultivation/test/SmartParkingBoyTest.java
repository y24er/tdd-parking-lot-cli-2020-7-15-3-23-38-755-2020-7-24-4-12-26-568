package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {

    @Test
    void should_return_car_ticket_when_park_car_from_more_empty_positions_given_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(5);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();

        //when
        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);

        //then
        assertEquals(1, parkingLot1.getPackingRooms().size());
        assertEquals(1, parkingLot2.getPackingRooms().size());
    }

    @Test
    void should_return_right_car_when_fetch_car_given_car_ticket() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot());
        Car car = new Car();
        CarTicket carTicket = smartParkingBoy.park(car);

        //when
        Car fetchCar = smartParkingBoy.fetch(carTicket);

        //then
        assertNotNull(carTicket);
        assertNotNull(fetchCar);
    }

    @Test
    void should_not_fetch_car_and_return_unrecognized_parking_ticket_when_fetch_car_given_wrong_ticket() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot());
        CarTicket carTicket = smartParkingBoy.park(new Car());
        CarTicket wrongCarTicket = new CarTicket();

        //when
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            smartParkingBoy.fetch(wrongCarTicket);
        });

        //then
        assertNotNull(carTicket);
        assertNotEquals(carTicket, wrongCarTicket);
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_not_fetch_car_and_return_unrecognized_parking_ticket_when_fetch_car_given_has_been_used_ticket() {
        //given
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot());
        CarTicket carTicket = smartParkingBoy.park(car);
        CarTicket wrongCarTicket = new CarTicket();
        Car fetchCar = smartParkingBoy.fetch(carTicket);

        //when
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            smartParkingBoy.fetch(carTicket);
        });

        //then
        assertNotNull(carTicket);
        assertEquals(car, fetchCar);
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_not_fetch_car_and_return_please_provide_your_parking_ticket_ticket_when_fetch_car_given_null_car_ticket() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot());

        //when
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            smartParkingBoy.fetch(null);
        });

        //then
        assertEquals("Please provide your parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_not_enough_position_when_park_car_to_all_full_capacity_parking_lot_given_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        //when
        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            smartParkingBoy.park(car3);
        });

        //then
        assertEquals(1, parkingLot1.getPackingRooms().size());
        assertEquals(1, parkingLot2.getPackingRooms().size());
        assertEquals("Not enough position.", exception.getMessage());
    }
}
