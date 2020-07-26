package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ServiceManager;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ServiceManagerTest {
    @Test
    void should_parking_boy_list_has_the_added_boy_when_add_parking_boy_to_management_list_given_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ServiceManager serviceManager = new ServiceManager(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        List parkingBoyList = serviceManager.addParkingBoy(parkingBoy);

        //then
        assertThat(parkingBoyList,hasItem(parkingBoy));
    }

}
