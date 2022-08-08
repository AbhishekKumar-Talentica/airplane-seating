package org.project.util;

import org.project.modal.Seat;
import org.project.modal.type.SeatType;

public class SeatingUtil {
    private static String filledSeat = "[ {%7s } PA: %4s ]";

    private static String emptySeat = "                       ";

    private static String cabinSpace = "     ";

    public static void main(String args[]) {

        int[][] cabin = {{3, 2}, {4, 3}, {2, 3}, {3, 4}};
        int passenger = 30;

        Seat[][] seat = new Seat[12][4];
        int counter = 0;
        for (int j = 0; j < seat[0].length; j++) {
            for (int i = 0; i < seat.length; i++) {
                if(i==j){
                    continue;
                }
                seat[i][j] = new Seat(++counter, SeatType.getRandomSeatType(),counter);
            }
        }
        printSeating(seat,cabin);
    }

    public static void printSeating(Seat[][] seat,int[][] cabin){
        printInfoDetails();
        for(int row = 0;row < seat[0].length;row++){
            int cabinIndex = 0;
            int cabinCounter = cabin[cabinIndex][0];
            for(int col = 0;col<seat.length;col++){
                if(cabinCounter < col){
                    cabinIndex++;
                    if(cabinIndex < cabin.length - 1){
                        cabinCounter = cabinCounter + cabin[cabinIndex][0];
                    }
                }
                if(cabinCounter == col){
                    System.out.print(cabinSpace);
                }
                if(seat[col][row] == null){
                    System.out.print(emptySeat);
                }else{
                    System.out.print(
                            String.format(filledSeat,
                                    seat[col][row].getSeatType(),
                                    seat[col][row].getPassengerNumber() == 0 ? "----" : seat[col][row].getPassengerNumber()));
                }
            }
            System.out.println();
        }
    }

    private static void printInfoDetails(){
        System.out.println("___________________________________________________________________________");
        System.out.println("|  [] : Represent one seat                                                |");
        System.out.println("|  {} : Represent Seat type A - Aisle, W - window, M - Middle             |");
        System.out.println("|  PA : Represent passenger number                                         |");
        System.out.println("___________________________________________________________________________");
    }
}
