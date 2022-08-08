package org.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.project.modal.Seat;
import org.project.modal.type.SeatType;
import org.project.service.AirplaneSeatingService;


@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class AirPlaneSeatingTest {

    AirplaneSeatingService airplaneSeatingService;

    @BeforeAll
    void setup() {
        this.airplaneSeatingService = new AirplaneSeatingService();
    }

    @Test
    void testAirplaneSeating(){
        int[][] cabins = {{1,2},{3,1},{2,3}};
        int passengers = 10;

        Seat[][] seat = airplaneSeatingService.bookingPassengerSeat(cabins,passengers);

        Assertions.assertEquals(seat.length,6);
        Assertions.assertEquals(seat[0].length,3);

        Assertions.assertEquals(seat[0][0].getPassengerNumber(),6);
        Assertions.assertEquals(seat[0][0].getSeatType(), SeatType.WINDOW);

        Assertions.assertEquals(seat[1][0].getPassengerNumber(),1);
        Assertions.assertEquals(seat[1][0].getSeatType(), SeatType.AISLE);

        Assertions.assertEquals(seat[2][0].getPassengerNumber(), 0);
        Assertions.assertEquals(seat[2][0].getSeatType(), SeatType.MIDDLE);

        Assertions.assertEquals(seat[3][0].getPassengerNumber(),2);
        Assertions.assertEquals(seat[3][0].getSeatType(), SeatType.AISLE);

        Assertions.assertEquals(seat[4][0].getPassengerNumber(),3);
        Assertions.assertEquals(seat[4][0].getSeatType(), SeatType.AISLE);

        Assertions.assertEquals(seat[5][0].getPassengerNumber(),7);
        Assertions.assertEquals(seat[5][0].getSeatType(), SeatType.WINDOW);

        Assertions.assertNull(seat[1][2]);
        Assertions.assertNull(seat[2][2]);
        Assertions.assertNull(seat[3][2]);
    }

    @Test
    void testAirplaneSeatingOrder(){
        int[][] cabins = {{1,1},{3,2}};
        int passengers = 8;

        Seat[][] seat = airplaneSeatingService.bookingPassengerSeat(cabins,passengers);

        Assertions.assertEquals(seat.length,4);
        Assertions.assertEquals(seat[0].length,2);

        Assertions.assertEquals(seat[1][0].getPassengerNumber(),1);
        Assertions.assertEquals(seat[1][0].getSeatType(), SeatType.AISLE);

        Assertions.assertEquals(seat[1][1].getPassengerNumber(),2);
        Assertions.assertEquals(seat[1][1].getSeatType(), SeatType.AISLE);

        Assertions.assertEquals(seat[0][0].getPassengerNumber(),3);
        Assertions.assertEquals(seat[0][0].getSeatType(), SeatType.WINDOW);

        Assertions.assertEquals(seat[3][0].getPassengerNumber(),4);
        Assertions.assertEquals(seat[3][0].getSeatType(), SeatType.WINDOW);

        Assertions.assertEquals(seat[3][1].getPassengerNumber(),5);
        Assertions.assertEquals(seat[3][1].getSeatType(), SeatType.WINDOW);

        Assertions.assertEquals(seat[2][0].getPassengerNumber(),6);
        Assertions.assertEquals(seat[2][0].getSeatType(), SeatType.MIDDLE);

        Assertions.assertEquals(seat[2][1].getPassengerNumber(),7);
        Assertions.assertEquals(seat[2][1].getSeatType(), SeatType.MIDDLE);
    }
}
