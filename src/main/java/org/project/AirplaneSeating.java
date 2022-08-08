package org.project;

import org.project.service.AirplaneSeatingService;
import org.project.util.SeatingUtil;

public class AirplaneSeating {
    public static void main(String[] args) {

        int[][] seat = {{3,2}, {4,3}, {2,3}, {3,4}};
        int passenger = 34;

        AirplaneSeatingService airplaneSeatingService = new AirplaneSeatingService();
        SeatingUtil.printSeating(airplaneSeatingService.bookingPassengerSeat(seat,passenger),seat);
    }
}
