package org.project.modal;

import org.project.modal.type.SeatType;

public class Seat {
    private int seatNumber;

    private SeatType seatType;

    private int passengerNumber;
    public Seat(int seatNumber,SeatType seatType){
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public Seat(int seatNumber,SeatType seatType,int passengerNumber){
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.passengerNumber = passengerNumber;
    }


    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }
}
