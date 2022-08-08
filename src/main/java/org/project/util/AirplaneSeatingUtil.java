package org.project.util;

import org.project.modal.Seat;

import java.util.Arrays;

public class AirplaneSeatingUtil {
    private static final String FILLED_SEAT = "[ <%7s > PA: (%4s) ]";
    private static final String EMPTY_SEAT = "                         ";
    private static final String CABIN_SPACE = "     ";

    /**
     * Print seats details on console
     * @param seat
     * @param cabin
     */
    public static void printSeating(Seat[][] seat,int[][] cabin){

        printInfoDetails();
        if(!AirplaneSeatingUtil.validCabin(cabin)){
            return ;
        }

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
                    System.out.print(CABIN_SPACE);
                }
                if(seat[col][row] == null){
                    System.out.print(EMPTY_SEAT);
                }else{
                    System.out.print(
                            String.format(FILLED_SEAT,
                                    seat[col][row].getSeatType(),
                                    seat[col][row].getPassengerNumber() == 0 ?
                                            "----" : seat[col][row].getPassengerNumber()));
                }
            }
            System.out.println();
        }
    }

    public static boolean validCabin(int[][] cabins){
        if(cabins.length <= 0){
            return false;
        }
        return Arrays.stream(cabins)
                .filter(cabin -> cabin.length != 2)
                .findAny()
                .isPresent() ? false :true;
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
