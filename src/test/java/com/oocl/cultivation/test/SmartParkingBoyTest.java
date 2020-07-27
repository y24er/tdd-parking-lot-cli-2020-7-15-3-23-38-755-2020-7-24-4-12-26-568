package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {

    @Test
    void should_return_car_ticket_when_park_car_from_more_empty_positions_given_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1, 5);
        ParkingLot parkingLot2 = new ParkingLot(2, 5);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();

        //when
        CarTicket carTicket1 = (CarTicket) smartParkingBoy.park(car1);
        CarTicket carTicket2 = (CarTicket) smartParkingBoy.park(car2);

        //then
        assertEquals(1, parkingLot1.getPackingRooms().size());
        assertEquals(1, parkingLot2.getPackingRooms().size());
    }

    @Test
    void should_return_not_enough_position_when_park_car_to_all_full_capacity_parking_lot_given_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1, 1);
        ParkingLot parkingLot2 = new ParkingLot(2, 1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        //when
        CarTicket carTicket1 = (CarTicket) smartParkingBoy.park(car1);
        CarTicket carTicket2 = (CarTicket) smartParkingBoy.park(car2);
        String result = (String) smartParkingBoy.park(car3);

        //then
        assertEquals(1, parkingLot1.getPackingRooms().size());
        assertEquals(1, parkingLot2.getPackingRooms().size());
        assertEquals("Not enough position.", result);
    }

    @Test
    void should_return_car_ticket_when_fetch_car_and_park_car_to_more_empty_positions_given_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1, 5);
        ParkingLot parkingLot2 = new ParkingLot(2, 5);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();

        //when
        CarTicket carTicket1 = (CarTicket) smartParkingBoy.park(car1);
        CarTicket carTicket2 = (CarTicket) smartParkingBoy.park(car2);

        Car fetchCar1 = (Car) smartParkingBoy.fetch(carTicket1);

        Car car3 = new Car();
        CarTicket carTicket3 = (CarTicket) smartParkingBoy.park(car3);

        //then
        assertEquals(1, parkingLot1.getPackingRooms().size());
        assertEquals(1, parkingLot2.getPackingRooms().size());
        assertNotNull(fetchCar1);
        assertEquals(car1, fetchCar1);
    }

}
