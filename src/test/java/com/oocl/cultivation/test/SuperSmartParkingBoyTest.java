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
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(6);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot1, parkingLot2);

        //when
        for (int time = 0; time < 3; time++) {
            superSmartParkingBoy.park(new Car());
        }

        //then
        assertEquals(1, parkingLot1.getPackingRooms().size());
        assertEquals(2, parkingLot2.getPackingRooms().size());
    }

    @Test
    void should_return_not_enough_position_when_park_car_in_all_full_parking_lot_given_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(6);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot1, parkingLot2);
        for (int i = 0; i < 11; i++) {
            superSmartParkingBoy.park(new Car());
        }

        //when
        Throwable exception = assertThrows(RuntimeException.class, () -> superSmartParkingBoy.park(new Car()));

        //then
        assertEquals("Not enough position.", exception.getMessage());
    }

    @Test
    void should_return_car_when_fetch_car_given_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(5);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot);
        Car car = new Car();
        CarTicket carTicket = superSmartParkingBoy.park(car);

        //when
        Car fetchCar = superSmartParkingBoy.fetch(carTicket);

        //then
        assertNotNull(fetchCar);
        assertEquals(car, fetchCar);
    }

}
