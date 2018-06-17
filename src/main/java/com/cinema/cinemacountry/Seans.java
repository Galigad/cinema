package com.cinema.cinemacountry;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Seans {
    private Movie movie;
    private Hall hall;
    private LocalDateTime date;
    private List<Seat> seats;

    public Seans(Movie movie, Hall hall, LocalDateTime date) {
        this.movie = movie;
        this.hall = hall;
        this.date = date;
        seats = new ArrayList<>();
        fillTheSeat();
    }

    private void fillTheSeat(){
        for(int i=0; i < hall.getCapacity(); i++) {
            seats.add(new Seat());
        }
    }
}
