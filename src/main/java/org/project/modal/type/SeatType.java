package org.project.modal.type;


import java.util.Random;

public enum SeatType {
    AISLE,
    MIDDLE,
    WINDOW;

    public static SeatType getRandomSeatType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
