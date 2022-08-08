package org.project;

import org.project.service.AirplaneSeatingService;
import org.project.util.SeatingUtil;

public class AirplaneSeating {
    public static void main(String[] args) {

        int[][] seat = {{3,2}, {4,3}, {2,3}, {3,4}};
        int passenger = 34;

        int[][] seat1 = {};
        int passenger1 = 8;

        AirplaneSeatingService airplaneSeatingService = new AirplaneSeatingService();
        SeatingUtil.printSeating(airplaneSeatingService.bookingPassengerSeat(seat1,passenger1),seat1);
    }
}
