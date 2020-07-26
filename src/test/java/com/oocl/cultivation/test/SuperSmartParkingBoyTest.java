package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartParkingBoyTest {
    @Test
    void should_return_car_ticket_when_park_car_in_larger_available_position_rate_parking_lot_given_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1, 5);
        ParkingLot parkingLot2 = new ParkingLot(2, 6);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot1, parkingLot2);

        //when
        Car car1 = new Car();
        Object result1 = superSmartParkingBoy.park(car1);
        CarTicket carTicket1 = null;
        if (result1 instanceof CarTicket)
            carTicket1 = (CarTicket) result1;

        Car car2 = new Car();
        Object result2 = superSmartParkingBoy.park(car2);
        CarTicket carTicket2 = null;
        if (result2 instanceof CarTicket)
            carTicket2 = (CarTicket) result2;

        Car car3 = new Car();
        Object result3 = superSmartParkingBoy.park(car3);
        CarTicket carTicket3 = null;
        if (result3 instanceof CarTicket)
            carTicket3 = (CarTicket) result3;

        //then
        assertNotNull(carTicket1);
        assertEquals(1, carTicket1.getParkingLotId());
        assertNotNull(carTicket2);
        assertEquals(2, carTicket2.getParkingLotId());
        assertNotNull(carTicket3);
        assertEquals(2, carTicket3.getParkingLotId());
    }

    @Test
    void should_return_not_enough_position_when_park_car_in_all_full_parking_lot_given_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1, 5);
        ParkingLot parkingLot2 = new ParkingLot(2, 6);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot1, parkingLot2);
        for (int i = 0; i < 11; i++) {
            superSmartParkingBoy.park(new Car());
        }

        //when
        Object result = superSmartParkingBoy.park(new Car());
        String message = null;
        if (result instanceof String)
            message = (String) result;

        //then
        assertNotNull(result);
        assertEquals("Not enough position.", message);
    }

    @Test
    void should_return_car_when_fetch_car_given_car_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1, 5);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot1);
        Car car = new Car();
        Object parkResult = superSmartParkingBoy.park(car);
        CarTicket carTicket = null;
        if (parkResult instanceof CarTicket)
            carTicket = (CarTicket) parkResult;

        //when
        Object fetchResult = superSmartParkingBoy.fetch(carTicket);
        Car fetchCar = null;
        if (fetchResult instanceof Car)
            fetchCar = (Car) fetchResult;

        //then
        assertNotNull(fetchCar);
        assertEquals(car, fetchCar);
    }

}
