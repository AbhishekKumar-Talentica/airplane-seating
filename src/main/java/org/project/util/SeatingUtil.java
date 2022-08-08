package org.project.util;

import org.project.modal.Seat;
import org.project.modal.type.SeatType;

public class SeatingUtil {
    private static final String filledSeat = "[ <%7s > PA: (%4s) ]";
    private static final String emptySeat = "                         ";
    private static final String cabinSpace = "     ";

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
        System.out.println("|  <> : Represent Seat type Aisle,window,Middle                           |");
        System.out.println("|  PA : Represent passenger number                                        |");
        System.out.println("___________________________________________________________________________");
        System.out.println();
    }
}
