package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_Car_ticket_when_park_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        CarTicket carTicket = (CarTicket) parkingBoy.park(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_fetch_car_when_fetch_car_from_parking_lot_given_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        CarTicket carTicket = (CarTicket) parkingBoy.park(car);

        //when
        Car fetchCar = (Car) parkingBoy.fetch(carTicket);

        //then
        assertNotNull(carTicket);
        assertNotNull(fetchCar);
    }

    @Test
    void should_not_fetch_car_return_unrecognized_parking_ticket_when_fetch_car_given_wrong_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        CarTicket carTicket = (CarTicket) parkingBoy.park(car);
        CarTicket wrongCarTicket = new CarTicket();

        //when
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            parkingBoy.fetch(wrongCarTicket);
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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        CarTicket carTicket = (CarTicket) parkingBoy.park(car);
        Car fetchCar = parkingBoy.fetch(carTicket);

        //when

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            parkingBoy.fetch(carTicket);
        });

        //then
        assertNotNull(carTicket);
        assertEquals(car, fetchCar);
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_not_fetch_car_and_return_please_provide_your_parking_ticket_ticket_when_fetch_car_given_null_car_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            parkingBoy.fetch(null);
        });
        //then
        assertEquals("Please provide your parking ticket.", exception.getMessage());
    }

    @Test
    void should_not_park_car_and_return_not_enough_position_when_fetch_car_given_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car());
        }
        //when
        String result = (String) parkingBoy.park(new Car());

        //then
        assertEquals("Not enough position.", result);
    }

    @Test
    void should_park_the_car_to_another_parking_lot_when_park_car_from_full_capacity_parking_lot_given_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(1, 5);
        parkingLots.add(parkingLot1);
        ParkingLot parkingLot2 = new ParkingLot(2, 5);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 5; i++) {
            parkingBoy.park(new Car());
        }
        String message = parkingBoy.checkParkingLotLeftCapacity(parkingLot1);

        //when
        Object result = parkingBoy.park(new Car());
        CarTicket carTicket = null;
        if (result instanceof CarTicket) {
            carTicket = (CarTicket) result;
        }
        //then
        assertEquals(5, parkingLot1.getPackingRooms().size());
        assertEquals("Not enough position.", message);
        assertNotNull(carTicket);
        assertEquals(1, parkingLot2.getPackingRooms().size());
    }

    @Test
    void should_return_not_enough_ticket_when_park_car_from_all_full_capacity_parking_lot_given_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(1, 5);
        parkingLots.add(parkingLot1);
        ParkingLot parkingLot2 = new ParkingLot(2, 5);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 5; i++) {
            parkingBoy.park(new Car());
        }
        String messageFromParkingLot1Capacity = parkingBoy.checkParkingLotLeftCapacity(parkingLot1);

        //when
        for (int i = 0; i < 5; i++) {
            parkingBoy.park(new Car());
        }
        String messageFromParkingLot2Capacity = parkingBoy.checkParkingLotLeftCapacity(parkingLot2);

        String messageFromParkCar = null;
        Object result = parkingBoy.park(new Car());
        if (result instanceof String) {
            messageFromParkCar = (String) result;
        }

        //then
        assertEquals("Not enough position.", messageFromParkingLot1Capacity);
        assertEquals("Not enough position.", messageFromParkingLot2Capacity);
        assertEquals("Not enough position.", messageFromParkCar);
    }

}
