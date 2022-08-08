package org.project.service;

import org.project.modal.Seat;
import org.project.modal.type.SeatType;
import org.project.util.AirplaneSeatingUtil;

import java.util.LinkedList;

public class AirplaneSeatingService {

    private static final int COL_INDEX = 0;
    private static final int ROW_INDEX = 1;

    /**
     * int[][] cabin = {{2,1},{1,2}}
     * transforms into
     * SEATS[][] = 3*2 matrix
     * ----------------------------------------------------------------------
     * |     (0,0)      | |     (0,1)      |           |     (0,2)       |  |
     *                                                 |     (1,2)          |
     * ----------------------------------------------------------------------
     * @param cabin
     * @param totalPassengers
     * @return SEATS[][]
     */
    public Seat[][] bookingPassengerSeat(int[][] cabin, int totalPassengers){
        if(!AirplaneSeatingUtil.validCabin(cabin)){
            return new Seat[0][0];
        }

        LinkedList<Seat> aisleSeatQueue = new LinkedList<>();
        LinkedList<Seat> windowSeatQueue = new LinkedList<>();
        LinkedList<Seat> middleSeatQueue = new LinkedList<>();

        Seat[][] seats = getSeats(cabin,aisleSeatQueue,windowSeatQueue,middleSeatQueue);

        return assignSeat(seats,totalPassengers,aisleSeatQueue,windowSeatQueue,middleSeatQueue);
    }

    private Seat[][] getSeats(int[][] cabins,
                              LinkedList<Seat> aisleSeatQueue,
                              LinkedList<Seat> windowSeatQueue,
                              LinkedList<Seat> middleSeatQueue) {

        Seat[][] seats = initSeats(cabins);
        int seatNumber = 0;
        for(int row = 0;row < seats[COL_INDEX].length;row++){
            int seatCounter = 0;
            for(int cabin = 0; cabin < cabins.length;cabin++){
                int seat = seatCounter;
                seatCounter += cabins[cabin][COL_INDEX];
                if(cabins[cabin][1] <= row){
                    continue;
                }
                for(;seat < seatCounter;seat++){

                    if((cabin == 0 && seat == 0) ||
                            (cabin == cabins.length-1 && seat == seats.length-1)){

                        seats[seat][row] = new Seat(++seatNumber, SeatType.WINDOW);
                        windowSeatQueue.add(seats[seat][row]);
                    } else if (seat == seatCounter-1 || seat == (seatCounter - cabins[cabin][0])) {
                        seats[seat][row] = new Seat(++seatNumber,SeatType.AISLE);
                        aisleSeatQueue.add(seats[seat][row]);
                    } else if(seats[seat][row] == null){
                        seats[seat][row] = new Seat(++seatNumber,SeatType.MIDDLE);
                        middleSeatQueue.add(seats[seat][row]);
                    }
                }

            }
        }
        return seats;
    }

    private Seat[][] assignSeat(Seat[][] seats,
                                int totalPassengers,
                                LinkedList<Seat> aisleSeatQueue,
                                LinkedList<Seat> windowSeatQueue,
                                LinkedList<Seat> middleSeatQueue) {
        int passengerCounter = 0;
        while(!aisleSeatQueue.isEmpty()){
            if(passengerCounter >= totalPassengers){
                return seats;
            }
            aisleSeatQueue.poll().setPassengerNumber(++passengerCounter);
        }

        while(!windowSeatQueue.isEmpty()){
            if(passengerCounter >= totalPassengers){
                return seats;
            }
            windowSeatQueue.poll().setPassengerNumber(++passengerCounter);
        }

        while(!middleSeatQueue.isEmpty()){
            if(passengerCounter >= totalPassengers){
                return seats;
            }
            middleSeatQueue.poll().setPassengerNumber(++passengerCounter);
        }
        return seats;
    }

    /**
     * Init Seats matrix : total column in cabin * max(row in cabin)
     * @param cabins
     * @return
     */
    private Seat[][] initSeats(int[][] cabins){
        int row = 0,col = 0;
        for(int i=0;i< cabins.length;i++){
            col += cabins[i][COL_INDEX];
            if(cabins[i][ROW_INDEX] > row){
                row = cabins[i][ROW_INDEX];
            }
        }

        return new Seat[col][row];
    }

}
