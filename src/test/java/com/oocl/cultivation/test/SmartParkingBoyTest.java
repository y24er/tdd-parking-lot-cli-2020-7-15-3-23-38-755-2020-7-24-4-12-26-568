package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {

    @Test
    void should_return_car_ticket_when_park_car_from_more_empty_positions_given_car() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(1, 5), new ParkingLot(2, 5));
        Car car1 = new Car();
        Car car2 = new Car();

        //when
        CarTicket carTicket1 = (CarTicket) smartParkingBoy.park(car1);
        CarTicket carTicket2 = (CarTicket) smartParkingBoy.park(car2);

        //then
        assertEquals(1, carTicket1.getParkingLotId());
        assertEquals(2, carTicket2.getParkingLotId());
    }

}
