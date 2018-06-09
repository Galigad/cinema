package com.cinema.cinemacountry;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Seat {
    private boolean available;

    public Seat() {
        available = true;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
