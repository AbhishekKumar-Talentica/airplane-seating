package org.project;

import org.project.service.AirplaneSeatingService;
import org.project.util.AirplaneSeatingUtil;

import java.util.Scanner;

public class AirplaneSeating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AirplaneSeatingService airplaneSeatingService = new AirplaneSeatingService();
        boolean booking = true;

        do{
            int numberOfCabins = scanner.nextInt();
            int[][] cabins = new int[numberOfCabins][2];
            for(int cabin = 0 ;cabin < numberOfCabins;cabin++){
                cabins[cabin][0] = scanner.nextInt();
                cabins[cabin][1] = scanner.nextInt();
            }
            int passengers = scanner.nextInt();

            AirplaneSeatingUtil.printSeating(
                    airplaneSeatingService.bookingPassengerSeat(cabins,passengers),cabins);

            System.out.println("Test another (y/n)");
            char cont = scanner.next().charAt(0);
            if(cont != 'y' || cont != 'Y'){
                booking = false;
            }
        }while(booking);
    }
}
